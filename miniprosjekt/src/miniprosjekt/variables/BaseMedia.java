package miniprosjekt.variables;

import java.io.Serializable;

// Alle dyr har det til felles at de har et navn og en alder
public class BaseMedia implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String data;
	private String variabelname;
	
	public BaseMedia () {
		name = "";
		age = 0;
		data = "";
		variabelname="TODO";
	}

	// Vi kan opprette et nytt dyr og ta vare på egenskapene som alle dyr har til felles
	public BaseMedia (BaseMedia media) {
		this.name = media.name;
		variabelname="TODO";
		this.data = media.data;
	}
	
	public BaseMedia (String name ,int age) {
		this.name = name;
		
		this.data = data; 
	}
	

	/**
	 * @return the variabelname
	 */
	public String getVariabelname() {
		return variabelname;
	}

	/**
	 * @param variabelname the variabelname to set
	 */
	public void setVariabelname(String variabelname) {
		this.variabelname = variabelname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		
		sb.append ("= new");
	
		return sb.toString();
	}
	public String getDec(){
		
		StringBuilder sb = new StringBuilder ();
		
		sb.append (getVariabelname());
		
		return sb.toString();
	}
	public String getAddToTable(){
		
		StringBuilder sb = new StringBuilder ();
		
		sb.append (getVariabelname());
		
		
		return sb.toString();
	}
	
}