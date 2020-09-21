<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin login</title>
<script type="text/javascript" src="admin.js"></script>
<link rel="stylesheet" href="../admin/css/admin.css">
<script type="text/javascript">
	function worker_check() {
		if (document.formm.adminId.value == "") {
			alert("아이디를 입력하세요.");
			return false;
		} else if (document.formm.adminPw.value == "") {
			alert("비밀번호를 입력하세요.");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<body>
	<div id="wrap">
		<div class="clear"></div>
		<div id="loginform">
			<p align="left">
				<b id="b">Admin mode</b>
			</p>
			<form name="formm" method="post"
				action="HairshopServlet?command=Admin_login">

				<table>
					<tr>
						<td>I D</td>
						<td><input type="text" name="adminId" size="10"
							value="admin"></td>
					</tr>
					<tr>
						<td>P W</td>
						<td><input type="password" name="adminPw" size="10"
							value="1234"></td>
					</tr>
					<tr align="right">
						<td colspan="2"><input type="submit" value="Login"
							onclick="return worker_check()"><br>
						<h4 style="color: red">${message}</h4></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
</body>
</html>