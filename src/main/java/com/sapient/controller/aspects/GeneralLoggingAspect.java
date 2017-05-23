package com.sapient.controller.aspects;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class GeneralLoggingAspect {
	
	private final Logger log = LoggerFactory.getLogger(getClass());


	@Around("execution(* com.sapient..*(..))")
	public Object loggingAroundMethod(ProceedingJoinPoint jp) throws Throwable {
		final String signature = jp.getTarget().getClass().getName() + '.' + jp.getSignature().getName();
		final List<Object> arguments = Arrays.asList(jp.getArgs());

		Object result = null;
		 try {
	        	StopWatch stopWatch = new StopWatch();		       	
	            doLog("INFO", "Entered Method {} with arguments {} ", signature, arguments);
	        	stopWatch.start(); 
	            result = jp.proceed();
	            stopWatch.stop();            
	            doLog("INFO", "Exited method {} Total execution time is**{} milliseconds** and result returned is {}", signature," "+stopWatch.getTotalTimeMillis()," " ,result);
	           
	        } catch (Exception e) {
	            log.error("[Exception at] {}{} exception={}", signature, arguments, e);
	            throw e;
	        }

	        return result;

		}
	
	 private void doLog(String level, @NotNull final String format, final Object... arguments) {
         switch (level) {
             case "DEBUG":
                 log.debug(format, arguments);
                 return;

             case "INFO":
                 log.info(format, arguments);
                 return;

             case "WARN":
                 log.warn(format, arguments);       
                 return;

             case "ERROR":
                 break;

             default:
                 log.error("Unable to appropriately handle given log level={}", level);
         }
         log.error(format, arguments);
     }

}
