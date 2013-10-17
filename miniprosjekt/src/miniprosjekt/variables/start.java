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
	JTextField hl;
	JLabel jlbLabel1;
	public start() {
		
		  JTextField ny1 = new JTextField ("dddkkkkkkkkk");
		  JLabel ny0 = new JLabel ("aaa");

		
		    GridBagLayout layout = new GridBagLayout ();
		    GridBagConstraints gbc = new GridBagConstraints();
		    setLayout (layout);
		    gbc.gridx = 1;
		    gbc.gridy = 1;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 1;
		    gbc.anchor = java.awt.GridBagConstraints.CENTER;
		    gbc.fill = java.awt.GridBagConstraints.NONE;
		    layout.setConstraints (ny1, gbc);
		    add (ny1);
		    gbc.gridx = 1;
		    gbc.gridy = 1;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 1;
		    gbc.anchor = java.awt.GridBagConstraints.CENTER;
		    gbc.fill = java.awt.GridBagConstraints.;
		    layout.setConstraints (ny0, gbc);
		    add (ny0);
		
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("jLabel Usage Demo");
		frame.addWindowListener(new WindowAdapter() {

			// Shows code to Add Window Listener
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setContentPane(new start());
		frame.pack();
		frame.setVisible(true);
	}
}