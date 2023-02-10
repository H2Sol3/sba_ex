<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
가입화면<br>

<form action="<%=request.getContextPath() %>/memberinsert" enctype="multipart/form-data" method=post>  
아이디<input type=text name="id" id="id" required><br>
암호<input type=password name="pw" id="pw"><br>
이름<input type=text name="name" id="name"><br>
폰<input type=text name="phone" id="phone" pattern="010[0-9]{4}[0-9]{4}"><br>
이메일<input type=email name="email" id="email"><br>
주소<input type=text name="address" id="address"><br>
사진선택<input type=file name="imagefile" id=imagefile><br>
가입일자동전송<input type=hidden name="indate" value="<%=new java.util.Date()%>" > 
<input type=submit value="회원가입">
</form>
</body>
</html>