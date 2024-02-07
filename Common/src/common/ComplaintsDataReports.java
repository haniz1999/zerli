package common;

import java.io.Serializable;
/**
 * Represents an ComplaintsDataReports with the fields month,numberOfComplaint, numberCompleted and numberProcessing
 * @author Laith Sadik 
 *
 */
public class ComplaintsDataReports implements Serializable{
/**
 * Creates an ComplaintsDataReports with the fields month,numberOfComplaint, numberCompleted and numberProcessing
 * @param month               A string representing the month of the compliant reports
 * @param numberOfComplaint   An int representing the number of compliant
 * @param numberCompleted     An int representing the number completed of the compliant
 * @param numberProcessing    An int representing the number of the compliant proccessing
 */
	public ComplaintsDataReports(String month, int numberOfComplaint, int numberCompleted, int numberProcessing) {
		super();
		this.month = month;
		this.numberOfComplaint = numberOfComplaint;
		this.numberCompleted = numberCompleted;
		this.numberProcessing = numberProcessing;
	}
	/**
	 * Gets the compliant reports's month
	 * @return A string representing the month of the compliant reports
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * Sets the compliantReports's month into the field month
	 * @param month A string representing the month of the compliant reports
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * Gets the compliant's number
	 * @return An int representing the number of the compliant reports
	 */
	public int getNumberOfComplaint() {
		return numberOfComplaint;
	}
	/**
	 * Sets the compliant reports's number into the field numberOfCompliant
	 * @param numberOfComplaint
	 */
	public void setNumberOfComplaint(int numberOfComplaint) {
		this.numberOfComplaint = numberOfComplaint;
	}
	/**
	 * Gets the compliant reports's is completed 
	 * @return An int representing the number completed compliant reports
	 */
	public int getNumberCompleted() {
		return numberCompleted;
	}
	/**
	 * Sets the compliant reports's is completed  into the field numberCompleted
	 * @param numberCompleted An int representing the number completed compliant reports
	 */
	public void setNumberCompleted(int numberCompleted) {
		this.numberCompleted = numberCompleted;
	}
	/**
	 * Gets the compliant reports's is processing
	 * @return An int representing the number is processing of the compliant reports
	 */
	public int getNumberProcessing() {
		return numberProcessing;
	}
	/**
	 * Sets the compliant reports's is processing into the field numberProcessing
	 * @param numberProcessing An int representing the number is processing of the compliant reports
	 */
	public void setNumberProcessing(int numberProcessing) {
		this.numberProcessing = numberProcessing;
	}
	private String month;
	private int numberOfComplaint;
	private int numberCompleted,numberProcessing;
	
	
}
