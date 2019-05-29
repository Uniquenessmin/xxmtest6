<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  

<script type="text/javascript" src="href/jquery-3.4.0.js"></script>

<title>课程后台管理</title>
</head>
<body>
<header><a href="index.jsp">退出登录</a></header>

    <div id="app">

        <!-- 标题 -->
        <div class="jumbotron jumbotron-fluid py-3">
            <div class="container">
                <h1 class="display-3">选课后台管理</h1>
                <p class="lead"></p>
            </div>
        </div>
         <!-- 主体 -->
        <div class="container-fluid">
            <div class="row">
            <form action="CreateCourseServlet">
                <div class="col-lg-14 col-sm-12">
                    <!-- 输入表单 -->
                    
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title" style="color:blue">添加课程</h4>
                            <!-- 输入框 -->
                            <div class="form-group">
                              <label for="">课程名字</label>
                              <input type="text" 
                                class="form-control form-control-lg"
                                
                                name="cName">
                            </div>
                            <div class="form-group">
                              <label for="">任课老师</label>
                              <input type="text"
                                class="form-control form-control-lg"
                                
                                name="cTeacher">
                            </div>
                            <div class="form-group">
                              <label for="">上课地点</label>
                              <input type="text"
                                class="form-control form-control-lg"
                                
                                name="cPlace">
                                 
                                  </div>
                                <div class="form-group">
                              <label for="">上课时间</label>
                              <input type="text"
                                class="form-control form-control-lg"
                                
                                name="cTime">
                            </div>
                            <div class="form-group">
                              <label for="">课时</label>
                              <input type="text"
                                class="form-control form-control-lg"
                                
                                name="cLong">
                            </div>
                            <div class="form-group">
                              <label for="">上课总人数</label>
                              <input type="text"
                                class="form-control form-control-lg"
                                
                                name="cTotal">
                            </div>
                            <div class="form-group">
                              <label for="">剩余可选数</label>
                              <input type="text"
                                class="form-control form-control-lg"
                                name="cRemain">
                            </div>
                              
                            </div>

                            <!-- 按钮 -->
                            <input type="submit" class="btn btn-primary btn-lg btn-block" value="创建">
                     </div>
                     </div>   
                    
                </form>
                
                
                <div class="col-lg-8 col-sm-12">
                    <!-- 表格 -->
                    <table class="table text-center">
                        <thead>
                            <tr class="text-center">
                                <th>编号</th>
                                <th style="width: 12% ">课程名</th>
                                <th>任课老师</th>
                                <th>上课地点</th>
                                <th style="width: 25% ">上课时间</th>
                                <th style="width: 7%">课时</th>
                                <th style="width: 7%">总人数</th>
                                <th >剩余数</th>
                                <th style="width: 18% " >操作</th>
                            </tr>
                        </thead>
                        
         <c:forEach items="${courseList}" var="courseList">
        <tr>
        	<td>${courseList.courseId}</td>
            <td>${courseList.courseName }</td>
            
            <td>${courseList.courseTeacher }</td>
            <td>${courseList.coursePlace }</td>
            <td>${courseList.courseTime }</td>
            
            <td>${courseList.courseTimelength }</td>
            
            <td>${courseList.courseTotal }</td>
            <td>${courseList.courseRemain }</td>
            <td >
                  <div class="row">
                                        <div class="col-lg-6 col-sm-12 " >
                                            <button type="button"  class="btn btn-primary " data-toggle="modal" data-target="#edit1${courseList.courseId}">编辑</button>
                                            <!-- 对话框 5.2 -->

                                            
                                            <!-- Modal 模态对话框 -->
                                            <div class="modal fade" id="edit1${courseList.courseId}" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title">编辑</h5>
                                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                    <span aria-hidden="true">&times;</span>
                                                                </button>
                                                        </div>
                                                        <div class="modal-body">
                                <!-- 开始编辑 -->
                                <form action="AdminCourseServlet" name="edit" method="post">
                                <div class="form-group">
                                    <!-- 课程号作为id，不显示，根据id进行修改 -->
                                    <input type="hidden" class="form-control" name="newNo" id="newNo"
                                      aria-describedby="helpId" value="${courseList.courseId}">
                                  </div>
                                 <div class="form-group">
                              <label for="">课程名字</label>
                              <input type="text" 
                                class="form-control form-control-lg"
                                value="${courseList.courseName }"
                                name="ccName">
                            </div>
                            <div class="form-group">
                              <label for="">任课老师</label>
                              <input type="text"
                                class="form-control form-control-lg"
                                value="${courseList.courseTeacher }"
                                name="ccTeacher">
                            </div>
                            <div class="form-group">
                              <label for="">上课地点</label>
                              <input type="text"
                                class="form-control form-control-lg"
                                value="${courseList.coursePlace }"
                                name="ccPlace">
                                 
                                  </div>
                                <div class="form-group">
                              <label for="">上课时间</label>
                              <input type="text"
                                class="form-control form-control-lg"
                                value="${courseList.courseTime }"
                                name="ccTime">
                            </div>
                            <div class="form-group">
                              <label for="">课时</label>
                              <input type="text"
                                class="form-control form-control-lg"
                                value="${courseList.courseTimelength }"
                                name="ccLong">
                            </div>
                            <div class="form-group">
                              <label for="">上课总人数</label>
                              <input type="text"
                                class="form-control form-control-lg"
                                value="${courseList.courseTotal}"
                                name="ccTotal">
                            </div>
                            <div class="form-group">
                              <label for="">剩余可选数</label>
                              <input type="text"
                                class="form-control form-control-lg"
                                value="${courseList.courseRemain }"
                                name="ccRemain">
                            </div>
                                              
                              <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                                            <input type="submit"  class="btn btn-primary" value="修改">
                                                        </div>
                             </form>
                                                    
                                                    </div>
                                                </div>
                                            </div>
                                            
                                        </div>
                                        
                                        <div class="col-lg-6 col-sm-12 " >
                                        <form action="CancelCourse">
                                        	
                                            <input type="submit"  class="btn btn-danger " value="删除">
                                        <input type="hidden" class="form-control" name="newNo" id="newNo"
                                      aria-describedby="helpId" value="${courseList.courseId}">
                                        </form>
                                        </div>
                                    </div>   
            </td>         
        </tr>
        </c:forEach>
                  
                    </table>
        </div>
            </div>
        </div>
</div>


  <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>