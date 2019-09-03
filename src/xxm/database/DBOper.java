package xxm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import xxm.bean.Student;
import xxm.dao.StudentDao;


public class DBOper {

  //驱动
  	private	static String driver = "com.mysql.cj.jdbc.Driver";
  	//database名，选择我要用的数据库shiyan6
  	private	static String url = "jdbc:mysql://localhost:3306/shiyan6?serverTimezone=UTC";
  	//验证用户名和密码
  	private	static String	username = "root";
  	private	static String  passwd= "123456";
  	//数据库的连接对象
  	private static Connection conn = null;
  	//Statement对象
  	private static  PreparedStatement ps = null;
  	 ResultSet rs = null;
  	 
  	/**
  	 * 连接数据库
  	 * @return
  	 * @throws SQLException
  	 */
  	public   Connection getConnection() throws SQLException {
  		try {
  			
  			Class.forName(driver);
  			conn = DriverManager.getConnection(url,username,passwd);//连接数据库
  		} catch (ClassNotFoundException e) {
  			System.err.println("无法连接数据库！");
  		}//加载驱动
  		return conn;		
  	}

    //执行sql语句，可以进行查询
    public ResultSet executeQuery(String preparedSql,String []param){
        try{
            ps = conn.prepareStatement(preparedSql);
            if(param != null){
                for (int i = 0; i < param.length; i++) {
                    ps.setString(i + 1, param[i]);
                }
            }
            rs = ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }       
        return rs;

    }
    //执行sql语句，增加，修改，删除
    public int executeUpdate(String preparedSql,String[]param){
        int num = 0;
        try{
            ps = conn.prepareStatement(preparedSql);
            if(ps != null){
                for (int i = 0; i < param.length; i++) {
                    ps.setString(i + 1, param[i]);
                }
            }
            num = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return num;
    }
    
    public static void main(String[] args) {
		try {
			DBOper dao = new DBOper();
			Connection conn=dao.getConnection();
			if(conn!=null)
			{
				System.out.println("连接数据库正常");
			}
			else {
				System.out.println("连接数据库异常");
			}

		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
}