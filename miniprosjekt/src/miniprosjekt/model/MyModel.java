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


@SuppressWarnings("serial")
public class MyModel extends AbstractTableModel {
	int i=0; 
	Vector<BaseMedia> data = new Vector<BaseMedia>();
	String titles[] = { Language.getMsg("type"),Language.getMsg("variable_name"), Language.getMsg("text"), Language.getMsg("row"), Language.getMsg("column"),
			Language.getMsg("rows") , Language.getMsg("columns"), Language.getMsg("fill"), Language.getMsg("alignment")};
	JFrame mainFrame;
	
	/*
	 * Sets the frame that contains the table for this table model
	 */
	public void setTableFrame (JFrame f) {
		mainFrame = f;
	}

	@Override
	public String getColumnName(int column) {
		return titles[column];
	}
	
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
			case 7 : return ("").getClass();
			case 8 : return ("").getClass();
		}
		return ("").getClass();
	}
	
	@Override
	public int getColumnCount() {
		return 9;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

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
			 if (media instanceof Jbutton)
				return "JButton";
			else if (media instanceof Jtextfield)
				return "JTextField";
			else if (media instanceof Jtextarea)
				return "JTextArea";
			else if (media instanceof Jlabel)
				return "JLabel";
			else if (media instanceof BaseMedia)
				return "Velg et type Media";
		}
		return null;
	}
	
	public void addMedia () {
		BaseMedia media = new BaseMedia ();
		data.add (media);
		fireTableRowsInserted(data.size(), data.size());
		 media.setVariabelname("ny"+i); 
		 i++;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	
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
	
	public void save (ObjectOutputStream oos) {
		try {
			for (int i=0; i<data.size(); i++)
				oos.writeObject(data.get(i));
		} catch (IOException ioe) {
			System.err.println ("Feil under skriving til fil");
		}
	}
	
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
			System.err.println ("OPPPSSSSS, dette var ingen dyrehage");
		} catch (ClassNotFoundException cnfe) {
			System.err.println ("Oi, vi har mista ur-dyret.");
		} catch (IOException ioe) {
			System.err.println ("Feil under lesing fra fil");
		} finally {
			fireTableDataChanged();
		}
	}
	
	public Vector<BaseMedia> getData () {
		return data;
	}
}



