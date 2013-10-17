package miniprosjekt.variables;

import java.util.Locale;
import java.util.ResourceBundle;


public class Language {

	private static ResourceBundle messages;
	private static Locale currentLocale;
	
	/**
	 * @param args
	 */
	public static void setLocale(String[] args){
		
		if (args.length==2) {
			currentLocale = new Locale (args[0], args[1]);
		} else if (args.length==1) {
			currentLocale = new Locale (args[0]);
		} else
			currentLocale = Locale.getDefault();
			
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
	}
	
	public static String getMsg(String key){
		return messages.getString(key);
	}

}
