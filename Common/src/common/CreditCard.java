package common;

import java.io.Serializable;
/**
 * Representing a credit card with the fields credit card id,number,card "cvv" code and validation date
 * @author Majd Zbedat
 *
 */
public class CreditCard implements Serializable{

	
	
	private String Id;
	private String creditCardNumber;
	private String creditCardCvvCode;
	private String creditCardValidDate;
	
	/**
	 * Creates an credit card with the fields credit card id,number,card "cvv" code and valid date
	 * @param id                   the id of the credit card
	 * @param creditCardNumber     the number of the credit card
	 * @param creditCardCvvCode    the cvv of the credit card
	 * @param creditCardValidDate  the validation date of the credit card
	 */
	public CreditCard(String id, String creditCardNumber, String creditCardCvvCode, String creditCardValidDate) {
		this.Id = id;
		this.creditCardNumber = creditCardNumber;
		this.creditCardCvvCode = creditCardCvvCode;
		this.creditCardValidDate = creditCardValidDate;
	}
	/**
	 * Gets the credit card's id
	 * @return a string representing the id of the credit card
	 */
	public String getId() {
		return Id;
	}
	/**
	 * Sets the credit card's id into the filed Id
	 * @param id a string representing the id of the credit card
	 */
	public void setId(String id) {
		Id = id;
	}
	/**
	 * Gets the credit card's number
	 * @return a string representing the number of the credit card
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	/**
	 * Sets the credit card's number in the field creditCardNumber
	 * @param creditCardNumber   A string representing the number of the credit card
	 */
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	/**
	 * Gets the credit card's "cvv" code
	 * @return  A string representing the "cvv" code of the credit card
	 */
	public String getCreditCardCvvCode() {
		return creditCardCvvCode;
	}
	/**
	 * Sets the credit card's "cvv" code in the filed creditCardCvvCode
	 * @param creditCardCvvCode A string representing the "cvv" code of the credit card
	 */
	public void setCreditCardCvvCode(String creditCardCvvCode) {
		this.creditCardCvvCode = creditCardCvvCode;
	}
	/**
	 * Gets the credit card's validation date 
	 * @return A string representing the validation date of the credit card
	 */
	public String getCreditCardValidDate() {
		return creditCardValidDate;
	}
	/**
	 * Sets the credit card's validation date in the field creditCardValidDate
	 * @param creditCardValidDate A string representing the validation date of the credit card
	 */
	public void setCreditCardValidDate(String creditCardValidDate) {
		this.creditCardValidDate = creditCardValidDate;
	}

	
	

	
}