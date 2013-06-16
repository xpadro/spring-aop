package xpadro.spring.mvc.aop.handler;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Aspect
@Component
public class CentralLoggingHandler {
	private static Logger mainLogger = LoggerFactory.getLogger("generic");

	@Before("@annotation(org.springframework.web.bind.annotation.RequestMapping) && @annotation(mapping)")
	public void logControllerAccess(RequestMapping mapping) {
		mainLogger.debug("Executing {} request", mapping.value()[0]);
	}
	
	@Before("execution(* xpadro.spring.mvc.*..*Service+.*(..)) && target(service)")
	public void logServiceAccess(Object service) {
		mainLogger.debug("Accessing {}", service.getClass().getSimpleName());
	}
}
