package com.fastcampus.ch2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
//	@RequestMapping(value = "/register/save", method={RequestMethod.GET, RequestMethod.POST}) GET,POST요청 둘다 허용한다는 의미
//	@RequestMapping("/register/add") 신규회원 가입 화면
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm"; //WEB-INF/view/registerForm.jsp
//	}
	
//	@RequestMapping(value = "/register/save", method=RequestMethod.POST) 이렇게 써도되지만 너무길어 그래서 새로운 애너테이션 @PostMapping 사용 할거야 그런데 @PostMapping은 4.3부터 나왔어
	@PostMapping("/register/save")
	public String save(User user, Model m) throws Exception {
		// 1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
			
			m.addAttribute("msg", msg);
			return "redirect:/register/add";
//			return "redirect:/register/add?msg="+msg; //URL재작성(rewriting) 위에 방법이 모델을 통해서 전달하는 방법.
		}
		
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
