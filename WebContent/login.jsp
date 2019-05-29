<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生登录</title>
</head>
　
<body style="text-align: center;">
      <br><br>
      <h3>学生登录</h3>
      <form action="LoginServlet" method="post">
          学号：<input type="text" name="stuno">
          <br><br>
          密码：<input type="password" name="stupassowrd">
          <br><br>
          <input type="submit" value="登录" name="submit">
          <a href="regist.jsp" role="button">注册</a>
          <a href="index.jsp">返回</a>
      </form>
 </body>

</html>