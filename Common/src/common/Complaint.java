package common;

import java.io.Serializable;
import java.util.Date;
/**
 * Represents an complaint with the fields idcomplaint,idWorker,idCustomer,datetotableview
 * complaintTime,complaintDetail,complaintype and warning
 * @author Laith Sadik 
 *
 */
public class Complaint implements Serializable {

	private String idcomplaint,idWorker,idCustomer,datetotableview;
	private Date complaintTime;
	private String complaintDetail;
	private ComplaintType complaintype;
	private boolean warning;
	/**
	 * Creates an compliant with the fields idWorker,idCustomer,complaintTime,complaintDetail
	 * complaintyp and warning
	 * @param idWorker         A string represents the id of the worker
	 * @param idCustomer       A string represents the id of the customer
	 * @param complaintTime    A Date represents the details of the complaint date 
	 * @param complaintDetail  A string represents the complaint details
	 * @param complaintype     A ComlaintType represents the type of the compliant
	 * @param warning          A boolean represents the warning of the complaint
	 */
	public Complaint(String idWorker, String idCustomer, Date complaintTime,
			String complaintDetail, ComplaintType complaintype, boolean warning) {
		super();
		
		this.idWorker = idWorker;
		this.idCustomer = idCustomer;
		this.complaintTime = complaintTime;
		this.complaintDetail = complaintDetail;
		this.complaintype = complaintype;
		this.warning = warning;
	}
	/**
	 * Creates an complaint with the fields idcomplaint,idWorker,idCustomer
     * complaintTime and complaintDetail
	 * @param idcomplaint      A string represents the id of the complaint 
	 * @param idWorker         A string represents the id of the worker
	 * @param idCustomer       A string represents the id of the customer
	 * @param complaintTime    A Date represents the details of the complaint date
	 * @param complaintDetail  A string represents the complaint details
	 */
	public Complaint(String idcomplaint,String idWorker, String idCustomer, Date complaintTime,String complaintDetail) {
		super();
		this.idcomplaint=idcomplaint;
		this.idWorker = idWorker;
		this.idCustomer = idCustomer;
		this.complaintTime = complaintTime;
		this.complaintDetail = complaintDetail;


	}
	/**
	 * Creates an complaint with the fields idcomplaint,idWorker,idCustomer
 * complaintTime,complaintDetail,complaintype and warning
	 * @param idcomplaint        A string represents the id of the complaint
	 * @param idWorker           A string represents the id of the worker
	 * @param idCustomer         A string represents the id of the customer
	 * @param complaintTime      A Date represents the details of the complaint date
	 * @param complaintDetail    A string represents the complaint details
	 * @param complaintype       A ComlaintType represents the type of the compliant
	 * @param warning            A boolean represents the warning of the complaint
	 */
	public Complaint(String idcomplaint,String idWorker, String idCustomer, Date complaintTime,
			String complaintDetail, ComplaintType complaintype, boolean warning) {
		super();
		this.idcomplaint=idcomplaint;
		this.idWorker = idWorker;
		this.idCustomer = idCustomer;
		this.complaintTime = complaintTime;
		this.complaintDetail = complaintDetail;
		this.complaintype = complaintype;
		this.warning = warning;
	}
	/**
	 * Creates an compliant with the fields idcomplaint,idWorker,idCustomer
     * datetotableview and complaintDetail
	 * @param idcomplaint        A string represents the id of the complaint
	 * @param idWorker           A string represents the id of the worker
	 * @param idCustomer         A string represents the id of the customer
	 * @param datetotableview    A string represents the date to table view of the complaint 
	 * @param complaintDetail    A string represents the complaint details
	 */
	public Complaint(String idcomplaint,String idWorker, String idCustomer, String datetotableview,
			String complaintDetail) {
		super();
		this.idcomplaint=idcomplaint;
		this.idWorker = idWorker;
		this.idCustomer = idCustomer;
		this.datetotableview = datetotableview;
		this.complaintDetail = complaintDetail;

	}

	
	
	/**
	 * Gets the compliant's id
	 * @return A string represents the id of the complaint 
	 */
	public String getIdcomplaint() {
		return idcomplaint;
	}
	/**
	 * Sets the compliant's id into the field idcompliant
	 * @param idcomplaint A string represents the id of the complaint
	 */
	public void setIdcomplaint(String idcomplaint) {
		this.idcomplaint = idcomplaint;
	}
	/**
	 * Gets the worker's id
	 * @return A string represents the id of the worker
	 */
	public String getIdWorker() {
		return idWorker;
	}
	/**
	 * Sets the worker's id into the field idworker
	 * @param idWorker A string represents the id of the worker
	 */
	public void setIdWorker(String idWorker) {
		this.idWorker = idWorker;
	}
	/**
	 * Gets the customer's id 
	 * @return A string represents the id of the customer
	 */
	public String getIdCustomer() {
		return idCustomer;
	}
	/**
	 * Sets the customer's id into the field idcustomer
	 * @param idCustomer A string represents the id of the customer
	 */
	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}
	/**
	 * Gets the comlpiant's time details 
	 * @return A Date represents the time details of the compliant
	 */
	public Date getComplaintTime() {
		return complaintTime;
	}
	/**
	 * Sets the comlpiant's time details into the field compliantTime
	 * @param complaintTime A Date represents the time details of the compliant
	 */
	public void setComplaintTime(Date complaintTime) {
		this.complaintTime = complaintTime;
	}
	/**
	 * Gets the compliant's details
	 * @return A string represent the details of the compliant
	 */
	public String getComplaintDetail() {
		return complaintDetail;
	}
	/**
	 * Sets the compliant's details into the field compliantDetail
	 * @param complaintDetail A string represent the details of the compliant
	 */
	public void setComplaintDetail(String complaintDetail) {
		this.complaintDetail = complaintDetail;
	}
	/**
	 * Gets the compliant's type
	 * @return A ComliantType represents the type of the compliant
	 */
	public ComplaintType getComplaintype() {
		return complaintype;
	}
	/**
	 * Sets the compliant's type into the field compliantype
	 * @param complaintype A ComliantType represents the type of the compliant
	 */
	public void setComplaintype(ComplaintType complaintype) {
		this.complaintype = complaintype;
	}
	/**
	 * Gets true if is warning else false
	 * @return A boolean represents true if it is warning else false
	 */
	public boolean isWarning() {
		return warning;
	}
	/**
	 * Sets true if it is warnings else false into the field warning
	 * @param warning A boolean represents true if it is warning else false
	 */
	public void setWarning(boolean warning) {
		this.warning = warning;
	}
	/**
	 * Gets the complint's date to table view 
	 * @return A string represents the date of the table view of the compliant
	 */
	public String getDatetotableview() {
		return datetotableview;
	}
	/**
	 * Sets the complint's date to table view into the field datetotableview
	 * @param datetotableview A string represents the date of the table view of the compliant
	 */
	public void setDatetotableview(String datetotableview) {
		this.datetotableview = datetotableview;
	}
	
	

	
	
}
