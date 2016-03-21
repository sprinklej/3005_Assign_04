package assign_04;

//class represents a user from the DB (client or staff)
public class Users {
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
	public Users(String name, String phone, String email, String address, String gender, String referralSource) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.referralSource = referralSource;
		this.staffTF = false;
	}
	
	// constructor - STAFF
	public Users(String name, String phone, String email, String address, String instructorType) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.instructorType = instructorType;
		this.staffTF = true;
	}
	
	// constructor - GENERAL
	public Users(String name, String phone, String email) {
		
	}
	
	// getters
	boolean getStaffTF() {
		return staffTF;
	}
	
	String getName() {
		return name;
	}
	
	String getPhone() {
		return phone;
	}
	
	String getEmail() {
		return email;
	}
	
	String getAddress() {
		return address;
	}
	
	String getInstructorType() {
		return instructorType;
	}
	
	String getGender() {
		return gender;
	}
	
	String getReferralSource() {
		return referralSource;
	}
	
	public String toString() {
		return "Hello";
	}
}
