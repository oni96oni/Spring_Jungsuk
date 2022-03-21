package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class ModelController {
	public String main(HashMap map) {
		// 작업 결과를 map에 저장
		map.put("id", "asdf");
		map.put("pwd", "1111");
		
		return "txtView2"; // 뷰이름을 반환
	}
}

public class MethodCall {
	public static void main(String[] args) throws Exception{
		HashMap map = new HashMap();
		System.out.println("before:"+map);

		ModelController mc = new ModelController(); //컨트롤러 생성
		String viewName = mc.main(map);
		
		System.out.println("after :"+map);
		
		render(map, viewName); // data와 txtView 데이터를 가지고 view로 보여준다 ${key} -> ${value} 로 해당 맵핑되는 값을 치환해서 보여준다.
	}
	
	static void render(HashMap map, String viewName) throws IOException {
		String result = "";
		
		// 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
		Scanner sc = new Scanner(new File(viewName+".txt"));
		
		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();
		
		// 2. map에 담긴 key를 하나씩 읽어서 template의 ${key}를 value바꾼다.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();

			// 3. replace()로 key를 value 치환한다.
			result = result.replace("${"+key+"}", (String)map.get(key));
		}
		
		// 4.렌더링 결과를 출력한다.
		System.out.println(result);
	}
}
