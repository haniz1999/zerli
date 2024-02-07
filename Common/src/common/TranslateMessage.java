package common;

import java.io.Serializable;
/**
 * Represents a translate message with the details tmt,ip and translate
 * @author Laith Sadik  & Othamn & Majd zbedat & Rani & Hani
 *
 */
public class TranslateMessage implements Serializable{
	
	TranslateMessageType tmt;
	String ip;
	Object translate;
	/**
	 * Gets the translate object
	 * @return An object representing the translate
	 */
	public Object getTranslate() {
		return translate;
	}
	/**
	 * Sets the translate object into the field translate
	 * @param translate An object representing the translate
	 */
	public void setTranslate(Object translate) {
		this.translate = translate;
	}
	/**
	 * Creates a translate message with the fields tmt and ip
	 * @param tmt  A TranslateMessageType representing the type of the message 
	 * @param ip   A string representing the ip of the message
	 */
	public TranslateMessage(TranslateMessageType tmt,String ip ) {
		this.tmt=tmt;
		this.ip=ip;
	}
	/**
	 * Creates a translate message with the fields translate and tmt
	 * @param tmt        A TranslateMessageType representing the type of the message 
	 * @param translate  An object representing the translate message
	 */
	public TranslateMessage(TranslateMessageType tmt,Object translate) {
		this.tmt=tmt;
		this.translate=translate;
	}
	/**
	 * Gets the message's type
	 * @return A TranslateMessageType representing the type of the message
	 */
	public TranslateMessageType getTranslateMessageTybe() {
		return tmt;
	}
	/**
	 * Sets the message's type into the field tmt
	 * @param tmt  A TranslateMessageType representing the type of the message
	 */
	public void setgetTranslateMessageTybe(TranslateMessageType tmt) {
		this.tmt = tmt;
	}
	/**
	 * Gets the ip of the message
	 * @return A string representing the ip of the message
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * Sets the ip of the message into the field ip
	 * @param ip A string representing the ip of the message
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	

}
