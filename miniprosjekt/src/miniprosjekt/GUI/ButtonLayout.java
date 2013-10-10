package miniprosjekt.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

import miniprosjekt.model.MyModel;
import miniprosjekt.variables.BaseMedia;


@SuppressWarnings("serial")
public class ButtonLayout extends JFrame {
	private MyModel dataModel = new MyModel ();
	private JTable table = new JTable (dataModel);
	private JToolBar toolbar = new JToolBar ();
	private String animals[] = {"TvSerie", "Movie" };
	private JComboBox<String> animalTypeEditor = new JComboBox<String> (animals);
	
	public ButtonLayout () {
		super ("Velkommen Media Planleggeren");
		dataModel.setTableFrame(this);
		add (new JScrollPane(table), BorderLayout.CENTER);
		table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(animalTypeEditor));
		
		JButton load = new JButton (new ImageIcon(getClass().getResource("/images/file.png")));
		load.setToolTipText("Last inn en dyrehage");
		load.addActionListener(new Load());
		JButton save = new JButton (new ImageIcon(getClass().getResource("/images/filesave.png")));
		save.setToolTipText("Lage en dyrehage");
		save.addActionListener(new Save());
		JButton saveReport = new JButton (new ImageIcon(getClass().getResource("/images/fileexport.png")));
		saveReport.setToolTipText("Lagre en rapport om dyrehagen");
		saveReport.addActionListener(new SaveReport());
		JButton addAnimal = new JButton (new ImageIcon(getClass().getResource("/images/insert_table_row.png")));
		addAnimal.setToolTipText("Legg til et dyr i dyrehagen");
		addAnimal.addActionListener(new ActionListener (){
			public void actionPerformed (ActionEvent ae) {
				dataModel.addAnimal();
			}
		});
		toolbar.add (load);
		toolbar.add (save);
		toolbar.addSeparator ();
		toolbar.add (saveReport);
		toolbar.addSeparator ();
		toolbar.add (addAnimal);
		add (toolbar, BorderLayout.NORTH);
		pack ();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible (true);
	}

	class Load implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser(new File("."));
			chooser.setFileSelectionMode (JFileChooser.FILES_ONLY);
			if (chooser.showOpenDialog(ButtonLayout.this)==JFileChooser.CANCEL_OPTION)
				return;
			File f = chooser.getSelectedFile();
			try {
				ObjectInputStream ois = new ObjectInputStream (new FileInputStream(f));
				dataModel.load (ois);
				ois.close ();	
			} catch (IOException ioe) {
				System.err.println ("Feil på filhåndteringen.");
			}
		}
	}
	
	class Save implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser(new File("."));
			chooser.setFileSelectionMode (JFileChooser.FILES_ONLY);
			if (chooser.showSaveDialog(ButtonLayout.this)==JFileChooser.CANCEL_OPTION)
				return;
			File f = chooser.getSelectedFile();
			if (f.exists())
				if (JOptionPane.showConfirmDialog(ButtonLayout.this, "Filen finnes, overskrive", "Bekreft", JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION)
					return;
			try {
				ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(f));
				dataModel.save (oos);
				oos.close ();	
			} catch (IOException ioe) {
				System.err.println ("Feil på filhåndteringen.");
			}
			
		}
	}

	class SaveReport implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser chooser = new JFileChooser(new File("."));
			chooser.setFileSelectionMode (JFileChooser.FILES_ONLY);
			if (chooser.showSaveDialog(ButtonLayout.this)==JFileChooser.CANCEL_OPTION)
				return;
			File f = chooser.getSelectedFile();
			if (f.exists())
				if (JOptionPane.showConfirmDialog(ButtonLayout.this, "Filen finnes, overskrive", "Bekreft", JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION)
					return;
			try {
				BufferedWriter bw = new BufferedWriter (new FileWriter (f));
				Vector<BaseMedia> animals =dataModel.getData(); 
				for (int i=0; i<animals.size(); i++) {
					bw.write(animals.get(i).toString());
					bw.newLine();
				}
				bw.close();
			} catch (IOException ioe) {
				System.err.println ("Feil under skriving av rapporten.");
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ButtonLayout();

	}
}
