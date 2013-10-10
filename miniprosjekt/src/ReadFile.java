import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReadFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream ("postnummerregister_ansi.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String tmp = null;
			while ((tmp = br.readLine())!=null)
				System.out.println (tmp);
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}
