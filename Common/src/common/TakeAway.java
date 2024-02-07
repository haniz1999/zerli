package common;

import java.io.Serializable;
/**
 * Represents a take away "details" with the fields first name,last name phone number
 * @author Laith Sadik
 *
 */
public class TakeAway implements Serializable{
	/**
	 * Return a string representing the take away with first name,last name phone number
	 */
	@Override
	public String toString() {
		return "TakeAway [firstName=" + firstName + ", LastName=" + LastName + ", phoneNumber=" + phoneNumber + "]";
	}

	private String firstName, LastName, phoneNumber;
	/**
	 * Gets the first name of the take away order
	 * @return A string representing the first name of the take away order
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Sets the first name of the take away order into the field firstName
	 * @param firstName A string representing the first name of the take away order
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Gets the last name of the take away order
	 * @return A string representing the last name of the take away order
	 */
	public String getLastName() {
		return LastName;
	}
	/**
	 * Sets the last name of the take away order into the field firstName
	 * @param firstName A string representing the last name of the take away order
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	/**
	 * Gets the phone number of the take away order
	 * @return A string representing the phone number of the take away order
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * sets the phone number of the take away order into the field phoneNumber
	 * @param phoneNumber A string representing the phone number of the take away order
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
