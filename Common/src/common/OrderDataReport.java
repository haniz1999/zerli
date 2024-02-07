package common;

import java.io.Serializable;
/**
 * Represents a order data report with the fields pieceName, total cost and number of piece
 * @author Rani
 *
 */
public class OrderDataReport implements Serializable{
/**
 * Creates a order data report with the fields pieceName, total cost and number of piece
 * @param pieceName      A string representing the piece name of the order report
 * @param totlaCost      A double representing the total cost
 * @param numberOfPiece  An int representing the number of piece
 */
	public OrderDataReport(String pieceName, double totlaCost, int numberOfPiece) {
		super();
		this.pieceName = pieceName;
		this.totlaCost = totlaCost;
		this.numberOfPiece = numberOfPiece; 
	}
	/**
	 * Gets the piece's name of the order report
	 * @return A string representing the name of the piece of the order report
	 */
	public String getPieceName() {
		return pieceName;
	}
	/**
	 * Sets the piece's name of the order report into the field pieceName
	 * @param pieceName A string representing the name of the piece of the order report
	 */
	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}
	/**
	 * Gets the total cost of the order in the report
	 * @return A double representing the total cost in the order's report
	 */
	public double getTotlaCost() {
		return totlaCost;
	}
	/**
	 * Sets the total cost of the order in the report into the field totalCost
	 * @param totlaCost A double representing the total cost in the order's report
	 */
	public void setTotlaCost(double totlaCost) {
		this.totlaCost = totlaCost;
	}
	/**
	 * Gets the number of piece in the order's report
	 * @return An int representing the number of piece
	 */
	public int getNumberOfPiece() {
		return numberOfPiece;
	}
	/**
	 * Sets the number of piece in the order's report into the field numberOfPiece
	 * @param numberOfPiece An int representing the number of piece
	 */
	public void setNumberOfPiece(int numberOfPiece) {
		this.numberOfPiece = numberOfPiece;
	}
	private String pieceName;
	private double totlaCost;
	private int numberOfPiece;
	
}
