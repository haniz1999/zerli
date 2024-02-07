package common;

import java.io.Serializable;
import java.util.Objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * Represnts an items with the field items's id,name,type,color,price and picture path 
 * @author Othamn
 *
 */
public class Items implements Serializable{
/**
 * Creates an items with the field items's id,name,type,color,price and picture path 
 * @param itemId     a string representing the id of the items
 * @param itemName   a string representing the name of the items
 * @param itemType   a ItemType representing the type of the items
 * @param color      a string representing the color of the items
 * @param price      a double representing the price of the items
 * @param picturePath   a string representing the picture path of the items
 */
	public Items(String itemId, String itemName, ItemType itemType, String color, double price,String picturePath) {
		this.itemId=itemId;
		this.itemName=itemName;
		this.itemType=itemType;
		this.color=color;
		this.price=price;
		this.picturePath=picturePath;
	}
/**
 * Gets the items's picture path
 * @return A string representing the picture path of the items
 */
	public String getPicturePath() {
		return picturePath;
	}
/**
 * Sets  the items's picture path into the field picturePath
 * @param picturePath A string representing the picture path of the items
 */
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	private String itemId, itemName, color,picturePath;
	private double price;
	private ItemType itemType;

/**
 * @return int representing the hash code of the items's id
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
		Items other = (Items) obj;
		return Objects.equals(itemId, other.itemId);
	}
/**
 * Gets the items's id
 * @return A string representing the id of the items
 */
	public String getItemId() {
		return itemId;
	}
/**
 * Sets the items's id into the field itemId
 * @param itemId A string representing the id of the items
 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
/**
 * Gets the items's name
 * @return A string representing the name of the items
 */
	public String getItemName() {
		return itemName;
	}
/**
 * Sets the items's name into the field itemName
 * @param itemName A string representing the name of the items
 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
/**
 * Gets the items's color
 * @return A string representing the color of the items
 */
	public String getColor() {
		return color;
	}
/**
 * Sets the items's color into the field color
 * @param color A string representing the color of the items
 */
	public void setColor(String color) {
		this.color = color;
	}
/**
 * Gets the items's price
 * @return A double representing the price of the items
 */
	public double getPrice() {
		return price;
	}
/**
 * Sets the items's price into the field price
 * @param price A double representing the price of the items
 */
	public void setPrice(double price) {
		this.price = price;
	}
/**
 * Gets the items's type
 * @return A ItemType representing the type of the items
 */
	public ItemType getItemType() {
		return itemType;
	}
/**
 * Sets the items's type into the field itemType
 * @param itemType A ItemType representing the type of the items
 */
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

}
