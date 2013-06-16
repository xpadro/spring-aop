package xpadro.spring.mvc.aop.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import xpadro.spring.mvc.aop.notifications.NotificationUtils;

@Component
@Aspect
public class CentralExceptionHandler {
	private static Logger errorLogger = LoggerFactory.getLogger("errors");
	
	@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping) && target(controller) && args(model,..)")
	public String handleException(ProceedingJoinPoint jp, Object controller, Model model) throws Throwable {
		String view = null;
		
		try {
			view = (String) jp.proceed();
		} catch (DataAccessException e) {
			errorLogger.error("error in {}", controller.getClass().getSimpleName(), e);
			NotificationUtils.sendNotification(e);
			model.addAttribute("errorMessage", e.getMessage());
			return "errorPage";
		}
		
		return view;
	}
}
