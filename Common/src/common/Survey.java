package common;

import java.io.Serializable;
import java.util.Date;
/**
 * Represents a survey with the fields survey's id ,start date, end date branch name, q1,q2,q3,q4,q5,q6(questions)
 * surveyType, promotion and period
 * @author Rani
 *
 */
public class Survey implements Serializable{
	
	private String idsurvey;
	private String q1question;
	private String q2question;
	private String q3question;
	private String q4question;
	private String q5question;
	private String q6question;
	private String startDate;
	private String endDate;
	private String surveyType;

	private String branchName;
	private String promotion;
	private String period;
	
	/**
	 * Creates an survey with the fields survey's id ,start date, end date branch name, q1,q2,q3,q4,q5,q6(questions)
 * surveyType, promotion and period
	 * @param idsurvey        A string representing the id of the survey
	 * @param q1question      A string representing the question 1 of the survey
	 * @param q2question      A string representing the question 2 of the survey
	 * @param q3question      A string representing the question 3 of the survey
	 * @param q4question      A string representing the question 4 of the survey
	 * @param q5question      A string representing the question 5 of the survey
	 * @param q6question      A string representing the question 6 of the survey
	 * @param startDate       A string representing the start date of the survey
	 * @param endDate         A string representing the end date of the survey
	 * @param surveyType      A string representing the type of the survey
	 * @param branchName      A string representing the branch name of the survey
	 * @param promotion       A string representing the promotion of the survey
	 * @param period          A string representing the period of the seurvey
	 */
	public Survey(String idsurvey, String q1question, String q2question, String q3question, String q4question,
			String q5question, String q6question, String startDate, String endDate, String surveyType,
			String branchName, String promotion, String period) {
		super();
		this.idsurvey = idsurvey;
		this.q1question = q1question;
		this.q2question = q2question;
		this.q3question = q3question;
		this.q4question = q4question;
		this.q5question = q5question;
		this.q6question = q6question;
		this.startDate = startDate;
		this.endDate = endDate;
		this.surveyType = surveyType;
		this.branchName = branchName;
		this.promotion = promotion;
		this.period = period;
	}
	
	/**
	 * Get the survey's id
	 * @return A string representing the id of the survey
	 */
	public String getIdsurvey() {
		return idsurvey;
	}
	/**
	 * Sets the survey's id into the field idsurvey
	 * @param idsurvey A string representing the id of the survey
	 */
	public void setIdsurvey(String idsurvey) {
		this.idsurvey = idsurvey;
	}
	/**
	 * Gets the survey 's question number 1
	 * @return A string representing the question number 1 of the survey
	 */
	public String getQ1question() {
		return q1question;
	}
	/**
	 * Sets the survey 's question number 1 into the filed q1question
	 * @param q1question A string representing the question number 1 of the survey
	 */
	public void setQ1question(String q1question) {
		this.q1question = q1question;
	}
	/**
	 * Gets the survey 's question number 2
	 * @return A string representing the question number 2 of the survey
	 */
	public String getQ2question() {
		return q2question;
	}
	/**
	 * Sets the survey 's question number 2 into the filed q2question
	 * @param q2question A string representing the question number 2 of the survey
	 */
	public void setQ2question(String q2question) {
		this.q2question = q2question;
	}
	/**
	 * Gets the survey 's question number 3
	 * @return A string representing the question number 3 of the survey
	 */
	public String getQ3question() {
		return q3question;
	}
	/**
	 * Sets the survey 's question number 3 into the filed q3question
	 * @param q3question A string representing the question number 3 of the survey
	 */
	public void setQ3question(String q3question) {
		this.q3question = q3question;
	}
	/**
	 * Gets the survey 's question number 4
	 * @return A string representing the question number 4 of the survey
	 */
	public String getQ4question() {
		return q4question;
	}
	/**
	 * Sets the survey 's question number 4 into the filed q4question
	 * @param q4question A string representing the question number 4 of the survey
	 */
	public void setQ4question(String q4question) {
		this.q4question = q4question;
	}
	/**
	 * Gets the survey 's question number 5
	 * @return A string representing the question number 5 of the survey
	 */
	public String getQ5question() {
		return q5question;
	}
	/**
	 * Sets the survey 's question number 5 into the filed q5question
	 * @param q5question A string representing the question number 5 of the survey
	 */
	public void setQ5question(String q5question) {
		this.q5question = q5question;
	}
	/**
	 * Gets the survey 's question number 6
	 * @return A string representing the question number 6 of the survey
	 */
	public String getQ6question() {
		return q6question;
	}
	/**
	 * Sets the survey 's question number 6 into the filed q6question
	 * @param q6question A string representing the question number 6 of the survey
	 */
	public void setQ6question(String q6question) {
		this.q6question = q6question;
	}
	/**
	 * Gets the survey's start date
	 * @return A string representing the start date of the survey
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * Sets the survey's start date into the field startDate
	 * @param startDate A string representing the start date of the survey
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * Gets the survey's end date 
	 * @return A string representing the end date of the survey
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * Sets the survey's end date into the field endDate
	 * @param endDate A string representing the end date of the survey
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * Gets the syrvey's type
	 * @return A string representing the type of the survey
	 */
	public String getSurveyType() {
		return surveyType;
	}
	/**
	 * Sets the syrvey's type into the field surveyType
	 * @param surveyType A string representing the type of the survey
	 */
	public void setSurveyType(String surveyType) {
		this.surveyType = surveyType;
	}
	/**
	 * Gets the survey's branch name
	 * @return A string representing the name of the survey's branch
	 */
	public String getBranchName() {
		return branchName;
	}
	/**
	 * Sets the survey's branch name into the field branchName
	 * @param branchName A string representing the name of the survey's branch
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	/**
	 * Gets the survey's promotion 
	 * @return A string representing the promotion of the survey
	 */
	public String getPromotion() {
		return promotion;
	}
	/**
	 * Sets the survey's promotion  into the field promotion
	 * @param promotion A string representing the promotion of the survey
	 */
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	/**
	 * Gets the survey's period
	 * @return A string representing the period of the survey
	 */
	public String getPeriod() {
		return period;
	}
	/**
	 * Sets the survey's period into the field period 
	 * @param period A string representing the period of the survey
	 */
	public void setPeriod(String period) {
		this.period = period;
	}



	

	


}
