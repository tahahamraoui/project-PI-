package tn.esprit.spring.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class loggingAspect {
private static final Logger l = LogManager.getLogger(loggingAspect.class);
	
	@Before("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodEntry(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		l.info("In method " + name + " : ");
		}
	
	@Around("execution(* tn.esprit.spring.service.*.*(..))")
	public void profile(ProceedingJoinPoint pjp) throws Throwable {
	long start = System.currentTimeMillis();
	pjp.proceed();
	long elapsedTime = System.currentTimeMillis() - start;
	l.info("Method execution time: " + elapsedTime + " milliseconds.");

	}
	
	@AfterReturning("execution(* tn.esprit.spring.services.*.*(..))")
	public void logMethodIn(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		l.info("In method " + name + " : ");
		}

}
