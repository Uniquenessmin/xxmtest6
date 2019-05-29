package xxm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import xxm.bean.Student;
import xxm.database.DBOper;


public class StudentDao extends DBOper{

	Connection conn =null;
	
	public StudentDao() {

		try {
			conn= super.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 添加学生用户
     * @param student
     * @return
     */
    public boolean addUser(Student student){
        boolean r = false;
       
        String sql = "INSERT INTO student(sno,sname,spassword,smajor,sclass,sgrade) VALUES(?,?,?,?,?,?);";
       
        try{

           int num = this.executeUpdate(sql,new String[]{student.getNo(),student.getName(),student.getPasswd(),student.getMajor(),student.getSclass(),student.getGrade()});
            if(num > 0){
                r = true;
               
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //this.closeAll();
        }
        return r;
    }
    
}

