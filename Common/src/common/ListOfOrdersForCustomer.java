package common;

import java.io.Serializable;
import java.util.Date;
/**
 * Represnts  list of orders for the customer  with the fields order's id ,items in order,products in order
 * order delivery date and status
 * @author Laith Sadik  & Othamn
 *
 */
public class ListOfOrdersForCustomer implements Serializable{

	private String orderId,itemsInOrder,productsInOrder;
	private Date OrderDeliveryDate;
	private Status status;
	/**
	 * Gets the order's id
	 * @return A string representing the id of the order for the customer
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * Sets the order's id into the field orderId
	 * @param orderId A string representing the id of the order for the customer
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * Gets the items in order
	 * @return A string representing the items in order
	 */
	public String getItemsInOrder() {
		return itemsInOrder;
	}
	/**
	 * Sets the items in order into the field itemsInOrder
	 * @param itemsInOrder  A string representing the items in order
	 */
	public void setItemsInOrder(String itemsInOrder) {
		this.itemsInOrder = itemsInOrder;
	}
	/**
	 * Gets the products in order 
	 * @return A string representing the products in order
	 */
	public String getProductsInOrder() {
		return productsInOrder;
	}
	/**
	 * Sets the products in order into the field productsInOrder
	 * @param productsInOrder A string representing the products in order
	 */
	public void setProductsInOrder(String productsInOrder) {
		this.productsInOrder = productsInOrder;
	}
	/**
	 * Gets the order delivery date
	 * @return A string representing the delivery date of the order
	 */
	public Date getOrderDeliveryDate() {
		return OrderDeliveryDate;
	}
	/**
	 * Sets the order delivery date into the field OrderDeliveryDate
	 * @param orderDeliveryDate A string representing the delivery date of the order
	 */
	public void setOrderDeliveryDate(Date orderDeliveryDate) {
		OrderDeliveryDate = orderDeliveryDate;
	}
	/**
	 * Gets the status of the list of the orders for the customer
	 * @return A Status representing the status of the list of the orders for the customer
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * Sets the status of the list of the orders for the customer into the field status
	 * @param status A Status representing the status of the list of the orders for the customer
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

}
