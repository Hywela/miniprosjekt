package miniprosjekt.model;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import miniprosjekt.variables.BaseMedia;
import miniprosjekt.variables.Jbutton;
import miniprosjekt.variables.Jtextfield;
import miniprosjekt.variables.Jlabel;
import miniprosjekt.variables.Jtextarea;


@SuppressWarnings("serial")
public class MyModel extends AbstractTableModel {
	int i=0; 
	Vector<BaseMedia> data = new Vector<BaseMedia>();
	String titles[] = { "Type","VariabelNavn", "Tekst", "Rad", "Kolonne","Rader" ,
			"Kolonner","Utfylling", "Forankring"};
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
				case 7 : return media.getUtfylling();
				case 8 : return media.getForankring();
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
			 if (((String)aValue).equals("Wrap Content")) {
				media.setUtfylling("Wrap Content");
			 }
			 if (((String)aValue).equals("Fill Parrent")) {
					media.setUtfylling("Fill Parrent");
			 }
				
			 if (((String)aValue).equals("Full width")) {
					media.setUtfylling("Full width");
			 }
				
			 if (((String)aValue).equals("Full Hight")) {
					media.setUtfylling("Full Hight");
			 }
		}

			 if (columnIndex==8){
				 if (((String)aValue).equals("Wrap Content")) {
					media.setForankring("Wrap Content");
				 }
				 if (((String)aValue).equals("Fill Parrent")) {
					 media.setForankring("Fill Parrent");
				 }
					
				 if (((String)aValue).equals("Full width")) {
					 media.setForankring("Full width");
				 }
					
				 if (((String)aValue).equals("Full Hight")) {
					 media.setForankring("Full Hight");
				 }
			
		}
		
		
		if (columnIndex==0) {
			BaseMedia newMedia = null;
			 if (((String)aValue).equals("JButton")) {
				 newMedia = new Jbutton (media);
			
			 } else if (((String)aValue).equals("JTextField")) {
				newMedia = new Jtextfield (media);
				//((Jtextfield)newMedia).setBowlPlacement(JOptionPane.showInputDialog (mainFrame, "I hvilket rom står gullfiskbollen?"));
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



