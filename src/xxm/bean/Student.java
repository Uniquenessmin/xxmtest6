package xxm.bean;

/**
 * 学生实体类
 * @author xxm
 *
 */
public class Student {

	String no;
	String name;
	String passwd;
	String major;
	String grade;
	String sclass;
	String selectedCourse;
	
	
	public Student() {
		
	}

	
	
	public String getSelectedCourse() {
		return selectedCourse;
	}



	public void setSelectedCourse(String cid) {
		this.selectedCourse = cid;
	}



	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	
}
