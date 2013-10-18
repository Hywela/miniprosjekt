package miniprosjekt.variables;

/**
 * Jlabel is a child class of BaseMedia
 * 
 * @author hyw
 * 
 */
public class Jlabel extends BaseMedia {
	private static final long serialVersionUID = 1L;

	/**
	 * constructor
	 * 
	 * @param media
	 */
	public Jlabel(BaseMedia media) {
		super(media);
	}

	public String getGridBagPara() {
		String temp = "";

		return String.format("%s%s%n%s(%s,gbc);", super.getGridBagPara(), temp,
				"layout.setConstraints", super.getVariabelname());

	}

	public String getAddToTable() {
		return String.format("%s (%s);", "add", super.getVariabelname());
	}

	
	public String getDec() {
		return String.format("%s %s;", super.getType(), super.getDec());
	}

	
	public String toString() {
		return String.format("%s %s %s(\"%s\");", super.getVariabelname(),
				super.toString(), super.getType(), super.getText());
	}
}
