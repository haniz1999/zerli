package common;

import java.io.Serializable;
/**
 * Represents an income quarter data reports with the fields month ,totlaCostMonth and numberOrdersMonth
 * @author Laith Sadik  & Rani
 *
 */
public class IncomeQuarterDataReports implements Serializable{

/**
 * Creates an income quarter data reports with the fields month ,totlaCostMonth and numberOrdersMonth
 * @param month                 A string representing the month of the income quarter data report
 * @param totlaCostMonth        A double representing the total cost month 
 * @param numberOrdersMonth     An int representing the number on order of month
 */
	public IncomeQuarterDataReports(String month, double totlaCostMonth, int numberOrdersMonth) {
		super();
		this.month = month;
		this.totlaCostMonth = totlaCostMonth;
		this.numberOrdersMonth = numberOrdersMonth;
	}
	/**
	 * Gets the income data report's month
	 * @return A string representing the month of the income data report
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * Sets the income data report's month into the field month 
	 * @param month A string representing the month of the income data report
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * Gets the total cost of month
	 * @return A double representing the total cost
	 */
	public double getTotlaCostMonth() {
		return totlaCostMonth;
	}
	/**
	 * Sets  the total cost of month into the field totalCostMonth
	 * @param totlaCostMonth A double representing the total cost
	 */
	public void setTotlaCostMonth(double totlaCostMonth) {
		this.totlaCostMonth = totlaCostMonth;
	}
	/**
	 * Gets the number of orders of month
	 * @return An int representing the total orders of month
	 */
	public int getNumberOrdersMonth() {
		return numberOrdersMonth;
	}
	/**
	 * Sets the number of orders of month into the field numberOrdersMonth
	 * @param numberOrdersMonth  An int representing the total orders of month
	 */
	public void setNumberOrdersMonth(int numberOrdersMonth) {
		this.numberOrdersMonth = numberOrdersMonth;
	}
	private String month;
	private double totlaCostMonth;
	private int numberOrdersMonth;
	
}
