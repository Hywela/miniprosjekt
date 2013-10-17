package miniprosjekt.variables;

public class Jtextarea extends BaseMedia {
int colums = 0;
int rows = 0;
int width = 0;
int height = 0;
boolean JscrollPanel =true, WordWrapping = true;

	
	
	/**
	 * @param args
	 */
	public Jtextarea(BaseMedia media) {
		super (media);
	
//JScrollPane ny0ScrollPane = new JScrollPane (ny0);
	}
	public String scrollCheck(){
		if ( JscrollPanel==true)
		return super.getVariabelname()+"ScrollPane";
		else return super.getVariabelname();
	}
	
	public String getGridBagPara(){
		
		String temp = "";
		if(JscrollPanel == true){
		if(width > 0 || height >0){
			temp = String.format("%nJScrollPane %sScrollPane = new JScrollPane (%s,%d,%d);"
					, super.getVariabelname() ,super.getVariabelname(), width, height);
			
		}else
		{
			temp = String.format("%nJScrollPane %sScrollPane = new JScrollPane (%s);"
					, super.getVariabelname() ,super.getVariabelname());
		}}
		
		return String.format("%s%s%n%s(%s,gbc);", super.getGridBagPara(),temp ,"layout.setConstraints",
				scrollCheck());

	}
	public String getAddToTable(){
		String wrap ="";
		if(WordWrapping){
			wrap = String.format( "%s.setLineWrap (true);"+
    "%n%s.setWrapStyleWord (true);",super.getVariabelname(),super.getVariabelname());
		}
		return String.format( "%s (%s);%n%s","add",scrollCheck(), wrap);
		
	}
	
	public String getDec () {
		return String.format( "%s %s;","JTextArea",super.getDec());
	}
	public String toString () {
		if (rows >0 ){
			return String.format("%s %s %s(\"%s\",%d,%d);", super.getVariabelname(), super.toString(),
				       "JTextArea", super.getText(), rows, colums); 
		}else{
			return String.format("%s %s %s(\"%s\");", super.getVariabelname(), super.toString(),
			       "JTextArea", super.getText()); 
			}
}
}
