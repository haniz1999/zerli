package common;

import java.io.Serializable;
/**
 * Represnts an income data report with the fields week,number of orders and total income
 * @author Laith Sadik 
 *
 */
public class IncomeDataReport implements Serializable{

/**
 * Creates an income data report with the fields week,number of orders and total income
 * @param week            A string representing the week of the income date reports 
 * @param numberOfOrders  An int representing the number of orders 
 * @param totalIncome     A double representing the total income 
 */
	public IncomeDataReport(String week, int numberOfOrders,double totalIncome) {
		super();
		this.week = week;
		this.numberOfOrders = numberOfOrders;  
		this.totalIncome = totalIncome;
	}
	/**
	 * Gets the incom's week
	 * @return A string representing the week of the income date report
	 */
	public String getWeek() {
		return week;
	}
	/**
	 * Sets the incom's week into the field week 
	 * @param week A string representing the week of the income date report
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	/**
	 * Gets the number of orders 
	 * @return An int representing the number of orders in the income date report
	 */
	public int getNumberOfOrders() {
		return numberOfOrders;
	}
	/**
	 * Sets the number of orders into the field numberOfOrders
	 * @param numberOfOrders An int representing the number of orders in the income date report
	 */
	public void setNumberOfOrders(int numberOfOrders) {
		this.numberOfOrders = numberOfOrders;
	}
	/**
	 * Gets the total income
	 * @return A double representing the total income
	 */
	public double getTotalIncome() {
		return totalIncome;
	}
	/**
	 * Sets the total income into the field totalIncome
	 * @param totalIncome  A double representing the total income
	 */
	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}
	private String week;
	private int numberOfOrders;
	private double totalIncome;
	
}
