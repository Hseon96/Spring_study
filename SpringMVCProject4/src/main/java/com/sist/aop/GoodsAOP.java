package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // 공통 모듈 => 메모리 할당을 못한다  (*로그처리) => 트랜잭션 , 보안
@Component // 이게 메모리 할당 
public class GoodsAOP {
	@Around("execution(* com.sist.web.*Controller.*(..))") // Controller가 들어가있는 전체 메소드
	// 				 ---              -----------  ---- 매개변수가 있거나 없거나 무조건 호출
	//              리턴형                           모든 컨트롤러로 끝나는.. 
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		Object obj=null;
		try
		{
			long start=System.currentTimeMillis();
			obj=jp.proceed(); // 메소드가 호출
			long end=System.currentTimeMillis();
			System.out.println("==================AOP 공통기반 처리==================");
			System.out.println("1. 사용자 요청 메소드:"+jp.getSignature().getName());
			System.out.println("2. 수행 시간:"+(end-start));
			System.out.println("=============================================");
		}catch(Exception ex) {}
		return obj;
	}
	// 모니터링 ==> 견고한 프로그램
	// 견고성() , 가독성 (유지보수) , 최적화(속도)
	// 순서(메인페이지) => 회원가입, 로그인 (=> 보안) AOP활용한다..
	@AfterReturning(value="execution(* com.sist.web.*Controller.*(..))",returning = "obj")
	public void afterReturning(Object obj) throws Throwable
	{
		System.out.println("======== 화면 이동 =========");
		System.out.println(obj);
		System.out.println("=========================");
		
	}
}
