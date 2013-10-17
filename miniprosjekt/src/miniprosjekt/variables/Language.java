package miniprosjekt.variables;

import java.util.Locale;
import java.util.ResourceBundle;

//Class for getting the correct language bundle 
public class Language {

	private static ResourceBundle messages;
	private static Locale currentLocale;
	
	/**
	 * Chooses what language bundle to use
	 * 
	 * @param args to specify what language user want to use, if not supplied the computers default language will be chosen
	 */
	public static void setLocale(String[] args){
		
		//if user decideds a language on launch
		if (args.length==2) {
			currentLocale = new Locale (args[0], args[1]);
		} else if (args.length==1) {
			currentLocale = new Locale (args[0]);
		} else	//else the computers default language 
			currentLocale = Locale.getDefault();
			
		//get correct lanugage bundle
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
	}
	
	/**
	 * Function for geting string resourses based on the resourse key
	 * 
	 * @param key The resource key to get
	 * @return The string correct language string
	 */
	public static String getMsg(String key){
		return messages.getString(key);
	}

}
