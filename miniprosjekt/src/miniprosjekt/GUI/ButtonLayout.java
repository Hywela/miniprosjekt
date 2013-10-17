package miniprosjekt.GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.TableCellRenderer;

import miniprosjekt.model.MyModel;
import miniprosjekt.variables.BaseMedia;
import miniprosjekt.variables.Language;

@SuppressWarnings("serial")
public class ButtonLayout extends JFrame {
	JFrame f;
	
	TableCellRenderer weirdRenderer;
	private Editor editor;
	private MyModel dataModel = new MyModel();
	private JTable table= new JTable(dataModel);
	private JToolBar toolbar = new JToolBar();
	private String layoutType[] = { "JLabel", "JTextField", "JTextArea",
			"JButton" };
	private JComboBox<String> animalTypeEditor = new JComboBox<String>(
			layoutType);
	private String alignments[] = { "WEST", "NORTHWEST", "SOUTHWEST", "EAST",
			"NORTHEAST", "SOUTHEAST", "NORTH", "SOUTH", "CENTER" };
	private JComboBox<String> alignmentEditor = new JComboBox<String>(
			alignments);
	private String size[] = { "NONE", "BOTH", "HORIZONTAL", "VERTICAL" };
	private JComboBox<String> sizeEditor = new JComboBox<String>(size);

