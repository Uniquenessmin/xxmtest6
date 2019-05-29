package xxm.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xxm.bean.Course;
import xxm.database.DBOper;

/**
 * 显示课程信息
 * 
 * @author xxm
 *
 */
@WebServlet("/FindCourseServlet")
public class FindCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }


	 public void process(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	

	        try { 
	             
	        	// 创建Connection连接
	        	DBOper dao = new DBOper();
	              Connection conn = dao.getConnection(); 
	              // SQL语句
	              String sql = "select * from course"; 
	              // 获取Statement
	              Statement statement =  conn.createStatement(); 
	          
	              ResultSet resultSet = statement.executeQuery(sql); 
	          
	              List<Course> courseLists = new ArrayList<Course>(); 
	              while (resultSet.next()) { 
	                Course course = new Course();
	                course.setCourseId(resultSet.getInt("course_Id"));
	                course.setCourseName(resultSet.getString("course_Name"));
	                course.setCourseRemain(resultSet.getInt("course_Remain"));
	                course.setCourseTotal(resultSet.getInt("course_Total"));
	                course.setCourseTeacher(resultSet.getString("course_Teacher"));
	                course.setCoursePlace(resultSet.getString("course_Place"));
	                course.setCourseTime(resultSet.getString("course_Time"));
	                course.setCourseTimelength(resultSet.getString("course_Timelength"));
	                
	                courseLists.add(course);
	              } 
	              request.setAttribute("courseList", courseLists);
	 
	              
	              resultSet.close(); 
	              statement.close(); 
	              conn.close(); 
	          
	            } catch (Exception e) { 
	              e.printStackTrace(); 
	            } 

	        request.getRequestDispatcher("adminCourse.jsp").forward(request, response);
	    }
}
