package xxm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xxm.database.DBOper;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
        PrintWriter out = response.getWriter();
        String stuno = request.getParameter("stuno");
        String stupass = request.getParameter("stupassowrd");    
        DBOper db = new DBOper();
        try {
        	db.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        String sql = "SELECT sno,spassword FROM student WHERE sno = ? AND spassword = ?";
        ResultSet rs = db.executeQuery(sql,new String[]{stuno,stupass});
        try {
            if(rs != null && rs.next()){
                HttpSession session = request.getSession();

                session.setAttribute("numSession", stuno);
                Cookie cookie = new Cookie("stuno",stuno);
                cookie.setMaxAge(60*60*24*30);
                response.addCookie(cookie);
                //登录成功，跳转...
   
                RequestDispatcher dispatcher = request.getRequestDispatcher("/FindServlet");
                dispatcher.forward(request,response);
            }else{
                out.print("登录失败");
                out.print("<br><a href = 'login.jsp'>重新登陆</a>");
//                response.setContentType("text/html;charset=UTF-8");
//               
//                response.setHeader("refresh", "0; url=/StudentSelect");

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void init()throws ServletException {

    }

}
