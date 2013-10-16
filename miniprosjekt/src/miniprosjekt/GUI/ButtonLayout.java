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

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import miniprosjekt.model.MyModel;
import miniprosjekt.variables.BaseMedia;

@SuppressWarnings("serial")
public class ButtonLayout extends JFrame {
	private MyModel dataModel = new MyModel ();
	private JTable table = new JTable (dataModel);
	private JToolBar toolbar = new JToolBar ();
	private String layoutType[] = {"JLabel", "JTextField", "JTextArea", "JButton" };
	private JComboBox<String> animalTypeEditor = new JComboBox<String> (layoutType);
	
		
    
	public ButtonLayout () {
		super ("Velkommen Media Planleggeren");
		dataModel.setTableFrame(this);
		
		JTextField mm = new JTextField();
		
		fileMenu();
		
		add (new JScrollPane(table), BorderLayout.CENTER);
		table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(animalTypeEditor));
		
		JButton load = new JButton (new ImageIcon(getClass().getResource("/images/file.png")));
		load.setToolTipText("Last inn en dyrehage");
		load.addActionListener(new Load());
		JButton save = new JButton (new ImageIcon(getClass().getResource("/images/filesave.png")));
		save.setToolTipText("Lage en dyrehage");
		save.addActionListener(new Save());
		JButton saveReport = new JButton (new ImageIcon(getClass().getResource("/images/fileexport.png")));
		saveReport.setToolTipText("Skriv ut en Show liste");
		saveReport.addActionListener(new SaveReport());
		JButton addAnimal = new JButton (new ImageIcon(getClass().getResource("/images/insert_table_row.png")));
		addAnimal.setToolTipText("Legg til en Serie/Film");
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
				Vector<BaseMedia> layoutType =dataModel.getData(); 
				bw.write("package miniprosjekt.variables;"
								+"import java.awt.GridLayout;"
								+"import java.awt.event.WindowAdapter;"
								+"import java.awt.event.WindowEvent;");
				bw.newLine();
				bw.write("import javax.swing.JLabel;");
				bw.newLine();
				bw.write("import javax.swing.JPanel;");
				bw.newLine();
				bw.write("public class example extends JPanel {");
				bw.newLine();
				for (int i=0; i<layoutType.size(); i++) {
					bw.write(layoutType.get(i).getDec());
				
					bw.newLine();
				}
				bw.write("public example() {");
				bw.newLine();
				for (int i=0; i<layoutType.size(); i++) {
				
				bw.write(layoutType.get(i).toString());
					bw.newLine();
				}
				for (int i=0; i<layoutType.size(); i++) {
					
					bw.write(layoutType.get(i).getAddToTable());
						bw.newLine();
					}
				bw.write("}//end of Constructor");
				bw.write("}//end of file");
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
	
	public void fileMenu(){
		
		JMenuBar menuBar = new JMenuBar();
        
        // Add the menubar to the frame
        setJMenuBar(menuBar);
        
        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        
        // Create and add simple menu item to one of the drop down menu
        JMenuItem newAction = new JMenuItem("New");
        JMenuItem openAction = new JMenuItem("Open");
        JMenuItem saveAction = new JMenuItem("Save");
        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem genAction = new JMenuItem("Generate Java");
        JMenuItem newItemAction = new JMenuItem("New Item");
        
        //file menu buttons
        fileMenu.add(newAction);
        fileMenu.add(openAction);
        fileMenu.add(saveAction);
        fileMenu.addSeparator();
        fileMenu.add(genAction);
        fileMenu.add(exitAction);
        
        //edit menu buttons
        editMenu.add(newItemAction);
        
        
        //file menu actions
        newAction.addActionListener(new ActionListener (){
			public void actionPerformed (ActionEvent ae) {
				//TODO: add action for new file
			}
		});
        
        openAction.addActionListener(new Load());
        
        saveAction.addActionListener(new Save());
		
        genAction.addActionListener(new SaveReport());
        
        exitAction.addActionListener(new ActionListener (){
			public void actionPerformed (ActionEvent ae) {
				System.exit(0);
			}
		});
        
        
        //edit menu button actions
        newItemAction.addActionListener(new ActionListener (){
			public void actionPerformed (ActionEvent ae) {
				dataModel.addAnimal();
			}
		});
      
        
	}
	
}
