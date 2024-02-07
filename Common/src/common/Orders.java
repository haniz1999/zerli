package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 * Represents an orders with the fields currentOrderDate, OrderId, productsList ,itemsList , totalPrductsPrice ,
 totalItemsPrice ,typeOfDelivery, OrderDeliveryDate, branch, greeting, delivery, deliveryFee, orderPrice, top
 issueDate,customerFristName, customerLastName, customerId, customerPhoneNumber, customerEmail, dilevery,
  status , orderDate ,itemsInOrder, productsInOrder ,receiverName ,receiverPhoneNumber receiverAddress, DateOfDelivery ,price1;
	, customerEmail1, customerId1
 * @author Laith Sadik  & Othamn & Majd Zbedat &Rani 
 *
 */
public class Orders implements Serializable {
/**
 * Gets the items in order
 * @return A string representing the items in order 
 */
	public String getItemsInOrder() {
		return itemsInOrder;
	}
/**
 * Sets the items in order into the field itemsInOrer
 * @param itemsInOrder
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
	 * Gets the order's current date
	 * @return A Date representing the date of the order
	 */
	public Date getCurrentOrderDate() {
		return currentOrderDate;
	}
	/**
	 * Sets the order's current date into the field currentOrderDate
	 * @param currentOrderDate A Date representing the date of the order
	 */
	public void setCurrentOrderDate(Date currentOrderDate) {
		this.currentOrderDate = currentOrderDate;
	}

