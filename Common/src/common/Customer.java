package common;

import java.io.Serializable;
/**
 * Represents an customer with the fields customer's id,email,balance and customer type
 * @author Laith Sadik  & Othamn
 *
 */
public class Customer implements Serializable {
	/**
	 * Creates an customer with the fields customer's id,email,balance and customer type
	 * @param customerId      A string representing the id of the customer
	 * @param email           A string representing the email of the customer
	 * @param balance         A double representing the balance of the customer
	 * @param customerType    A CustomerType representing the type of the customer
	 */
public Customer(String customerId, String email, double balance, CustomerType customerType) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.balance = balance;
		this.customerType = customerType;
	}
/**
 * Gets the customer's id
 * @return A string representing the id of the customer
 */
public String getCustomerId() {
		return customerId;
	}
/**
 * Sets the customer's id into the field customerId
 * @param customerId A string representing the id of the customer
 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * Gets the customer's email
	 * @return A string representing the email of the customer
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Sets the customer's email into the field email
	 * @param email A string representing the email of the customer
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Gets the customer's balance
	 * @return A double representing the balance of the customer
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * Sets the customer's balance into the field balance
	 * @param balance A double representing the balance of the customer 
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * Gets the customer's type
	 * @return An CustomerType representing the type of the customer
	 */
	public CustomerType getCustomerType() {
		return customerType;
	}
	/**
	 * Sets the customer's type into the field customerType
	 * @param customerType An CustomerType representing the type of the customer
	 */
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
private String customerId,email;
private double balance;
private CustomerType customerType;
	
	
////////////////////////////////////////////////////
//////////////////////////////////////////////
//////////////////////////////////////////////add by majd zbedat in 3/6/2022


private Double totalPrice;
/**
 * Gets the customer's total price
 * @return A double representing the total price of the customer
 */
public Double getTotalPrice() {
return totalPrice;
}
/**
 * Sets the customer's total price into the field totalPrice
 * @param totalPrice  A double representing the total price of the customer
 */
public void setTotalPrice(Double totalPrice) {
this.totalPrice = totalPrice;
}
/**
 * Creates an customer with the field totalPrice
 * @param totalPrice  A double representing the total price of the customer
 */
public Customer(double totalPrice) {
this.totalPrice=totalPrice;
}

/////////////////////////////////////
////////////////////////////////////
/////////////////////////////////////





}
