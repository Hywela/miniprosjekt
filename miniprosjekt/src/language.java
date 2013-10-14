import java.util.Locale;
import java.util.ResourceBundle;


public class language {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Lanugage setup
				String language;
				String country;
				
				 if (args.length != 2) {	//set default language
			         language = new String("en");
			         country = new String("US");
			     } else {
			         language = new String(args[0]);
			         country = new String(args[1]);
			     }
				
				 Locale currentLocale;
			     ResourceBundle messages;
			     currentLocale = new Locale(language, country);
			     messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
			     
			     
			     //TODO: reove testing lines
			     System.out.println(messages.getString("greetings"));
			     System.out.println(messages.getString("inquiry"));
			     System.out.println(messages.getString("farewell"));
	}

}
