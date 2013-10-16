package miniprosjekt.variables;

public class Jtextfield extends BaseMedia {
	private static final long serialVersionUID = 1L;
	String bowlPlacement;
	
	public Jtextfield (BaseMedia media) {
		super (media);
	}

	public String getBowlPlacement() {
		return bowlPlacement;
	}

	public void setBowlPlacement(String bowlPlacement) {
		this.bowlPlacement = bowlPlacement;
	}
	public String getAddToTable(){
		return String.format( "%s (%s);","add",super.getAddToTable());
	}
	
	public String getDec () {
		return String.format( "%s %s;","JTextField",super.getDec());
	}
	public String toString () {
		return String.format("%s %s %s(%s.%s);", "jtext" , super.toString(), "JTextField","JLabel","CENTER");
	}
}
