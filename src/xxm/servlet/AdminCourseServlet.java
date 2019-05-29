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

import xxm.bean.Course;
import xxm.dao.CourseDao;

/**
 * 修改课程数据
 * 
 * @author xxm
 *
 */
@WebServlet("/AdminCourseServlet")
public class AdminCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
		int cid = Integer.parseInt(request.getParameter("newNo"));
		String cteach = request.getParameter("ccTeacher");
		String cname = request.getParameter("ccName");
		String cplace = request.getParameter("ccPlace");
		String ctime = request.getParameter("ccTime");
		String clong = request.getParameter("ccLong");
		int ctotal= Integer.parseInt(request.getParameter("ccTotal"));
		int cremain = Integer.parseInt(request.getParameter("ccRemain"));
		System.out.printf("%d,%s,%s,%s,%s,%s,%d,%d\n",cid,cteach,cplace,cname,ctime,clong,ctotal,cremain);
		System.out.println("===========");
		//设置属性
        Course course = new Course();
        course.setCourseId(cid);
        course.setCourseName(cname);
        course.setCourseTeacher(cteach);
        course.setCoursePlace(cplace);
        course.setCourseTime(ctime);
        course.setCourseTimelength(clong);
        course.setCourseTotal(ctotal);
        course.setCourseRemain(cremain);
		
		 //修改数据
        CourseDao dao = new CourseDao();
       
			try {
				Connection conn = dao.getConnection();
				if(dao.update(course)) {
					System.out.println("修改成功！");
				}else {
					System.out.println("修改失败！");
				}
			
	              conn.close(); 
	              response.sendRedirect("/xxmtest6/FindCourseServlet");
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
