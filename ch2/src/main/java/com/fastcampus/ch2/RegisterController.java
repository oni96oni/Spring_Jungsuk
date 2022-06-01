package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService();
		System.out.println("conversionService = " + conversionService);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df,false));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
	}
	
	@RequestMapping(value = "/add", method={RequestMethod.GET, RequestMethod.POST}) //GET,POST요청 둘다 허용한다는 의미
	public String register() {
		return "registerForm"; //WEB-INF/view/registerForm.jsp
	}
	
//	@RequestMapping(value = "/register/save", method=RequestMethod.POST) 이렇게 써도되지만 너무길어 그래서 새로운 애너테이션 @PostMapping 사용 할거야 그런데 @PostMapping은 4.3부터 나왔어
	@PostMapping("/save")
	public String save(User user, BindingResult result, Model m) throws Exception {
		System.out.println("result="+result);
		System.out.println("user="+user);
		// 1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
			
			m.addAttribute("msg", msg);
			return "forward:/register/add";
//			return "redirect:/register/add?msg="+msg; //URL재작성(rewriting) 위에 방법이 모델을 통해서 전달하는 방법.
		}
		
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
