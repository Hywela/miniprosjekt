package miniprosjekt.variables;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class start extends JPanel {
	JTextField hl;	JTextField TODO;
	JLabel jlbLabel1;
	public start() {
		
	
		
		TODO = new JTextField("ddd");
		  GridBagLayout layout = new GridBagLayout ();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout (layout);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth= 0;
		gbc.gridheight = 1;
		gbc.anchor = java.awt.GridBagConstraints.CENTER;
		gbc.fill = java.awt.GridBagConstraints.CENTER;
		 layout.setConstraints (TODO, gbc);
		add (TODO);
		
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("jLabel Usage Demo");
		

			
		frame.setContentPane(new start());
		frame.pack();
		frame.setVisible(true);
	}
}