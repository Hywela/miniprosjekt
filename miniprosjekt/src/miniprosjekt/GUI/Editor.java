package miniprosjekt.GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miniprosjekt.model.MyModel;
import miniprosjekt.variables.BaseMedia;







@SuppressWarnings("serial")
public class Editor extends JPanel {
	
	
	private JTextField column = new JTextField (4);
	private JTextField row = new JTextField (4);
	private JTextField height = new JTextField (4);
	private JTextField width = new JTextField (4);
	private JButton add = new JButton ("Ok");
	private JButton cancle = new JButton ("cancle");
	
	
	public Editor (String type) {
	
		
		GridBagLayout gbl = new GridBagLayout ();
		setLayout (gbl);
		GridBagConstraints gbc = new GridBagConstraints ();
		
		gbc.anchor = GridBagConstraints.EAST;
		
		if (type =="JTextArea"){
			gbc.gridx = 0;
			gbc.gridy = 0;
			JLabel lcolumn = new JLabel ("column : ");
			gbl.setConstraints(lcolumn, gbc);
			add (lcolumn);
			
			
			}
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel lheight = new JLabel ("height : ");
		gbl.setConstraints(lheight, gbc);
		add (lheight);
		
		gbc.gridy = 2;
		JLabel lwidth = new JLabel ("Width : ");
		gbl.setConstraints(lwidth, gbc);
		add (lwidth);
		
		gbc.gridy = 3;
		JLabel lrow = new JLabel ("row : ");
		gbl.setConstraints(lrow, gbc);
		add (lrow);
			
			
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		if (type =="JTextArea"){	
			gbc.gridy = 0;
			gbl.setConstraints(column, gbc);
			add(column);
			
		}
		
		
		
			gbc.gridy = 1;
			gbl.setConstraints(height, gbc);
			add(height);
			
			gbc.gridy = 2;
			gbl.setConstraints(width, gbc);
			add(width);gbc.gridy = 3;
			
			gbl.setConstraints(row, gbc);
			add(row);
		
		
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		
		gbl.setConstraints(add, gbc);
		add (add);
		
		gbc.gridwidth = 2;
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.EAST;
	
		gbl.setConstraints(cancle, gbc);
		add (cancle);
		
		setBorder (BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
	 
		
	
	}


	public void setValues(int c, int r, int h, int w){
		column.setText( Integer.toString(c));
		row.setText( Integer.toString(r));
		height.setText( Integer.toString(h));
		width.setText( Integer.toString(w));
	}


	public JButton ok() {
		return add;
		
	}

	public JButton cancle() {
		return cancle;
		
	}
	
	public int getHeigt() {
		
		return Integer.parseInt(height.getText());
	}
public int getColumn() {
		
		return Integer.parseInt(column.getText());
	}
public int getRow() {
	
	return Integer.parseInt(row.getText());
}
public int getwidth() {
	
	return Integer.parseInt(width.getText());
}
}