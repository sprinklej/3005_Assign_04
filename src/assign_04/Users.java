package assign_04;

//class represents a user from the DB (client or staff)
public class Users {
	int ID = -1;
	String name = null;
	String phone = null;
	String email = null;
	String address = null;
	
	// staff specific
	String instructorType = null;
	
	// client specific
	String gender = null;
	String referralSource = null;

	// is user is a staff member than true
	boolean staffTF = false;
	
	// constructor - CLIENTS
	public Users(int ID, String name, String phone, String email, String address, String gender, String referralSource) {
		this.ID = ID;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.referralSource = referralSource;
		this.staffTF = false;
	}
	
	// constructor - STAFF
	public Users(int ID, String name, String phone, String email, String address, String instructorType) {
		this.ID = ID;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.instructorType = instructorType;
		this.staffTF = true;
	}
	
	// constructor - GENERAL
	public Users(String name, String email) {
		
	}
	
	// getters
	public boolean getStaffTF() {
		return staffTF;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getInstructorType() {
		return instructorType;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getReferralSource() {
		return referralSource;
	}
	
	// setters
	public void setStaffTF(boolean flag) {
		staffTF = flag;
	}
		
	public void setName(String nm) {
		name = nm;
	}
	
	public void setPhone(String ph) {
		phone = ph;
	}
	
	public void setEmail(String em) {
		email = em;
	}
	
	public void setAddress(String addr) {
		address = addr;
	}
	
	public void setInstructorType(String iType) {
		instructorType = iType;
	}
	
	public void setGender(String gndr) {
		gender = gndr;
	}
	
	public void setReferralSource(String rs) {
		referralSource = rs;
	}
	
	public String toString() {		
		String keyIndent = "";
		int maxNameDigits = 20;
		for (int i=0; i< maxNameDigits - (""+name).length(); i++ ) {  //(""+name) - prevents null erro
			keyIndent = keyIndent + " ";
		}
		
		return "" + name + keyIndent + " " + email; 
	}
}
