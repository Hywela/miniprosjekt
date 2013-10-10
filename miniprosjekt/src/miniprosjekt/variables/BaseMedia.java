package miniprosjekt.variables;

import java.io.Serializable;

// Alle dyr har det til felles at de har et navn og en alder
public class BaseMedia implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	
	public BaseMedia () {
		name = "";
		age = 0;
	}

	// Vi kan opprette et nytt dyr og ta vare på egenskapene som alle dyr har til felles
	public BaseMedia (BaseMedia animal) {
		name = animal.name;
		age = animal.age;
	}
	
	public BaseMedia (String name, int age) {
		this.name = name;
		this.age = age;
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
		sb.append (getName());
		sb.append (" og er ");
		sb.append (getAge());
		sb.append (" år gammel.");
		return sb.toString();
	}
}