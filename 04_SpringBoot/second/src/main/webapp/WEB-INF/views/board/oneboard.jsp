<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
td{
background-color: skyblue;
}
</style>
</head>
<body>
<!-- <table border=2px style="text-align: center"> -->
<!-- <tr style="background-color: lightgrey"><th>글번호</th><th>제목</th><th>내용</th><th>작성자</th><th>조회수</th><th>날짜</th></tr> -->
<!-- <tr> -->
<%-- <td>${oneboard.seq }</td> --%>
<%-- <td><input type="text" value="${oneboard.title }"></td> --%>
<%-- <td><input type="text" value="${oneboard.contents }"></td> --%>
<%-- <td>${oneboard.writer }</td> --%>
<%-- <td>${oneboard.viewcount }</td> --%>
<%-- <td>${oneboard.writingtime }</td> --%>
<!-- </tr> -->
<!-- <tr> -->
<!-- <td colspan="6"><input type="submit" value="수정버튼"> -->
<!-- <input type="submit" value="삭제버튼"></td> -->
<!-- </tr> -->
<!-- </table> -->

<!-- <table border=2> -->
<%-- <tr><td>게시물번호</td><td>${oneboard.seq }</td></tr> --%>
<%-- <tr><td>제목</td><td><input type="textarea" value="${oneboard.title }"></td></tr> --%>
<%-- <tr><td>내용</td><td><input type="textarea" value="${oneboard.contents }"></td></tr> --%>
<%-- <tr><td>작성자</td><td><input type="textarea" value="${oneboard.writer }"></td></tr> --%>
<%-- <tr><td>조회수</td><td>${oneboard.viewcount }</td></tr> --%>
<%-- <tr><td>날짜</td><td><input type="textarea" value="${oneboard.writingtime }"></td></tr> --%>
<!-- </table> -->

<form action="${submitUrl}">
<table border="2">
<tr>
	<td> 번호 </td> <td> <input type="text" value= " ${oneboard.seq}" readonly>  </td>
</tr>
<tr>
	<td> 제목 </td> <td><input type="text" value= "${oneboard.title}"> </td>
</tr>
<tr>
	<td> 내용 </td> <td> <textarea cols=50 rows=5> ${oneboard.contents}</textarea>  </td>
</tr>
<tr>
	<td> 작성자 </td> <td><input type="text" value= " ${oneboard.writer}" readonly> </td>
</tr>
<tr>
	<td> 조회수 </td> <td> ${oneboard.viewcount} </td>
</tr>
<tr>
	<td> 작성시간 </td> <td> ${oneboard.writingtime} </td>
</tr>
<tr>
	<td colspan="2"> <input type="submit" value="수정 버튼"> <input type="submit" value="삭제 버튼"> </td> 
</tr>

</table>



</body>
</html>