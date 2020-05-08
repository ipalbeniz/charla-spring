package com.demo.aop;

import java.time.Duration;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MethodDurationProcessor {

	@Around("@annotation(MethodDuration)")
	public Object logDuration(final ProceedingJoinPoint joinPoint) throws Throwable {

		final Instant start = Instant.now();

		final Object proceed = joinPoint.proceed();

		final Duration timeLapse = Duration.between(start, Instant.now());

		this.logDurationMessage(joinPoint, timeLapse);

		return proceed;
	}

	private void logDurationMessage(ProceedingJoinPoint joinPoint, Duration timeLapse) {

		log.info("The method {}.{} took {} ms",
				 joinPoint.getSignature().getDeclaringType().getSimpleName(),
				 joinPoint.getSignature().getName(),
				 timeLapse.toMillis());
	}
}
