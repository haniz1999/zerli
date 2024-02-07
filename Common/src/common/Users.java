package common;

import java.io.Serializable;
import java.util.Objects;
/**
 * Represents an user with the fields user's first Name,last Name,id,phone Number,email,user Type,user name
 * ,password,status In System,isLoggedIn
 * @author Laith Sadik  & Othamn & Majd zbedat & Rani & Hani
 *
 *
 */
public class Users implements Serializable{

	/**
	 * Gets the user's status in system
	 * @return A string representing the status in system of the user
	 */
	public String getStatusInSystem() {
		return statusInSystem;
	}
	/**
	 * Sets the user's status in system into th field statuInSystem
	 * @param statusInSystem
	 */
	public void setStatusInSystem(String statusInSystem) {
		this.statusInSystem = statusInSystem;
	}
	private String firstName,lastName,id,phoneNumber,email,userType,username,password,statusInSystem;
	
	//////////////////////////////////
	//add by majd

	
	
	//////////////////////////////////////////////
//	public String getWorkerPosition() {
//		return WorkerPosition;
//	}
//
//	public void setWorkerPosition(String workerPosition) {
//		WorkerPosition = workerPosition;
//	}
	///////////////////////////////////
	private boolean isLoggedIn;
	/**
	 * Creates an user with the fields user's first Name,last Name,id,phone Number,email,user Type,user name
 * ,password,status In System,isLoggedIn
	 * @param firstName         A string representing the first name of the user
	 * @param lastName          A string representing the last name of the user
	 * @param id                A string representing the id of the user
	 * @param phoneNumber       A string representing the phone number of the user
	 * @param email             A string representing the email of the user 
	 * @param statusInSystem    A string representing the status in system of the user
	 * @param isLoggedIn        A boolean representing if the user is logged in or not 
	 * @param username          A string representing the user name of the user
	 * @param password          A string representing the password of the user
	 * @param userType          A string representing the type of the user
	 */
	public Users(String firstName,String lastName,String id,String phoneNumber,String email,String statusInSystem,boolean isLoggedIn,String username,String password,String userType) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.id=id;
		this.phoneNumber=phoneNumber;
		this.isLoggedIn=isLoggedIn;
		this.email=email;
		this.userType=userType;
		this.username=username;
		this.password=password;
		this.statusInSystem=statusInSystem;
		this.phoneNumber=phoneNumber;
		
	}

	
	/**
	 * Creates an user with the fields user's first name,last name,id and status in system
	 * @param firstName         A string representing the first name of the user
	 * @param lastName          A string representing the last name of the user          
	 * @param id                A string representing the id of the user
	 * @param statusInSystem    A string representing the status in system of the user
	 */
	public Users(String firstName, String lastName, String id, String statusInSystem) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.statusInSystem = statusInSystem;
	}

	
	

	
	
	/**
	 * Gets the user's first name 
	 * @return A string representing the first name of the user
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Sets the user's first name  into the field firstName
	 * @param firstName A string representing the first name of the user
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Gets the user's last name 
	 * @return A string representing the last name of the user
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Sets the user's last name  into the field firstName
	 * @param firstName A string representing the last name of the user
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Gets the user's id
	 * @return A string representing the id of the user
	 */
	public String getId() {
		return id;
	}
	/**
	 * Sets the user's id into the field id
	 * @param id A string representing the id of the user
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Gets the user's phone number
	 * @return A string representing the phone number of the user
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * Sets the user's phone number into the field phoneNumber
	 * @param phoneNumber A string representing the phone number of the user
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * Gets the user's email
	 * @return A string representing the email of the user
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Sets the user's email into the field email
	 * @param email A string representing the email of the user
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Gets the user's type
	 * @return A string representing the type of the user
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * Sets the user's type into the field userType
	 * @param userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * Gets the user's user name
	 * @return A string representing the user name of the user
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Sets the user's user name into the field username
	 * @param username A string representing the user name of the user
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Gets the user's password
	 * @return A string representing the password of the user
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Sets the user's password into the field password 
	 * @param password A string representing the password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}
//	public String getBranchName() {
//		return branchName;
//	}
//	public void setBranchName(String branchName) {
//		this.branchName = branchName;
//	}
	/**
	 * Gets true if the user logged in and false if not
	 * @return A boolean representing if the user logged in or not
	 */
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	/**
	 * Sets true if the user logged in and false if not into the field isLoggedIn
	 * @param isLoggedIn A boolean representing if the user logged in or not
	 */
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	/**
	 * Returns int representing the hash code of the user's id
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	/**
	 * Returns "true" if the object "obj" equals to the current object and "false" if not 
	 * @return boolean representing if the object "obj" equals to the current object or not
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(id, other.id);
	}

}
