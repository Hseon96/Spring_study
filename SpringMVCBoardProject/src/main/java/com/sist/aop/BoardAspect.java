package com.sist.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect  // 공통 모듈이고 
@Component // 메모리 할당은 얘가!
public class BoardAspect {
	// 시점만 정하면 된다 => 메소드를 적용한 위치  => JoinPoint
	// 어떤 메소드  => PointCut
	// JoinPoint + PointCut = Weaving
	@Before("execution(* com.sist.web.*Controller.*(..))") //메소드에 진입
	public void before(JoinPoint jp)
	{
		String name=jp.getSignature().getName();
		System.out.println(name+"진입..");
	}
	@After("execution(* com.sist.web.*Controller.*(..))") // 메소드종료 => finally ==> 사이트의 공통적인 출력부분
	public void after(JoinPoint jp)
	{
		String name=jp.getSignature().getName();
		System.out.println(name+"정상적으로 수행완료..");
	}
	@AfterReturning(value="execution(* com.sist.web.*Controller.*(..))",returning = "obj") // => 정상수행 => return값을 받아서 처리
	public void afterReturning(String obj)
	{
		System.out.println(obj+".jsp로 이동 완료...");
	}
}