	private Date currentOrderDate;
	private String OrderId;
	private ArrayList<Products> productsList = new ArrayList<>();
	private ArrayList<Item> itemsList = new ArrayList<>();
	private double totalPrductsPrice = 0;
	private double totalItemsPrice = 0;
	private TypeOfDelivery typeOfDelivery;
	private Date OrderDeliveryDate;
	private String branch;
	private String greeting;
	private Delivery delivery;
	public final double deliveryFee = 50.0;
	private double orderPrice;
	private TypeOfPayment top;
	private Date issueDate;
	private String customerFristName, customerLastName, customerId, customerPhoneNumber, customerEmail;
	private boolean dilevery;
	private Status status = Status.PENDING_APPROVAL;
	private Date orderDate; // add by Majd Zbedat
	private String itemsInOrder, productsInOrder;// laith sdiq
	/**
	 * Creates an orders with the fields OrderId, branch,customerId,status, orderDate, orderPrice,customerEmail
	 * @param OrderId      A string representing the id of the order 
	 * @param branch       A string representing the  branch of the order
	 * @param customerId   A string representing the customer id
	 * @param status       A Status representing the status of the order
	 * @param orderDate    A Date representing the date of the order
	 * @param orderPrice   A double representing the price of the order
	 * @param customerEmail   A string representing the email of the customer
	 */
	// another constructor for CONFRIMING QUERY
	public Orders(String OrderId, String branch, String customerId, Status status, Date orderDate, Double orderPrice,
			String customerEmail) {
		super();

		this.OrderId = OrderId;
		this.branch = branch;
		this.customerId = customerId;
		this.status = status;
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
		this.customerEmail = customerEmail;
	}
/**
 * Creates an orders with the field order id,items in order,order delivery date and status
 * @param orderId             A string representing the id of the order 
 * @param itemsInOrder        A string representing the items in order
 * @param OrderDeliveryDate   A Date representing the details of the date of the delivery of the order
 * @param status              A Status representing the status of the order
 */
	// laith sdiq
	public Orders(String orderId, String itemsInOrder, Date OrderDeliveryDate, Status status) {
		super();
		this.OrderId = orderId;
		this.itemsInOrder = itemsInOrder;
		this.OrderDeliveryDate = OrderDeliveryDate;
		this.status = status;
	}
	/**
	 * Constructor creates an order by calling the constructor of the super class
	 */
	public Orders() {
		super();
	}
	/**
	 * Gets the order's status
	 * @return A Status representing the status of the order
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * Sets the order's status into the field status
	 * @param status representing the status of the order
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * Gets true if the order delivers false if not
	 * @return A boolean representing if the order delivers or not
	 */
	public boolean isDilevery() {
		return dilevery;
	}
	 /**
	  * Sets true if the order delivers false if not into the field delivery
	  * @param dilevery A boolean representing if the order delivers or not
	  */
	public void setDilevery(boolean dilevery) {
		this.dilevery = dilevery;
	}
	/**
	 * Gets the order's id
	 * @return A string representing the id of the order
	 */
	public String getOrderId() {
		return OrderId;
	}
	/**
	 * Sets the order's id into the field OrderId
	 * @param orderId A string representing the id of the order
	 */
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	/**
	 * Returns a string representing the details of the order
	 */
	@Override
	public String toString() {
		return "Orders [takeAway=" + takeAway + ", productsList=" + productsList + ", itemsList=" + itemsList
				+ ", totalPrductsPrice=" + totalPrductsPrice + ", totalItemsPrice=" + totalItemsPrice
				+ ", typeOfDelivery=" + typeOfDelivery + ", branch=" + branch + ", greeting=" + greeting + ", delivery="
				+ delivery + ", deliveryFee=" + deliveryFee + ", orderPrice=" + orderPrice + ", top=" + top
				+ ", issueDate=" + issueDate + ", customerFristName=" + customerFristName + ", customerLastName="
				+ customerLastName + ", customerId=" + customerId + ", customerPhoneNumber=" + customerPhoneNumber
				+ ", customerEmail=" + customerEmail + "]";
	}
	/**
	 * Gets the order's "top" the type of payment
	 * @return A TypOfPayment representing the "top" type of payment of the order
	 */
	public TypeOfPayment getTop() {
		return top;
	}
	/**
	 * Sets the order's "top" the type of payment into the field top
	 * @param top A TypOfPayment representing the "top" type of payment of the order
	 */
	public void setTop(TypeOfPayment top) {
		this.top = top;
	}
	/**
	 * Gets the order's date
	 * @return A Date representing the date of the order
	 */
	public Date getIssueDate() {
		return issueDate;
	}
	/**
	 * Sets the order's date into the field issueDate
	 * @param issueDate A Date representing the date of the order
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	/**
	 * Gets the customer's first name 
	 * @return A string representing the first name of the customer
	 */
	public String getCustomerFristName() {
		return customerFristName;
	}
	/**
	 * Sets the customer's first name into the field customerFirstName
	 * @param customerFristName A string representing the first name of the customer
	 */
	public void setCustomerFristName(String customerFristName) {
		this.customerFristName = customerFristName;
	}
	/**
	 * Gets the customer's last name 
	 * @return A string representing the last name of the customer
	 */
	public String getCustomerLastName() {
		return customerLastName;
	}
	/**
	 * Sets the customer's last name into the field customerLastNmae
	 * @param customerLastName A string representing the last name of the customer
	 */
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
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
	 * Gets the customer's phone number
	 * @return A string representing the phone number of the customer
	 */
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	/**
	 * Sets the customer's phone number into the field customerPhoneNumber
	 * @param customerPhoneNumber A string representing the phone number of the customer
	 */
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	/**
	 * Gets the customer's email
	 * @return A string representing the email of the customer
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	/**
	 * Sets the customer's email into the field customerEmail
	 * @param customerEmail
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	/**
	 * Gets the order's price
	 * @return A double representing the price of the order
	 */
	public double getOrderPrice() {
		return orderPrice;
	}
	/**
	 * Sets the order's price into the field orderPrice
	 * @param orderPrice  A double representing the price of the order
	 */
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	/**
	 * Gets the delivery's fee
	 * @return A double representing the fee of the delivery
	 */
	public double getDeliveryFee() {
		return deliveryFee;
	}
	/**
	 * Gets the delivery details 
	 * @return A Delivery representing the delivery details
	 */
	public Delivery getDelivery() {
		return delivery;
	}
	/**
	 * Sets the delivery details  into the field delivery
	 * @param delivery A Delivery representing the delivery details
	 */
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	/**
	 * Gets the total price of the products 
	 * @return A double representing the total price of the products in the order
	 */
	public double getTotalPrductsPrice() {
		return totalPrductsPrice;
	}
	/**
	 * Sets the total price of the products  into the field totalProdustsPrice
	 * @param totalPrductsPrice A double representing the total price of the products in the order
	 */
	public void setTotalPrductsPrice(double totalPrductsPrice) {
		this.totalPrductsPrice = totalPrductsPrice;
	}
	/**
	 * Gets the total price of the items
	 * @return A double representing the total price of the items in the order
	 */
	public double getTotalItemsPrice() {
		return totalItemsPrice;
	}
	/**
	 * Sets  the total price of the items into the field totalItemsPrice
	 * @param totalItemsPrice A double representing the total price of the items in the order
	 */
	public void setTotalItemsPrice(double totalItemsPrice) {
		this.totalItemsPrice = totalItemsPrice;
	}
	/**
	 * Get the order's greeting
	 * @return A string representing the greeting of the order
	 */
	public String getGreeting() {
		return greeting;
	}
	/**
	 * Sets the order's greeting into the field greeting
	 * @param greeting A string representing the greeting of the order
	 */
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	/**
	 * Get the order's branch
	 * @return A string representing the branch of the order
	 */
	public String getBranch() {
		return branch;
	}
	/**
	 * Sets the order's branch into the field branch
	 * @param branch A string representing the branch of the order
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}
	/**
	 * Get the order's date of the delivery details
	 * @return A Date representing the date of the delivery for the order
	 */
	public Date getOrderDeliveryDate() {
		return OrderDeliveryDate;
	}
	/**
	 * Sets the order's date of the delivery details into the field OrderDeliveryDate
	 * @param orderDeliveryDate A Date representing the date of the delivery for the order
	 */
	public void setOrderDeliveryDate(Date orderDeliveryDate) {
		OrderDeliveryDate = orderDeliveryDate;
	}
	/**
	 * Gets the order's type of delivery details
	 * @return A TypeOfDelivery representing the type of delivery for the order
	 */
	public TypeOfDelivery getTypeOfDelivery() {
		return typeOfDelivery;
	}
	/**
	 * Sets the order's type of delivery details into the field typeOfDelivery
	 * @param typeOfDelivery A TypeOfDelivery representing the type of delivery for the order
	 */
	public void setTypeOfDelivery(TypeOfDelivery typeOfDelivery) {
		this.typeOfDelivery = typeOfDelivery;
	}

