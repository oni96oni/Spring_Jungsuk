package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {

	public static void main(String[] args) throws Exception{
//		Hello hello = new Hello();
//		hello.main(); // private이라서 외부 호출 불가
		
		/*
		 * 아까는 어떻게 호출된것? 
		 * Reflection API를 사용하기 때문 -> 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공
		 * java.lang.reflect패키지를 제공
		 */
		
		/*
		 * Hello클래스의 Class객체(클래스의 정보를 담고 있는 객체)를 얻어온다.
		 * 참고로 클래스파일이 메모리에 올라갈 때, 클래스 파일마다 Class객체가 하나씩 생성된다.
		 */
		Class helloClass = Class.forName("com.fastcamplus.ch22.Hello");
		
		Hello hello = (Hello)helloClass.newInstance(); //Class객체가 가진 정보로 객체 생성, 반환타입이 object라서 형변환 필요
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); // private인 main()을 호출 가능하게 한다.
		
		main.invoke(hello); //hello.main()를 호출한것과 동일
	}

}
