package com.iu.s5.transfer;

import org.aspectj.lang.ProceedingJoinPoint;

public class Card {

	public void cardAfter() {
		System.out.println("----------------------");
		System.out.println("카드 결제");
	}
	
	public Object cardCheck(ProceedingJoinPoint join) throws Throwable {
		System.out.println("----------------------");
		System.out.println("카드 check in");
		Object[] ar = join.getArgs();
		for(Object o : ar) {
			System.out.println(o);
		}
		
		//bus, subway 실행
		Object obj = join.proceed();
		
		System.out.println("카드 check out");
		
		return obj;
	}
}