	private TakeAway takeAway;
	/**
	 * Gets the order's take away details 
	 * @return A TakeAway representing the details of the order's take away
	 */
	public TakeAway getTakeAway() {
		return takeAway;
	}
	/**
	 * Sets the order's take away details into the field takeAway
	 * @param takeAway A TakeAway representing the details of the order's take away
	 */
	public void setTakeAway(TakeAway takeAway) {
		this.takeAway = takeAway;
	}
	/**
	 * Gets the order's date details 
	 * @return A Date representing the  date's details  of the order
	 */
	public Date getOrderDate() {
		return orderDate;
	}
	/**
	 * Sets the order's date details into the field orderDate
	 * @param orderDate A Date representing the  date's details  of the order
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * Gets the order's list of the products 
	 * @return A ArrayList<Products> representing the list of the products of the order
	 */
	public ArrayList<Products> getProductsList() {
		return productsList;
	}
	/**
	 * Sets the  order's list of the products into the productsList
	 * @param productsList A ArrayList<Products> representing the list of the products of the order
	 */
	public void setProductsList(ArrayList<Products> productsList) {
		this.productsList = productsList;
	}
	/**
	 * Gets the order's list of the items
	 * @return A ArrayList<Item> representing the list of the items of the order
	 */
	public ArrayList<Item> getItemsList() {
		return itemsList;
	}
	/**
	 * Sets the order's list of the items into the field itemsList
	 * @param itemsList A ArrayList<Item> representing the list of the items of the order
	 */
	public void setItemsList(ArrayList<Item> itemsList) {
		this.itemsList = itemsList;
	}
	/**
	 * gets the list of the items as a string or null if there is no item 
	 * @return A string representing the list of the items
	 */
	public String getItemListToDB() {
		String sb = "";
		if (this.getItemsList().size() != 0) {
			for (int i = 0; i < this.getItemsList().size(); i++) {
				sb += (this.itemsList.get(i).getItemName());
				if (i < this.getItemsList().size() - 1)
					sb += ",";
			}

		}
		if (this.getProductsList().size() != 0) {
			if (this.getItemsList().size() != 0)
				sb += ",";
			for (int i = 0; i < this.getProductsList().size(); i++) {
				sb += (this.productsList.get(i).getProductName());
				if (i < this.getProductsList().size() - 1)
					sb += ",";
			}
			return sb;
		}
		return sb;
	}

/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////           add by majd zbedat in 2/6/2022
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////

