package com.sapient.controller.aspects;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class AnnotatedLoggingAspect {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * @param jp - ProceedingJointPoint
     * @param loggable - Loggable
     * @return returns the next executable point to proceed in target
     * @throws Throwable - throws exception when proceeding with joint point
     */
	
		@Around("execution(* *(..)) && @annotation(loggable)")	
	   public Object loggingAroundMethodAnnotated(@NotNull final ProceedingJoinPoint jp,
                                      @NotNull final Loggable loggable) throws Throwable {
        final String signature = jp.getTarget().getClass().getName() + '.' + jp.getSignature().getName();
        final List<Object> arguments = Arrays.asList(jp.getArgs());

        final Object result;
        try {
        	StopWatch stopWatch = new StopWatch();		       	
            doLog(loggable.level(), "Entered Method {} with arguments {} ***from annotated logger ***", signature, arguments);
        	stopWatch.start(); 
            result = jp.proceed();
            stopWatch.stop();            
            doLog(loggable.level(), "Exited method {} Total execution time is **{} milliseconds** and result returned is {}**output from annotated logger**", signature," "+stopWatch.getTotalTimeMillis()," " ,result);
           
        } catch (Exception e) {
            log.error("[Exception at] {}{} exception={}***annotated**", signature, arguments, e);
            throw e;
        }

        return result;
    }
        /**
         * Logs the message with appropriate log level.
         * @param level - level to log
         * @param format - format for logging
         * @param arguments - arguments for logging
         */
        private void doLog(@NotNull final Loggable.Level level, @NotNull final String format, final Object... arguments) {
            switch (level) {
                case DEBUG:
                    log.debug(format, arguments);
                    return;

                case INFO:
                    log.info(format, arguments);
                    return;

                case WARN:
                    log.warn(format, arguments);       
                    return;

                case ERROR:
                    break;

                default:
                    log.error("Unable to appropriately handle given log level={}", level);
            }
            log.error(format, arguments);
        }
        
      

        
     
}
