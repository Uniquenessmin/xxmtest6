package xxm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xxm.database.DBOper;

/**
 * Servlet implementation class RemainAddServlet
 */
@WebServlet("/RemainAddServlet")
public class RemainAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        process(req, resp);
	    }
	 
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        process(req, resp);
	    }
	    
	    protected void process(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        try { 
	        	DBOper db = new DBOper();
	              Connection conn = db.getConnection(); 
	              Statement statement = (Statement) conn.createStatement(); 
	 
	              //String keyString = new String(req.getParameter("id").getBytes("iso-8859-1"), "utf-8");
	              
	              req.setCharacterEncoding("UTF-8");
	              //课程号
	              String keyString = req.getParameter("id");
	              
	              if(keyString == null) {
	                    keyString = "";
	                    resp.sendRedirect("/FindServlet");
	                    
	                    return;
	              }
	              
	              //添加课程,只能选一门课程
	              String numSession = (String) req.getSession().getAttribute("numSession");
	              String sql1 = "select selected_course from student where sno = " + numSession;
	              ResultSet resultSet = statement.executeQuery(sql1);
	              String course = "";
	              while (resultSet.next()) {
	                  course = resultSet.getString("selected_course");
	              }
	              
	              //还没有选课
	              if(course==null||course.length()==0) {
	            	  
	            	  //修改课程数据
		              String sql2 = "update student set selected_course=\'" + keyString + "\' where sno = " + numSession;
		              statement.executeUpdate(sql2);
	              
		              //课程余量-1
		              String sql = "update course set course_Remain=course_Remain-1 where course_Id = \'"+ keyString + "\'";
		              statement.executeUpdate(sql);
	              
	              }else {
	            	  PrintWriter pw = resp.getWriter();
	            	  pw.println("<h4>重复选课</h4>");
	              }
	              
	             
	              statement.close(); 
	              conn.close(); 
	            } catch (Exception e) { 
	              e.printStackTrace(); 
	            }
	        
	        resp.getWriter().print("{\"data\":\"返回json数据！\"}"); 
	    }
	
}
