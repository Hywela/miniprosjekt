package miniprosjekt.model;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import miniprosjekt.variables.BaseMedia;
import miniprosjekt.variables.TvSerie;
import miniprosjekt.variables.Movie;


@SuppressWarnings("serial")
public class MyModel extends AbstractTableModel {
	Vector<BaseMedia> data = new Vector<BaseMedia>();
	String titles[] = {"Media", "Tittle", "Raiting"};
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
			case 2 : return (new Integer(0)).getClass();
		}
		return ("").getClass();
	}
	
	@Override
	public int getColumnCount() {
		return 3;
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
				case 1 : return media.getName();
				case 2 : return media.getAge();
			}
		} else {
			 if (media instanceof TvSerie)
				return "TvSerie";
			else if (media instanceof Movie)
				return "Movie";
			else if (media instanceof BaseMedia)
				return "Velg et type Media";
		}
		return null;
	}
	
	public void addAnimal () {
		BaseMedia media = new BaseMedia ();
		data.add (media);
		fireTableRowsInserted(data.size(), data.size());
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		BaseMedia media = data.get(rowIndex);
		if (columnIndex==1)
			media.setName ((String)aValue);
		if (columnIndex==2)
			media.setAge ((Integer)aValue);
		if (columnIndex==0) {
			BaseMedia newMedia = null;
			 if (((String)aValue).equals("TvSerie")) {
				 newMedia = new TvSerie (media);
				String tmp = JOptionPane.showInputDialog (mainFrame, "Date?");
				/*if (tmp!=null&&tmp.equalsIgnoreCase("ja"))
					((TvSerie)newMedia).setLikesCats(true);
				else
					((TvSerie)newMedia).setLikesCats(false);
			*/
			 } else if (((String)aValue).equals("Movie")) {
				newMedia = new Movie (media);
				((Movie)newMedia).setBowlPlacement(JOptionPane.showInputDialog (mainFrame, "I hvilket rom st�r gullfiskbollen?"));
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
			// Slutt p� fila
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