	private String receiverName;
	private String receiverPhoneNumber;
	private String receiverAddress;
	private String DateOfDelivery;
	private Double price1;
	private String customerEmail1;
	private String customerId1;
/**
 * Gets the customer's id
 * @return A string representing the id of the customer1
 */
	public String getCustomerId1() {
		return customerId1;
	}
/**
 * Sets the customer's id into the field customerId1
 * @param customerId1 A string representing the id of the customer1
 */
	public void setCustomerId1(String customerId1) {
		this.customerId1 = customerId1;
	}
/**
 * Gets the order's price
 * @return A double representing the price of the orders
 */
	public Double getPrice1() {
		return price1;
	}
/**
 * Sets the order's price into the field price1
 * @param price1 A double representing the price of the orders
 */
	public void setPrice1(Double price1) {
		this.price1 = price1;
	}
/**
 * Creates an orders with the fields OrderId,receiverName,receiverPhoneNumber,receiverAddress,price1
 * DateOfDelivery,customerEmail1 and customerId1
 * @param OrderId                A string representing the id of the order
 * @param receiverName           A string representing the name of the orders receiver
 * @param receiverPhoneNumber    A string representing the phone number  of the orders receiver
 * @param receiverAddress        A string representing the address of the orders receiver
 * @param price1                 A double representing the price of orders
 * @param DateOfDelivery         A string representing the date of the delivery of the orders
 * @param customerEmail1         A string representing the email of the customer
 * @param customerId1            A string representing the id of the customer
 */
	public Orders(String OrderId, String receiverName, String receiverPhoneNumber, String receiverAddress,
			Double price1, String DateOfDelivery, String customerEmail1, String customerId1) {
		this.OrderId = OrderId;
		this.receiverName = receiverName;
		this.receiverPhoneNumber = receiverPhoneNumber;
		this.receiverAddress = receiverAddress;
		this.DateOfDelivery = DateOfDelivery;
		this.price1 = price1;
		this.customerEmail1 = customerEmail1;
		this.customerId1 = customerId1;
	}

///////////////////////////////////////////////
/**
 * Gets the customer's email
 * @return A string representing the email of the customer
 */
	public String getCustomerEmail1() {
		return customerEmail1;
	}
/**
 * Sets the customer's email into the field customerEmail1
 * @param customerEmail1 A string representing the email of the customer
 */
	public void setCustomerEmail1(String customerEmail1) {
		this.customerEmail1 = customerEmail1;
	}
/**
 * Gets the delievry's date 
 * @return A string representing the date of the delivery 
 */
	public String getDateOfDelivery() {
		return DateOfDelivery;
	}
/**
 * Sets the delievry's date into the field dateOfDelivery
 * @param dateOfDelivery A string representing the date of the delivery
 */
	public void setDateOfDelivery(String dateOfDelivery) {
		DateOfDelivery = dateOfDelivery;
	}

///////////////////////////////////////////////
	/**
	 * Gets the order's receiver name
	 * @return A string representing the name of the order's receiver
	 */
	public String getReceiverName() {
		return receiverName;
	}
/**
 * Sets the order's receiver name into the field receiverName
 * @param receiverName  A string representing the name of the order's receiver
 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
/**
 * Gets the order's receiver phone number 
 * @return A string representing the phone number of the order's receiver
 */
	public String getReceiverPhoneNumber() {
		return receiverPhoneNumber;
	}
/**
 * Sets the order's receiver phone into the field receiverPhoneNumber 
 * @param receiverPhoneNumber A string representing the phone number of the order's receiver
 */
	public void setReceiverPhoneNumber(String receiverPhoneNumber) {
		this.receiverPhoneNumber = receiverPhoneNumber;
	}
/**
 * Gets the order's receiver address 
 * @return A string representing the address of the order's receiver
 */
	public String getReceiverAddress() {
		return receiverAddress;
	}
/**
 * Sets the order's receiver address into the field receiverAddress
 * @param receiverAddress A string representing the address of the order's receiver
 */
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////           add by majd zbedat
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////

