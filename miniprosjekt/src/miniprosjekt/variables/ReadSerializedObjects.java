package miniprosjekt.variables;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadSerializedObjects {
	ObjectInputStream input;
	
	private void openFile () {
		try {
			// �pner filen dyr.ser og legger en ObjectInputStream rundt streamen fra filen
			input = new ObjectInputStream (new FileInputStream ("dyr.ser"));
		} catch (IOException ioe) {
			System.err.println ("Kunne ikke �pne filen 'dyr.ser'");
			System.exit (1);
		}
	}
	
	private void readFile () {
		SerializableAnimal animal;
		try {
			while (true) {
				// readObject returner et Object, vi caster dette til v�r type
				// Ikke strengt tatt n�dvendig siden toString finnes i Object klassen
				// men er en sikkerhet for at vi leser riktig type objekt
				animal = (SerializableAnimal)input.readObject();
				System.out.println (animal);
			}
		} catch (EOFException eofe) {
			// End of file, breaking out of while loop. 
		} catch (ClassNotFoundException cnfe) {
			// Dersom vi av en eller annen grunn ikke kan gj�re om det leste objektet til 
			// et objekt av klassen SerializableAnimal
			System.err.println ("Kunne ikke lese objekt av klassen Animal!");
		} catch (IOException ioe) {
			System.err.println ("Feil under lesing fra fil");
		}
	}
	
	private void closeFile () {
		try {
			input.close();
		} catch (IOException ioe) {
			System.err.println ("Feil under lukking av fil.");
		}
	}
	
	public static void main(String[] args) {
		ReadSerializedObjects rso = new ReadSerializedObjects();
		rso.openFile();
		rso.readFile();
		rso.closeFile();
	}
}
