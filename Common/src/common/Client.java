package common;

import java.util.Objects;
/**
 * Represents an client with the fields client's ip,host and translate message type
 * @author Laith Sadik & Othman Habib allah
 *
 */
public class Client {
	
	private String clientIp,clientHost,clientTranslateMessageType;
	/**
	 * Returns int representing the hash code of the client by the fields 
	 * "client host,client ip,client translate message type"
	 */
	@Override
	public int hashCode() {
		return Objects.hash(clientHost, clientIp, clientTranslateMessageType);
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
		Client other = (Client) obj;
		return Objects.equals(clientHost, other.clientHost) && Objects.equals(clientIp, other.clientIp);
	}
	/**
	 * Creates an client with the fields client's ip,host and translate message type
	 * @param clientIp                     A string representing the ip of the client
	 * @param clientHost                   A string representing the host of the client
	 * @param clientTranslateMessageType   A string representing the translate message type of the client
	 */
	public Client(String clientIp, String clientHost, String clientTranslateMessageType) {
     this.clientIp=clientIp;
     this.clientHost=clientHost;
     this.clientTranslateMessageType=clientTranslateMessageType; 

	}
	/**
	 * Gets the client's Ip
	 * @return A string representing the ip of the client
	 */
	public String getClientIp() {
		return clientIp;
	}
	/**
	 * Sets the client's Ip into the field ClientIp
	 * @param clientIp A string representing the ip of the client
	 */
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	/**
	 * Gets the client's host
	 * @return A string representing the host of the client
	 */
	public String getClientHost() {
		return clientHost;
	}
	/**
	 * Sets the client's host into the field ClientHost
	 * @param clientHost A string representing the host of the client
	 */
	public void setClientHost(String clientHost) {
		this.clientHost = clientHost;
	}
	/**
	 * Gets the client's translate message type
	 * @return A string representing the translate message of the client
	 */
	public String getClientTranslateMessageType() {
		return clientTranslateMessageType;
	}
	/**
	 * Sets the client's translate message type into the field ClienTranslateMessageType
	 * @param clientTranslateMessageType A string representing the translate message of the client
	 */
	public void setClientTranslateMessageType(String clientTranslateMessageType) {
		this.clientTranslateMessageType = clientTranslateMessageType;
	}

	
	
	
	
}
