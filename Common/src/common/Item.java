
package common;

import java.io.Serializable;
import java.util.Objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * Representing an Item with the fields item's id ,name,type,color,price and picture path
 * @author Laith Sadik
 *
 */
public class Item implements Serializable{

/**
 * return Returns A string representing the item's name "Item[item name]"
 */
	@Override
	public String toString() {
		return "Item [itemName=" + itemName + "]";
	}
/**
 * @return int representing the hash code of the item's id 
 */
	@Override
	public int hashCode() {
		return Objects.hash(itemId);
	}
/**
 * Returns "true" if the object "obj" equals to the current object and "false" if not 
 * @return boolean representing if the object "obj" equals to the current object or not
 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(itemId, other.itemId);
	}
/**
 * Creates an Item with the fields item's id ,name,type,color,price and picture path
 * @param itemId        a string representing the id of the item
 * @param itemName      a string representing the name of the item
 * @param itemType      a ItemType representing the type of the item
 * @param color         a string representing the color of the item
 * @param price         a double representing the price of the item
 * @param picturePath   a string representing the picture path of the item
 */
	public Item(String itemId, String itemName, ItemType itemType, String color, double price,String picturePath) {
		this.itemId=itemId;
		this.itemName=itemName;
		this.itemType=itemType;
		this.color=color;
		this.price=price;
		this.picturePath=picturePath;
	}
/**
 * Gets the item's picture path
 * @return A string representing the picture path of the item
 */
	public String getPicturePath() {
		return picturePath;
	}
/**
 * Sets the item's picture path into the field picturePath
 * @param picturePath  A string representing the picture path of the item
 */
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	private String itemId, itemName, color,picturePath;
	private double price,discount; 
	private ItemType itemType;

/**
 * Gets the item's id
 * @return a string representing the id of the item
 */
	public String getItemId() {
		return itemId;
	}
/**
 * Sets the item's id into th field itemId
 * @param itemId a string representing the id of the item
 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
/**
 * Gets the item's name
 * @return A string representing the name of the item
 */
	public String getItemName() {
		return itemName;
	}
/**
 * Sets the item's id into the field itemName
 * @param itemName  A string representing the name of the item
 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
/**
 * Gets the item's color
 * @return A string representing the color of the item
 */
	public String getColor() {
		return color;
	}
/**
 * Sets the item's color into the field color
 * @param color A string representing the color of the item
 */
	public void setColor(String color) {
		this.color = color;
	}
/**
 * Gets the item's price
 * @return A double representing the price of the item
 */
	public double getPrice() {
		return price;
	}
/**
 * Sets the item's price into the field price
 * @param price A double representing the price of the item
 */
	public void setPrice(double price) {
		this.price = price;
	}
/**
 * Gets the item's type
 * @return A ItemType representing the type of the item
 */
	public ItemType getItemType() {
		return itemType;
	}
/**
 * Sets the item's type into the field itemType
 * @param itemType A ItemType representing the type of the item
 */
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	/**
	 * Creates an item with the fields  itemId,  itemName, itemType, 
	 *  color,  price,g picturePath, discount
	 *   
     * @param itemId        a string representing the id of the item
     * @param itemName      a string representing the name of the item
     * @param itemType      a ItemType representing the type of the item
     * @param color         a string representing the color of the item
     * @param price         a double representing the price of the item
     * @param picturePath   a string representing the picture path of the item
	 * @param discount      a double representing the discount of the item
	 */
	/////////////////////////////////////////////// add by othman 
	public Item(String itemId, String itemName, ItemType itemType, String color, double price,String picturePath,double discount) {
		this.itemId=itemId;
		this.itemName=itemName;
		this.itemType=itemType;
		this.color=color;
		this.price=price;
		this.picturePath=picturePath;
		this.discount=discount;
	}
/**
 * Gets the item's discount
 * @return A double representing the discount of the item
 */
	public double getDiscount() {
		return discount;
	}
/**
 * Sets the item's discount into the field discount
 * @param discount A double representing the discount of the item
 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	//////////////////////////////////////////////////////////
	
	
	
	//add by laith in 5/6/2022
////laith
	/**
	 * Creates an item with the fields itemName,itemType and price
	 * @param itemName      A string representing the name of the item
	 * @param itemType      An ItemType representing the type of the item
	 * @param price         A double representing the price of the item
	 */
	public Item(String itemName, ItemType itemType,  double price) {

		this.itemName = itemName;
		this.itemType = itemType;
		this.price = price;

	}
//////laith
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}