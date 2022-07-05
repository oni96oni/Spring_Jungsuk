<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.Random"%>
<%-- <%! 클래스 영역 %> --%>
<%!  
	int getRandomInt(int range){
		return new Random().nextInt(range)+1;
	}
%>
<%-- <%  메서드 영역 - service()의 내부 %> --%>
<%
	int idx1 = getRandomInt(6);
	int idx2 = getRandomInt(6);
%>
<html>
<head>
	<title>twoDice.jsp</title>
</head>
<body>
<%-- 여기서 소스주소 resources를 삭제했는데 내가 어떤 부분을 건들여서 그런지 잘 모르겠다. --%>
	<img src='img/dice<%=idx1%>.jpg'>
	<img src='img/dice<%=idx2%>.jpg'>
</body>
</html>