package common;

import java.io.Serializable;
/**
 * Represents a survey answers with the fields surveyAnswerId, surveyQuestionId, q1answer, q2answer, q3answer
 * , q4answer, q5answer,q6answer, fillDate ,  branchWorkerId and pdfField
 * @author Rani
 *
 */
public class SurveyAnswer implements Serializable{
	
	
	private String surveyAnswerId;
	private String surveyQuestionId;
	private String q1answer;
	private String q2answer;
	private String q3answer;
	private String q4answer;
	private String q5answer;
	private String q6answer;
	private String fillDate;
	private String branchWorkerId;
	
	private byte[] pdfField;
	
	
	
	/**
	 * Creates a survey answers with the fields surveyAnswerId, surveyQuestionId, q1answer, q2answer, q3answer
     * , q4answer, q5answer,q6answer, fillDate and  branchWorkerId
	 * @param surveyAnswerId       A string representing the id of the survey answers
	 * @param surveyQuestionId     A string representing the id of the survey question
	 * @param q1answer             A string representing the answer for the q1
	 * @param q2answer             A string representing the answer for the q2
	 * @param q3answer             A string representing the answer for the q3
	 * @param q4answer             A string representing the answer for the q4
	 * @param q5answer             A string representing the answer for the q5
	 * @param q6answer             A string representing the answer for the q6
	 * @param fillDate             A string representing the fill date of the survey
	 * @param branchWorkerId       A string representing the branch worker's id
	 */
	public SurveyAnswer(String surveyAnswerId, String surveyQuestionId, String q1answer, String q2answer,
			String q3answer, String q4answer, String q5answer, String q6answer, String fillDate,
			String branchWorkerId) {
		super();
		this.surveyAnswerId = surveyAnswerId;
		this.surveyQuestionId = surveyQuestionId;
		this.q1answer = q1answer;
		this.q2answer = q2answer;
		this.q3answer = q3answer;
		this.q4answer = q4answer;
		this.q5answer = q5answer;
		this.q6answer = q6answer;
		this.fillDate = fillDate;
		this.branchWorkerId = branchWorkerId;
	}
	/**
	 * Represents a survey answers with the fields surveyAnswerId, surveyQuestionId, q1answer, q2answer, q3answer
     * , q4answer, q5answer,q6answer, fillDate ,  branchWorkerId and pdfField
     * @param surveyAnswerId       A string representing the id of the survey answers
	 * @param surveyQuestionId     A string representing the id of the survey question
	 * @param q1answer             A string representing the answer for the q1
	 * @param q2answer             A string representing the answer for the q2
	 * @param q3answer             A string representing the answer for the q3
	 * @param q4answer             A string representing the answer for the q4
	 * @param q5answer             A string representing the answer for the q5
	 * @param q6answer             A string representing the answer for the q6
	 * @param fillDate             A string representing the fill date of the survey
	 * @param branchWorkerId       A string representing the branch worker's id
	 * @param pdfField             A byte representing the pdf filed
	 */
	public SurveyAnswer(String surveyAnswerId, String surveyQuestionId, String q1answer, String q2answer,
			String q3answer, String q4answer, String q5answer, String q6answer, String fillDate,
			String branchWorkerId,byte[] pdfField) {
		super();
		this.surveyAnswerId = surveyAnswerId;
		this.surveyQuestionId = surveyQuestionId;
		this.q1answer = q1answer;
		this.q2answer = q2answer;
		this.q3answer = q3answer;
		this.q4answer = q4answer;
		this.q5answer = q5answer;
		this.q6answer = q6answer;
		this.fillDate = fillDate;
		this.branchWorkerId = branchWorkerId;
		this.pdfField = pdfField;
	}
	
	
	/**
	 * Gets the pdf filed for the survey answers 
	 * @return A byte[] representing the pdf filed of the answers
	 */
	public byte[] getPdfField() {
		return pdfField;
	}

/**
 * Sets the pdf filed for the survey answers  into the field pdfFiled 
 * @param pdfField A byte[] representing the pdf filed of the answers
 */
	public void setPdfField(byte[] pdfField) {
		this.pdfField = pdfField;
	}

