package xxm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xxm.bean.Student;
import xxm.dao.StudentDao;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public RegisterServlet() {
		
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
	        String userno = request.getParameter("userNo");
	        String username = request.getParameter("userName");
	        String userpass = request.getParameter("password");
	        String major = request.getParameter("major");
	        String grade = request.getParameter("grade");
	        String sclass = request.getParameter("sclass");
	        PrintWriter out = response.getWriter();

	        Student user = new Student();
	        user.setNo(userno);
	        user.setName(username);
	        user.setPasswd(userpass);
	        user.setMajor(major);
	        user.setGrade(grade);
	        user.setSclass(sclass);
	       
	        StudentDao dao = new StudentDao();
	        try {
				Connection conn = dao.getConnection();
				if(conn!=null) {
					out.print("conn is not null");
				}
				 if(dao.addUser(user)){
			            out.print("注册成功！");
			            response.sendRedirect("login.jsp");
			        }
			        else{
			            out.print("注册失败！");
			        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }

}
