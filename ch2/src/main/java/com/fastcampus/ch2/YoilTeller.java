package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
public class YoilTeller {
	@RequestMapping("/getYoil") // http://localhost:8080/ch2/getYoil?year=2022&month=8&day=4
	//    public static void main(String[] args) {
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//        String year = args[0];
		//        String month = args[1];
		//        String day = args[2];
		// 1. 입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");

		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);

		// 2. 처리
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1:일요일, 2:월요일, ...
		char yoil = " 일월화수목금토".charAt(dayOfWeek);

		// 3. 출력
//      System.out.println(year + "년 " + month + "월 " + day + "일은 ");
//      System.out.println(yoil + "요일입니다.");
		response.setContentType("text/html");    // 응답의 형식을 html로 지정 (타입을 정해주어야해!)
		response.setCharacterEncoding("utf-8");  // 응답의 인코딩을 utf-8로 지정
		PrintWriter out = response.getWriter();  // responser 객체에서 브라우저로의 출력 스트림(out)을 얻는다.(브라우저 페이지소스에서 확인가능
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println(year + "년 " + month + "월 " + day + "일은 ");
		out.println(yoil + "요일입니다.");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}