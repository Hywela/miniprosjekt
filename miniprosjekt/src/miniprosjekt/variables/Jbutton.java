package miniprosjekt.variables;

// Hunder er en type dyr
public class Jbutton extends BaseMedia {
	private static final long serialVersionUID = 1L;
	// Noen hunder liker katter, andre ikke
	boolean likesCats;
	
	// Vi kan opprette en hund på grunnlag av et hvilket som helst annet dyr
	// navn og alder blir da overført til hunden
	public Jbutton (BaseMedia animal) {
		super (animal);
	}

	public boolean getLikesCats() {
		return likesCats;
	}

	public void setLikesCats(boolean likesCats) {
		this.likesCats = likesCats;
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
