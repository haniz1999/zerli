package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import common.Branch;
import common.BranchManager;
import common.CreditCard;
import common.Customer;
import common.CustomerType;
import common.IncomeDataReport;
import common.IncomeQuarterDataReports;
import common.Item;
import common.ItemType;
import common.Items;
import common.ItemsWithImage;
import common.ListOfOrdersForCustomer;
import common.OrderDataReport;
import common.Orders;
import common.ProductType;
import common.Products;
import common.Report;
import common.ReportAndItsBranches;
import common.Status;
import common.Survey;
import common.SurveyAnswer;
import common.Users;
import common.BranchWorker;
import common.Complaint;
import common.ComplaintType;
import common.ComplaintsDataReports;
import controller.ServerController;
/**
 * Represents a connection to the data base 
 * @author Laith Sadik  & Othamn & Majd zbedat & Rani & Hani
 *
 *
 */
public class MySqlConnection {

	static Connection con;
	public static String mySqlDbName, mySqlDbUser, mySqlDbPassword;
/**
 * make the connection with the data base
 */
	public static void dbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Driver definition succeed");
		} catch (Exception ex) {
			/* handle the error */
			System.out.println("Driver definition failed");
		}

		try {
			con = DriverManager.getConnection(mySqlDbName, mySqlDbUser, mySqlDbPassword);

			System.out.println("SQL connection succeed");

		} catch (SQLException ex) {
			ServerController.flag = false;
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
	/**
	 * Insert Data To Out Date Base From External Source
	 */
	public static void importExternalDataBase() {

		PreparedStatement ps, ps1, psBranch;
		ResultSet result, resultBranch;
		try {
			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.externalusersystem");
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {
				ps1 = MySqlConnection.con
						.prepareStatement("insert into zerliproject.users values (?,?,?,?,?,?,?,?,?,?)");

				ps1.setString(1, result.getString(1));
				ps1.setString(2, result.getString(2));
				ps1.setString(3, result.getString(3));
				ps1.setString(4, result.getString(5));
				ps1.setString(5, result.getString(6));
				ps1.setString(6, result.getString(7));
				ps1.setInt(7,0);
				ps1.setString(8, result.getString(8));
				ps1.setString(9, result.getString(9));
				ps1.setString(10, result.getString(10));
				ps1.execute();

			}

			ps = MySqlConnection.con
					.prepareStatement("Select *From zerliproject.externalusersystem where usertype = ?");
			ps.setString(1, "customer");
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {
				ps1 = MySqlConnection.con.prepareStatement("insert into zerliproject.customer values (?,?,?,?)");
				ps1.setString(1, result.getString(3));
				ps1.setString(2, result.getString(6));
				ps1.setDouble(3, 0);
				ps1.setString(4, "NEWCUSTOMER");
				ps1.execute();

			}

			ps = MySqlConnection.con
					.prepareStatement("Select *From zerliproject.externalusersystem where usertype = ?");
			ps.setString(1, "customer");
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {
				ps1 = MySqlConnection.con.prepareStatement("insert into zerliproject.creditcardtable values (?,?,?,?)");
				ps1.setString(1, result.getString(3));
				ps1.setString(2, result.getString(11));
				ps1.setString(3, result.getString(12));
				ps1.setString(4, result.getString(13));
				ps1.execute();

			}

			ps = MySqlConnection.con
					.prepareStatement("Select *From zerliproject.externalusersystem where usertype = ?");
			ps.setString(1, "branchworker");
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {
				ps1 = MySqlConnection.con.prepareStatement("insert into zerliproject.branchworker values (?,?,?,?,?)");
				ps1.setString(1, result.getString(3));
				ps1.setString(2, result.getString(14));
				ps1.setString(3, result.getString(4));
				ps1.setString(4, result.getString(1));
				ps1.setString(5, result.getString(2));
				ps1.execute();
			}
				ps = MySqlConnection.con
						.prepareStatement("Select *From zerliproject.externalusersystem where usertype = ?");
				ps.setString(1, "branchmanager");
				ps.execute();
				result = ps.getResultSet();
				while (result.next()) {
					ps1 = MySqlConnection.con.prepareStatement("insert into zerliproject.branchmanager values (?,?)");
					ps1.setString(1, result.getString(3));
					ps1.setString(2, result.getString(4));
					ps1.execute();
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

/**
 * checking if the user name is logged in 
 * @param username   A string representing the the user name
 * @param password   A string representing the password
 * @return the user with username and password
 */
	public static Object checkLogin(String username, String password) {

		PreparedStatement ps;
		ResultSet result;
		boolean flagIsLoggedIn;
		Users user = null;

		try {
			ps = MySqlConnection.con
					.prepareStatement("Select *From zerliproject.users where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.execute();
			result = ps.getResultSet();
			if (!result.next())
				return user;
			if (result.getInt(7) == 0)
				flagIsLoggedIn = false;
			else
				flagIsLoggedIn = true;

			user = new Users(result.getString(1), result.getString(2), result.getString(3), result.getString(4),
					result.getString(5), result.getString(6), flagIsLoggedIn, result.getString(8), result.getString(9),
					result.getString(10));

			if (!(user.isLoggedIn() == true)) {
				ps = MySqlConnection.con
						.prepareStatement("UPDATE zerliproject.users SET isLoggedIn=1 where username=? and password=?"); // changed
																															// by
																															// majd
																															// inloggedIN
																															// to
																															// 0
																															// should
																															// return
																															// it
																															// to
																															// 1.

				ps.setString(1, username);
				ps.setString(2, password);
				ps.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;

	}
/**
 * make the user log out 
 * @param user An Users representing the user that log out
 */
	public static void logout(Users user) {

		try {
			PreparedStatement ps = MySqlConnection.con
					.prepareStatement("UPDATE zerliproject.users SET isLoggedIn=0 where id=?");
			ps.setString(1, user.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
/**
 * Gets list of items from the DB
 * @return An ArrayList<ItemWithImage> representing the list of the items
 */
	public static ArrayList<ItemsWithImage> getItemFromDB() {
		ArrayList<ItemsWithImage> itemList = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;

		try {
			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.item_in_catalog");
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {

				itemList.add(new ItemsWithImage(
						new Item(result.getString(1), result.getString(2), ItemType.valueOf(result.getString(3)),
								result.getString(4), Double.parseDouble(result.getString(5)), result.getString(6),
								Double.parseDouble(result.getString(7)))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;

	}
/**
 * Gets list of products from the DB
 * @return An ArrayList<Products> representing the list of the products
 */
	public static ArrayList<Products> getProductFromDB() {
		ArrayList<Products> productList = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;
		try {
			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.product_in_catalog");
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {

				productList.add(
						new Products(result.getString(1), result.getString(2), ProductType.valueOf(result.getString(3)),
								result.getString(4), Double.parseDouble(result.getString(5)), result.getString(6),
								Double.parseDouble(result.getString(7))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
/**
 * Gets a list of item from DB
 * @return An ArrayList<Item> representing the list of item
 */
	public static ArrayList<Item> getNewItemFromDB() {
		ArrayList<Item> itemList = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;

		try {
			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.item_in_catalog");
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {
				itemList.add(new Item(result.getString(1), result.getString(2), ItemType.valueOf(result.getString(3)),
						result.getString(4), Double.parseDouble(result.getString(5)), result.getString(6),
						Double.parseDouble(result.getString(7))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}
/**
 * Gets the list of items with details (conditions) from the DB
 * @param details A String representing the details of the item that wants to get from the DB
 * @return  An ArrayList<Item> representing the list of item
 */
	public static ArrayList<Item> getDetailsItemsForCatalogFromDB(String[] details) {

		ArrayList<Item> itemList = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;
		try {
			if (details.length == 4) {
				ps = MySqlConnection.con.prepareStatement(
						"Select *From zerliproject.item_in_catalog where Type=? and Price>? and Price<? and Color=?");
				ps.setString(1, details[0]);
				ps.setDouble(2, Double.parseDouble(details[1]));
				ps.setDouble(3, Double.parseDouble(details[2]));
				ps.setString(4, details[3]);
			} else {
				ps = MySqlConnection.con.prepareStatement(
						"Select *From zerliproject.item_in_catalog where Type=? and Price >=? and Price <=?");
				ps.setString(1, details[0]);
				ps.setDouble(2, Double.parseDouble(details[1]));
				ps.setDouble(3, Double.parseDouble(details[2]));
			}
			ps.execute();
			result = ps.getResultSet();

			while (result.next()) {

				itemList.add(new Item(result.getString(1), result.getString(2), ItemType.valueOf(result.getString(3)),
						result.getString(4), Double.parseDouble(result.getString(5)), result.getString(6),
						Double.parseDouble(result.getString(7))));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return itemList;
	}
	/**
	 * Sets the order into the DB
	 * 
	 * @param order An Order representing the order wants to set
	 */
	public static void setOrder(Orders order) {
		int id = 5;
		PreparedStatement ps;
		try {
			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.orders");
			ps.execute();
			ResultSet result = ps.getResultSet();

			if (!result.next())
				id = 3;
			else
				while (result.next())
					id += Integer.valueOf(result.getString(1)) * 5;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String orderDeliveryDate, query, currentOrderDate;
		if (order.getOrderDeliveryDate() != null && order.getCurrentOrderDate() != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			orderDeliveryDate = dateFormat.format(order.getOrderDeliveryDate());
			currentOrderDate = dateFormat.format(order.getCurrentOrderDate());
		} else {
			currentOrderDate = null;
			orderDeliveryDate = null;
		}

		String[] spl = orderDeliveryDate.split("-");/////////////////////
		String[] weekSpl = spl[2].split(" ");/////////////////////
		int day = Integer.parseInt(weekSpl[0]);
		String weeks;
		if (day >= 1 && day <= 7)
			weeks = "1";
		else if (day >= 8 && day <= 14)
			weeks = "2";
		else if (day >= 15 && day <= 21)
			weeks = "3";
		else if (day >= 22 && day <= 28)
			weeks = "4";
		else
			weeks = "5";

		if (order.getDelivery() != null)
			query = "INSERT INTO zerliProject.orders ( orderId, customerId, branch, status, greetingCard, totalPrice, orderDeliveryDate, deliveryFee, paymentOptions, supplyType, ListOfItems, receiverAddress, receiverName, receiverPhoneNumber, customerFirstName, customerLastName, customerPhoneNumber, customerEmail, orderDate, year, month, week) VALUES( '"
					+ String.valueOf(id) + "' , '" + order.getCustomerId() + "' , '" + order.getBranch() + "' , '"
					+ order.getStatus().name() + "' , '" + order.getGreeting() + "' ," + " '" + order.getOrderPrice()
					+ "' , '" + orderDeliveryDate + "' ,  '" + order.getDeliveryFee() + "' , '" + order.getTop().name()
					+ "' ," + " '" + order.getTypeOfDelivery().name() + "' , '" + order.getItemListToDB() + "' , '"
					+ order.getDelivery().getCity() + "-" + order.getDelivery().getStreet() + "' , '"
					+ order.getDelivery().getFirstName() + " " + order.getDelivery().getLastName() + "' , '"
					+ order.getDelivery().getPhoneNumber() + "' ," + " '" + order.getCustomerFristName() + "' , '"
					+ order.getCustomerLastName() + "' , '" + order.getCustomerPhoneNumber() + "' , '"
					+ order.getCustomerEmail() + "', '" + currentOrderDate + "', '" + spl[0] + "', '" + spl[1] + "', '"
					+ weeks + "' )";
		else
			query = "INSERT INTO zerliProject.orders ( orderId, customerId, branch, status, greetingCard, totalPrice, orderDeliveryDate, deliveryFee, paymentOptions, supplyType, ListOfItems, receiverAddress, receiverName, receiverPhoneNumber, customerFirstName, customerLastName, customerPhoneNumber, customerEmail, orderDate, year, month, week) VALUES( '"
					+ String.valueOf(id) + "' , '" + order.getCustomerId() + "' , '" + order.getBranch() + "' , '"
					+ order.getStatus().name() + "' , '" + order.getGreeting() + "' ," + " '" + order.getOrderPrice()
					+ "' , '" + orderDeliveryDate + "' ,  '" + order.getDeliveryFee() + "' , '" + order.getTop().name()
					+ "' ," + " '" + order.getTypeOfDelivery().name() + "' , '" + order.getItemListToDB() + "' , '"
					+ null + "' , '" + order.getTakeAway().getFirstName() + " " + order.getTakeAway().getLastName()
					+ "' , '" + order.getTakeAway().getPhoneNumber() + "' ," + " '" + order.getCustomerFristName()
					+ "' , '" + order.getCustomerLastName() + "' , '" + order.getCustomerPhoneNumber() + "' , '"
					+ order.getCustomerEmail() + "' , '" + currentOrderDate + "' , '" + spl[0] + "', '" + spl[1]
					+ "', '" + weeks + "' )";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

/**
 * insert the list of orders of the user into the DB
 * @param user An Users representing the user 
 * @return An ArrayList<Orders> representing the list of orders for the user
 */
	public static ArrayList<Orders> insertIntoListOfOrdersForCustomer(Users user) {
		ArrayList<Orders> list = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;
		try {
			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.orders where customerId = ? ");
			ps.setString(1, user.getId());
			ps.execute();
			result = ps.getResultSet();
			  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			while (result.next()) {

				try {
					list.add(new Orders(result.getString(1), result.getString(12),dateFormat.parse(result.getString(7)),
							Status.valueOf(result.getString(4))));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}
/**
 * Gets details about payment from the Db
 * @param user An Users representing the user
 * @return An Customer representing user details
 */
	public static Customer giveDetailsForPayment(Users user) {
		Customer customer = null;
		PreparedStatement ps;
		ResultSet result;
		try {
			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.customer where customerId = ? ");
			ps.setString(1, user.getId());
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {

				customer = new Customer(result.getString(1), result.getString(2), result.getDouble(3),
						CustomerType.valueOf((result.getString(4))));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}
/**
 * Updating the balance type into the DB
 * @param c An Customer representing the cutomer 
 */
	public static void updateBalanceCustomerType(Customer c) {

		PreparedStatement ps;
		ResultSet res;
		try {
			ps = MySqlConnection.con.prepareStatement(
					"update zerliproject.customer set balance=? , customerType=? where customerId =?");

			ps.setDouble(1, c.getBalance());
			ps.setString(2, c.getCustomerType().name());
			ps.setString(3, c.getCustomerId());
			ps.execute();
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

////////////////////laith
/**
 * Canceling the order
 * @param obj A string representing 
 */
	public static void changeOrderToCamceled(String obj) {
		String[] result = ((String) obj).split(",");
		PreparedStatement ps;
		ResultSet res;
		try {
			ps = MySqlConnection.con
					.prepareStatement("update zerliproject.orders set status=? , cancelDateTime=? where orderId =?");

			ps.setString(1, Status.CANCELED.name());
			ps.setString(2, result[1]);
			ps.setString(3, result[0]);
			ps.execute();
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * Gets the data of the income reports from the DB
 * @param branch  A string representing the branch of the report
 * @param year    A string representing the year of the report
 * @param month   A string representing the month of the report
 * @return An ArrayList<IncomeDataReport> representing the data of the income report
 */
	public static ArrayList<IncomeDataReport> getDataForIncomeReport(String branch, String year, String month) {

		ArrayList<IncomeDataReport> list = new ArrayList<IncomeDataReport>();
		PreparedStatement ps;
		ResultSet res;
		int count = 0;
		double week = 0;
		int numberOfOrders = 0;

		try {
			ps = MySqlConnection.con.prepareStatement(
					"SELECT * FROM zerliproject.orders where branch=? and year=? and month=? and week=?");

			ps.setString(1, branch);
			ps.setString(2, year);
			ps.setString(3, month);
			ps.setString(4, "1");
			ps.execute();
			res = ps.getResultSet();
			while (res.next()) {

				numberOfOrders++;
				week += Double.parseDouble(res.getString(6));
			}
			list.add(new IncomeDataReport("week1", numberOfOrders, week));
			week = 0;
			numberOfOrders = 0;

			ps = MySqlConnection.con.prepareStatement(
					"SELECT * FROM zerliproject.orders where branch=? and year=? and month=? and week=?");

			ps.setString(1, branch);
			ps.setString(2, year);
			ps.setString(3, month);
			ps.setString(4, "2");
			ps.execute();
			res = ps.getResultSet();
			while (res.next()) {

				numberOfOrders++;
				week += Double.parseDouble(res.getString(6));
			}
			list.add(new IncomeDataReport("week2", numberOfOrders, week));
			week = 0;
			numberOfOrders = 0;

			ps = MySqlConnection.con.prepareStatement(
					"SELECT * FROM zerliproject.orders where branch=? and year=? and month=? and week=?");

			ps.setString(1, branch);
			ps.setString(2, year);
			ps.setString(3, month);
			ps.setString(4, "3");
			ps.execute();
			res = ps.getResultSet();
			while (res.next()) {

				numberOfOrders++;
				week += Double.parseDouble(res.getString(6));
			}
			list.add(new IncomeDataReport("week3", numberOfOrders, week));
			week = 0;
			numberOfOrders = 0;

			ps = MySqlConnection.con.prepareStatement(
					"SELECT * FROM zerliproject.orders where branch=? and year=? and month=? and week=?");

			ps.setString(1, branch);
			ps.setString(2, year);
			ps.setString(3, month);
			ps.setString(4, "4");
			ps.execute();
			res = ps.getResultSet();
			while (res.next()) {

				numberOfOrders++;
				week += Double.parseDouble(res.getString(6));
			}
			list.add(new IncomeDataReport("week4", numberOfOrders, week));
			week = 0;
			numberOfOrders = 0;

			ps = MySqlConnection.con.prepareStatement(
					"SELECT * FROM zerliproject.orders where branch=? and year=? and month=? and week=?");

			ps.setString(1, branch);
			ps.setString(2, year);
			ps.setString(3, month);
			ps.setString(4, "5");
			ps.execute();
			res = ps.getResultSet();
			while (res.next()) {

				numberOfOrders++;
				week += Double.parseDouble(res.getString(6));
			}
			list.add(new IncomeDataReport("week5", numberOfOrders, week));
			week = 0;
			numberOfOrders = 0;

			ps = MySqlConnection.con.prepareStatement(
					"insert into zerliproject.income_report values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, branch);
			ps.setString(2, year);
			ps.setString(3, month);
			ps.setString(4, list.get(0).getWeek());
			ps.setString(5, list.get(1).getWeek());
			ps.setString(6, list.get(2).getWeek());
			ps.setString(7, list.get(3).getWeek());
			ps.setString(8, list.get(4).getWeek());
			ps.setDouble(9, list.get(0).getTotalIncome());
			ps.setDouble(10, list.get(1).getTotalIncome());
			ps.setDouble(11, list.get(2).getTotalIncome());
			ps.setDouble(12, list.get(3).getTotalIncome());
			ps.setDouble(13, list.get(4).getTotalIncome());
			ps.setInt(14, list.get(0).getNumberOfOrders());
			ps.setInt(15, list.get(1).getNumberOfOrders());
			ps.setInt(16, list.get(2).getNumberOfOrders());
			ps.setInt(17, list.get(3).getNumberOfOrders());
			ps.setInt(18, list.get(4).getNumberOfOrders());
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
/**
 * Gets a ready report from the DB
 * @param branch  A string representing the branch of the report
 * @param year    A string representing the year of the report
 * @param month   A string representing the month of the report
 * @return An ArrayList<Object> representing the income report
 */
	public static ArrayList<Object> getReadyDataIncomeReport(String branch, String year, String month) {
		ArrayList<Object> list = new ArrayList<>();
		PreparedStatement ps;
		ResultSet res;

		try {
			ps = MySqlConnection.con.prepareStatement(
					"SELECT * FROM zerliproject.income_report where branch=?  and year=? and month=?");
			ps.setString(1, branch);
			ps.setString(2, year);
			ps.setString(3, month);
			ps.execute();
			res = ps.getResultSet();
			if (!res.next()) {
				list.add(false);
				return list;
			}

			list.add(true);
			list.add(new IncomeDataReport(res.getString(4), res.getInt(14), res.getDouble(9)));
			list.add(new IncomeDataReport(res.getString(5), res.getInt(15), res.getDouble(10)));
			list.add(new IncomeDataReport(res.getString(6), res.getInt(16), res.getDouble(11)));
			list.add(new IncomeDataReport(res.getString(7), res.getInt(17), res.getDouble(12)));
			list.add(new IncomeDataReport(res.getString(8), res.getInt(18), res.getDouble(13)));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
/**
 * checking if there income reports into the DB
 * @param branch  A string representing the branch of the report
 * @param year    A string representing the year of the report
 * @param month   A string representing the month of the report
 * @return true if there is income report else returns false
 */
	public static Object checkIfThereIncomeReports(String branch, String year, String month) {
		Object obj = null;
		PreparedStatement ps;
		ResultSet res;

		try {
			ps = MySqlConnection.con
					.prepareStatement("SELECT * FROM zerliproject.orders where branch=?  and year=? and month=?");

			ps.setString(1, branch);
			ps.setString(2, year);
			ps.setString(3, month);
			ps.execute();
			res = ps.getResultSet();
			if (!res.next()) {
				obj = false;
			} else {
				obj = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}
/**
 * checking i there orders reports into the DB
 * @param branch  A string representing the branch of the report
 * @param year    A string representing the year of the report
 * @param month   A string representing the month of the report
 * @return true if there is income report else returns false
 */
	public static Object checkIfThereOrderReports(String branch, String year, String month) {

		Object obj = null;
		PreparedStatement ps;
		ResultSet res;

		try {
			ps = MySqlConnection.con
					.prepareStatement("SELECT * FROM zerliproject.orders where branch=?  and year=? and month=?");

			ps.setString(1, branch);
			ps.setString(2, year);
			ps.setString(3, month);
			ps.execute();
			res = ps.getResultSet();
			if (!res.next()) {
				obj = false;
			} else {
				obj = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}
/**
 * Gets a ready orders report from the DB
 * @param branch  A string representing the branch of the report
 * @param year    A string representing the year of the report
 * @param month   A string representing the month of the report
 * @return An ArrayList<Object> representing the orders report
 */
	public static ArrayList<Object> getReadyDataOrderReport(String branch, String year, String month) {
		ArrayList<Object> list = new ArrayList<>();
		PreparedStatement ps;
		ResultSet res;

		try {
			ps = MySqlConnection.con.prepareStatement(
					"SELECT * FROM zerliproject.order_reports where branch=?  and year=? and month=?");
			ps.setString(1, branch);
			ps.setString(2, year);
			ps.setString(3, month);
			ps.execute();
			res = ps.getResultSet();
			if (!res.next()) {
				list.add(false);
				return list;
			}

			list.add(true);
			list.add(new OrderDataReport("Pot", res.getDouble(4), res.getInt(13)));
			list.add(new OrderDataReport("Bouquet", res.getDouble(5), res.getInt(14)));
			list.add(new OrderDataReport("Flower", res.getDouble(6), res.getInt(15)));
			list.add(new OrderDataReport("Seedling", res.getDouble(7), res.getInt(16)));
			list.add(new OrderDataReport("Branch", res.getDouble(8), res.getInt(17)));
			list.add(new OrderDataReport("StylesBouquet", res.getDouble(9), res.getInt(18)));
			list.add(new OrderDataReport("SeedlingFlowers", res.getDouble(10), res.getInt(19)));
			list.add(new OrderDataReport("SpecailZerli", res.getDouble(11), res.getInt(20)));
			list.add(new OrderDataReport("BridalBouquet", res.getDouble(12), res.getInt(21)));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
/**
 * Gets data of orders report from the DB
 * @param branch  A string representing the branch of the report
 * @param year    A string representing the year of the report
 * @param month   A string representing the month of the report
 * @return An ArrayList<OrderDataReport> representing the data orders report
 */
	public static ArrayList<OrderDataReport> getDataOrderReport(String branch, String year, String month) {
		ArrayList<OrderDataReport> OrderReportlist = new ArrayList<>();
		PreparedStatement ps;
		ResultSet res;
		ArrayList<Item> pot = new ArrayList<>();
		ArrayList<Item> bouquet = new ArrayList<>();
		ArrayList<Item> flower = new ArrayList<>();
		ArrayList<Item> seedling = new ArrayList<>();
		ArrayList<Item> branchTree = new ArrayList<>();
		ArrayList<Products> stylesBouquet = new ArrayList<>();
		ArrayList<Products> seedlingFlowers = new ArrayList<>();
		ArrayList<Products> specailZerli = new ArrayList<>();
		ArrayList<Products> bridalBouquet = new ArrayList<>();

		try {

			ps = MySqlConnection.con.prepareStatement("SELECT * FROM zerliproject.item_in_catalog where Type = ? ");
			ps.setString(1, ItemType.Pot.name());
			ps.execute();
			res = ps.getResultSet();

			while (res.next()) {
				pot.add(new Item(res.getString(2), ItemType.valueOf(res.getString(3)), res.getDouble(5)));
			}

			ps = MySqlConnection.con.prepareStatement("SELECT * FROM zerliproject.item_in_catalog where Type= ? ");
			ps.setString(1, ItemType.Bouquet.name());
			ps.execute();
			res = ps.getResultSet();
			while (res.next()) {
				bouquet.add(new Item(res.getString(2), ItemType.valueOf(res.getString(3)), res.getDouble(5)));
			}

			ps = MySqlConnection.con.prepareStatement("SELECT * FROM zerliproject.item_in_catalog where Type= ? ");
			ps.setString(1, ItemType.Flower.name());
			ps.execute();
			res = ps.getResultSet();
			while (res.next()) {
				flower.add(new Item(res.getString(2), ItemType.valueOf(res.getString(3)), res.getDouble(5)));
			}

			ps = MySqlConnection.con.prepareStatement("SELECT * FROM zerliproject.item_in_catalog where Type= ? ");
			ps.setString(1, ItemType.Seedling.name());
			ps.execute();
			res = ps.getResultSet();
			while (res.next()) {
				seedling.add(new Item(res.getString(2), ItemType.valueOf(res.getString(3)), res.getDouble(5)));
			}
			ps = MySqlConnection.con.prepareStatement("SELECT * FROM zerliproject.item_in_catalog where Type = ? ");
			ps.setString(1, ItemType.Branch.name());
			ps.execute();
			res = ps.getResultSet();
			while (res.next()) {
				branchTree.add(new Item(res.getString(2), ItemType.valueOf(res.getString(3)), res.getDouble(5)));
			}

			ps = MySqlConnection.con.prepareStatement("SELECT * FROM zerliproject.product_in_catalog where Type= ? ");
			ps.setString(1, ProductType.StylesBouquet.name());
			ps.execute();
			res = ps.getResultSet();
			while (res.next()) {
				stylesBouquet
						.add(new Products(res.getString(2), ProductType.valueOf(res.getString(3)), res.getDouble(5)));
			}
			ps = MySqlConnection.con.prepareStatement("SELECT * FROM zerliproject.product_in_catalog where Type= ? ");
			ps.setString(1, ProductType.SeedlingFlowers.name());
			ps.execute();
			res = ps.getResultSet();
			while (res.next()) {
				seedlingFlowers
						.add(new Products(res.getString(2), ProductType.valueOf(res.getString(3)), res.getDouble(5)));
			}
			ps = MySqlConnection.con.prepareStatement("SELECT * FROM zerliproject.product_in_catalog where Type= ? ");
			ps.setString(1, ProductType.SpecailZerli.name());
			ps.execute();
			res = ps.getResultSet();
			while (res.next()) {
				specailZerli
						.add(new Products(res.getString(2), ProductType.valueOf(res.getString(3)), res.getDouble(5)));
			}

			ps = MySqlConnection.con.prepareStatement("SELECT * FROM zerliproject.product_in_catalog where Type= ? ");
			ps.setString(1, ProductType.BridalBouquet.name());
			ps.execute();
			res = ps.getResultSet();
			while (res.next()) {
				bridalBouquet
						.add(new Products(res.getString(2), ProductType.valueOf(res.getString(3)), res.getDouble(5)));
			}

			String[] spl;
			ps = MySqlConnection.con
					.prepareStatement("SELECT * FROM zerliproject.orders where branch=?  and year=? and month=?");
			ps.setString(1, branch);
			ps.setString(2, year);
			ps.setString(3, month);
			ps.execute();
			res = ps.getResultSet();

			int[] count = new int[9];
			double[] tc = new double[9];
			for (int i = 0; i < 9; i++) {
				count[i] = 0;
				tc[i] = 0;
			}

			while (res.next()) {

				String result = res.getString(12);
				spl = result.split(",");

				for (int i = 0; i < spl.length; i++) {

					for (int i1 = 0; i1 < pot.size(); i1++) {
						if (pot.get(i1).getItemName().equals(spl[i])) {
							count[0]++;
							tc[0] += pot.get(i1).getPrice();
						}
					}
					for (int i1 = 0; i1 < bouquet.size(); i1++) {
						if (bouquet.get(i1).getItemName().equals(spl[i])) {
							count[1]++;
							tc[1] += bouquet.get(i1).getPrice();
						}
					}
					for (int i1 = 0; i1 < flower.size(); i1++) {
						if (flower.get(i1).getItemName().equals(spl[i])) {
							count[2]++;
							tc[2] += flower.get(i1).getPrice();
						}
					}
					for (int i1 = 0; i1 < seedling.size(); i1++) {
						if (seedling.get(i1).getItemName().equals(spl[i])) {
							count[3]++;
							tc[3] += seedling.get(i1).getPrice();
						}
					}
					for (int i1 = 0; i1 < branchTree.size(); i1++) {
						if (branchTree.get(i1).getItemName().equals(spl[i])) {
							count[4]++;
							tc[4] += branchTree.get(i1).getPrice();
						}
					}
					for (int i1 = 0; i1 < stylesBouquet.size(); i1++) {
						if (stylesBouquet.get(i1).getProductName().equals(spl[i])) {
							count[5]++;
							tc[5] += stylesBouquet.get(i1).getPrice();
						}
					}
					for (int i1 = 0; i1 < seedlingFlowers.size(); i1++) {
						if (seedlingFlowers.get(i1).getProductName().equals(spl[i])) {
							count[6]++;
							tc[6] += seedlingFlowers.get(i1).getPrice();
						}
					}
					for (int i1 = 0; i1 < specailZerli.size(); i1++) {
						if (specailZerli.get(i1).getProductName().equals(spl[i])) {
							count[7]++;
							tc[7] += specailZerli.get(i1).getPrice();
						}
					}
					for (int i1 = 0; i1 < bridalBouquet.size(); i1++) {
						if (bridalBouquet.get(i1).getProductName().equals(spl[i])) {
							count[8]++;
							tc[8] += bridalBouquet.get(i1).getPrice();
						}
					}

				}

			}

			OrderReportlist.add(new OrderDataReport("Pot", tc[0], count[0]));
			OrderReportlist.add(new OrderDataReport("Bouquet", tc[1], count[1]));
			OrderReportlist.add(new OrderDataReport("Flower", tc[2], count[2]));
			OrderReportlist.add(new OrderDataReport("Seedling", tc[3], count[3]));
			OrderReportlist.add(new OrderDataReport("Branch", tc[4], count[4]));
			OrderReportlist.add(new OrderDataReport("StylesBouquet", tc[5], count[5]));
			OrderReportlist.add(new OrderDataReport("SeedlingFlowers", tc[6], count[6]));
			OrderReportlist.add(new OrderDataReport("SpecailZerli", tc[7], count[7]));
			OrderReportlist.add(new OrderDataReport("BridalBouquet", tc[8], count[8]));

			ps = MySqlConnection.con.prepareStatement(
					"insert into zerliproject.order_reports values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, branch);
			ps.setString(2, year);
			ps.setString(3, month);
			ps.setDouble(4, OrderReportlist.get(0).getTotlaCost());
			ps.setDouble(5, OrderReportlist.get(1).getTotlaCost());
			ps.setDouble(6, OrderReportlist.get(2).getTotlaCost());
			ps.setDouble(7, OrderReportlist.get(3).getTotlaCost());
			ps.setDouble(8, OrderReportlist.get(4).getTotlaCost());
			ps.setDouble(9, OrderReportlist.get(5).getTotlaCost());
			ps.setDouble(10, OrderReportlist.get(6).getTotlaCost());
			ps.setDouble(11, OrderReportlist.get(7).getTotlaCost());
			ps.setDouble(12, OrderReportlist.get(8).getTotlaCost());
			ps.setInt(13, OrderReportlist.get(0).getNumberOfPiece());
			ps.setInt(14, OrderReportlist.get(1).getNumberOfPiece());
			ps.setInt(15, OrderReportlist.get(2).getNumberOfPiece());
			ps.setInt(16, OrderReportlist.get(3).getNumberOfPiece());
			ps.setInt(17, OrderReportlist.get(4).getNumberOfPiece());
			ps.setInt(18, OrderReportlist.get(5).getNumberOfPiece());
			ps.setInt(19, OrderReportlist.get(6).getNumberOfPiece());
			ps.setInt(20, OrderReportlist.get(7).getNumberOfPiece());
			ps.setInt(21, OrderReportlist.get(8).getNumberOfPiece());
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return OrderReportlist;
	}
/**
 * checking if there quarter income reports into the DB
 * @param branch  A string representing the branch of the report
 * @param year    A string representing the year of the report
 * @param quarter   A string representing the quarter of the report
 * @return true if there a quarter income report else returns false
 */
	public static Object checkIfThereQuarterIncomeReport(String branch, String year, String quarter) {

		Object obj = true;
		PreparedStatement ps;
		ResultSet res;

		try {
			if (quarter.equals("1")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.orders where branch=?  and year=? and month >= ? and month <= ? ");

				ps.setString(1, branch);
				ps.setString(2, year);
				ps.setString(3, "01");
				ps.setString(4, "03");
				ps.execute();
				res = ps.getResultSet();
				if (!res.next()) {
					obj = false;
				}
			}
			if (quarter.equals("2")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.orders where branch=?  and year=? and month >= ? and month <= ? ");

				ps.setString(1, branch);
				ps.setString(2, year);
				ps.setString(3, "04");
				ps.setString(4, "06");
				ps.execute();
				res = ps.getResultSet();
				if (!res.next()) {
					obj = false;
				}
			}
			if (quarter.equals("3")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.orders where branch=?  and year=? and month >= ? and month <= ? ");
				ps.setString(1, branch);
				ps.setString(2, year);
				ps.setString(3, "07");
				ps.setString(4, "09");
				ps.execute();
				res = ps.getResultSet();
				if (!res.next()) {
					obj = false;
				}

			}
			if (quarter.equals("4")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.orders where branch=?  and year=? and month >= ? and month <= ? ");

				ps.setString(1, branch);
				ps.setString(2, year);
				ps.setString(3, "10");
				ps.setString(4, "12");
				ps.execute();
				res = ps.getResultSet();
				if (!res.next()) {
					obj = false;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}
/**
 * Gets a ready quarter income report from the DB
 * @param branch  A string representing the branch of the report
 * @param year    A string representing the year of the report
 * @param quarter   A string representing the quarter of the report
 * @return An ArrayList<Object> representing the quarter income report
 */
	public static ArrayList<Object> getReadyQuarterIncomeReports(String branch, String year, String quarter) {

		ArrayList<Object> list = new ArrayList<>();
		PreparedStatement ps;
		ResultSet res;

		try {
			ps = MySqlConnection.con.prepareStatement(
					"SELECT * FROM zerliproject.income_quarter_report where branch=?  and year=? and quarter=? ");
			ps.setString(1, branch);
			ps.setString(2, year);
			ps.setString(3, quarter);
			ps.execute();
			res = ps.getResultSet();

			if (!res.next()) {
				list.add(false);
				return list;
			}
			list.add(true);

			list.add(new IncomeQuarterDataReports(res.getString(10), res.getDouble(4), res.getInt(7)));
			list.add(new IncomeQuarterDataReports(res.getString(11), res.getDouble(5), res.getInt(8)));
			list.add(new IncomeQuarterDataReports(res.getString(12), res.getDouble(6), res.getInt(9)));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
/**
 * Gets a quarter income report from the DB 
 * @param branch  A string representing the branch of the report
 * @param year    A string representing the year of the report
 * @param quarter   A string representing the quarter of the report
 * @return An ArrayList<Object> representing the quarter income report
 */
	public static ArrayList<IncomeQuarterDataReports> getQuarterIncomeReports(String branch, String year,
			String quarter) {

		ArrayList<IncomeQuarterDataReports> list = new ArrayList<>();
		PreparedStatement ps;
		ResultSet res;
		int count1 = 0, count2 = 0, count3 = 0;
		double totalCost1 = 0, totalCost2 = 0, totalCost3 = 0;
		try {
			if (quarter.equals("1")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.orders where branch=?  and year=? and month >= ? and month <= ? ");

				ps.setString(1, branch);
				ps.setString(2, year);
				ps.setString(3, "01");
				ps.setString(4, "03");
				ps.execute();
				res = ps.getResultSet();
				while (res.next()) {
					if (res.getString(23).equals("01")) {
						count1++;
						totalCost1 += res.getDouble(6);
					} else if (res.getString(23).equals("02")) {
						count2++;
						totalCost2 += res.getDouble(6);
					} else if (res.getString(23).equals("03")) {
						count3++;
						totalCost3 += res.getDouble(6);
					}
				}
				list.add(new IncomeQuarterDataReports("January", totalCost1, count1));
				list.add(new IncomeQuarterDataReports("February", totalCost2, count2));
				list.add(new IncomeQuarterDataReports("March", totalCost3, count3));
			}
			if (quarter.equals("2")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.orders where branch=?  and year=? and month >= ? and month <= ? ");

				ps.setString(1, branch);
				ps.setString(2, year);
				ps.setString(3, "04");
				ps.setString(4, "06");
				ps.execute();
				res = ps.getResultSet();
				while (res.next()) {
					if (res.getString(23).equals("04")) {
						count1++;
						totalCost1 += res.getDouble(6);
					} else if (res.getString(23).equals("05")) {
						count2++;
						totalCost2 += res.getDouble(6);
					} else if (res.getString(23).equals("06")) {
						count3++;
						totalCost3 += res.getDouble(6);
					}
				}
				list.add(new IncomeQuarterDataReports("April", totalCost1, count1));
				list.add(new IncomeQuarterDataReports("May", totalCost2, count2));
				list.add(new IncomeQuarterDataReports("June", totalCost3, count3));
			}
			if (quarter.equals("3")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.orders where branch=?  and year=? and month >= ? and month <= ? ");
				ps.setString(1, branch);
				ps.setString(2, year);
				ps.setString(3, "07");
				ps.setString(4, "09");
				ps.execute();
				res = ps.getResultSet();
				while (res.next()) {
					if (res.getString(23).equals("07")) {
						count1++;
						totalCost1 += res.getDouble(6);
					} else if (res.getString(23).equals("08")) {
						count2++;
						totalCost2 += res.getDouble(6);
					} else if (res.getString(23).equals("09")) {
						count3++;
						totalCost3 += res.getDouble(6);
					}
				}
				list.add(new IncomeQuarterDataReports("July", totalCost1, count1));
				list.add(new IncomeQuarterDataReports("August", totalCost2, count2));
				list.add(new IncomeQuarterDataReports("September", totalCost3, count3));
			}
			if (quarter.equals("4")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.orders where branch=?  and year=? and month >= ? and month <= ? ");

				ps.setString(1, branch);
				ps.setString(2, year);
				ps.setString(3, "10");
				ps.setString(4, "12");
				ps.execute();
				res = ps.getResultSet();
				while (res.next()) {
					if (res.getString(23).equals("10")) {
						count1++;
						totalCost1 += res.getDouble(6);
					} else if (res.getString(23).equals("11")) {
						count2++;
						totalCost2 += res.getDouble(6);
					} else if (res.getString(23).equals("12")) {
						count3++;
						totalCost3 += res.getDouble(6);
					}
				}
				list.add(new IncomeQuarterDataReports("October", totalCost1, count1));
				list.add(new IncomeQuarterDataReports("November", totalCost2, count2));
				list.add(new IncomeQuarterDataReports("December", totalCost3, count3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			ps = MySqlConnection.con.prepareStatement(
					"insert into zerliproject.income_quarter_report values (?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, year);
			ps.setString(2, quarter);
			ps.setString(3, branch);
			ps.setDouble(4, list.get(0).getTotlaCostMonth());
			ps.setDouble(5, list.get(1).getTotlaCostMonth());
			ps.setDouble(6, list.get(2).getTotlaCostMonth());
			ps.setInt(7, list.get(0).getNumberOrdersMonth());
			ps.setInt(8, list.get(1).getNumberOrdersMonth());
			ps.setInt(9, list.get(2).getNumberOrdersMonth());
			ps.setString(10, list.get(0).getMonth());
			ps.setString(11, list.get(1).getMonth());
			ps.setString(12, list.get(2).getMonth());
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
/**
 * checking if there an complaints reports
 * @param year     A string representing the year of the report
 * @param quarter  A string representing the quarter of the report 
 * @return  true if there an complaints report else returns false
 */
	public static Object checkIfThereComplaintsReports(String year, String quarter) {

		Object obj = true;
		PreparedStatement ps;
		ResultSet res;

		try {
			if (quarter.equals("1")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.complaints where year=? and month >= ? and month <= ? ");

				ps.setString(1, year);
				ps.setString(2, "01");
				ps.setString(3, "03");
				ps.execute();
				res = ps.getResultSet();
				if (!res.next()) {
					obj = false;
				}
			}
			if (quarter.equals("2")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.complaints where year=? and month >= ? and month <= ? ");

				ps.setString(1, year);
				ps.setString(2, "04");
				ps.setString(3, "06");
				ps.execute();
				res = ps.getResultSet();
				if (!res.next()) {
					obj = false;
				}
			}
			if (quarter.equals("3")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.complaints where year=? and month >= ? and month <= ? ");

				ps.setString(1, year);
				ps.setString(2, "07");
				ps.setString(3, "09");
				ps.execute();
				res = ps.getResultSet();
				if (!res.next()) {
					obj = false;
				}

			}
			if (quarter.equals("4")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.complaints where year=? and month >= ? and month <= ? ");

				ps.setString(1, year);
				ps.setString(2, "10");
				ps.setString(3, "12");
				ps.execute();
				res = ps.getResultSet();
				if (!res.next()) {
					obj = false;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}
/**
 * Gets an complaints report from the DB
 * @param year     A string representing the year of the report
 * @param quarter  A string representing the quarter of the report 
 * @return An ArrayList<ComplaintsDataReports> representing the complaints report
 */
	public static ArrayList<ComplaintsDataReports> getComplaintsReports(String year, String quarter) {
		ArrayList<ComplaintsDataReports> list = new ArrayList<>();

		PreparedStatement ps;
		ResultSet res;
		int count1 = 0, count2 = 0, count3 = 0;
		int completed1 = 0, processing1 = 0;
		int completed2 = 0, processing2 = 0;
		int completed3 = 0, processing3 = 0;
		try {
			if (quarter.equals("1")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.complaints where year=? and month >= ? and month <= ? ");

				ps.setString(1, year);
				ps.setString(2, "01");
				ps.setString(3, "03");
				ps.execute();
				res = ps.getResultSet();
				while (res.next()) {

					if (res.getString(9).equals("01")) {
						count1++;
						if (ComplaintType.valueOf(res.getString(6)) == ComplaintType.COMPLETED)
							completed1++;
						else
							processing1++;
					}

					if (res.getString(9).equals("02")) {
						count2++;
						if (ComplaintType.valueOf(res.getString(6)) == ComplaintType.COMPLETED)
							completed2++;
						else
							processing2++;
					}

					if (res.getString(9).equals("03")) {
						count3++;
						if (ComplaintType.valueOf(res.getString(6)) == ComplaintType.COMPLETED)
							completed3++;
						else
							processing3++;
					}

				}

				list.add(new ComplaintsDataReports("January", count1, completed1, processing1));
				list.add(new ComplaintsDataReports("February", count2, completed2, processing2));
				list.add(new ComplaintsDataReports("March", count3, completed3, processing3));
			}
			if (quarter.equals("2")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.complaints where year=? and month >= ? and month <= ? ");

				ps.setString(1, year);
				ps.setString(2, "04");
				ps.setString(3, "06");
				ps.execute();
				res = ps.getResultSet();
				while (res.next()) {

					if (res.getString(9).equals("04")) {
						count1++;
						if (ComplaintType.valueOf(res.getString(6)) == ComplaintType.COMPLETED)
							completed1++;
						else
							processing1++;
					}

					if (res.getString(9).equals("05")) {
						count2++;
						if (ComplaintType.valueOf(res.getString(6)) == ComplaintType.COMPLETED)
							completed2++;
						else
							processing2++;
					}

					if (res.getString(9).equals("06")) {
						count3++;
						if (ComplaintType.valueOf(res.getString(6)) == ComplaintType.COMPLETED)
							completed3++;
						else
							processing3++;
					}

				}

				list.add(new ComplaintsDataReports("April", count1, completed1, processing1));
				list.add(new ComplaintsDataReports("May", count2, completed2, processing2));
				list.add(new ComplaintsDataReports("June", count3, completed3, processing3));
			}
			if (quarter.equals("3")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.complaints where year=? and month >= ? and month <= ? ");

				ps.setString(1, year);
				ps.setString(2, "07");
				ps.setString(3, "09");
				ps.execute();
				res = ps.getResultSet();
				while (res.next()) {

					if (res.getString(9).equals("07")) {
						count1++;
						if (ComplaintType.valueOf(res.getString(6)) == ComplaintType.COMPLETED)
							completed1++;
						else
							processing1++;
					}

					if (res.getString(9).equals("08")) {
						count2++;
						if (ComplaintType.valueOf(res.getString(6)) == ComplaintType.COMPLETED)
							completed2++;
						else
							processing2++;
					}

					if (res.getString(9).equals("09")) {
						count3++;
						if (ComplaintType.valueOf(res.getString(6)) == ComplaintType.COMPLETED)
							completed3++;
						else
							processing3++;
					}

				}

				list.add(new ComplaintsDataReports("July", count1, completed1, processing1));
				list.add(new ComplaintsDataReports("August", count2, completed2, processing2));
				list.add(new ComplaintsDataReports("September", count3, completed3, processing3));
			}
			if (quarter.equals("4")) {
				ps = MySqlConnection.con.prepareStatement(
						"SELECT * FROM zerliproject.complaints where year=? and month >= ? and month <= ? ");

				ps.setString(1, year);
				ps.setString(2, "10");
				ps.setString(3, "12");
				ps.execute();
				res = ps.getResultSet();
				while (res.next()) {

					if (res.getString(9).equals("10")) {
						count1++;
						if (ComplaintType.valueOf(res.getString(6)) == ComplaintType.COMPLETED)
							completed1++;
						else
							processing1++;
					}

					if (res.getString(9).equals("11")) {
						count2++;
						if (ComplaintType.valueOf(res.getString(6)) == ComplaintType.COMPLETED)
							completed2++;
						else
							processing2++;
					}

					if (res.getString(9).equals("12")) {
						count3++;
						if (ComplaintType.valueOf(res.getString(6)) == ComplaintType.COMPLETED)
							completed3++;
						else
							processing3++;
					}

				}
				list.add(new ComplaintsDataReports("October", count1, completed1, processing1));
				list.add(new ComplaintsDataReports("November", count2, completed2, processing2));
				list.add(new ComplaintsDataReports("December", count3, completed3, processing3));
			}

			ps = MySqlConnection.con.prepareStatement(
					"insert into zerliproject.complaints_reports values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, year);
			ps.setString(2, quarter);
			ps.setString(3, list.get(0).getMonth());
			ps.setString(4, list.get(1).getMonth());
			ps.setString(5, list.get(2).getMonth());
			ps.setInt(6, list.get(0).getNumberOfComplaint());
			ps.setInt(7, list.get(1).getNumberOfComplaint());
			ps.setInt(8, list.get(2).getNumberOfComplaint());
			ps.setInt(9, list.get(0).getNumberCompleted());
			ps.setInt(10, list.get(1).getNumberCompleted());
			ps.setInt(11, list.get(2).getNumberCompleted());
			ps.setInt(12, list.get(0).getNumberProcessing());
			ps.setInt(13, list.get(1).getNumberProcessing());
			ps.setInt(14, list.get(2).getNumberProcessing());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
/**
 * Gets a ready complaints report from the DB
 * @param year     A string representing the year of the report
 * @param quarter  A string representing the quarter of the report 
 * @return An ArrayList<Object< representing the complaints report
 */
	public static ArrayList<Object> getComplaintsReadyReports(String year, String quarter) {
		ArrayList<Object> list = new ArrayList<>();
		PreparedStatement ps;
		ResultSet res;

		try {
			ps = MySqlConnection.con
					.prepareStatement("SELECT * FROM zerliproject.complaints_reports where year=? and quarter=? ");
			ps.setString(1, year);
			ps.setString(2, quarter);
			ps.execute();
			res = ps.getResultSet();

			if (!res.next()) {
				list.add(false);
				return list;
			}
			list.add(true);

			list.add(new ComplaintsDataReports(res.getString(3), res.getInt(6), res.getInt(9), res.getInt(12)));
			list.add(new ComplaintsDataReports(res.getString(4), res.getInt(7), res.getInt(10), res.getInt(13)));
			list.add(new ComplaintsDataReports(res.getString(5), res.getInt(8), res.getInt(11), res.getInt(14)));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}
////////////////////laith

///////////////////////////////////////////////////////

//Majd comment is block 

//public static ArrayList<Report> getReportFromDB() {
//ArrayList<Report> reportsList = new ArrayList<>();
//PreparedStatement ps;
//ResultSet result;
//
//try {
//ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.reports");
//ps.execute();
//result=ps.getResultSet();
//while (result.next()) {
//System.out.println(result.getString(1)  + result.getString(2) +result.getString(3)+result.getString(4)+result.getString(5)+result.getString(6)+result.getString(7));
//reportsList.add(new Report(result.getString(1) , result.getString(2),result.getString(3),result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
//}
//} catch (SQLException e) {
//e.printStackTrace();
//}
//return reportsList;
//
//}

/////////////////////////////////////////////////
/**
 * Gets a ready report from the DB
 * @return An ArrayList<Report> representing the report 
 */
	public static ArrayList<Report> getReportFromDB() {
		ArrayList<Report> reportsList = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;

		try {
			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.reports");
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {

				reportsList.add(new Report(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reportsList;

	}

//////////////////////////////////////////
/**
 * Gets a report with its branch from the DB
 * @return An ArrayList<ReportAndItsBranches> representing the report 
 */
	public static ArrayList<ReportAndItsBranches> getReportAndItsBranchesFromDB() {
		ArrayList<ReportAndItsBranches> reportsAndBranchesList = new ArrayList<>();
		PreparedStatement ps, ps1;
		ResultSet result, result1;

		try {

//String date = convertMonthAndYearToString(String year,String month);
			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.reports");
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {

				System.out
						.println(result.getString(1) + result.getString(2) + result.getString(3) + result.getString(4));

				ps1 = MySqlConnection.con.prepareStatement(
						"Select *From zerliproject.orders Where branch = '" + result.getString(2) + "'");
				ps1.execute();
				result1 = ps1.getResultSet();
				while (result1.next()) {
					reportsAndBranchesList.add(new ReportAndItsBranches(result1.getString(2), result.getString(4)));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<ReportAndItsBranches> noDuplicates = new ArrayList<>();
// we want to return list with no duplicates
		for (ReportAndItsBranches obj : reportsAndBranchesList) {
			if (!noDuplicates.contains(obj))
				noDuplicates.add(obj);
		}
		return noDuplicates;

	}
/**
 * Gets the brach from the DB
 * @return An ArrayList<Branch> representing the branch
 */
	public static ArrayList<Branch> getBranchFromDB() {

		ArrayList<Branch> branches = new ArrayList<>();

		PreparedStatement ps;
		ResultSet result;

		try {

			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.branch");
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {
				branches.add(new Branch(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4), Double.parseDouble(result.getString(5)), result.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return branches;
	}

/////////////

////////////////////////////////////

//add by Majd Zbedat
/**
 * Gets the users status from the DB
 * @return An ArrayList<Users> representing the list of the user's status 
 */
	public static ArrayList<Users> getUsersListStatus() {
		ArrayList<Users> userList = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;

		try {
			ps = MySqlConnection.con.prepareStatement(
					"Select * From zerliproject.users where userType=? and(statusInSystem=? or statusInSystem=?)");
			ps.setString(1, "customer");
			ps.setString(2, "CONFIRMED");
			ps.setString(3, "FROZEN");

			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {

				userList.add(
						new Users(result.getString(1), result.getString(2), result.getString(3), result.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;

	}

////////////////////////////////////////////////////////

/////////////////////////////////////////////////////
///add by Majd Zbedat
/**
 * Remove an customer from DB
 * @param id A string representing the customer to remove
 */
	public static void getRemoveCustomer(String id) {
//ArrayList<Object> removeCus = new ArrayList<>();
		PreparedStatement ps;

		System.out.println(id + "///////////////");
		try {
			ps = MySqlConnection.con.prepareStatement("DELETE From zerliproject.users where id=? and userType=? ");
			ps.setString(1, id);
			ps.setString(2, "customer");
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////

//Majd Zbedat
/**
 * Gets the user's details from the DB
 * @return An ArrayList<Users> representing the details of the user
 */
	public static ArrayList<Users> getDetailsUser() {
		ArrayList<Users> userDetails = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;
//	boolean flagActive;

		try {
			ps = MySqlConnection.con.prepareStatement("Select * From zerliproject.users where userType=? ");
			ps.setString(1, "customer");
			ps.execute();
			result = ps.getResultSet();
//if(result.getInt(7) == 0)
//flagActive = false;
//else
//flagActive =true;

			while (result.next()) {

				userDetails.add(new Users(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), result.getString(6), result.getBoolean(7),
						result.getString(8), result.getString(9), result.getString(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userDetails;

	}

///////////////////////////////////////////////////////////////
	/**
	 * Edit the details of the user
	 * @param id          A string representing the id of the user
	 * @param Status      A string representing the status of the user
	 * @param isLoggedIn  A string representing if the user logged in o not
	 */
	public static void editStatus(String id, String Status, String isLoggedIn) {
		PreparedStatement ps;
		ResultSet res;
		try {
			ps = MySqlConnection.con
					.prepareStatement("update zerliproject.users set statusInSystem=?,isLoggedIn=? where id =?");

			ps.setString(1, Status);
			ps.setString(2, isLoggedIn);
			ps.setString(3, id);

			ps.execute();
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

////////////////////////////////////////////////////////////////////////
//add by Majd Zbedat

	}
///////////////////////////////////////////////////////////////////////

//add by Majd Zbedat
	/**
	 * Gets list of the registration users 
	 * @return An ArrayList<Users> representing the list of the registration users
	 */
	public static ArrayList<Users> userListRegistration() {
		ArrayList<Users> userRegistration = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;

		try {
			ps = MySqlConnection.con
					.prepareStatement("Select * From zerliproject.users where userType=? and statusInSystem=? ");
			ps.setString(1, "customer");
			ps.setString(2, "NA");
//ps.setString(4,"NA");

			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {

				userRegistration.add(
						new Users(result.getString(1), result.getString(2), result.getString(3), result.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userRegistration;
	}

///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////
//add by Majd Zbedat
	/**
	 * Confirming the registration of the user with ID id
	 * @param id A string representing the id of the user
	 */
	public static void AccountRegistration(String id) {
		PreparedStatement ps;
		ResultSet res;
		try {
			ps = MySqlConnection.con.prepareStatement("update zerliproject.users set statusInSystem=? where id =?");

			ps.setString(1, "CONFIRMED");
			ps.setString(2, id);
			ps.execute();
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

////////////////////////////////////////////////////////////////////////
//add by Majd Zbedat

	}

////////////////////////////////////
//add by Majd Zbedat
	/**
	 * Gets the workers list
	 * @return An ArrayList representing the list of the workers
	 */
	public static ArrayList<Users> getWorkerList() {
		ArrayList<Users> workerList = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;

		try {
			ps = MySqlConnection.con.prepareStatement("Select * From zerliproject.users where userType=?");
			ps.setString(1, "branchworker");

			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {

				workerList.add(
						new Users(result.getString(1), result.getString(2), result.getString(3), result.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return workerList;

	}

///////////////////////////////////////////////////

////////\\                 //\\            //     *
////         //  \\               //  \\          //      ||
////         //    \\             //    \\        //       ||
////////      \\           //      \\      //        ||
///           /////////\\\         //        \\    //         ||
////        //          \\       //          \\  //          ||
////     //            \\     //            \\//           ||
////////////////*****************************************************************************************///////////////////////////////////////////////////////
////////////////*****************************************************************************************///////////////////////////////////////////////////////
////////////////*****************************************************************************************///////////////////////////////////////////////////////
////////////////*****************************************************************************************///////////////////////////////////////////////////////
////////////////*****************************************************************************************///////////////////////////////////////////////////////
////////////////*****************************************************************************************///////////////////////////////////////////////////////
////////////////*****************************************************************************************///////////////////////////////////////////////////////
////////////////*****************************************************************************************///////////////////////////////////////////////////////

//add by rani
////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////
//CONFIRMING QUERY
//this query will return a list of orders which their status is PENDING_APPROVAL // APPROVED // UN_APPROVED
	/**
	 * Gets a list of orders with the status PENDING_APPROVAL or APPROVED or UN_APPROVED
	 * @return An ArrayList<Orders> representing the list of orders
	 */
	public static ArrayList<Orders> getOrderToApproveFromDB() {

		ArrayList<Orders> orders = new ArrayList<>();

		PreparedStatement ps;
		ResultSet result;

		try {

			ps = MySqlConnection.con.prepareStatement(
					"Select *From zerliproject.orders Where status NOT IN ('COMPLETED','UN_APPROVED','APPROVED')");
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {

				String s1 = result.getString(20);
				String s2 = result.getString("OrderDeliveryDate");
				String s3 = result.getString("cancelDateTime");
				System.out.println(s1);
				System.out.println(s2);
				System.out.println(s3);
//DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
//String strDate = dateFormat.format(result.getDate("OrderDeliveryDate"));  
				orders.add(new Orders(result.getString(1), result.getString(3), result.getString(2),
						Status.valueOf(result.getString(4)), result.getString(21),
						Double.parseDouble(result.getString(6)), result.getString(20),
						result.getString("OrderDeliveryDate"), result.getString("cancelDateTime")));
//System.out.println("the order date is : " + result.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orders;
	}
/**
 * Change the status of the orders to APPROVED 
 * @param order_id A string representing the id of the order
 * @return An ArrayList<Orders> representing the orders that chnged
 */
	public static ArrayList<Orders> changeOrderStatusToApproved(String order_id) {

		ArrayList<Orders> updated_orders = new ArrayList<>();

		PreparedStatement ps;
		ResultSet result;

		try {

			ps = MySqlConnection.con.prepareStatement(
					"UPDATE zerliproject.orders SET status = 'APPROVED' WHERE (orderId = '" + order_id + "')");
			ps.execute();
			result = ps.getResultSet();

			ps = MySqlConnection.con.prepareStatement(
					"Select *From zerliproject.orders Where status NOT IN ('COMPLETED','UN_APPROVED','APPROVED')");
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {
				updated_orders.add(new Orders(result.getString(1), result.getString(3), result.getString(2),
						Status.valueOf(result.getString(4)), result.getString(21),
						Double.parseDouble(result.getString(6)), result.getString(20),
						result.getString("OrderDeliveryDate"), result.getString("cancelDateTime")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return updated_orders;
	}
/**
 * Change the status of the orders to UNAPPROVED 
 * @param order_id A string representing the id of the order
 * @return  An ArrayList<Orders> representing the orders that changed
 */
	public static ArrayList<Orders> changeOrderStatusToUnApproved(String order_id) {

		ArrayList<Orders> updated_orders = new ArrayList<>();

		PreparedStatement ps, ps1;
		ResultSet result, result1;

		try {

			ps = MySqlConnection.con.prepareStatement(
					"UPDATE zerliproject.orders SET status = 'UN_APPROVED' WHERE (orderId = '" + order_id + "')");
			ps.execute();
//result = ps.getResultSet();

			ps1 = MySqlConnection.con.prepareStatement(
					"Select *From zerliproject.orders Where status NOT IN ('COMPLETED','UN_APPROVED','APPROVED')");
			ps1.execute();
			result1 = ps1.getResultSet();
			while (result1.next()) {

				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String orderdeliveyDate = result1.getString("OrderDeliveryDate");
				String orderCancelDate = result1.getString("cancelDateTime");

				System.out.println("the order id is " + result1.getString(1));
				System.out
						.println("From my sql connection the delivery time is " + result1.getString("OrderDeliveryDate")
								+ "the cancel date is" + result1.getString("cancelDateTime"));

				updated_orders.add(new Orders(result1.getString(1), result1.getString(3), result1.getString(2),
						Status.valueOf(result1.getString(4)), result1.getString(21),
						Double.parseDouble(result1.getString(6)), result1.getString(20),
						result1.getString("OrderDeliveryDate"), result1.getString("cancelDateTime")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return updated_orders;
	}

//public static ArrayList<Customer> getCustomersFromDB() {                                  ///////////////////////////////////////////////////////////////////////
//                                                /////////////////////////////*************************************
//ArrayList<Customer> customersList = new ArrayList<>();                                 ////////////////////////////////************************************ 
//                                                 ////////////////////////////////************************************
//PreparedStatement ps;                                                                      ////////////////////////////////************************************
//ResultSet result;                                                                               ////////////////////////////////************************************
//                                                       ////////////////////////////////************************************
//try {                                                                                       Ask Rani About it
//
//ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.customer");
//ps.execute();
//result = ps.getResultSet();
//while (result.next()) {
//customersList.add(new Customer(result.getString(1), result.getString(2), result.getString(3),
//result.getString(4), result.getString(5), result.getString(6),
//Boolean.parseBoolean(result.getString(7)), result.getString(8), result.getString(9)));
//}
//} catch (SQLException e) {
//e.printStackTrace();
//}
//
//return customersList;
//}

/////////////////////////////////////////// add by rani
/////////////////////////////////////////// 30.5/////////////////////////////////////
//////////////////////////////////////////// ////////////////////////////////////

//public static Boolean addSurvey(Survey surveyToAdd) {
//
//PreparedStatement ps;
//// ResultSet result;
//
//try {
//ps = MySqlConnection.con.prepareStatement("INSERT INTO zerliproject.survey values (?,?,?,?,?,?,?,?,?,?)");
//ps.setString(1, surveyToAdd.getIdsurvey());
//ps.setString(2, surveyToAdd.getQ1().toString());
//ps.setString(3, surveyToAdd.getQ2().toString());
//ps.setString(4, surveyToAdd.getQ3().toString());
//ps.setString(5, surveyToAdd.getQ5().toString());
//ps.setString(6, surveyToAdd.getQ5().toString());
//ps.setString(7, surveyToAdd.getQ6().toString());
//ps.setString(8, surveyToAdd.getStartDate());
//ps.setString(9, surveyToAdd.getEndDate());
//ps.setString(10, surveyToAdd.getBranchName());
//
//ps.execute();
//
//} catch (SQLException e) {
//e.printStackTrace();
//return false;
//}
//return true;
//
//}

/////////////////////////////////////////// add by rani
/////////////////////////////////////////// 30.5/////////////////////////////////////
//////////////////////////////////////////// ////////////////////////////////////

/////////////////////////////////////////// add by rani
/////////////////////////////////////////// 31.5/////////////////////////////////////
//////////////////////////////////////////// ////////////////////////////////////
	/**
	 * Gets a branch worker with user id
	 * @param userId A string representing the i of the worker
	 * @return A BranchWoreker representing the branch worker 
	 */
	public static BranchWorker getBranchWorkerByUserId(String userId) {

		PreparedStatement ps;
		ResultSet result;
		BranchWorker bw = null;

		try {

			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.branchworker WHERE Id=?");
			ps.setString(1, userId);
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {
				bw = new BranchWorker(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bw;
	}
/////////////////////////////////////////// add by rani
/////////////////////////////////////////// 31.5/////////////////////////////////////
//////////////////////////////////////////// ////////////////////////////////////

/////////////////////////////////////////// add by rani
/////////////////////////////////////////// 3.6/////////////////////////////////////
//////////////////////////////////////////// ////////////////////////////////////
	/**
	 * Adding balance by customer id 
	 * @param customerId A string representing the id of the customer
	 * @param refund     A string representing the refund 
	 * @return true if the adding is success else false
	 */
	public static boolean addBalanceByCustomerId(String customerId, String refund) {

		PreparedStatement ps;
		ResultSet result;
		double newRefund = 0;

		try {

			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.customer WHERE customerId=?");
			ps.setString(1, customerId);
			ps.execute();
			result = ps.getResultSet();

			if (result.next()) {
				newRefund = result.getDouble("balance") + Double.parseDouble(refund);
			}

			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.customer WHERE customerId=?");
			ps.setString(1, customerId);
			ps.execute();
			result = ps.getResultSet();

			ps = MySqlConnection.con.prepareStatement(
					"UPDATE zerliproject.customer SET balance = ? WHERE (customerId = '" + customerId + "')");
			ps.setString(1, Double.toString(newRefund));
			ps.execute();
			result = ps.getResultSet();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

/////////////////////////////////////////// add by rani
/////////////////////////////////////////// 3.6/////////////////////////////////////
//////////////////////////////////////////// ////////////////////////////////////

/////////////////////////////////////////// add by rani
/////////////////////////////////////////// 4.6/////////////////////////////////////
//////////////////////////////////////////// ////////////////////////////////////
/**
 * Gets the survey
 * @return An ArrayList<Survey> representing the list of surey
 */
	public static ArrayList<Survey> getSurveys() {
		PreparedStatement ps;
		ResultSet result;

		ArrayList<Survey> surveys_list = new ArrayList<>();

		try {

			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.survey");
			ps.execute();
			result = ps.getResultSet();

			while (result.next()) {

				surveys_list.add(new Survey(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), result.getString(6), result.getString(7),
						result.getString(8), result.getString(9), result.getString(10), result.getString(11),
						result.getString(12), result.getString(13)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return surveys_list;
	}

/////////////////////////////////////////// add by rani
/////////////////////////////////////////// 4.6/////////////////////////////////////
//////////////////////////////////////////// ////////////////////////////////////

/////////////////////////////////////////// add by rani
/////////////////////////////////////////// 5.6/////////////////////////////////////
//////////////////////////////////////////// ////////////////////////////////////
	/**
	 * Gets the survey answer
	 * @return An ArrayList<SurveyAnswer> representing the survey answers
	 */
	public static ArrayList<SurveyAnswer> getSurveyAnswer() {
		PreparedStatement ps;
		ResultSet result;
		ArrayList<SurveyAnswer> surveysAnswers_list = new ArrayList<>();

		try {

			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.surveys_answers");
			ps.execute();
			result = ps.getResultSet();

			while (result.next()) {

				surveysAnswers_list.add(new SurveyAnswer(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), result.getString(6), result.getString(7),
						result.getString(8), result.getString(9), result.getString(10)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return surveysAnswers_list;
	}

	public static ArrayList<SurveyAnswer> addSurveyAnswer(SurveyAnswer answeredSurveyToSave) {

		PreparedStatement ps;
		ResultSet result;

		ArrayList<SurveyAnswer> surveysAnswersAfterAdd_list = new ArrayList<>();

		try {
			ps = MySqlConnection.con
					.prepareStatement("INSERT INTO zerliproject.surveys_answers values (?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, answeredSurveyToSave.getSurveyAnswerId());
			ps.setString(2, answeredSurveyToSave.getSurveyQuestionId());
			ps.setString(3, answeredSurveyToSave.getQ1answer());
			ps.setString(4, answeredSurveyToSave.getQ2answer());
			ps.setString(5, answeredSurveyToSave.getQ3answer());
			ps.setString(6, answeredSurveyToSave.getQ4answer());
			ps.setString(7, answeredSurveyToSave.getQ5answer());
			ps.setString(8, answeredSurveyToSave.getQ6answer());
			ps.setString(9, answeredSurveyToSave.getFillDate());
			ps.setString(10, answeredSurveyToSave.getBranchWorkerId());
			ps.setString(11, null);
			ps.execute();

			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.surveys_answers");
			ps.execute();
			result = ps.getResultSet();

			while (result.next()) {

				surveysAnswersAfterAdd_list.add(new SurveyAnswer(result.getString(1), result.getString(2),
						result.getString(3), result.getString(4), result.getString(5), result.getString(6),
						result.getString(7), result.getString(8), result.getString(9), result.getString(10)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return surveysAnswersAfterAdd_list;
	}
/////////////////////////////////////////// add by rani
/////////////////////////////////////////// 5.6/////////////////////////////////////
//////////////////////////////////////////// ////////////////////////////////////

/////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////

////////////////*****************************************************************************************///////////////////////////////////////////////////////
////////////////*****************************************************************************************///////////////////////////////////////////////////////
////////////////*****************************************************************************************///////////////////////////////////////////////////////
////////////////*****************************************************************************************///////////////////////////////////////////////////////

	////// add by new Majd Zbedat
/**
 * Gets the details of the credit card
 * @return An ArrayList<CreditCard> representing the credit card details
 */
	public static ArrayList<CreditCard> getCreditCard() {
		ArrayList<CreditCard> CreditCardList = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;

		try {
			ps = MySqlConnection.con.prepareStatement("Select * From zerliproject.creditcardtable");

			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {

				CreditCardList.add(new CreditCard(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CreditCardList;

	}

	// add by Majd Zbedat
	/**
	 * Gets the branch manager 
	 * @param id A string representing the id of the branch manager 
	 * @return An ArrayList<BranchManager< representing the branch manager
	 */
	public static ArrayList<BranchManager> getBranchManager(String id) {
		ArrayList<BranchManager> BranchManagerList = new ArrayList<>();
		PreparedStatement ps;
		ResultSet res;
		try {
			ps = MySqlConnection.con.prepareStatement("Select * From zerliproject.branchmanager where id =?");

			ps.setString(1, id);
			ps.execute();
			res = ps.getResultSet();
			while (res.next()) {

				System.out.println(res.getString(1) + res.getString(2));
				BranchManagerList.add(new BranchManager(res.getString(1), res.getString(2)));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		////////////////////////////////////////////////////////////////////////
		// add by Majd Zbedat
		return BranchManagerList;

	}

//	//add by Majd Zbedat in 30/5/2022
	/**
	 * Gets a list of the branch workers
	 * @param BranchName A string representing the name of the branch
	 * @return An ArrayList<BranchWorker> representing the branch workers
	 */
	public static ArrayList<BranchWorker> getBranchWorkerList(String BranchName) {
		ArrayList<BranchWorker> branchWorker = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;

		try {
			ps = MySqlConnection.con.prepareStatement("Select * From zerliproject.branchworker where branchName=?");

			ps.setString(1, BranchName);
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {
				branchWorker.add(new BranchWorker(result.getString(1), result.getString(2), result.getString(4),
						result.getString(5)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return branchWorker;

	}
	//////// add by othman
/**
 * Deleting a product with id 
 * @param id A string representing the id of the product
 */
	public static void Deleteproduct(String id) {
		PreparedStatement ps;

		try {
			ps = MySqlConnection.con.prepareStatement("DELETE From zerliproject.product_in_catalog where ProductId=? ");
			ps.setString(1, id);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
/**
 * Adding a product catalog
 * @param result A Products representing the product
 */
	public static void Addproducttocatalog(Products result) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		// ResultSet result;

		try {
			ps = MySqlConnection.con
					.prepareStatement("INSERT INTO zerliproject.product_in_catalog values (?,?,?,?,?,?,?)");
			ps.setString(1, result.getProductId().toString());
			ps.setString(2, result.getProductName().toString());
			ps.setString(3, result.getProductType().name());
			ps.setString(4, result.getProductComposition().toString());
			ps.setDouble(5, result.getPrice());
			ps.setString(6, result.getImagePath().toString());
			ps.setDouble(7, result.getDiscount());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
/**
 * Gets item from DB
 * @return An ArrayList<Item> representing the list of items
 */
	public static ArrayList<Item> getItems() {
		ArrayList<Item> itemList = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;

		try {
			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.item_in_catalog");
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {

				itemList.add(new Item(result.getString(1), result.getString(2), ItemType.valueOf(result.getString(3)),
						result.getString(4), Double.parseDouble(result.getString(5)), result.getString(6),
						Double.parseDouble(result.getString(7))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;

	}
/**
 * Deleting items from DB
 * @param id A string representing the id of the item
 */
	public static void Deleteitem(String id) {
		// TODO Auto-generated method stub
		PreparedStatement ps;

		try {
			ps = MySqlConnection.con.prepareStatement("DELETE From zerliproject.item_in_catalog where ItemId=? ");
			ps.setString(1, id);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
/**
 * Adding item to the catalog
 * @param result AN Item representing the item to add
 */
	public static void Additemtocatalog(Item result) {
		// TODO Auto-generated method stub
		PreparedStatement ps;

		try {
			ps = MySqlConnection.con
					.prepareStatement("INSERT INTO zerliproject.item_in_catalog values (?,?,?,?,?,?,?)");
			ps.setString(1, result.getItemId().toString());
			ps.setString(2, result.getItemName().toString());
			ps.setString(3, result.getItemType().name());
			ps.setString(4, result.getColor().toString());
			ps.setDouble(5, result.getPrice());
			ps.setString(6, result.getPicturePath().toString());
			ps.setDouble(7, result.getDiscount());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
///////add by othman 
	///////////////////////////////
	///////////////////////////////
/**
 * Edit the discount of the product
 * @param result A Product representing the product
 */
	public static void editDiscount(Products result) {
		// TODO Auto-generated method stub
		PreparedStatement ps, ps1;
		double d = (result.getPrice() * (100 - result.getDiscount())) / 100;

		try {
			ps = MySqlConnection.con
					.prepareStatement("UPDATE zerliproject.product_in_catalog SET discount=? WHERE ProductId=?");
			ps.setDouble(1, result.getDiscount());
			ps.setString(2, result.getProductId());
			ps.execute();

			ps1 = MySqlConnection.con
					.prepareStatement("UPDATE zerliproject.product_in_catalog SET Price=? WHERE ProductId=?");
			ps1.setDouble(1, d);
			ps1.setString(2, result.getProductId());
			ps1.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
/**
 * Edit the discount of the item 
 * @param result An Item representing the item 
 */
	public static void editDiscountItem(Item result) {
		// TODO Auto-generated method stub
		PreparedStatement ps, ps1;
		double d = (result.getPrice() * (100 - result.getDiscount())) / 100;

		try {
			ps = MySqlConnection.con
					.prepareStatement("UPDATE zerliproject.item_in_catalog SET discount=? WHERE ItemId=?");
			ps.setDouble(1, result.getDiscount());
			ps.setString(2, result.getItemId());
			ps.execute();

			ps1 = MySqlConnection.con
					.prepareStatement("UPDATE zerliproject.item_in_catalog SET Price=? WHERE ItemId=?");
			ps1.setDouble(1, d);
			ps1.setString(2, result.getItemId());
			ps1.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////

	// block for Majd Zbedat create it in 1/6/22
/////////////////////////////////////////////////
//////////////////////////////////////
///////////////////////////
////////////////////
/////////////
///////
////
	/**
	 * Gets branch worker user
	 * @param BranchWorkerId A string representing the id of the branch worker
	 * @return An ArrayList<Users> repesenting the branch workers
	 */
	public static ArrayList<Users> getBranchWorkerUser(String BranchWorkerId) {
		ArrayList<Users> branchWorkerUser = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;

		try {
			ps = MySqlConnection.con.prepareStatement("Select * From zerliproject.users where id=?");

			ps.setString(1, BranchWorkerId);
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {
				branchWorkerUser.add(new Users(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), result.getString(6), result.getBoolean(7),
						result.getString(8), result.getString(9), result.getString(10)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return branchWorkerUser;

	}
/**
 * Gets worker position 
 * @param BranchWorkerById A string representing the id of the branch worker
 * @return An ArrayList<BranchWorker> representing the positions of the branch workers
 */
	public static ArrayList<BranchWorker> getbranchWorkerByIdtoGetWorkerPosition(String BranchWorkerById) {
		ArrayList<BranchWorker> branchWorkerByIdtoGetWorkerPosition = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;

		try {
			ps = MySqlConnection.con.prepareStatement("Select * From zerliproject.branchworker where id=?");

			ps.setString(1, BranchWorkerById);
			ps.execute();
			result = ps.getResultSet();
			while (result.next()) {
				branchWorkerByIdtoGetWorkerPosition.add(new BranchWorker(result.getString(1), result.getString(2),
						result.getString(4), result.getString(5)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return branchWorkerByIdtoGetWorkerPosition;

	}

///////////////////////////////////////////////////////////////
//add by Majd Zbedat
	/**
	 * Updates the status of the branch worker
	 * @param id     A string representing the id of the branch worker
	 * @param status A string representing the status of the branch worker
	 */
	public static void updateBranchWorkerStatus(String id, String status) {
		PreparedStatement ps;
		ResultSet res;
		try {
			ps = MySqlConnection.con
					.prepareStatement("update zerliproject.branchworker set WorkerPosition=? where id =?");

			ps.setString(1, status);
			ps.setString(2, id);
			ps.execute();
		} catch (SQLException e) {
//TODO Auto-generated catch block
			e.printStackTrace();
		}

////////////////////////////////////////////////////////////////////////
//add by Majd Zbedat

	}

//add by Majd Zbedat
	/**
	 * Gets the details of the delivery for the order
	 * @return An ArrayList<Orders> representing the details of the delivery
	 */
	public static ArrayList<Orders> getOrdersDetailsForDelivery() {
		ArrayList<Orders> orderDetailsForDeliveryList = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;

		try {
			ps = MySqlConnection.con
					.prepareStatement("Select * From zerliproject.orders where status=? and supplyType=?");
			ps.setString(1, "APPROVED");
			ps.setString(2, "DELIVERY");

			ps.execute();
			result = ps.getResultSet();

			while (result.next()) {
//System.out.println(result.getString(1)+ result.getString(15)+ result.getString(16)+ result.getString(14)+result.getString(7));

				orderDetailsForDeliveryList.add(new Orders(result.getString(1), result.getString(15),
						result.getString(16), result.getString(14), result.getDouble(6), result.getString(7),
						result.getString(20), result.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderDetailsForDeliveryList;

	}

//add by Majd Zbedat
	/**
	 * Edit the status of the order from delivery to completed 
	 * @param orderId A string representing the id of the order
	 */
	public static void EditByDeliveryToCompleted(String orderId) {
		PreparedStatement ps;
		ResultSet res;
		try {
			ps = MySqlConnection.con.prepareStatement("update zerliproject.orders set status=? where orderId =?");

			ps.setString(1, "COMPLETED");
			ps.setString(2, orderId);
			ps.execute();
		} catch (SQLException e) {
//TODO Auto-generated catch block
			e.printStackTrace();
		}

////////////////////////////////////////////////////////////////////////
//add by Majd Zbedat

	}

//add by Majd Zbedat
	/**
	 * Edit the balance returning money 
	 * @param newBalance  A double representing the new balance
	 * @param CustomerId1 A string representing the id of the customer
	 */
	public static void EditReturnMoney(double newBalance, String CustomerId1) {
		PreparedStatement ps;
		ResultSet res;
		try {
			ps = MySqlConnection.con.prepareStatement("update zerliproject.customer set balance=? where customerId =?");

			ps.setDouble(1, newBalance);
			ps.setString(2, CustomerId1);
			ps.execute();
		} catch (SQLException e) {
//TODO Auto-generated catch block
			e.printStackTrace();
		}

////////////////////////////////////////////////////////////////////////
//add by Majd Zbedat

	}

//add by Majd Zbedat
	/**
	 * Gets the total price for the customer
	 * @param IdCustomer A string representing the id of the customer
	 * @return An ArrayList<Customer> representing the customer
	 */
	public static ArrayList<Customer> getCustomeTotalPrice(String IdCustomer) {
		ArrayList<Customer> CustomeTotalPriceList = new ArrayList<>();
		PreparedStatement ps;
		ResultSet result;

		try {
			ps = MySqlConnection.con.prepareStatement("Select * From zerliproject.customer where customerId=?");
			ps.setString(1, IdCustomer);

			ps.execute();
			result = ps.getResultSet();

			while (result.next()) {
//System.out.println(result.getString(1)+ result.getString(15)+ result.getString(16)+ result.getString(14)+result.getString(7));

				CustomeTotalPriceList.add(new Customer(result.getDouble(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return CustomeTotalPriceList;
	}

//add by Majd Zbedat
	/**
	 * Sets the supply date 
	 * @param ActualSupplyDate  A string representing the supply date
	 * @param OrderId           A string representing the id of the order
	 */
	public static void setActualSupplyDate(String ActualSupplyDate, String OrderId) {
		PreparedStatement ps;
		ResultSet res;
		try {
			ps = MySqlConnection.con
					.prepareStatement("update zerliproject.orders set actualSupplyDate=? where orderId =?");

			ps.setString(1, ActualSupplyDate);
			ps.setString(2, OrderId);
			ps.execute();
		} catch (SQLException e) {
//TODO Auto-generated catch block
			e.printStackTrace();
		}

////////////////////////////////////////////////////////////////////////
//add by Majd Zbedat

	}
///
////
///////
////////
///////////////
//////////////////
////////////////////////
////////////////////////////////
//////////////////////////////////////

	// add by othman in 5/6
//////from here the department  service star//////////
	////////////////////////
	/**
	 * Register the compliant 
	 * @param complaint A Complaint representing the complaint
	 */
	public static void registerComplaint(Complaint complaint) {
		// TODO Auto-generated method stub
		int id = 50;
		PreparedStatement ps;
		try {
			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.complaints");
			ps.execute();
			ResultSet result = ps.getResultSet();

			if (!result.next())
				id = 30;
			else
				while (result.next())
					id += Integer.valueOf(result.getString(1)) * 5;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(complaint.getComplaintTime().getYear() + "");
		String currentComplaintDate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		currentComplaintDate = dateFormat.format(complaint.getComplaintTime());
		/*
		 * String year; SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy");
		 * year = dateFormat2.format(complaint.getComplaintTime());
		 * System.out.println(year); String month; SimpleDateFormat dateFormat3 = new
		 * SimpleDateFormat("MM"); month =
		 * dateFormat3.format(complaint.getComplaintTime()); System.out.println(month);
		 */
		String[] spl = currentComplaintDate.split("-");
		// System.out.println(spl[0]+"xxx"+spl[1]+"yyyyy");
		try {
			ps = MySqlConnection.con.prepareStatement("INSERT INTO zerliproject.complaints values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, String.valueOf(id));
			ps.setString(2, complaint.getIdWorker());
			ps.setString(3, complaint.getIdCustomer());

			ps.setString(4, currentComplaintDate);
			ps.setString(5, complaint.getComplaintDetail());
			ps.setString(6, complaint.getComplaintype().name());
			ps.setBoolean(7, complaint.isWarning());
			ps.setString(8, spl[0]);
			ps.setString(9, spl[1]);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
/**
 * Gets complaints from DB
 * @return An ArrayList<Complaint> representing the complaints
 */
	public static ArrayList<Complaint> getcomplaints() {
		// TODO Auto-generated method stub
		ArrayList<Complaint> list = new ArrayList<>();
		PreparedStatement ps;

		try {

			ps = MySqlConnection.con.prepareStatement("Select * From zerliproject.complaints where complaintType=?");
			ps.setString(1, "PROCESSING");
			ps.execute();
			ResultSet result = ps.getResultSet();
			while (result.next()) {
				list.add(new Complaint(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5)));// here
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
/**
 * Gets warning complaint
 * @return An ArrayList<Complaint> representing the complaints
 */
	public static ArrayList<Complaint> getwarncomplaints() {
		// TODO Auto-generated method stub
		ArrayList<Complaint> list = new ArrayList<>();
		PreparedStatement ps, ps1;

		try {

			ps = MySqlConnection.con
					.prepareStatement("Select * From zerliproject.complaints where complaintType=? and warning=?");
			ps.setString(1, "PROCESSING");
			ps.setString(2, "0");

			ps.execute();
			ResultSet result = ps.getResultSet();
			Date thisDate = new Date();

			String x1;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			x1 = dateFormat.format(thisDate);

			long minutes1 = 0;
			try {
				Date date1 = dateFormat.parse(x1);
				minutes1 = date1.getTime() / 60000;
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			while (result.next()) {

				long minutes = 0;

				try {
					Date date2 = dateFormat.parse(result.getString(4));
					minutes = date2.getTime() / 60000;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if ((minutes1 - minutes) > 1440) {// 1440=24*60
					list.add(new Complaint(result.getString(1), result.getString(2), result.getString(3),
							result.getString(4), result.getString(5)));// here
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		////
		if (list.size() > 0)
			for (int i = 0; i < list.size(); i++) {
				try {
					ps1 = MySqlConnection.con
							.prepareStatement("UPDATE zerliproject.complaints SET warning=? WHERE idComplaints=?");
					ps1.setString(1, "1");
					ps1.setString(2, list.get(i).getIdcomplaint());
					ps1.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return list;

	}
/**
 * Finish the handling complaints 
 * @param money A string reperesenting the money to handl
 */
	public static void finishhandlingcomplaints(String[] money) {
		// TODO Auto-generated method stub
		PreparedStatement ps, ps1, ps3;
		double balance = 0;
		try {
			ps3 = MySqlConnection.con.prepareStatement("Select* From zerliproject.customer WHERE customerId=?");
			ps3.setString(1, money[1]);
			ps3.execute();
			ResultSet result = ps3.getResultSet();
			if (result.next())
				balance = Double.valueOf(money[0]) + result.getDouble(3);
			System.out.println(money[0] + "");

			ps = MySqlConnection.con.prepareStatement("UPDATE zerliproject.customer SET balance=? WHERE customerId=?");
			ps.setDouble(1, balance);
			ps.setString(2, money[1]);
			ps.execute();

			ps1 = MySqlConnection.con
					.prepareStatement("UPDATE zerliproject.complaints SET complaintType=? WHERE idComplaints=?");
			ps1.setString(1, "COMPLETED");
			ps1.setString(2, money[2]);
			ps1.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
/**
 * customer table
 * @return An ArrayList<Customer> representing the customer
 */
	public static ArrayList<Customer> theCustomersis() {
		// TODO Auto-generated method stub
		ArrayList<Customer> validcustomer = new ArrayList<>();
		PreparedStatement ps3;

		try {
			ps3 = MySqlConnection.con.prepareStatement("Select* From zerliproject.customer");
			ps3.execute();
			ResultSet result = ps3.getResultSet();
			while (result.next()) {
				validcustomer.add(new Customer(result.getString(1), result.getString(2), result.getDouble(3),
						CustomerType.valueOf(result.getString(4))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return validcustomer;
	}
///////add by othman 

/////////////////////////////////////////// add by rani-hani
/////////////////////////////////////////// 5.6/////////////////////////////////////
//////////////////////////////////////////// ////////////////////////////////////
/**
 * Updatnig the answers of the survey
 * @param surveyAnswerWithPdf  A SurveyAnswer representing the answers of the survey
 * @return An ArrayList<SurveyAnswer> representing the answers of the survey
 */
	public static ArrayList<SurveyAnswer> updateSurveyAnswerWithPdf(SurveyAnswer surveyAnswerWithPdf) {

		PreparedStatement ps;
		ResultSet result;

		ArrayList<SurveyAnswer> surveysAnswersAfterUpdatePdf_list = new ArrayList<>();

		try {
			ps = MySqlConnection.con
					.prepareStatement("UPDATE zerliproject.surveys_answers SET pdfField = ? WHERE (surveyAnswerId = '"
							+ surveyAnswerWithPdf.getSurveyAnswerId() + "')");

			System.out.println(surveyAnswerWithPdf.getPdfField());
//InputStream is = new ByteArrayInputStream(surveyAnswerWithPdf.getPdfField());
//ps.setBinaryStream(1, is);
			ps.setBytes(1, surveyAnswerWithPdf.getPdfField());
			ps.execute();

			ps = MySqlConnection.con.prepareStatement("Select *From zerliproject.surveys_answers");
			ps.execute();
			result = ps.getResultSet();

			while (result.next()) {

				surveysAnswersAfterUpdatePdf_list
						.add(new SurveyAnswer(result.getString(1), result.getString(2), result.getString(3),
								result.getString(4), result.getString(5), result.getString(6), result.getString(7),
								result.getString(8), result.getString(9), result.getString(10), result.getBytes(11)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return surveysAnswersAfterUpdatePdf_list;
	}

/////////////////////////////////////////// add by rani-hani
/////////////////////////////////////////// 5.6/////////////////////////////////////
//////////////////////////////////////////// ////////////////////////////////////

}
