package common;

import java.util.Objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * Represents an Item with the fields item type,color,item name,item id,image,price,picture path,and Item
 * @author Rani
 *
 */
public class ItemsWithImage{
	private ItemType itemType;
	private String color, itemName, itemId;
	private Item item;
	private ImageView image;
	private double price;
	private String picturePath;
/**
 * Creates an Item with item type,color,item name,item id,image,price,picture path,and Item
 * @param item
 */
	public ItemsWithImage(Item item) {
		super();
		this.itemType = item.getItemType();
		this.color = item.getColor();
		this.itemName = item.getItemName();
		this.itemId = item.getItemId();
		this.item = item;
		this.price = item.getPrice();
		this.picturePath = item.getPicturePath();
        this.image = new ImageView(new Image(item.getPicturePath(), 64.0, 64.0, false, true));
	}
	
	/**
	 * Returns int representing the hash code of the Item Id
	 */
	@Override
	public int hashCode() {
		return Objects.hash(itemId);
	}
	/**
	 * Returns True if the object "obj" equals to the current object or False if not
	 * @param obj object to compare with 
	 * @return boolean "true" or "false"
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemsWithImage other = (ItemsWithImage) obj;
		return Objects.equals(itemId, other.itemId);
	}
	/**
	 * Gets the item's type
	 * @return A ItemType representing the type of the itemWithImage
	 */
	public ItemType getItemType() {
		return itemType;
	}
/**
 * Sets the itemWithImage's type into the field itemType
 * @param itemType A ItemType representing the type of the itemWithImage
 */
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	/**
	 * Gets the itemsWithImage's color 
	 * @return A string representing the color of the itemWithImage
	 */
	public String getColor() {
		return color;
	}
	/**
	 * Sets the itemsWithImage's color into the field color
	 * @param color A string representing the color of the itemWithImage
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * Gets the itemsWithImage's name
	 * @return A string representing the name of the items
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * Sets the itemsWithImage's name into the field name
	 * @param itemName A string representing the name of the itemWithImage
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * Gets the itemsWithImage's id
	 * @return A string representing the id of the itemWithImage
	 */
	public String getItemId() {
		return itemId;
	}
	/**
	 * Sets the itemsWithImage's id into the field itemId
	 * @param itemId A string representing the id of the itemWithImage
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
/**
 * Gets the item of the itemWithImage
 * @return An Items representing the item of the itemWithImage
 */
	public Item getItem() {
		return item;
	}
/**
 * Sets the item of the itemWithImage into the field item
 * @param item An Items representing the item of the itemWithImage
 */
	public void setItem(Item item) {
		this.item = item;
	}
/**
 * Gets the image of the itemWithImage
 * @return An ImageView representing the image of the itemWithImage
 */
	public ImageView getImage() {
		return image;
	}
/**
 * Sets the image of the itemWithImage into the field image
 * @param image An ImageView representing the image of the itemWithImage
 */
	public void setImage(ImageView image) {
		this.image = image;
	}
	/**
	 * Gets the itemsWithImage's price
	 * @return A double representing the price of the itemWithImage
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Sets the itemsWithImage's price into the field price
	 * @param price A double representing the price of the itemWithImage
	 */
	public void setPrice(double price) {
		this.price = price;
	}
/**
 * Gets the ItemWithImage's picture path
 * @return A string representing the picture path of the itemWithImage
 */
	public String getPicturePath() {
		return picturePath;
	}
/**
 * Sets the ItemWithImage's picture path into the field piturePath
 * @param picturePath A string representing the picture path of the itemWithImage
 */
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

}
