package miniprosjekt.variables;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;

import javax.swing.JFrame;

import miniprosjekt.GUI.Editor;

@SuppressWarnings("serial")
public class CreateTextFile extends JFrame {
	private Editor editor = new Editor ();
	private Formatter output;
	
	public CreateTextFile () {
		// GUI stuff
		super ("Legg til dyr i fila.");
		add (editor);
		// Når vi trykker på legg til i editoren skal denne klassens actionPerformed kalles
		editor.setAddAction(new AddAnimal ());
		pack ();
		addWindowListener (new CloseWindow());
			
		// File stuff
		try {
			// Åpner filen det skal skrives til
			output = new Formatter ("dyr.txt");
		} catch (SecurityException se) {
			System.err.println ("Du har ikke skriverettigheter til filen!");
			System.exit (1);
		} catch (FileNotFoundException fnfe) {
			System.err.println ("Feil ved åpning eller opprettelse av filen!");
			System.exit (1);
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible (true);
	}
	
	class AddAnimal implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			try {
				// Henter informasjon om et dyr fra editoren
				Media animal = editor.getAnimal();
				// Skriver dette til fil. NB, type og navn kan kun være ett ord!! 
				output.format("%s %s %d\n", animal.getType(), animal.getName());
				editor.clear();
			} catch (FormatterClosedException fce) {
				System.err.println ("Feil under skriving til fil.");
			}
		}
	}
	
	class CloseWindow extends WindowAdapter {
		public void windowClosing (WindowEvent we) {
			// Fila MÅ lukkes ordentlig, hvis ikke er det slett ikke godt å si hva en ender opp med
			if (output!=null)
				output.close();
		}
	}
	
	public static void main(String[] args) {
		new CreateTextFile();
	}
	
}
