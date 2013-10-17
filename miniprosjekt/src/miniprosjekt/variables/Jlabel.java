package miniprosjekt.variables;

public class Jlabel extends BaseMedia{
	private static final long serialVersionUID = 1L;


	
	public Jlabel(BaseMedia media) {
		super(media);
	}
	public String getGridBagPara(){
		String temp = "";
		
		
		return String.format("%s%s%n%s(%s,gbc);", super.getGridBagPara(),temp ,"layout.setConstraints",
				super.getVariabelname());

	}
	public String getAddToTable() {
		return String.format( "%s (%s);","add",super.getVariabelname());
	}

	//Declere the variable
	public String getDec() {
		return String.format("%s %s;", super.getType(), super.getDec());
	}
//Say new about the variable
	public String toString() {
		 return String.format("%s %s %s(\"%s\");", super.getVariabelname(), super.toString(),
				 super.getType(), super.getText());
	}
}
