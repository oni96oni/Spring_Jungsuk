package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
public class YoilTellerMVC {
		@RequestMapping("/getYoilMVC")
		public ModelAndView main(int year, int month, int day) throws IOException {
			//이 String이 view의 이름이다.
			
			ModelAndView mv = new ModelAndView();
			//1.유효성 검사
			
//			if(!isValid(year,month,day)) {
//				return "yoilError";
//			}
			
//			// 2. 요일 계산
			char yoil = getYoil(year, month, day);
			
			// 3. 계산한 결과를 model에 저장
			mv.addObject("year", year);
			mv.addObject("month", month);
			mv.addObject("day", day);
			mv.addObject("yoil", yoil);
			
			// 4. 결과를 보여줄 view를 지정
			mv.setViewName("yoil");
			
			return mv;
			
//			return "yoil"; // /WEB-INF/views/yoil.jsp 위치는 항상 동일하니까 yoil만 써도 알아먹는다. servlet-context에서 접두 점미를 붙여주기때문

	}

		private boolean isValid(int year, int month, int day) {
			return true;
		}

		private char getYoil(int year, int month, int day) {
			Calendar cal = Calendar.getInstance();
			cal.set(year, month - 1, day);

			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1:일요일, 2:월요일, ...
			return " 일월화수목금토".charAt(dayOfWeek);
		}
}