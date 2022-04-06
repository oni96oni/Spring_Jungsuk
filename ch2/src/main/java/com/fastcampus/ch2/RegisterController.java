package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
	
//	@RequestMapping(value="/register/save", method={RequestMethod.GET,RequestMehod.POST})
//	@RequestMapping("/register/add") 신규회원 가입 화면
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm"; // WEB-INF/view/registerForm.jsp
//	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) 길어서 아래처럼 쓴다
	@PostMapping("/register/save") //spreing4.3부터 포스트매핑추가
	public String save(User user, Model m) throws Exception{
		//1.유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
			
			m.addAllAttributes("msg",msg);
			return "redirect:/register/add?msg="+msg; //URL 재작성(rewriting)
		}
		
		//2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
	
	return false;
}
}
