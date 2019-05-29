package xxm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xxm.bean.Course;
import xxm.bean.Student;
import xxm.dao.CourseDao;
import xxm.dao.StudentDao;

/**
 * 创建课程，管理员
 * 
 * @author xxm
 *
 */
@WebServlet("/CreateCourseServlet")
public class CreateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset = utf-8");
        String cName = request.getParameter("cName");
        String cTeacher = request.getParameter("cTeacher");
        String cPlace = request.getParameter("cPlace");
        String cTime = request.getParameter("cTime");
        String cLong = request.getParameter("cLong");
        int cTotal = Integer.parseInt(request.getParameter("cTotal"));
        int cRemain = Integer.parseInt(request.getParameter("cRemain"));
        PrintWriter out = response.getWriter();
        
        //设置属性
        Course course = new Course();
        course.setCourseName(cName);
        course.setCourseTeacher(cTeacher);
        course.setCoursePlace(cPlace);
        course.setCourseTime(cTime);
        course.setCourseTimelength(cLong);
        course.setCourseTotal(cTotal);
        course.setCourseRemain(cRemain);
        
        //添加到数据库
        CourseDao dao = new CourseDao();
        try {
			Connection conn = dao.getConnection();
			if(conn!=null) {
				out.print("conn is not null");
			}
			 if(dao.addCourse(course)){
		            out.print("添加成功！");
		            System.out.println("成功！");
		            response.sendRedirect("/xxmtest6/FindCourseServlet");
		        }
		        else{
		            out.print("添加失败！");
		            System.out.println("失败！");
		            response.sendRedirect("/xxmtest6/FindCourseServlet");
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
