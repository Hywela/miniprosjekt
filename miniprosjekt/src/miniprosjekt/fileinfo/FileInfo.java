package miniprosjekt.fileinfo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class FileInfo extends JPanel {
	JToolBar toolbar = new JToolBar ();
	JTextArea text = new JTextArea (5,5);
	
	public FileInfo () {
		setLayout (new BorderLayout ());
		// Knapp for � velge hvilken fil/katalog vi �nsker informasjon om 
		JButton inspect = new JButton (new ImageIcon (getClass().getResource("/images/viewmag.png")));
		inspect.setToolTipText("Inspiser en fil");
		inspect.addActionListener (new Inspect());
		// Knapp for � lagre informasjonen til en tekstfil
		JButton saveLog = new JButton (new ImageIcon (getClass().getResource("/images/filesave.png")));
		saveLog.setToolTipText("Lagre log som tekstfil");
		saveLog.addActionListener(new SaveLog());
		toolbar.add (inspect);
		toolbar.add	(saveLog);
		add (toolbar, BorderLayout.NORTH);
		// Legger tekstomr�det inn i en scrollpane i center av applikasjonen
		add (new JScrollPane(text), BorderLayout.CENTER);
		setPreferredSize (new Dimension(400, 400));
		setMinimumSize (new Dimension(400, 400));
	
	}
	
	// Klassen for � inspisere en fil/katalog
	class Inspect implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			// Oppretter JFileChooser og sender med gjeldende katalog som parameter
			// Dersom vi ikke gj�r dette s� vil den default �pne p� brukerens hjemmeomr�de
			JFileChooser chooser = new JFileChooser(new File("."));
			// Vi �nsker � kunne velge b�de filer og kataloger
			chooser.setFileSelectionMode (JFileChooser.FILES_AND_DIRECTORIES);
			// Dersom brukeren trykker cancel s� returnerer vi fra metoden
			if (chooser.showOpenDialog(FileInfo.this)==JFileChooser.CANCEL_OPTION)
				return;
			// En fil er valgt, hent denne
			File f = chooser.getSelectedFile();
			// Dersom filen finnes p� systemet
			if (f.exists()) {
				// Dump informasjon om filen
				String res = String.format ("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n",
						f.getName(), " exists", 
						(f.isFile()?"is a file":"is not a file"),
						(f.isDirectory()?"is a directory":"is not a directory"),
						(f.isAbsolute()?"is absolute path":"is not absolute path"),
						"Last modified: ", f.lastModified(),
						"Length: ", f.length(),
						"Path: ", f.getPath(),
						"Absolute path: ", f.getAbsolutePath(),
						"Parent: ",f.getParent());
				text.append(res);
				// Dersom det er en katalog s� lister vi ut filene i katalogen
				if (f.isDirectory()) {
					// Henter en oversikt over filer/kataloger i katalogen
					String dir[] = f.list();
					text.append("\n\nDirectory contents:\n");
					for (String tmp : dir)
						text.append (tmp+"\n");
				}
				text.append("-------------------\n");
			} else {
				// Filen finnes ikke
				text.append(String.format ("%s %s\n", f, "does not exist"));
				text.append("-------------------\n");
			}
		}
	}
	
	// Klassen benyttes for � lagre loggen til tekstfil
	class SaveLog implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			// Lager igjen en JFilechooser med gjeldende katalog som startpunkt
			JFileChooser chooser = new JFileChooser(new File("."));
			// Vi �nsker � skrive til fil
			chooser.setFileSelectionMode (JFileChooser.FILES_ONLY);
			// Dersom brukeren trykker avbryt s� returnerer vi
			if (chooser.showSaveDialog(FileInfo.this)==JFileChooser.CANCEL_OPTION)
				return;
			File f = chooser.getSelectedFile();
			// Dersom filen eksisterer s� sp�r vi om den skal overskrives
			if (f.exists())
				if (JOptionPane.showConfirmDialog(FileInfo.this, "Filen finnes, overskrive", "Bekreft", JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION)
					// Ikke overskrive, da returnerer vi
					return;
			try {
				// En FileWriter kan skrive til fil, men en BufferedWriter er enda bedre :)
				BufferedWriter bw = new BufferedWriter (new FileWriter (f));
				// Write metoden skriver teksten til fil
				bw.write(text.getText());
				// Igjen, vi M� huske � lukke filen
				bw.close();
			} catch (IOException ioe) {
				// Filoperasjoner er alltid i try/catch
				System.err.println ("Feil p� skriving til fil");
			}
		}
	}
			
	public static void main(String[] args) {
		JFrame f = new JFrame ("Inspiser filer");
		FileInfo fi = new FileInfo();
		f.add (fi);
		f.pack ();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
