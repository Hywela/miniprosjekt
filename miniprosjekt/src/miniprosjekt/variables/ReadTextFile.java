package miniprosjekt.variables;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {
	private Scanner input;
	
	private void openFile() {
		try {
			// åpner fila vi skal lese fra
			input = new Scanner (new File ("dyr.txt"));
		} catch (FileNotFoundException fnfe) {
			System.err.println ("Fant ikke filen dyr.txt");
		}
	}

	private void readFile() {
		Media animal = new Media ();
		try {
			// Så lenge det finnes flere elementer som kan leses på fila
			// NB, dersom du skriver inn en streng med mellomrom i type eller navn så vil ikke dette fungere
			while (input.hasNext()) {
				// Leser to strenger og et tall, en streng er en rekke med tegn, regner ny streng når den finner whitespace
				animal.setType(input.next());
				animal.setName(input.next());
				System.out.println (animal);
			}
		} catch (NoSuchElementException nsee) {
			System.err.println ("Feil format på filen!");
			input.close();
			nsee.printStackTrace();
			System.exit(1);
		} catch (IllegalStateException ise) {
			System.err.println ("Feil under lesing av filen");
			input.close();
			System.exit(1);
		}
	}

	private void closeFile() {
		if (input!=null)
			input.close();
	}

	public static void main(String[] args) {
		ReadTextFile rtf = new ReadTextFile ();
		rtf.openFile ();
		rtf.readFile ();
		rtf.closeFile ();
	}
}