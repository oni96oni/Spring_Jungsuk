package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class TwoDice {
    @RequestMapping("/rollDice")
    //    public static void main(String[] args) { , 매개변수에 response만 있으므로 입력은 없고 출력만있는 모습 
    public void main(HttpServletResponse response) throws IOException {
        int idx1 = (int)(Math.random()*6)+1;
        int idx2 = (int)(Math.random()*6)+1;

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src='img/dice"+idx1+".jpg'>");
        out.println("<img src='img/dice"+idx2+".jpg'>");
        out.println("</body>");
        out.println("</html>");
        out.close();
        //프린트문으로 html형식을 출력만해주면 된다! 브라우저에 내가원하는 모습을 출력하기위해서는
        //나는 경로에 resources를 빼주어야 경로를 자세히 찾을 수 있다.
    }
}