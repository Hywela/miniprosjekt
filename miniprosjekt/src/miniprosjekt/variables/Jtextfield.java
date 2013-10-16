package miniprosjekt.variables;

public class Jtextfield extends BaseMedia {
	private static final long serialVersionUID = 1L;
	String placement;
	int colums=20;
	
	public Jtextfield(BaseMedia media) {
		super(media);
	}

	public String getPlacement() {
		return placement;
	}

	public void setPlacement(String placement) {
		this.placement = placement;
	}

	public String getHPostion(){
		return String.format( "%s.%s(%S.%S);",super.getVPostion(),"setHorizontalTextPosition","JLabel"
				,"CENTER");	
	}
	public String getVPostion(){
		return String.format( "%s.%s(%S.%S);",super.getVPostion(),"setVerticalTextPosition","JLabel"
				,"CENTER");
		
	}
	public String getAddToTable() {
		return String.format("%s (%s);", "add", super.getAddToTable());
	}

	public String getDec() {
		return String.format("%s %s;", "JTextField", super.getDec());
	}

	public String toString() {
		return String.format("%s %s %s(\"%s\",%d);", "jtext", super.toString(),
				"JTextField", super.getVariabelname(), colums);
	}
}
