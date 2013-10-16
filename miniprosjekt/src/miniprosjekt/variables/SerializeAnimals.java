package miniprosjekt.variables;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SerializeAnimals {
	private Scanner input;
	private ObjectOutputStream output;
	
	private void openFiles () {
		try {
			// �pner dyr.txt for lesing
			// �pner dyr.ser som en output fil, legger en ObjectOutputStream utenp� denne filen
			// Det er denne ObjectOutputStreamen som tillater oss � skrive objekter rett til fil
			input = new Scanner (new File ("dyr.txt"));
			output = new ObjectOutputStream (new FileOutputStream("dyr.ser"));
			
		} catch (FileNotFoundException fnfe) {
			System.err.println ("Fant ikke filen dyr.txt");
			System.exit(1);
		} catch (IOException ioe) {
			System.err.println ("Feil ved �pning av dyr.ser");
			System.exit(1);
		}
	}
	
	private void serialize () {
		
		try {
		
			while (input.hasNext()) {
				SerializableAnimal animal = new SerializableAnimal ();
				
				animal.setType(input.next());
				animal.setName(input.next());
				animal.setAge(input.nextInt());
				// Skriver objektet til fil, kan ogs� skrive int, float etc til fil.
				
				output.writeObject(animal);
		
				System.out.printf("Objektet '%s' er skrevet til disk\n", animal);
			}
		}  catch (NoSuchElementException nsee) {
			System.err.println ("Feil format p� filen!");
			return;
		} catch (IllegalStateException ise) {
			System.err.println ("Feil under lesing av filen");
			return;			
		} catch (IOException ioe) {
			System.err.println ("Feil under skriving til fil");
			return;
		}
		
	}
	
	private void closeFiles () {
		// Igjen m� vi lukke filene
		if (input!=null)
			input.close();
		if (output!=null) {
			// Scanner og Formatter er en spesiell m�te � h�ndtere filer p�
			// output er mer normal IO og vi m� ta hensyn til exceptions n�r vi lukker filen
			try {
				output.close();
			} catch (IOException e) {
				System.err.println ("Feil p� lukking av fil.");
			}
		}
	}
	
	public static void main(String[] args) {
		SerializeAnimals sa = new SerializeAnimals();
		sa.openFiles();
		sa.serialize();
		sa.closeFiles();
		System.out.println ("Alle dyr er serialisert til disk.");
	}
}
