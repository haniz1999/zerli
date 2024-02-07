package common;

import java.io.Serializable;
import java.util.Objects;

import javafx.scene.image.ImageView;
/**
 * Representing a products with the fields product Id,product Name,product Composition,image Path,price,
 * product type, image and discount
 * @author Othman
 *
 */
public class Products implements Serializable{
	/**
	 * Return a string representing a product with his name
	 */
	@Override
	public String toString() {
		return "Products [productName=" + productName + "]";
	}
	/**
	 * Gets the product's image path
	 * @return A string representing the image path of the product
	 */
	public String getImagePath() {
		return imagePath;
	}
	/**
	 * Sets the product's image path into the field imagPath
	 * @param imagePath A string representing the image path of the product
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	private String productId,productName,productComposition,imagePath;
	private double price,discount;
	private ProductType productType;
	private ImageView image;
	/**
	 * Gets the product's image details
	 * @return An ImageView representing the details of the product's image
	 */
	public ImageView getImage() {
		return image; 
	}
	/**
	 * Sets the product's image details into the field image
	 * @param image An ImageView representing the details of the product's image
	 */
	public void setImage(ImageView image) {
		this.image = image;
	} 
	/**
	 * Creates a product with the field product Id,product Name,product Composition,price,
     * product type
	 * @param productId           A string representing the id of the product
	 * @param productName         A string representing the name of the product
	 * @param productType         A productType representing the details of the product's t
	 * @param productComposition  A string representing the product composition 
	 * @param price               A double representing the price of the product
	 */
	public Products(String productId, String productName,ProductType productType,String productComposition
			, double price) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.productComposition = productComposition;
			this.price = price;
			this.productType = productType;
		}
	/**
	 * * Creates a product with the field product Id,product Name,product Composition,price,
     * product type,image path 
	 * @param productId           A string representing the id of the product
	 * @param productName         A string representing the name of the product
	 * @param productType         A productType representing the details of the product's type
	 * @param productComposition  A string representing the product composition 
	 * @param price               A double representing the price of the product
	 * @param imagePath           A string representing the image path of the product
	 */
	public Products(String productId, String productName,ProductType productType,String productComposition
		, double price,String imagePath) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productComposition = productComposition;
		this.price = price;
		this.productType = productType;
		this.imagePath=imagePath;
	}
	/**
	 * Creates a products with the fields product Id,product Name,product Composition,price,
     * product type, image path and discount 
     * @param productId           A string representing the id of the product
	 * @param productName         A string representing the name of the product
	 * @param productType         A productType representing the details of the product's type
	 * @param productComposition  A string representing the product composition 
	 * @param price               A double representing the price of the product
	 * @param imagePath           A string representing the image path of the product
	 * @param discount            A double representing the dicount of the product
	 */
	public Products(String productId, String productName,ProductType productType,String productComposition
			, double price,String imagePath,double discount)//add by othman 
	{
		super();
		this.productId = productId;
		this.productName = productName;
		this.productComposition = productComposition;
		this.price = price;
		this.productType = productType;
		this.imagePath=imagePath;
		this.discount=discount;
	}
	/**
	 * Gets the product's discount
	 * @return A double representing the discount of the product
	 */
	public double getDiscount() {
		return discount;
	}
	/**
	 * Sets the product's discount into the field discount 
	 * @param discount A double representing the discount of the product
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	/**
	 * Creates a products by the details of the product P1
	 * @param p1 representing the details of the product
	 */
	public Products(Products p1) {
		this.price=p1.price;
		this.productComposition=p1.productComposition;
		this.productId=p1.productId;
		this.productName=p1.productName;
		this.image=p1.image;
		this.productType=p1.productType;
	}
	/**
	 * Returns int representing  the hash code of the  product Id 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(productId);
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
		Products other = (Products) obj;
		return Objects.equals(productId, other.productId);
	}
	/**
	 * Gets the product's id
	 * @return A string representing the id of the product
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * Sets the product's id into the field productId
	 * @param productId  A string representing the id of the product
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * Gets the product's name
	 * @return A string representing the name of the product
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * Sets the product's name into the field productName
	 * @param productName A string representing the name of the product
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * Gets the product's composition 
	 * @return A string representing the composition of the product
	 */
	public String getProductComposition() {
		return productComposition;
	}
	/**
	 * Sets the  product's composition  into the field productComposition
	 * @param productComposition A string representing the composition of the product
	 */
	public void setProductComposition(String productComposition) {
		this.productComposition = productComposition;
	}
	/**
	 * Gets the product's price
	 * @return A double representing the price of the product
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Sets the product's price into the field price
	 * @param price A double representing the price of the product
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Gets the product's type details
	 * @return A ProductType representing the details of the product's type
	 */
	public ProductType getProductType() {
		return productType;
	}
	/**
	 * Sets the product's type details into the field productType
	 * @param productType  A ProductType representing the details of the product's type
	 */
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	
	
	
	
	
	
//////laith
	/**
	 * Creates a product with the field product name ,product type and price
	 * @param productName     A string representing the product's name
	 * @param productType     A string representing the product's type
	 * @param price           A double representing the price of th product
	 */
	public Products(String productName, ProductType productType, double price) {
		super();
		this.productName = productName;
		this.price = price;
		this.productType = productType;
	}

	///////////// laith
	
	
	
	
	
	
	

}
