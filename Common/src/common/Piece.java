package common;

import java.util.ArrayList;
/**
 * Represents a piece with the fields piece's price,name and type
 * @author Othman
 *
 */
public class Piece {
	/**
	 * Gets the piece's price
	 * @return A double representing the price of the piece
	 */
public double getPrice() {
		return price;
	}
/**
 * Sets the piece's price into the field price
 * @param price  A double representing the price of the piece
 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Gets the piece's name
	 * @return A string representing the name of the piece
	 */
	public String getPieceName() {
		return pieceName;
	}
	/**
	 * Sets the piece's name into the field pieceName
	 * @param pieceName  A string representing the name of the piece
	 */
	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}
	/**
	 * Gets the piece's type
	 * @return A string representing the type of the piece
	 */
	public String getPieceType() {
		return pieceType;
	}
	/**
	 * Sets the piece's type into the field pieceTypr
	 * @param pieceType A string representing the type of the piece
	 */
	public void setPieceType(String pieceType) {
		this.pieceType = pieceType;
	}
	/**
	 * Sets the details of the item into the fields price ,pieceName and pieceType
	 * @param item An Item representing the details of the item
	 */
	public void setItem(Item item) {
		this.price=item.getPrice();
		this.pieceName=item.getItemName();
		this.pieceType=item.getItemType().toString();
	}
	/**
	 * Sets the details of the product into the fields price ,pieceName and pieceType
	 * @param product a Products representing the details of the product
	 */
	public void setProduct(Products product) {
		this.price=product.getPrice();
		this.pieceName=product.getProductName();
		this.pieceType=product.getProductType().toString();
	}
private double price ;
private String pieceName,pieceType;

	
}
