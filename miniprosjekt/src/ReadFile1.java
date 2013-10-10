import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReadFile1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("postnummerregister_ansi.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			
			String tmp;
			while ((tmp=br.readLine())!=null)
				System.out.println (tmp);
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		

	}

}
