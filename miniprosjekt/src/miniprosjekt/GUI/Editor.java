package miniprosjekt.GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miniprosjekt.variables.Language;
/**
 * Editor Handles the hiddent frame for choosing values
 * @author Kevin
 * @author Kristoffer
 */
@SuppressWarnings("serial")
public class Editor extends JPanel {

	private JCheckBox  JscrollPanel = new JCheckBox("JscrollPanel", true);
	private JCheckBox  WordWrapping = new JCheckBox("WordWrapping", true);
	private JTextField column = new JTextField(4);
	private JTextField row = new JTextField(4);
	private JTextField height = new JTextField(4);
	private JTextField width = new JTextField(4);
	private JButton add = new JButton(Language.getMsg("ok"));
	private JButton cancle = new JButton(Language.getMsg("cancel"));
	/**
	 * Constructor
	 * @param type
	 */
	public Editor(String type) {

		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.anchor = GridBagConstraints.EAST;

		if (type == "JTextArea") {
			gbc.gridx = 0;
			gbc.gridy = 0;
			JLabel lcolumn = new JLabel(Language.getMsg("column")+ " : ");
			gbl.setConstraints(lcolumn, gbc);
			add(lcolumn);

		}
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel lheight = new JLabel(Language.getMsg("hight")+ " : ");
		gbl.setConstraints(lheight, gbc);
		add(lheight);

		gbc.gridy = 2;
		JLabel lwidth = new JLabel(Language.getMsg("width")+ " : ");
		gbl.setConstraints(lwidth, gbc);
		add(lwidth);

		gbc.gridy = 3;
		JLabel lrow = new JLabel(Language.getMsg("row")+ " : ");
		gbl.setConstraints(lrow, gbc);
		add(lrow);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 0;

		if (type == "JTextArea") {
			gbc.gridy = 0;
			gbl.setConstraints(column, gbc);
			add(column);
			
			gbc.gridx = 1;
			gbc.gridy = 4;
			gbl.setConstraints(JscrollPanel, gbc);
			add(JscrollPanel);
			gbc.gridx = 1;
			gbc.gridy = 5;
			gbl.setConstraints(WordWrapping, gbc);
			add(WordWrapping);
			
		}
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbl.setConstraints(height, gbc);
		add(height);

		gbc.gridy = 2;
		gbl.setConstraints(width, gbc);
		add(width);
		gbc.gridy = 3;

		gbl.setConstraints(row, gbc);
		add(row);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;

		gbl.setConstraints(add, gbc);
		add(add);

		gbc.gridwidth = 2;
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.EAST;

		gbl.setConstraints(cancle, gbc);
		add(cancle);

		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	}
	/**
	 * The Cancle button
	 * @return Jbutton cancle
	 */
	public JButton cancle() {
		return cancle;

	}
	/**
	 * 
	 * @return a Integer cast from column
	 */
	public int getColumn() {

		return Integer.parseInt(column.getText());
	}
	/**
	 * 
	 * @return a Integer cast from height
	 */
	public int getHeigt() {

		return Integer.parseInt(height.getText());
	}
	/**
	 * 
	 * @return a Integer cast from row
	 */
	public int getRow() {

		return Integer.parseInt(row.getText());
	}
	/**
	 * 
	 * @return a Integer cast from width
	 */
	public int getwidth() {

		return Integer.parseInt(width.getText());
	}
	/**
	 * The Submit Button
	 * @return Jbutton Object
	 */
	public JButton ok() {
		return add;

	}
/**
 * {@link JscrollPanel}
 * @return bool
 */
	public boolean getJscrollPanel(){
		boolean selected = JscrollPanel.isSelected();
		return selected;
	}
	/**
	 * 
	 * @return bool
	 */
	public boolean getWordWrapping(){
		boolean selected = WordWrapping.isSelected();

		return selected;
	}
	/**
	 * 
	 * @param select(bool)
	 */
	public void setJscrollPanel(Boolean select){
		 JscrollPanel.setSelected(select);
		
	}
	/**
	 * 
	 * @param select(bool)
	 */
	public void setWordWrapping(Boolean select){
		WordWrapping.setSelected(select);
	}
	/**
	 * Sets values in jtexfield/jtextarea objects;
	 * @param c = column
	 * @param r = rows
	 * @param h = height
	 * @param w = width
	 */
	public void setValues(int c, int r, int h, int w) {
		column.setText(Integer.toString(c));
		row.setText(Integer.toString(r));
		height.setText(Integer.toString(h));
		width.setText(Integer.toString(w));
	}
}