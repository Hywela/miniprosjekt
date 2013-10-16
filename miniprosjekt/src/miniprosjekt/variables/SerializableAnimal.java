package miniprosjekt.variables;

import java.io.Serializable;

// Når en klasse implementerer Serializable er dette et signal til kompilatoren
// Denne klassen med alle data elementer skal kunne serialiseres til disk
public class SerializableAnimal implements Serializable {
	// Det er din jobb å endre denne når klassen endres slik at den ikke kan 
	// leses fra disk lenger (dvs, nye dataelementer eller metoder)
	private static final long serialVersionUID = 1L;
	private String type;
	private String name;
	private int age;
	
	public SerializableAnimal () {
		type = "";
		name = "";
		age = 0;
	}
	
	public SerializableAnimal (String type, String name, int age) {
		this.type = type;
		this.name = name;
		this.age = age;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder ();
	
		sb.append (getType());
		sb.append ("en ");
		sb.append (getName());
		sb.append (" er ");
		sb.append (getAge());
		sb.append (" år gammel.");
		return sb.toString();
	}
}