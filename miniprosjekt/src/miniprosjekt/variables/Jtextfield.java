package miniprosjekt.variables;

/**
 * This class handles the JTextField
 * 
 * @author Kevin
 * @author Kristoffer
 * 
 */
public class Jtextfield extends BaseMedia {
	private static final long serialVersionUID = 1L;
	int rows = 0;
	int width = 0;
	int height = 0;

	/**
	 * Constructor
	 * 
	 * @param media
	 */
	public Jtextfield(BaseMedia media) {
		super(media);
	}

	/**
	 * getaddToTable() : returns a string In the javcode output
	 */
	public String getAddToTable() {
		return String.format("%s (%s);", "add", super.getVariabelname());
	}

	/**
	 * getGridBagPara() outputs Constrainst and Preferedsize + the mother class
	 * outputs the rest of the grid output to javacode
	 */
	public String getGridBagPara() {
		String temp = "";
		if (width > 0 || height > 0) {
			temp = String.format(
					"%n%s.setPreferredSize (new java.awt.Dimension(%d,%d));",
					super.getVariabelname(), width, height);
		}
		return String.format("%s%s%n%s(%s,gbc);", super.getGridBagPara(), temp,
				"layout.setConstraints", super.getVariabelname());
	}

	/**
	 * Returns a string with java code (spesific the declaring)
	 */
	public String getDec() {
		return String.format("%s %s;", super.getType(), super.getDec());
	}

	/**
	 * Returns a string and checks to see if the rows is above 0 IF so it
	 * returns A String with two parameteres instead of one
	 */
	public String toString() {
		if (rows == 0) {
			return String.format("%s %s %s(\"%s\");", super.getVariabelname(),
					super.toString(), super.getType(), super.getText());
		} else
			return String.format("%s %s %s(\"%s\",%d);",
					super.getVariabelname(), super.toString(), super.getType(),
					super.getText(), rows);
	}

	/**
	 * setSPValues(int h, int w, int r, int c)
	 * 
	 * @param h
	 *            sets the value of heigth
	 * @param w
	 *            sets the value of width
	 * @param r
	 *            sets the value of rows
	 * @param c
	 *            sets the value of columns (in this object is does not)
	 */
	public void setSPValues(int h, int w, int r, int c) {
		height = h;
		width = w;
		rows = r;
	}

	/**
	 * Returns the value height
	 * 
	 * @return height
	 */
	public int getSPValuesHeight() {
		return height;
	}

	/**
	 * Returns the value width
	 * 
	 * @return width
	 */
	public int getSPValuesWidth() {

		return width;
	}

	/**
	 * Returns the value rows
	 * 
	 * @return rows
	 */
	public int getSPValuesRows() {

		return rows;
	}

	/**
	 * Returns 0 since its not being used
	 * 
	 * @return 0
	 */
	public int getSPValuesColumns() {

		return 0;
	}

}