	public ButtonLayout() {
		super(Language.getMsg("window_header"));
		
	
		    
		dataModel.setTableFrame(this);
		fileMenu();
		
		
		add(new JScrollPane(table), BorderLayout.CENTER);
		table.getColumnModel().getColumn(0)
				.setCellEditor(new DefaultCellEditor(animalTypeEditor));
		table.getColumnModel().getColumn(7)
				.setCellEditor(new DefaultCellEditor(sizeEditor));
		table.getColumnModel().getColumn(8)
				.setCellEditor(new DefaultCellEditor(alignmentEditor));
		TableCellRenderer renderer = table.getTableHeader().getDefaultRenderer();
		table.getColumnModel().getColumn(0).setCellRenderer(new ColorRenderer(renderer));
		
		JButton load = new JButton(new ImageIcon(getClass().getResource(
				"/images/file.png")));
		load.setToolTipText(Language.getMsg("open_file"));
		load.addActionListener(new Load());
		JButton save = new JButton(new ImageIcon(getClass().getResource(
				"/images/filesave.png")));
		save.setToolTipText(Language.getMsg("save_file"));
		save.addActionListener(new Save());
		JButton saveReport = new JButton(new ImageIcon(getClass().getResource(
				"/images/fileexport.png")));
		saveReport.setToolTipText(Language.getMsg("export"));
		saveReport.addActionListener(new SaveReport());
		JButton addAnimal = new JButton(new ImageIcon(getClass().getResource(
				"/images/insert_table_row.png")));
		addAnimal.setToolTipText(Language.getMsg("add"));
		addAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dataModel.addMedia();
			}
		});
		toolbar.add(load);
		toolbar.add(save);
		toolbar.addSeparator();
		toolbar.add(saveReport);
		toolbar.addSeparator();
		toolbar.add(addAnimal);
		add(toolbar, BorderLayout.NORTH);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		table.addMouseListener(new RightClicker());
	}
	
	private class RightClicker extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			if (e.isMetaDown()) {
				int rowcheck = table.getSelectedRow();
				final Vector<BaseMedia> layoutType = dataModel.getData();
				if (rowcheck > -1) {
					if (layoutType.get(rowcheck).getType() == "JTextField" ||
							layoutType.get(rowcheck).getType() == "JTextArea") {
					
						f = new JFrame();
					editor = new Editor(layoutType.get(rowcheck).getType());
					editor.setValues(layoutType.get(rowcheck)
							.getSPValuesColumns(), layoutType.get(rowcheck)
							.getSPValuesRows(), layoutType.get(rowcheck)
							.getSPValuesHeight(), layoutType.get(rowcheck)
							.getSPValuesWidth());
					if(layoutType.get(rowcheck).getType() == "JTextArea"){
					editor.setWordWrapping(layoutType.get(rowcheck).isWordWrapping());
					editor.setJscrollPanel(layoutType.get(rowcheck).isJscrollPanel());
					}
					f.add(editor);
					f.pack();
					f.setVisible(true);

					JButton cancle = editor.cancle();
					cancle.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							f.setVisible(false);

						}
					});
					JButton ok = editor.ok();
					ok.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							f.setVisible(false);
							int rowcheck = table.getSelectedRow();
							if (layoutType.get(rowcheck).getType() == "JTextField") {
								layoutType.get(rowcheck).setSPValues(
										editor.getHeigt(), editor.getwidth(),
										editor.getRow(), 0);

							}
							if (layoutType.get(rowcheck).getType() == "JTextArea") {
								layoutType.get(rowcheck).setSPValues(
										editor.getHeigt(), editor.getwidth(),
										editor.getRow(), editor.getColumn());
								layoutType.get(rowcheck).setWordWrapping(editor.getWordWrapping());
								layoutType.get(rowcheck).setJscrollPanel(editor.getJscrollPanel());
								

							}

						}
					});

				}
			}
		}
		}
	}

	class Load implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser(new File("."));
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			if (chooser.showOpenDialog(ButtonLayout.this) == JFileChooser.CANCEL_OPTION)
				return;
			File f = chooser.getSelectedFile();
			try {
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(f));
				dataModel.load(ois);
				ois.close();
			} catch (IOException ioe) {
				System.err.println("Feil på filhåndteringen.");
			}
		}
	}

	class Save implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser(new File("."));
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			if (chooser.showSaveDialog(ButtonLayout.this) == JFileChooser.CANCEL_OPTION)
				return;
			File f = chooser.getSelectedFile();
			if (f.exists())
				if (JOptionPane.showConfirmDialog(ButtonLayout.this,
						Language.getMsg("overwrite_file"),
						Language.getMsg("confirm"), JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
					return;
			try {
				ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream(f));
				dataModel.save(oos);
				oos.close();
			} catch (IOException ioe) {
				System.err.println("Feil på filhåndteringen.");
			}

		}
	}

	// TODO:: bytt ut example med et generert navn
	class SaveReport implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			File f = new File("example.java");
			if (f.exists())
				if (JOptionPane.showConfirmDialog(ButtonLayout.this,
						Language.getMsg("overwrite_file"),
						Language.getMsg("confirm"), JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
					return;
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				Vector<BaseMedia> layoutType = dataModel.getData();
				for (int i = 0; i < layoutType.size(); i++) {
					
					System.out.println(layoutType.get(i).getType());
					
				}
				
				bw.write("import java.awt.*;");
				bw.newLine();
				bw.write("import javax.swing.*;");

				bw.newLine();
				bw.write("public class example extends JPanel {");
				bw.newLine();
				for (int i = 0; i < layoutType.size(); i++) {
					bw.write(layoutType.get(i).getDec());

					bw.newLine();
				}
				bw.write("public example() {");
				bw.newLine();

				for (int i = 0; i < layoutType.size(); i++) {

					bw.write(layoutType.get(i).toString());
					bw.newLine();
				}
				bw.write("  GridBagLayout layout = new GridBagLayout ();");
				bw.newLine();
				bw.write("GridBagConstraints gbc = new GridBagConstraints();");
				bw.newLine();
				bw.write("setLayout (layout);");
				bw.newLine();

				for (int i = 0; i < layoutType.size(); i++) {
					bw.write(layoutType.get(i).getGridBagPara());
					bw.newLine();
					bw.write(layoutType.get(i).getAddToTable());
				}
				bw.write("}//end of Constructor");
				bw.newLine();
				bw.write("public static void main(String[] args) {");
				bw.newLine();
				bw.write("JFrame frame = new JFrame(\"Example\");");
				bw.newLine();
				bw.write("frame.setContentPane(new example());");
				bw.newLine();
				bw.write("frame.pack();");
				bw.newLine();
				bw.write("frame.setVisible(true);}");
				bw.newLine();
				bw.write("}//end of file");
				bw.close();
			} catch (IOException ioe) {
				System.err.println("Feil under skriving av rapporten.");
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Language.setLocale(args);
		new ButtonLayout();

	}

	public void fileMenu() {

		JMenuBar menuBar = new JMenuBar();

		// Add the menubar to the frame
		setJMenuBar(menuBar);

		// Define and add two drop down menu to the menubar
		JMenu fileMenu = new JMenu(Language.getMsg("file"));
		JMenu editMenu = new JMenu(Language.getMsg("edit"));
		menuBar.add(fileMenu);
		menuBar.add(editMenu);

		// Create and add simple menu item to one of the drop down menu
		JMenuItem newAction = new JMenuItem(Language.getMsg("new"));
		JMenuItem openAction = new JMenuItem(Language.getMsg("open_file"));
		JMenuItem saveAction = new JMenuItem(Language.getMsg("save_file"));
		JMenuItem exitAction = new JMenuItem(Language.getMsg("exit"));
		JMenuItem genAction = new JMenuItem(Language.getMsg("export"));
		JMenuItem newItemAction = new JMenuItem(Language.getMsg("add"));

		// file menu buttons
		fileMenu.add(newAction);
		fileMenu.add(openAction);
		fileMenu.add(saveAction);
		fileMenu.addSeparator();
		fileMenu.add(genAction);
		fileMenu.add(exitAction);

		// edit menu buttons
		editMenu.add(newItemAction);

		// file menu actions
		newAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// TODO: add action for new file
			}
		});

		openAction.addActionListener(new Load());

		saveAction.addActionListener(new Save());

		genAction.addActionListener(new SaveReport());

		exitAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});

		// edit menu button actions
		newItemAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dataModel.addMedia();
			}
		});

	}
}
