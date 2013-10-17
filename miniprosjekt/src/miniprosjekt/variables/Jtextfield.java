package miniprosjekt.variables;

public class Jtextfield extends BaseMedia {
	private static final long serialVersionUID = 1L;
	int rows = 0;
	int width = 0;
	int height = 0;
	
	public Jtextfield(BaseMedia media) {
		super(media);
	}


	
	public String getAddToTable() {
		return String.format( "%s (%s);","add",super.getVariabelname());
	}
	public String getGridBagPara(){
		String temp = "";
		if(width > 0 || height >0){
			temp = String.format("%n%s.setPreferredSize (new java.awt.Dimension(%d,%d));"
					, super.getVariabelname() ,width,height);
			
		}
		
		return String.format("%s%s%n%s(%s,gbc);", super.getGridBagPara(),temp ,"layout.setConstraints",
				super.getVariabelname());

	}
	
	//Declere the variable
	public String getDec() {
		return String.format("%s %s;", "JTextField", super.getDec());
	}
//Say new about the variable
	public String toString() {
		if(rows ==0){
		return String.format("%s %s %s(\"%s\");", super.getVariabelname(), super.toString(),
				"JTextField", super.getText());
		}else return String.format("%s %s %s(\"%s\",%d);", super.getVariabelname(), super.toString(),
				"JTextField", super.getText(), rows);
	}
}
