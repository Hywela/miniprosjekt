package miniprosjekt.variables;

public class Jtextarea extends BaseMedia {

	/**
	 * @param args
	 */
	public Jtextarea(BaseMedia media) {
		super (media);
	

	}
	public String getAddToTable(){
		return String.format( "%s (%s);","add",super.getAddToTable());
	}
	
	public String getDec () {
		return String.format( "%s %s;","JTextArea",super.getDec());
	}
	public String toString() {
		return String.format("%s %s %s(\"%s\");", super.getVariabelname(), super.toString(),
				"JTextArea", super.getText());
	}
}
