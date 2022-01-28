<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<h1>${member.member_password }</h1>
 --%>
 	<h1>${member.member_name }</h1>
 	<form id="" action="encryption.do" method="post">
 	<input type="text" id="str" name="str"> &nbsp;

 	<input type="submit" value="암호화">
 	</form>
</body>
</html>