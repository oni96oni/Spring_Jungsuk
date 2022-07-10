package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {//HttpServletRequest request을 써도 되지만 이렇게 session을 써줘도 된다 스프링에서 넣어준다.
		//1 . 세션을 종료
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, String toURL, boolean rememberId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("id = "+id);
		System.out.println("pwd = "+pwd);
		System.out.println("rememberId = "+rememberId);
		// 1. id와 pwd를 확인
		if(!loginCheck(id,pwd)) {
			// 2-1. 일치하지 않으면, loginForm으로 이동
			String msg = URLEncoder.encode("아이디 또는 패스워드가 일치하지 않습니다.", "utf-8");
			
			return "redirect:/login/login?msg="+msg;
		}
		// 2-2. id와 pwd가 일치하면, 홈으로 이동 일치하지않으면, loginForm으로 이동
		
		// ★세션 객체아 id를 저장하는 방법!
		// 세션 객체를 얻어오기 request에서!
		HttpSession session = request.getSession();
		// 세션 객체에 id를 저장
		session.setAttribute("id",id);
		
		if(rememberId) {
			//	1. 쿠키를 생성
			Cookie cookie = new Cookie("id", id); //id에 내가 id로 받은 값을 저장하는거니까 id저장하는것! id=asdf
			// 	2. 응답에 저장
			response.addCookie(cookie);
		} else {
			//쿠키를 삭제
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0); 
			response.addCookie(cookie);
		}
		// 	3. 홈으로 이동
		toURL = toURL==null || toURL.equals("") ? "/" : toURL;
		
		return "redirect:"+toURL;
	}

	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}
