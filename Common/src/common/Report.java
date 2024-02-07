package common;

import java.io.Serializable;
/**
 * Represents a report with the fields report's id ,type,date,income,type branch's id and name
 * @author Laith Sadik 
 *
 */
public class Report implements Serializable {
	
	
	private String report_id;
	private String branch_id;
	private String report_type;
	private String report_date;
	private String BranchName;
	private String Income;
	private String type;
	/**
	 * Creates a report with the fields report's id ,type,date,income,type branch's id and name
	 * @param report_id     A string representing the id of the report
	 * @param branch_id     A string representing the id of the branch
	 * @param report_type   A string representing the type of the report
	 * @param report_date   A string representing the date of the report
	 * @param BranchName    A string representing the name of the branch
	 * @param Income        A string representing the incom of the report
	 * @param type          A string representing the type of the report
	 */
	public Report(String report_id, String branch_id, String report_type,String report_date,String BranchName,String Income,String type) {
		super();
		this.setReport_id(report_id);
		this.setBranch_id(branch_id);
		this.setReport_type(report_type);
		this.setReport_date(report_date);
		
	}
	/**
	 * gets the report's id
	 * @return A string representing the id of the report
	 */
	public String getReport_id() {
		return report_id;
	}
	/**
	 * Sets  the report's id into the field report_id
	 * @param report_id A string representing the id of the report
	 */
	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}
	/**
	 * Gets the branch's id
	 * @return A string representing the id of the branch
	 *  */
	public String getBranch_id() {
		return branch_id;
	}
	/**
	 * Sets the branch's id into the field barnch_id
	 * @param branch_id A string representing the id of the branch
	 */
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	/**
	 * Gets the report's date
	 * @return A string representing the date of the report 
	 */
	public String getReport_date() {
		return report_date;
	}
	/**
	 * Sets the report's date into the field report_date 
	 * @param report_date A string representing the date of the report 
	 */
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	/**
	 * Gets the report's type
	 * @return A string representing the type of the report
	 */
	public String getReport_type() {
		return report_type;
	}
	/**
	 * Sets the report's type into the field report_type
	 * @param report_type A string representing the type of the report
	 */
	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}
	/**
	 * Gets the branch's name
	 * @return A string representing the name of the branch
	 */
	public String getBranchName() {
		return BranchName;
	}
	/**
	 * Sets the branch's name into the field BranchNmae
	 * @param BranchName A string representing the name of the branch
	 */
	public void setBranchName(String BranchName) {
		this.BranchName = BranchName;
	}
	/**
	 * Gets the report's income
	 * @return a string representing the income of the report
	 */
	public String getIncome() {
		return Income;
	}
	/**
	 * Sets the report's income into the field Income
	 * @param Income a string representing the income of the report
	 */
	public void setIncome(String Income) {
		this.Income = Income;
	}
	
	/**
	 * Gets the report's type
	 * @return A string representing the type of the report
	 */
	public String getType() {
		return type;
	}
	/**
	 * Sets the report's type into the field type
	 * @param type A string representing the type of the report
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
}
