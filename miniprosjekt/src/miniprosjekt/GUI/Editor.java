package miniprosjekt.GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miniprosjekt.variables.Media;



@SuppressWarnings("serial")
public class Editor extends JPanel {
	private static final String mediaTypes[] = {"JLabel", "JTextField", "JTextArea", "JButton"};
	private JComboBox<String> type = new JComboBox<String> (mediaTypes);
	private JTextField name = new JTextField (20);
	private JTextField age = new JTextField (4);
	private JButton add = new JButton ("Add a Show");
	
	public Editor () {
		
		GridBagLayout gbl = new GridBagLayout ();
		setLayout (gbl);
		GridBagConstraints gbc = new GridBagConstraints ();
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets (2,2,2,2);
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel ltype = new JLabel ("Type Media : ");
		gbl.setConstraints(ltype, gbc);
		add (ltype);
		gbc.gridy = 1;
		JLabel lname = new JLabel ("Title : ");
		gbl.setConstraints(lname, gbc);
		add (lname);
		gbc.gridy = 2;
		JLabel lage = new JLabel ("Raiting : ");
		gbl.setConstraints(lage, gbc);
		add (lage);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbl.setConstraints(type, gbc);
		add (type);
		gbc.gridy = 1;
		gbl.setConstraints(name, gbc);
		add (name);
		gbc.gridy = 2;
		gbl.setConstraints(age, gbc);
		add (age);
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbl.setConstraints(add, gbc);
		add (add);
		setBorder (BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}

	public Media getAnimal () {
		Media media = new Media();
		media.setType((String)type.getSelectedItem());
		media.setName(name.getText());
	//	media.setAge(Integer.parseInt(age.getText())); TODO
		return media;
	}
	
	public void setAddAction (ActionListener al) {
		add.addActionListener(al);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame ();
		Editor ae = new Editor();
		f.add (ae);
		f.pack ();
		f.setVisible(true);
	}

	public void clear() {
		type.setSelectedIndex(0);
		name.setText("");
		age.setText("");
		type.requestFocusInWindow();
	}
}