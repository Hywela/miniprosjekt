package miniprosjekt.variables;

import java.io.Serializable;


public class BaseMedia implements Serializable{
	


	private static final long serialVersionUID = 1L;
	private String type ="";
	private String text="";
	private String fill;
	private String alignment;
	int rad, kolonne,kolonner, rader;

	private String variabelname;
	
	
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the forankring
	 */
	public String getAlignment() {
		return alignment;
	}

	/**
	 * @param forankring the forankring to set
	 */
	public void setAlignment(String forankring) {
		this.alignment = forankring;
	}

	/**
	 * @return the utfylling
	 */
	public String getFill() {
		return fill;
	}

	/**
	 * @param utfylling the utfylling to set
	 */
	public void setFill(String utfylling) {
		this.fill = utfylling;
	}

	public BaseMedia () {
	rad = 1;
	kolonne = 1;
	rader= 1;
	variabelname="";
	fill = "NONE";
	alignment = "CENTER";
	text="Insert texst";
	type="JLabel";
	}

	// Vi kan opprette et nytt dyr og ta vare på egenskapene som alle dyr har til felles
	public BaseMedia (BaseMedia media) {
		fill = media.fill;
		alignment = media.alignment;
		text = media.text;
		rad = media.rad;
		rader = media.rader;
		kolonne = media.kolonne;
		kolonner = media.kolonner;
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
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the rad
	 */
	public int getRad() {
		return rad;
	}

	/**
	 * @param rad the rad to set
	 */
	public void setRad(int rad) {
		this.rad = rad;
	}

	/**
	 * @return the kolonne
	 */
	public int getKolonne() {
		return kolonne;
	}

	/**
	 * @param kolonne the kolonne to set
	 */
	public void setKolonne(int kolonne) {
		this.kolonne = kolonne;
	}

	/**
	 * @return the rader
	 */
	public int getRader() {
		return rader;
	}

	/**
	 * @param rader the rader to set
	 */
	public void setRader(int rader) {
		this.rader = rader;
	}

	/**
	 * @return the Kolonner
	 */
	public int getKolonner() {
		return kolonner;
	}

	/**
	 * @param kolloner the Kolonner to set
	 */
	public void setKolonner(int kolonner) {
		this.kolonner = kolonner;
	}
	
	//111111111111111111111111111111
	
	public String getGridBagPara(){
		return String.format( "%ngbc.gridx = %d;" +
				"%ngbc.gridy = %d;" +
				"%ngbc.gridwidth= %d;" +
				"%ngbc.gridheight = %d;" +
				"%ngbc.anchor = java.awt.GridBagConstraints.%s;"+
				"%ngbc.fill = java.awt.GridBagConstraints.%s;"
				,getKolonne(),getRad(),getKolonner(),getKolonne(),getAlignment(),
				getFill());
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
		
		
		
		
		return sb.toString();
	}
	
	public void setSPValues(int h, int w, int r, int c){
		
	
	}
	public int getSPValuesHeight(){
		
		return getSPValuesHeight();
	}
	public int getSPValuesWidth(){
		
		return getSPValuesWidth();
	}
	public int getSPValuesRows(){
		
		return getSPValuesRows();
	}
	public int getSPValuesColumns(){
		
		return getSPValuesColumns();
	}
}