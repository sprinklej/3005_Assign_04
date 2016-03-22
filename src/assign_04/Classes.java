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
	
	// constructor - GENERAL
	public Classes(String className, int currentSize, int maxSize, String classType, String dateTime) {
		
	}
	
	// getters
	public int getID() {
		return classID;
	}
	
	public String getStaffEmail() {
		return staffEmail;
	}
	
	public String getClassName() {
		return className;
	}
	
	public int getCurrentSize() {
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

	// setters	
	public void setStaffEmail(String se) {
		staffEmail = se;
	}
	
	public void setClassName(String cn) {
		className = cn;
	}
	
	public void setCurrentSize(int cs) {
		currentSize = cs;
	}
	
	public void setMaxSize(int ms) {
		maxSize = ms;
	}
	
	public void setClassType(String ct) {
		classType = ct;
	}
	
	public void setDateTime(String dt) {
		dateTime = dt;
	}
	
	public String toString() {				
		String rtrnString = "";
		String keyIndent = "";
		
		// class name
		int maxNameDigits = 15;
		for (int i = 0; i < maxNameDigits - (""+className).length(); i++) {
			keyIndent = keyIndent + " ";
		}
		rtrnString = rtrnString + className + keyIndent + " ";

		//class type 
		int maxTypeDigits = 12;
		keyIndent = "";
		for (int i = 0; i < maxTypeDigits - (""+classType).length(); i++) {
			keyIndent = keyIndent + " ";
		}
		rtrnString = rtrnString + classType + keyIndent + " " + dateTime;
		//rtrnString = rtrnString + classType;
		
		return rtrnString;
	}
}
