package miniprosjekt.variables;

public class Movie extends BaseMedia {
	private static final long serialVersionUID = 1L;
	String bowlPlacement;
	
	public Movie (BaseMedia animal) {
		super (animal);
	}

	public String getBowlPlacement() {
		return bowlPlacement;
	}

	public void setBowlPlacement(String bowlPlacement) {
		this.bowlPlacement = bowlPlacement;
	}

	public String toString () {
		return String.format("%s%s %s%s.", "Gullfisken heter ", super.toString(), "Gullfiskbollen står i ", getBowlPlacement());
	}
}
