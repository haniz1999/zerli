
package common;

import java.io.Serializable;
/**
 * Represents  a Branch worker with the fields branch worker id,worker position,branch name ,first name and last name
 * @author  Rani Khori
 *
 */
public class BranchWorker implements Serializable {

	
	private String Id;
	private String workerPosition;
	private String branchName;
	private String firstName;
	private String lastName;
	
	/**
	 * Gets the branch worker's first name
	 * @return a string representing the first name of the branch worker
	 */
	public String getFirstName() {
		return firstName;
	}
/**
 * Sets the branch worker's first name in the field firstName
 * @param firstName A string representing the first name of the branch worker
 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
/**
 * Gets the branch worker's last name
 * @return A string representing the last name of the branch worker
 */
	public String getLastName() {
		return lastName;
	}
/**
 * Sets the branch worker's last name in the field lastName
 * @param lastName  A string representing the last name of the branch worker
 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
/**
 * Creates a branch worker with the fields branch worker id,worker position,branch name ,first name and last name
 * @param id                A string representing the id of the branch worker
 * @param workerPosition    A string representing the worker position of the branch worker
 * @param branchName        A string representing the branch name of the branch worker
 * @param firstName         A string representing the first name of the branch worker
 * @param lastName          A string representing the last name of the branch worker
 */
	public BranchWorker(String id, String workerPosition, String branchName,String firstName,String lastName) {
		super();
		Id = id;
		this.workerPosition = workerPosition;
		this.branchName = branchName;
		this.firstName=firstName;
		this.lastName=lastName;
	}
	
	
	/**
	 * Creates a branch worker with the fields branch worker id,worker position ,first name and last name
	 * @param id               A string representing the id of the branch worker
	 * @param workerPosition   A string representing the worker position of the branch worker
	 * @param firstName        A string representing the first name of the branch worker
	 * @param lastName         A string representing the last name of the branch worker
	 */
	public BranchWorker(String id, String workerPosition,String firstName,String lastName) {
		super();
		Id = id;
		this.workerPosition = workerPosition;
		this.firstName=firstName;
		this.lastName=lastName;
	}
	/**
	 * Gets the branch worker's id
	 * @return A string representing the id of the branch worker
	 */
	public String getId() {
		return Id;
	}

/**
 * Sets the branch worker's id into the field Id
 * @param id  A string representing the id of the branch worker
 */
	public void setId(String id) {
		Id = id;
	}

/**
 * Gets the branch worker's position
 * @return A string representing the position of the branch worker 
 */
	public String getWorkerPosition() {
		return workerPosition;
	}

/**
 * Sets the branch worker's position into the field workerPosition
 * @param workerPosition A string representing the position of the branch worker
 */
	public void setWorkerPosition(String workerPosition) {
		this.workerPosition = workerPosition;
	}

/**
 * Gets the branch worker's branch name
 * @return A string representing the branch name of the branch worker
 */
	public String getBranchName() {
		return branchName;
	}

/**
 * Sets the branch worker's branch name into the field branchName
 * @param branchName   A string representing the branch name of the branch worker
 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	
}
