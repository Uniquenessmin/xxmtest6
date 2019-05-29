  <!-- JSTL1.1 的声明是： -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; ISO-8859-1" language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生选课</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <!--<link rel="stylesheet" type="text/css" href="pages/css/studentIndex.css">  -->  
    
    <script type="text/javascript" src="href/jquery-3.4.0.js"></script>
    <script type="text/javascript">
        //选择课程
        $(document).ready(
                function() {
                $("input[name='select']").click(function(){
                    var node = $(this);
                    //获取剩余量
                  //通过td里面的元素获得tr,使用tr的children（“td”） 方法获取所有的td，在通过eq(1) 拿第二个td
                    var remainNum = $(this).parent().parent().children("td").eq(1).html();
                    console.log(remainNum);
                    if (!(remainNum == "0")) {
                        $.ajax({
                            url:"http://localhost:8080/xxmtest6/RemainAddServlet",    //请求的url地址
                            dataType:"json",    //返回格式为json
                            async:true,    //请求是否异步，默认为异步，这也是ajax重要特性
                            data:{"id":$(this).attr("id")},    //参数值
                            type:"POST",    //请求方式
                            beforeSend:function(){
                                //请求前的处理
                            },
                            success:function(req){
                                //请求成功时处理
                                //node.parent().parent().remove();
                                node.parent().parent().children("td").eq(1).html(parseInt(remainNum)-parseInt(1));
                                alert("已选中！");
                                document.getElementById("stuInfoIframe").contentWindow.location.reload(true);
                            },
                            complete:function(){
                                //请求完成的处理
                                //alert("请求完成！");
                            },
                            error:function(){
                                //请求出错处理
                                alert("重复选择！");
                            }
                        });
                    } else {
                        alert("此课程人数已满！");
                    }
                });
            });
    </script>
  </head>
  
  <body>
  <header><a style="flow :right" href="index.jsp">退出登录</a></header>
      <h3>学生选课界面</h3>
      <form action="SearchServlet" method="post">
          查找：<input type="text" name="search" value=<%=request.getParameter("search") == null?"":request.getParameter("search")%> >
          <input type="submit" value="搜索" name="ok" />
      </form>
      <br><br>
    <table class="table">
        <tr>
            <td>课程名称</td>
            <td>剩余量</td>
            <td>总数量</td>
            <td>任课教师</td>
            <td>课程地点</td>
            <td>课程时间</td>
            <td>课程时长</td>
            <td>操作</td>
        </tr>
        
        <c:forEach items="${courseList}" var="courseList">
        <tr>
            <td>${courseList.courseName }</td>
            <td>${courseList.courseRemain }</td>
            <td>${courseList.courseTotal }</td>
            <td>${courseList.courseTeacher }</td>
            <td>${courseList.coursePlace }</td>
            <td>${courseList.courseTime }</td>
            <td>${courseList.courseTimelength }</td>
            <td>
                <input type="button" value="选中" name="select" id="${courseList.courseId}"/>
            </td>
        </tr>
        </c:forEach>
    </table>
    
    <br><br>
    <hr>
    <br><br>
    <h2>我的选课</h2>
    <frameset>
        <iframe style="width: 80%;" id="stuInfoIframe" src="StudentInfoServlets"></iframe>
    </frameset>
  </body>
</html>
