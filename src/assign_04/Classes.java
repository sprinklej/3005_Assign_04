package assign_04;

// class represents a class from the DB
public class Classes {
	int classID = -1;
	String staffEmail = null;
	String className = null;
	int currentSize = 0;
	int maxSize = 0;
	String classType = null;
	String dateTime = null;
	
	// constructor
	public Classes(int classID, String staffEmail, String className, int currentSize, int maxSize, String classType, String dateTime) {
		this.classID = classID;
		this.staffEmail = staffEmail;
		this.className = className;
		this.currentSize = currentSize;
		this.maxSize = maxSize;
		this.classType = classType;
		this.dateTime = dateTime;
	}
	
	// getters
	public String getStaffEmail() {
		return staffEmail;
	}
	
	public String getClassName() {
		return className;
	}
	
	public int getcurrentSize() {
		return currentSize;
	}
	
	public int getMaxSize() {
		return maxSize;
	}
	
	public String getClassType() {
		return classType;
	}
	
	public String getDateTime() {
		return dateTime;
	}
}
