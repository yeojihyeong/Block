<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
	<div><h1>로 끄 인</h1></div>
	<div>
		<form id="frm" action="login.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">아 이 띠</th>
						<th width="200">
							<input type="email" id="member_id" name="member_id">
						</th>
					</tr>
					<tr>
						<th width="150">패스워드</th>
						<th width="200">
							<input type="password" id="member_password" name="member_passowrd">
						</th>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취쏘우"> 
			</div>
		</form>
	</div>
</div>
</body>
</html>