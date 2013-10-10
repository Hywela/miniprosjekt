package miniprosjekt.variables;

import java.util.Date;

public class Media {
	private String type;
	private String name;
    boolean watched;
	Date date;
	
	public Media () {
		type = "";
		name = "";
		watched  = false;
		date = null;
	}
	
	public Media (String type, String name) {
		this.type = type;
		this.name = name;
		
		//this.date = date;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setDate(Date date){
		this.date=date;
	}
	public Date getDate(Date date){
		return date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		sb.append (getType());
		sb.append ("en ");
		sb.append (getName());
		sb.append (" er ");
		
		return sb.toString();
	}
}