package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. ���� ȣ�Ⱑ���� ���α׷����� ���!
@Controller
public class Hello {
	
	int iv = 10; // �ν��Ͻ�����
	static int cv = 20; //static����
	
	// 2.URL�� �޼��带 ����
	@RequestMapping("/hello") //private�̾ �ܺο��� ȣ�Ⱑ���ϰ�����! �� �ֳ����̼���
	private void main() { //���� static�� ��� �� ����Ǵ� ������ ��Ĺ ���ο��� ��ü�� �������־�̴�!
		System.out.println("Hello - private");
		System.out.println(cv);
		System.out.println(iv);
	}
	
	public static void main2() {
		System.out.println(cv);
//		System.out.println(iv); ������ ���´� static �޼���� cv�� ��밡�� �׷��� �ν��Ͻ� �޼��带 �ַ� ����ϴ°� ����!.
	}
}
