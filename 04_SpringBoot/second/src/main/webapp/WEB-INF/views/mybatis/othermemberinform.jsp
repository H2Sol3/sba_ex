<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>${otherinform.name }���� �����Դϴ�. (�����ڸ�)</h1>
<h3>���̵� : ${otherinform.id}</h3>
<h3>�̸��� : ${otherinform.email}</h3>
<h3>�� : ${otherinform.phone}</h3>
<h3>�ּ� : ${otherinform.address}</h3>
<h3>���� : <img src="http://localhost:8085/upload/${otherinform.image}"></h3>

<script>
	alert('${updateresult}');
</script>
</body>
</html>