	/**
	 * Gets the survey answer's id 
	 * @return A string representing the id of the survey answers
	 */
	public String getSurveyAnswerId() {
		return surveyAnswerId;
	}
	/**
	 * Sets the survey answer's id  into the field surveyAnswerId
	 * @param surveyAnswerId A string representing the id of the survey answers
	 */
	public void setSurveyAnswerId(String surveyAnswerId) {
		this.surveyAnswerId = surveyAnswerId;
	}
	/**
	 * Gets the survey question's id 
	 * @return A string representing the id of the survey question
	 */
	public String getSurveyQuestionId() {
		return surveyQuestionId;
	}
	/**
	 * Sets the survey question's id into the field surveyQuestionId
	 * @param surveyQuestionId A string representing the id of the survey question
	 */
	public void setSurveyQuestionId(String surveyQuestionId) {
		this.surveyQuestionId = surveyQuestionId;
	}
	/**
	 * Gets the survey's q1 answer
	 * @return A string representing the answer for the question 1 of the survey
	 */
	public String getQ1answer() {
		return q1answer;
	}
	/**
	 * Sets the survey's q1 answer into the field  q1answer
	 * @param q1answer A string representing the answer for the question 1 of the survey
	 */
	public void setQ1answer(String q1answer) {
		this.q1answer = q1answer;
	}
	/**
	 * Gets the survey's q2 answer
	 * @return A string representing the answer for the question 2 of the survey
	 */
	public String getQ2answer() {
		return q2answer;
	}
	/**
	 * Sets the survey's q2 answer into the field  q2answer
	 * @param q2answer A string representing the answer for the question 2 of the survey
	 */
	public void setQ2answer(String q2answer) {
		this.q2answer = q2answer;
	}
	/**
	 * Gets the survey's q3 answer
	 * @return A string representing the answer for the question 3 of the survey
	 */
	public String getQ3answer() {
		return q3answer;
	}
	/**
	 * Sets the survey's q3 answer into the field  q3answer
	 * @param q3answer A string representing the answer for the question 3 of the survey
	 */
	public void setQ3answer(String q3answer) {
		this.q3answer = q3answer;
	}
	/**
	 * Gets the survey's q4 answer
	 * @return A string representing the answer for the question 4 of the survey
	 */
	public String getQ4answer() {
		return q4answer;
	}
	/**
	 * Sets the survey's q4 answer into the field  q4answer
	 * @param q4answer A string representing the answer for the question 4 of the survey
	 */
	public void setQ4answer(String q4answer) {
		this.q4answer = q4answer;
	}
	/**
	 * Gets the survey's q5 answer
	 * @return A string representing the answer for the question 5 of the survey
	 */
	public String getQ5answer() {
		return q5answer;
	}
	/**
	 * Sets the survey's q5 answer into the field  q5answer
	 * @param q5answer A string representing the answer for the question 5 of the survey
	 */
	public void setQ5answer(String q5answer) {
		this.q5answer = q5answer;
	}
	/**
	 * Gets the survey's q6 answer
	 * @return A string representing the answer for the question 6 of the survey
	 */
	public String getQ6answer() {
		return q6answer;
	}
	/**
	 * Sets the survey's q6 answer into the field  q6answer
	 * @param q6answer A string representing the answer for the question 6 of the survey
	 */
	public void setQ6answer(String q6answer) {
		this.q6answer = q6answer;
	}
	/**
	 * Gets the survey's fill date 
	 * @return A string representing the fill date of the survey
	 */
	public String getFillDate() {
		return fillDate;
	}
	/**
	 * Sets the survey's fill date into the field fillDate
	 * @param fillDate A string representing the fill date of the survey
	 */
	public void setFillDate(String fillDate) {
		this.fillDate = fillDate;
	}
	/**
	 * Gets the branch worker's id
	 * @return A string representing the id of the branch worker
	 */
	public String getBranchWorkerId() {
		return branchWorkerId;
	}
	/**
	 * Sets the branch worker's id into the field branchWorkerId
	 * @param branchWorkerId A string representing the id of the branch worker
	 */
	public void setBranchWorkerId(String branchWorkerId) {
		this.branchWorkerId = branchWorkerId;
	}

	/**
	 * Returns "true" if the object "obj" equals to the current object and "false" if not 
	 * @return boolean representing if the object "obj" equals to the current object or not
	 */
	@Override
	public boolean equals(Object obj) {
		
		if(obj == this)return true;
		if(!(obj instanceof SurveyAnswer))return false;
		
		SurveyAnswer s = (SurveyAnswer) obj;
		
		if(s.fillDate.equals(this.fillDate) && s.branchWorkerId.equals(this.branchWorkerId) &&
				s.q1answer.equals(this.q1answer) && s.q2answer.equals(this.q2answer) && 
				s.q3answer.equals(this.q3answer) && s.q4answer.equals(this.q4answer) && 
				s.q5answer.equals(this.q5answer) && s.q6answer.equals(this.q6answer) &&
				s.surveyQuestionId.equals(this.surveyQuestionId))
			return true;
		
		else return false;
		
	}


}
