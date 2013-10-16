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
			// Åpner dyr.txt for lesing
			// Åpner dyr.ser som en output fil, legger en ObjectOutputStream utenpå denne filen
			// Det er denne ObjectOutputStreamen som tillater oss å skrive objekter rett til fil
			input = new Scanner (new File ("dyr.txt"));
			output = new ObjectOutputStream (new FileOutputStream("dyr.ser"));
			
		} catch (FileNotFoundException fnfe) {
			System.err.println ("Fant ikke filen dyr.txt");
			System.exit(1);
		} catch (IOException ioe) {
			System.err.println ("Feil ved åpning av dyr.ser");
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
				// Skriver objektet til fil, kan også skrive int, float etc til fil.
				
				output.writeObject(animal);
		
				System.out.printf("Objektet '%s' er skrevet til disk\n", animal);
			}
		}  catch (NoSuchElementException nsee) {
			System.err.println ("Feil format på filen!");
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
		// Igjen må vi lukke filene
		if (input!=null)
			input.close();
		if (output!=null) {
			// Scanner og Formatter er en spesiell måte å håndtere filer på
			// output er mer normal IO og vi må ta hensyn til exceptions når vi lukker filen
			try {
				output.close();
			} catch (IOException e) {
				System.err.println ("Feil på lukking av fil.");
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