	private String cancelDateTime1;// add by rani 2.6
	private String orderDeliveryDate1; // add by rani 3.6
	private String orderDate1; // add by rani 3.6

///////// also getters and setters 3.6 by rani
	/**
	 * Gets the delivery's date of the order 
	 * @return A string representing the date of the delivery of the orders
	 */
	public String getOrderDeliveryDate1() {
		return orderDeliveryDate1;
	}

// add by rani 
	/**
	 * Sets the delivery's date of the order into the field orderDeliveryDate1
	 * @param orderDeliveryDate1  A string representing the date of the delivery of the orders
	 */
	public void setOrderDeliveryDate1(String orderDeliveryDate1) {
		this.orderDeliveryDate1 = orderDeliveryDate1;
	}

// add by rani 
	/**
	 * Gets the order's date
	 * @return A string representing the date of the order
	 */
	public String getOrderDate1() {
		return orderDate1;
	}

// add by rani 
	/**
	 * Sets the order's date into the field orderDate1
	 * @param orderDate1 A string representing the date of the order
	 */
	public void setOrderDate1(String orderDate1) {
		this.orderDate1 = orderDate1;
	}
///////// also getters and setters 3.6 by rani

///////// also getters and setters 2.6 by rani
	/**
	 * Gets the canceling date of the order
	 * @return A string representing the canceling date of the order
	 */
	public String getCancelDateTime1() {
		return cancelDateTime1;
	}
/**
 * Sets the canceling date of the order into the field cancelDateTime1
 * @param cancelDateTime1 A string representing the canceling date of the order
 */
	public void setCancelDateTime1(String cancelDateTime1) {
		this.cancelDateTime1 = cancelDateTime1;
	}
///////// also getters and setters 2.6 by rani

//add by rani
// another constructor for CONFRIMING QUERY
// update 2.6
	/**
	 * Creates an orders with the fields  OrderId, branch, customerId , status, orderDate1
	 * ,orderPrice, customerEmail, orderDeliveryDate1, cancelDateTime1
	 * @param OrderId               A string representing the id of the order
	 * @param branch                A string representing the  branch of the order
	 * @param customerId            A string representing the customer id
	 * @param status                A Status representing the status of the order
	 * @param orderDate1            A Date representing the date of the order
	 * @param orderPrice            A double representing the price of the order
	 * @param customerEmail         A string representing the email of the customer
	 * @param orderDeliveryDate1    A string representing the date of the delivery
	 * @param cancelDateTime1       A string representing the canceling date 
	 */
	public Orders(String OrderId, String branch, String customerId, Status status, String orderDate1, Double orderPrice,
			String customerEmail, String orderDeliveryDate1, String cancelDateTime1) {
		super();

		this.OrderId = OrderId;
		this.branch = branch;
		this.customerId = customerId;
		this.status = status;
		this.orderDate1 = orderDate1;
		this.orderPrice = orderPrice;
		this.customerEmail = customerEmail;
		this.orderDeliveryDate1 = orderDeliveryDate1;
		this.cancelDateTime1 = cancelDateTime1;

	}

}
