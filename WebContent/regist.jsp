<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h2 align=center>注册页面</h2>
	<center>
  	
  		<form action="RegisterServlet" method="post" >  
  			<table  border="1">
  				<tr>
  					<td>学号：</td>
  					<td><input name="userNo"></td>
  				</tr>
  				<tr>
  					<td>姓名：</td>
  					<td><input name="userName"></td>
  				</tr>
  				<tr>
  					<td>密码：</td>
  					<td><input name="password" type="password"></td>
  				</tr>
  				
  				<tr>
  					<td>院系：</td>
  					<td><input name="major"></td>
  				</tr>
  				<tr>
  					<td>年级：</td>
  					<td><input name="grade"></td>
  				</tr>
  				<tr>
  					<td>班级：</td>
  					<td><input name="sclass"></td>
  				</tr>
  				<tr align="center">
  					<td colspan="2"><input type="submit" value="提交注册"><input type = "reset" value = "重置"></td>
  				</tr>
  			</table>
  		</form>
  		
  		您有账号？<a href="login.jsp"><front color="GREEN" >点击直接登录</front></a>
  	</center>	

</body>
</html>