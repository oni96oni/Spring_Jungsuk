package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 원격 호출가능한 프로그램으로 등록!
@Controller
public class Hello {
	
	int iv = 10; // 인스턴스변수
	static int cv = 20; //static변수
	
	// 2.URL과 메서드를 연결
	@RequestMapping("/hello") //private이어도 외부에서 호출가능하게해줘! 이 애너테이션이
	private void main() { //여기 static이 없어도 잘 실행되는 이유는 톰캣 내부에서 객체를 생성해주어서이다!
		System.out.println("Hello - private");
		System.out.println(cv);
		System.out.println(iv);
	}
	
	public static void main2() {
		System.out.println(cv);
//		System.out.println(iv); 에러가 나온다 static 메서드는 cv만 사용가능 그래서 인스턴스 메서드를 주로 사용하는게 좋다!.
	}
}
