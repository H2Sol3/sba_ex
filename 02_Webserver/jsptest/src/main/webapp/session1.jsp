<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%> <!-- false로 해두면 오류남 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	MemberDTO dto = new MemberDTO();
	
	dto.setId(id);
	dto.setPw(pw);
	dto.setName(name);
//	HttpSession session = request.getSession(); 이미 자동으로 생성되어있음
session.setAttribute("sessiondto", dto);
	%>

<%="출력" %> <!--out.println("출력"); 같은 문장 -->
</body>
</html>