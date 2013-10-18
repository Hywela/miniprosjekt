package miniprosjekt.variables;

import java.io.Serializable;

/**
 * Class Basemedia is a mother class for Jbutton , Jlabel, Jtextarea, Jtextfield
 * @author Kevin
 * @author Kristoffer
 * It has 9 variables
 * 
 */
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
	 * @param alignment the alignment to set
	 */
	public void setAlignment(String alignment) {
		this.alignment = alignment;
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
/**
 *  Constructor for BaseMedia 
 */
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

	/**
	 * Sets the local values from the media object;
	 * @param media
	 */
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
	 * @return the kolonner
	 */
	public int getKolonner() {
		return kolonner;
	}

	/**
	 * @param kolloner the kolonner to set
	 */
	public void setKolonner(int kolonner) {
		this.kolonner = kolonner;
	}
	/**
	 * Generates the Gridbaglayour code
	 * @return String
	 */
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
	/**
	 * Strings together javacode for the javafile
	 * @return string
	 */
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		sb.append ("= new");
		return sb.toString();
	}
	/**
	 * Strings together javacode for the javafile
	 * @return string
	 */
	public String getDec(){	
		StringBuilder sb = new StringBuilder ();		
		sb.append (getVariabelname());
		return sb.toString();
	}
	/**
	 * Used to visit the child
	 * @return a string from the child
	 */
	public String getAddToTable(){
		
		return null;
	}
	/**
	 * Sets values in the child member of this class
	 * @param h (heigth)
	 * @param w	(With)
	 * @param r	(Rows)
	 * @param c	(Colums)
	 */
	public void setSPValues(int h, int w, int r, int c){	
	
	}
	/**
	 * @return a value from the child of this object
	 */
	public int getSPValuesHeight(){
		
		return getSPValuesHeight();
	}
	/**
	 * @return a value from the child of this object
	 */
	public int getSPValuesWidth(){
		
		return getSPValuesWidth();
	}
	
	/**
	 * @return a value from the child of this object
	 */
	public int getSPValuesRows(){
		
		return getSPValuesRows();
	}
	/**
	 * @return a value from the child of this object
	 */
	public int getSPValuesColumns(){
		
		return getSPValuesColumns();
	}
	/**
	 * gets a bool from in the child of this object
	 * @return the jscrollPanel
	 */
	public boolean isJscrollPanel() {
		return isJscrollPanel();
	}
	/** 
	 * Sets a bool to true or false in the child of this object
	 * @param jscrollPanel the jscrollPanel to set
	 */
	public void setJscrollPanel(boolean jscrollPanel) {
		
	}
	/**
	 * gets a bool from in the child of this object
	 * @return the wordWrapping
	 */
	public boolean isWordWrapping() {
		return isWordWrapping();
	}
	/**
	 * Sets a bool to true or false in the child of this object
	 * @param wordWrapping the wordWrapping to set
	 */
	public void setWordWrapping(boolean wordWrapping) {
		
	}
}