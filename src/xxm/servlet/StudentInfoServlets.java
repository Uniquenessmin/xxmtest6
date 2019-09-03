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
import xxm.bean.Student;
import xxm.database.DBOper;

/**
 * Servlet implementation class StudentInfoServlets
 */
@WebServlet("/StudentInfoServlets")
public class StudentInfoServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInfoServlets() {
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
    
    protected void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try { 
            
              Connection conn = (new DBOper()).getConnection(); 
              Statement statement = (Statement) conn.createStatement(); 
              
              String numSession = (String) req.getSession().getAttribute("numSession");
              String sql1 = "select * from student where sno = " + numSession;
          
              ResultSet resultSet = statement.executeQuery(sql1); 
  
              List<Student> courseStudentList = new ArrayList<Student>(); 
              while (resultSet.next()) { 
                  Student student = new Student();
                  student.setSelectedCourse(resultSet.getString("selected_course"));
                  //将学生加入到课程列表
                  courseStudentList.add(student); 
              } 
 
              String courseStudentString= courseStudentList.get(0).getSelectedCourse();
              String[] array = courseStudentString.split(",");
              
              List<Course> studentCourseList = new ArrayList<Course>(); 
              for (String s:array) {
                  String sql2 = "select * from course where course_Id = " + s ;
                  resultSet = statement.executeQuery(sql2);
                  
                  while (resultSet.next()) {
                      Course course = new Course();
                      course.setCourseId(resultSet.getInt("course_Id"));
                      course.setCourseName(resultSet.getString("course_Name"));
                      course.setCourseTeacher(resultSet.getString("course_Teacher"));
                      course.setCoursePlace(resultSet.getString("course_Place"));
                      course.setCourseTime(resultSet.getString("course_Time"));
                      course.setCourseTimelength(resultSet.getString("course_Timelength"));
                      //将课程加入学生课程列表
                      studentCourseList.add(course);
                  }
              }
 
              req.setAttribute("studentCourseList", studentCourseList);

              resultSet.close(); 
              statement.close(); 
              conn.close(); 
          
            } catch (Exception e) { 
              e.printStackTrace(); 
            } 
           
            resp.setCharacterEncoding("UTF-8");
            req.getRequestDispatcher("studentInfo.jsp").forward(req, resp);
    }

}
