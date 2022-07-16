package com.fastcampus.ch2;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
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
//		ConversionService conversionService = binder.getConversionService();
//		System.out.println("conversionService = " + conversionService);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df,false)); 주어진 형태로 문자열이 들어오면 Date값으로 변경
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#")); //구분자 #으로 구분해서 나눠서 저장해준다.
//		binder.setValidator(new UserValidator()); // UserValidator를 WebDataBinder의 로컬 validator로 등록
//		binder.addValidators(new UserValidator());
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList = " + validatorList);
	}
	
	@RequestMapping(value = "/add", method={RequestMethod.GET, RequestMethod.POST}) //GET,POST요청 둘다 허용한다는 의미
	public String register() {
		return "registerForm"; //WEB-INF/view/registerForm.jsp
	}
	
//	@RequestMapping(value = "/register/save", method=RequestMethod.POST) 이렇게 써도되지만 너무길어 그래서 새로운 애너테이션 @PostMapping 사용 할거야 그런데 @PostMapping은 4.3부터 나왔어
	@PostMapping("/save")
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {
		System.out.println("result="+result);
		System.out.println("user="+user);
		
		// 수동 검증 - Validator를 직접 생성하고, validate()를 직접 호출
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result); BindingResult는 Errors의 자손
		
		//User객체를 검증한 결과 에러가 있으면, registerForm을 이용해서 에러를 보여줘야한다.
		if(result.hasErrors()) {
			return "registerForm";
		}
		
//		// 1. 유효성 검사 --> 이 부분을 컨트롤러 메서드안에서 처리하지 않고 validator를 만들어서 사용!!
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
//			
//			m.addAttribute("msg", msg);
//			return "forward:/register/add"; // 모델을 통한 전달방법
		
//			return "redirect:/register/add?msg="+msg; // URL재작성(rewriting) 60+61줄 합친것과 동일!
//		}
		
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
