package miniprosjekt.variables;

// Hunder er en type dyr
public class Jbutton extends BaseMedia {
	private static final long serialVersionUID = 1L;

	
	// Vi kan opprette en hund på grunnlag av et hvilket som helst annet dyr
	// navn og alder blir da overført til hunden
	public Jbutton (BaseMedia media) {
		super (media);
	}


	public String getAddToTable() {
		return String.format("%s (%s);", "add", super.getAddToTable());
	}

	//Declere the variable
	public String getDec() {
		return String.format("%s %s;", "JButton", super.getDec());
	}
//Say new about the variable
	public String toString() {
		 return String.format("%s %s %s(\"%s\");", super.getVariabelname(), super.toString(),
				  "JButton", super.getText()); 
	}

}
