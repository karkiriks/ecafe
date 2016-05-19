package com.edu.ecafe.Advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class logAdvice {

	public logAdvice() {
	}
	
	@Before("execution(* com.edu.ecafe.Controller.*.*(..))")
	public void tracebeforemethod(JoinPoint joinpoint) {
		System.out.println("Aspect before execution of method " + joinpoint.getSignature().getDeclaringType() + joinpoint.getSignature().getName());
	}

	@After("execution(* *.*.delete*(..))")
	public void traceaftermethod(JoinPoint joinpoint) {
		System.out.println("after execution of method " + joinpoint.getSignature().getDeclaringType() + joinpoint.getSignature().getName());
	}

}
