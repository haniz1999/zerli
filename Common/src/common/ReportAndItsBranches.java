package common;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * represents a report and it's branch with fields branch's id,name,income and report's date and total orders
 *@author Laith Sadik  & Othamn
 *
 */
public class ReportAndItsBranches implements Serializable {
	
	private String branch_id;

	private String branch_name;
	
	private double branch_income;
	
	private String report_date;
	
    private ArrayList<String> flower = new ArrayList();
    private ArrayList<String> seeding = new ArrayList();
    private ArrayList<String> pot = new ArrayList();
    private ArrayList<String> branch = new ArrayList();
    private ArrayList<String> bouquet = new ArrayList();
    
    private ArrayList<String> product = new ArrayList();
    
	private int totalOrders = 0;

	/**
	 * Creates a report and it's branch with fields branch's id,name,income and report's date and total orders
	 * @param branch_id      A string representing the id of the branch
	 * @param branch_name    A string representing the name of the branch
	 * @param branch_income  A double representing the income of the branch
	 * @param report_date    A string representing the date of the report
	 * @param totalOrders    An int representing the total orders 
	 */
	public ReportAndItsBranches(String branch_id,String branch_name,double branch_income,String report_date,int totalOrders) {
		this.branch_id=branch_id;
		this.branch_name=branch_name;
		this.branch_income=branch_income;
		this.report_date = report_date;
		this.totalOrders = totalOrders;
		
	}
	// the constructor at line 36 will be deleted after creating branches table
	/**
	 * Creates a report and its branch with the fields branch's id and report's date
	 * @param branch_id      A string representing the of the branch
	 * @param report_date    A string representing the date of the report
	 */
	public ReportAndItsBranches(String branch_id,String report_date) {
		
		this.branch_id=branch_id;
		this.report_date = report_date;

	}
	/**
	 * Returns "true" if the object "v" equals to the current object and "false" if not 
	 * @return boolean representing if the object "v" equals to the current object or not
	 */
    @Override
    public boolean equals(Object v) {
        boolean retVal = false;

        if (v instanceof ReportAndItsBranches){
        	ReportAndItsBranches ptr = (ReportAndItsBranches) v;
        	if(ptr.branch_id.equals(this.branch_id) && ptr.report_date.equals(this.report_date)) {
        		retVal = true;
        	}
        	else retVal = false;
            System.out.println("the retval is:" + retVal);
        }

     return retVal;
  }



/**
 * Gets the branch's id
 * @return A string representing the id of the branch
 */
	public String getBranch_id() {
		return branch_id;
	}
	/**
	 * Sets the branch's id into the field branch_id
	 * @param branch_id A string representing the id of the branch
	 */
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	/**
	 * Gets the branch's name
	 * @return A string representing the name of the branch 
	 */
	public String getBranch_name() {
		return branch_name;
	}
	/**
	 * Sets the branch's name into the field branch_name
	 * @param branch_name A string representing the name of the branch
	 */
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	/**
	 * Gets the branch's income
	 * @return A double representing the income of the branch
	 */
	public double getBranch_income() {
		return branch_income;
	}
	/**
	 * Sets the branch's income into the field branch_income
	 * @param branch_income A double representing the income of the branch
	 */
	public void setBranch_income(double branch_income) {
		this.branch_income = branch_income;
	}
	/**
	 * Gets the report's date
	 * @return A string representing the date if the report
	 */
	public String getReport_date() {
		return report_date;
	}
	/**
	 * Sets the report's date into the field report_date
	 * @param report_date A string representing the date if the report
	 */
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	/**
	 * Gets the list of the flower
	 * @return An ArrayList<String> representing the list of the flower
	 */
	public ArrayList<String> getFlower() {
		return flower;
	}
	/**
	 * Sets the list of the flower into the field flower
	 * @param flower An ArrayList<String> representing the list of the flower
	 */
	public void setFlower(ArrayList<String> flower) {
		this.flower = flower;
	}
	/**
	 * Gets the list of the seeding
	 * @return An ArrayList<String> representing the list of the seeding 
	 */
	public ArrayList<String> getSeeding() {
		return seeding;
	}
	/**
	 * Sets the list of the seeding into the field seeding
	 * @param seeding An ArrayList<String> representing the list of the seeding 
	 */
	public void setSeeding(ArrayList<String> seeding) {
		this.seeding = seeding;
	}
	/**
	 * Gets the list of the pot
	 * @return An ArrayList<String> representing the list of the pot
	 */
	public ArrayList<String> getPot() {
		return pot;
	}
	/**
	 * Sets the list of the pot into the field pot
	 * @param pot An ArrayList<String> representing the list of the pot
	 */
	public void setPot(ArrayList<String> pot) {
		this.pot = pot;
	}
	/**
	 * Gets the list of the branch
	 * @return An ArrayList<String> representing the list of the branch
	 */
	public ArrayList<String> getBranch() {
		return branch;
	}
	/**
	 * Sets the list of the branch into the field branch
	 * @param branch An ArrayList<String> representing the list of the branch
	 */
	public void setBranch(ArrayList<String> branch) {
		this.branch = branch;
	}
	/**
	 * Gets the list of the bouquet 
	 * @return An ArrayList<String> representing the list of the bouquet
	 */
	public ArrayList<String> getBouquet() {
		return bouquet;
	}
	/**
	 * Sets the list of the bouquet into the field bouquet
	 * @param bouquet An ArrayList<String> representing the list of the bouquet
	 */
	public void setBouquet(ArrayList<String> bouquet) {
		this.bouquet = bouquet;
	}
	/**
	 * Gets the list of the product 
	 * @return An ArrayList<String> representing the list of the product
	 */
	public ArrayList<String> getProduct() {
		return product;
	}
	/**
	 * Sets the list of the product into the field product
	 * @param product An ArrayList<String> representing the list of the product
	 */
	public void setProduct(ArrayList<String> product) {
		this.product = product;
	}
	/**
	 * Gets the total orders 
	 * @return An int representing the total orders
	 */
	public int getTotalOrders() {
		return totalOrders;
	}
	/**
	 * Sets the total orders into the field totalOrders
	 * @param totalOrders An int representing the total orders
	 */
	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}


    


}
