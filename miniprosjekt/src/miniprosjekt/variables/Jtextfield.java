package miniprosjekt.variables;

public class Jtextfield extends BaseMedia {
	private static final long serialVersionUID = 1L;


	
	public Jtextfield(BaseMedia media) {
		super(media);
	}


	
	public String getAddToTable() {
		return String.format("%s (%s);", "add", super.getAddToTable());
	}

	//Declere the variable
	public String getDec() {
		return String.format("%s %s;", "JTextField", super.getDec());
	}
//Say new about the variable
	public String toString() {
		return String.format("%s %s %s(\"%s\");", super.getVariabelname(), super.toString(),
				"JTextField", super.getText());
	}
}
