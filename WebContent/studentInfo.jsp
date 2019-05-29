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
    
    <title>学生课程</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
     <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script type="text/javascript" src="href/jquery-3.4.0.js"></script>
    <script type="text/javascript">
    //学生课程
    $(document).ready(
        function() {
            $.ajax({
                url:"http://localhost:8080/xxmtest6/StudentInfoServlets",    //请求的url地址
                //dataType:"text",   //返回格式
                async:true,//请求是否异步，默认为异步，这也是ajax重要特性
                data:{
                },    //参数值,发送个服务端的数据
                type:"GET",   //请求方式
                beforeSend:function(){
                    //请求前的处理
                },
                success:function(req){
                    //请求成功时处理
                    //alert("学生课程显示成功！");
                },
                complete:function(){
                    //请求完成的处理
                    //alert("请求完成！");
                },
                error:function(){
                    //请求出错处理
                    //alert("学生课程显示失败！");
                }
            });
        });
    
        //取消课程
        $(document).ready(
                function() {
                $("input[name='cancel']").click(function(){
                    var node = $(this);
                    var nodeId = $(this).attr("id");
                    var remainNum = $("#"+nodeId, window.parent.document).parent().parent().children("td").eq(1).html();
                    
                    $.ajax({
                        url:"http://localhost:8080/xxmtest6/CancelServlet",    //请求的url地址
                        dataType:"json",   //返回格式为json
                        async:true,//请求是否异步，默认为异步，这也是ajax重要特性
                        data:{"id":$(this).attr("id")},    //参数值
                        type:"POST",   //请求方式
                        beforeSend:function(){
                            //请求前的处理
                        },
                        success:function(req){
                            //请求成功时处理
                               /* var iframe = window.parent;
                            var div =iframe.document.getElementById(nodeId);
                            alert(div.length); */
                            node.parent().parent().remove();
                             $("#"+nodeId, window.parent.document).parent().parent().children("td").eq(1).html(parseInt(remainNum)+parseInt("1"));
                             alert("取消成功！");
                            //window.location.reload();
                        },
                        complete:function(){
                            //请求完成的处理
                            //alert("请求完成！");
                        },
                        error:function(){
                            //请求出错处理
                            alert("取消失败！");
                        }
                    });
                });
            });
    </script>
  </head>
  
  <body>
      <table class="table">
        <tr>
            <td>课程名称</td>
            <td>任课教师</td>
            <td>课程地点</td>
            <td>课程时间</td>
            <td>课程时长</td>
            <td>操作</td>
        </tr>
        
        <c:forEach items="${studentCourseList }" var="studentCourseList">
        <tr>
            <td>${studentCourseList.courseName }</td>
            <td>${studentCourseList.courseTeacher }</td>
            <td>${studentCourseList.coursePlace }</td>
            <td>${studentCourseList.courseTime }</td>
            <td>${studentCourseList.courseTimelength }</td>
            <td>
                <input type="button" value="取消" name="cancel" id="${studentCourseList.courseId }" />
            </td>
        </tr>
        </c:forEach>
    </table>
  </body>
</html>
