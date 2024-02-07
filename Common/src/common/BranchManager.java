package common;

import java.io.Serializable;
/**
 * Represents a Branch manager with the fields branch manager id,name,email,phone number,revenue fee and status"in system"
 * @author Majd Zbedat & Rani Khori
 *
 */
public class BranchManager implements Serializable{

	
	private String Id;
	private String branchName;
	/**
	 * Gets the Branch manager's id 
	 * @return a string representing the id of the branch manager
	 */
	public String getId() {
		return Id;
	}
	/**
	 * Sets the Branch manager's id into the field Id
	 * @param id A string representing the id of the branch manager
	 */
	public void setId(String id) {
		Id = id;
	}
	/**
	 * Gets the branch manager's name
	 * @return A string representing the name of the branch manager
	 */
	public String getBranchName() {
		return branchName;
	}
	/**
	 * Sets the branch manager's name into the field branchName
	 * @param branchName A string representing the name of the branch manager
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	/**
	 * Creates a Branch manager with the fields branch manager id and name
	 * @param id          A string representing the id of the branch manager
	 * @param branchName  A string representing the name of the branch manager
	 */
	public BranchManager(String id, String branchName) {
		super();
		Id = id;
		this.branchName = branchName;
	}
}