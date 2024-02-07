package common;

import java.io.Serializable;
/**
 * Represents a delivery with the fields delivery's first name,last name,phone number ,city and street
 * @author Majd Zbedat
 *
 */
public class Delivery implements Serializable{
	/**
	 * Returns a string represents the details of the delivery first name,last name,phone number,city and street
	 */
	@Override
	public String toString() {
		return "Delivery [firstName=" + firstName + ", LastName=" + LastName + ", phoneNumber=" + phoneNumber
				+ ", City=" + City + ", Street=" + Street + "]";
	}

	private String firstName, LastName, phoneNumber,City,Street;
	/**
	 * Gets the delivery's city
	 * @return A string representing the city of the delivery
	 */
	public String getCity() {
		return City;
	}
	/**
	 * Sets the delivery's city into the field city
	 * @param city A string representing the city of the delivery
	 */
	public void setCity(String city) {
		City = city;
	}
	/**
	 * Gets the delivery's street
	 * @return A string representing the street of the delivery
	 */
	public String getStreet() {
		return Street;
	}
	/**
	 * Sets the delivery's street into the field street
	 * @param street A string representing the street of the delivery
	 */
	public void setStreet(String street) {
		Street = street;
	}
	/**
	 * Gets the delivery's first name
	 * @return A string representing the first name of the delivery
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Sets the delivery's first name into the field firstName
	 * @param firstName A string representing the first name of the delivery
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Gets the delivery's last name
	 * @return A string representing the last name of the delivery
	 */
	public String getLastName() {
		return LastName;
	}
	/**
	 * Sets the delivery's last name into the field lastName
	 * @param lastName A string representing the last name of the delivery
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	/**
	 * Gets the delivery's phone number 
	 * @return A string representing the phone number of the delivery
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * Sets the delivery's phone number into the field phoneNumber
	 * @param phoneNumber A string representing the phone number of the delivery
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
