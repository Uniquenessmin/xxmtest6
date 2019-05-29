package xxm.dao;

import java.sql.Connection;
import java.sql.SQLException;

import xxm.bean.Course;
import xxm.bean.Student;
import xxm.database.DBOper;

/**
 * 课程管理
 * 
 * @author xxm
 *
 */
public class CourseDao  extends DBOper{

	Connection conn =null;
	
	public CourseDao(){
		try {
			conn= super.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** 
	 * 添加选课课程
    * @param course
    * @return
    */
   public boolean addCourse(Course course){
       boolean r = false;
      
       String sql = "INSERT INTO course(course_Name,course_Remain,course_Total,course_Teacher,course_Place,course_Time,course_Timelength) VALUES(?,?,?,?,?,?,?);";
      
       try{

          int num = this.executeUpdate(sql,new String[]{course.getCourseName(),String.valueOf(course.getCourseRemain()),String.valueOf(course.getCourseTotal()),course.getCourseTeacher(),course.getCoursePlace(),course.getCourseTime(),course.getCourseTimelength()});
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
   
  
   public boolean update(Course course) {
	   
	   String sql = "update course set course_Name=?,course_Teacher=?,course_Place=?,course_Time=?,course_Timelength=?,course_Total=?,course_Remain=? where course_Id = ? ";
	   int num = this.executeUpdate(sql, new String[]{course.getCourseName(),
			   course.getCourseTeacher(),
			   course.getCoursePlace(),
			   course.getCourseTime(),
			   course.getCourseTimelength(),
			   String.valueOf(course.getCourseTotal()),
			   String.valueOf(course.getCourseRemain()),
			   String.valueOf(course.getCourseId())});
	  if(num>0)
	    return true;
	  else return false;
   }
}
