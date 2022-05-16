package com.fastcampus.ch22;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	int iv = 10; //인스턴스 변수
	static int cv = 20; //static 변수
	
	@RequestMapping("/hello")
	private void main() { //인스턴스메서드!
		System.out.println("Hello - private");
		System.out.println(cv);
		System.out.println(iv);
	}
	
	public static void main2() {
		System.out.println(cv); //ok
//		System.out.println(iv); //에러
	}
}
