package miniprosjekt.model;


import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

import miniprosjekt.variables.BaseMedia;
import miniprosjekt.variables.Jbutton;
import miniprosjekt.variables.Jlabel;
import miniprosjekt.variables.Jtextarea;
import miniprosjekt.variables.Jtextfield;
import miniprosjekt.variables.Language;

/**
 * 
 * 	Handles the table layout seting the Column titles and takes care of displaying the base media content
 * 
 * @author Kristoffer
 * @author Kevin
 */
@SuppressWarnings("serial")
public class MyModel extends AbstractTableModel {
	// Still needs to hold the column titles
	
		// Using a vector to store the data, this can be anything really
	
	int i=0; 
	Vector<BaseMedia> data = new Vector<BaseMedia>();
	String titles[] = { Language.getMsg("type"),Language.getMsg("variable_name"), Language.getMsg("text"), Language.getMsg("row"), Language.getMsg("column"),
						Language.getMsg("rows") , Language.getMsg("columns"), Language.getMsg("fill"), Language.getMsg("alignment")};

	JFrame mainFrame;
	
	/**
	 * Sets the frame that contains the table for this table model
	 * 
	 * @param f the layout in witch to set the frame
	 */
	public void setTableFrame (JFrame f) {
		mainFrame = f;
	}


	/**
	 * 
	 * @param the column 	the index of the column
	 * @return titles 		the tile of chosen column
	 */
	@Override
	public String getColumnName(int column) {
		return titles[column];
	}
	
	/**
	 * 
	 * @param column Index 		Index for column to return
	 * @return	the column class for this object
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0 : return ("").getClass();
			case 1 : return ("").getClass();
			case 2 : return ("").getClass();
			case 3 : return (new Integer(0)).getClass();
			case 4 : return (new Integer(0)).getClass();
			case 5 : return (new Integer(0)).getClass();
			case 6 : return (new Integer(0)).getClass();
			
			case 7 :  return ("").getClass();
			case 8 : return ("").getClass();
		}
		return ("").getClass();
	}
	
	/**
	 * @return the number of columns in the model
	 */
	@Override
	public int getColumnCount() {
		return titles.length;
	}

	/**
	 * @return the number of rows in the table
	 */
	@Override
	public int getRowCount() {
		return data.size();
	}

	/**
	 * returns the data of a selected position in the table
	 * 
	 * @param row	The row number to look up
	 * @param col 	The column to look up
	 * @return the data in selected object
	 */
	@Override
	public Object getValueAt(int row, int col) {
		BaseMedia media = data.get(row);
		if (col>0) {
			switch (col) {
				case 1 : return media.getVariabelname();
				case 2 : return media.getText();
				case 3 : return media.getRad();
				case 4 : return media.getKolonne();
				case 5 : return media.getRader();
				case 6 : return media.getKolonner();
				case 7 : return media.getFill();
				case 8 : return media.getAlignment();
			}
		} else {
			 if (media instanceof Jbutton){
				 media.setType("JButton");
			 return "JButton";
			 }else if (media instanceof Jtextfield){
				 media.setType("JTextField");
				return "JTextField";
			 }else if (media instanceof Jtextarea){
				 media.setType("JTextArea");
				return "JTextArea";
			}else if (media instanceof Jlabel){
				 media.setType("JLabel");
				return "JLabel";
			}else if (media instanceof BaseMedia)
				return Language.getMsg("Choose_type");
		}
		return null;
	}
	
	/**
	 * add a new item to the table
	 */
	public void addMedia () {
		
		BaseMedia media = new BaseMedia ();
		data.add (media);
		fireTableRowsInserted(data.size(), data.size());
		 media.setVariabelname("ny"+i); 
		 i++;
	}
	/**
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 * @return true
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	
	/**
	 * sets a calue at selected position
	 * @param aValue 	and object with the new value
	 * @param rowIndex	
	 * @param columnIndex
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		BaseMedia media = data.get(rowIndex);
		if (columnIndex==1)
			media.setVariabelname((String)aValue);
		if (columnIndex==2)
			media.setText((String)aValue);
		if (columnIndex==3)
			media.setRad((int)aValue);
		if (columnIndex==4)
			media.setKolonne((int)aValue);
		if (columnIndex==5)
			media.setRader((int)aValue);
		if (columnIndex==6)
			media.setKolonner((int)aValue);
		if (columnIndex==7){
			 if (((String)aValue).equals("NONE")) {
				media.setFill("NONE");
			 }
			 if (((String)aValue).equals("BOTH")) {
					media.setFill("BOTH");
			 }
				
			 if (((String)aValue).equals("HORIZONTAL")) {
					media.setFill("HORIZONTAL");
			 }
				
			 if (((String)aValue).equals("VERTICAL")) {
					media.setFill("VERTICAL");
			 }
		}
			 if (columnIndex==8){
				 if (((String)aValue).equals("WEST")) {
					media.setAlignment("WEST");
				 }
				 if (((String)aValue).equals("NORTHWEST")) {
					 media.setAlignment("NORTHWEST");
				 }
					
				 if (((String)aValue).equals("SOUTHWEST")) {
					 media.setAlignment("SOUTHWEST");
				 }
					
				 if (((String)aValue).equals("EAST")) {
					 media.setAlignment("EAST");
				 }
				 if (((String)aValue).equals("NORTHEAST")) {
					 media.setAlignment("NORTHEAST");
				 }
				 if (((String)aValue).equals("SOUTHEAST")) {
					 media.setAlignment("SOUTHEAST");
				 }
				 if (((String)aValue).equals("NORTH")) {
					 media.setAlignment("NORTH");
				 }
				 if (((String)aValue).equals("SOUTH")) {
					 media.setAlignment("SOUTH");
				 }
				 if (((String)aValue).equals("CENTER")) {
					 media.setAlignment("CENTER");
				 }
			
		}
		
		
		if (columnIndex==0) {
			BaseMedia newMedia = null;
			 if (((String)aValue).equals("JButton")) {
				 newMedia = new Jbutton (media);
			
			 } else if (((String)aValue).equals("JTextField")) {
				newMedia = new Jtextfield (media);
				
			 } else if (((String)aValue).equals("JLabel")) {
					newMedia = new Jlabel(media);
			 } else if (((String)aValue).equals("JTextArea")) {
					newMedia = new Jtextarea (media);
			 }
				 
			data.set(rowIndex, newMedia);
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	/**
	 * 
	 * saves all objects to file
	 * 
	 * @param oos	the file in witch to save
	 */
	public void save (ObjectOutputStream oos) {
		try {
			for (int i=0; i<data.size(); i++)
				oos.writeObject(data.get(i));
		} catch (IOException ioe) {
			System.err.println ("Feil under skriving til fil");
		}
	}
	
	
	/**
	 * 
	 * Loads all objects from file
	 * 
	 * @param ois 	input file
	 */
	public void load (ObjectInputStream ois) {
		data.clear();
		try {
			while (true) {
				BaseMedia animal = (BaseMedia)ois.readObject();
				data.add(animal);
			}
		} catch (EOFException eofe) {
			// Slutt på fila
		} catch (ClassCastException cce) {
			System.err.println ("error wrong filetype");
		} catch (ClassNotFoundException cnfe) {
			System.err.println ("lost base types.");
		} catch (IOException ioe) {
			System.err.println ("error reading file");
		} finally {
			fireTableDataChanged();
		}
	}
	
	/**
	 * 
	 * Returns the vector of all table items
	 * 
	 * @return	table vector with all items
	 */
	public Vector<BaseMedia> getData () {
		return data;
	}
}



