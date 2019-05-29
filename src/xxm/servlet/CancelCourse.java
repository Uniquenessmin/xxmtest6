package xxm.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xxm.dao.CourseDao;


/**
 * 删除课程
 * @author Administrator
 *
 */
@WebServlet("/CancelCourse")
public class CancelCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
		String courseId = request.getParameter("newNo");
		 //删除数据
        CourseDao dao = new CourseDao();
       
			try {
				Connection conn = dao.getConnection();
				String sql = "delete from course where course_Id = " + courseId;
				Statement statement = (Statement) conn.createStatement();
				
				if(courseId == null) {
                    courseId = "";
                    response.sendRedirect("/xxmtest6/FindCourseServlet");
                    
                    return;
              }
				response.sendRedirect("/xxmtest6/FindCourseServlet");
				statement.executeUpdate(sql);
				statement.close(); 
	              conn.close(); 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
			
			}
			
			
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
