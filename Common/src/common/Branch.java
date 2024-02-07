package common;

import java.io.Serializable;
/**
 * Represents a Branch with the fields branch's id,name,email,phone number,revenue fee and status in system
 * @author Majd zbedat
 *
 */
public class Branch implements Serializable{
	
	private String branch_id;
	private String branch_name;
	private String branch_email;
	private String branch_phoneNumber;
	private double branch_revenueFee;
	private String branch_statusInSystem;
	
	/**
	 * Creates a branch with the fields branch's id,name,email,phone number,revenue fee and status in system
	 * @param branch_id               a string representing the id of the branch
	 * @param branch_name             a string representing the name of the branch
	 * @param branch_email            a string representing the email of the branch
	 * @param branch_phoneNumber      a string representing the phone number of the branch
	 * @param branch_revenueFee       a double representing the revenue fee of the branch
	 * @param branch_statusInSystem   a string representing the status in system of the branch
	 */
	public Branch(String branch_id, String branch_name, String branch_email, String branch_phoneNumber,
			double branch_revenueFee, String branch_statusInSystem) {
		this.branch_id = branch_id;
		this.branch_name = branch_name;
		this.branch_email = branch_email;
		this.branch_phoneNumber = branch_phoneNumber;
		this.branch_revenueFee = branch_revenueFee;
		this.branch_statusInSystem = branch_statusInSystem;
	}
	
	/**
	 * Gets the branch's id 
	 * @return A string representing the id of the branch
	 */
	public String getBranch_id() {
		return branch_id;
	}

	/**
	 * Sets the branch's id into the field branch_id
	 * @param branch_id A string representing the id of the branch
	 */
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	/**
	 * Gets the branch's name
	 * @return A string representing the name of the branch
	 */
	public String getBranch_name() {
		return branch_name;
	}
	/**
	 * Sets the branch's name into the field branch_name
	 * @param branch_name A string representing the name of the branch
	 */
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	/**
	 * Gets the branch's email
	 * @return A string representing the email of the branch
	 */
	public String getBranch_email() {
		return branch_email;
	}
	/**
	 * Sets the branch's email into the field branch_email
	 * @param branch_email A string representing the email of the branch
	 */
	public void setBranch_email(String branch_email) {
		this.branch_email = branch_email;
	}
	/**
	 * Gets the branch's phone number
	 * @return A string representing the phone number of the branch
	 */
	public String getBranch_phoneNumber() {
		return branch_phoneNumber;
	}
	/**
	 * Sets  the branch's phone number into the field branch_phoneNumber
	 * @param branch_phoneNumber A string representing the phone number of the branch
	 */
	public void setBranch_phoneNumber(String branch_phoneNumber) {
		this.branch_phoneNumber = branch_phoneNumber;
	}
	/**
	 * Gets the branch's revenue fee
	 * @return A double representing the revenue fee of the branch
	 */
	public double getBranch_revenueFee() {
		return branch_revenueFee;
	}
	/**
	 * Sets the branch's revenue fee into the field branch_revenueFee
	 * @param branch_revenueFee A double representing the revenue fee of the branch
	 */
	public void setBranch_revenueFee(double branch_revenueFee) {
		this.branch_revenueFee = branch_revenueFee;
	}
	/**
	 * Gets the branch's status in system 
	 * @return A string representing the status in system of the branch
	 */
	public String getBranch_statusInSystem() {
		return branch_statusInSystem;
	}
	/**
	 * Sets the branch's status in system into the field branch_statusInSystem
	 * @param branch_statusInSystem A string representing the status in system of the branch
	 */
	public void setBranch_statusInSystem(String branch_statusInSystem) {
		this.branch_statusInSystem = branch_statusInSystem;
	}


	

	

}
