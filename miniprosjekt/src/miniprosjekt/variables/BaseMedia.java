package miniprosjekt.variables;

import java.io.Serializable;

// Alle dyr har det til felles at de har et navn og en alder
public class BaseMedia implements Serializable{
	/**
	 * @return the horizontal
	 */
	public String getHorizontal() {
		return Horizontal;
	}


	private static final long serialVersionUID = 1L;
	private String name;
	private String text;
	private String Horizontal;
	private String Vertical;

	private String variabelname;
	
	public BaseMedia () {
		name = "";
		
		variabelname="TODO";
	}

	// Vi kan opprette et nytt dyr og ta vare på egenskapene som alle dyr har til felles
	public BaseMedia (BaseMedia media) {
		this.name = media.name;
		variabelname=media.variabelname;
		
	}
	
	public BaseMedia (String variabelname) {
		this.variabelname = variabelname;
		 
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
	
	/**
	 * @param horizontal the horizontal to set
	 */
	public void setHorizontal(String horizontal) {
		Horizontal = horizontal;
	}

	/**
	 * @return the vertical
	 */
	public String getVertical() {
		return Vertical;
	}

	/**
	 * @param vertical the vertical to set
	 */
	public void setVertical(String vertical) {
		Vertical = vertical;
	}
	
	//111111111111111111111111111111
	public String getHPostion(){
	    StringBuilder sb = new StringBuilder ();
		
	    sb.append (getVariabelname());
		return sb.toString();
		
	}
	public String getVPostion(){
	    StringBuilder sb = new StringBuilder ();
		
	    sb.append (getVariabelname());
		return sb.toString();
		
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