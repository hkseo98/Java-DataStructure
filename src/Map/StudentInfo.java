package Map;

public class StudentInfo {
	
	private String studentID; 
	private String studentName;
	
	StudentInfo(String studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
	}
	
	public void setStudentID(String id) { 
		this.studentID = id;
	} 
	public void setStudentName(String name) { 
		this.studentName = name;
	}
	public String getStudentID() { 
		return this.studentID;
	}
	public String getStudentName() {
		return this.studentName;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

	}

}
