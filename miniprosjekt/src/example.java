import java.awt.*;
import javax.swing.*;
public class example extends JPanel {
JTextArea ny0;
JTextArea ny1;
JTextArea ny2;
JTextArea ny3;
public example() {
ny0 = new JTextArea("Insert texst");
ny1 = new JTextArea("Insert texst");
ny2 = new JTextArea("Insert texst");
ny3 = new JTextArea("Insert texst");
  GridBagLayout layout = new GridBagLayout ();
GridBagConstraints gbc = new GridBagConstraints();
setLayout (layout);

gbc.gridx = 1;
gbc.gridy = 1;
gbc.gridwidth= 0;
gbc.gridheight = 1;
gbc.anchor = java.awt.GridBagConstraints.CENTER;
gbc.fill = java.awt.GridBagConstraints.NONE;
layout.setConstraints(ny0,gbc);
add (ny0);
ny0.setLineWrap (true);
ny0.setWrapStyleWord (true);
gbc.gridx = 1;
gbc.gridy = 1;
gbc.gridwidth= 0;
gbc.gridheight = 1;
gbc.anchor = java.awt.GridBagConstraints.CENTER;
gbc.fill = java.awt.GridBagConstraints.NONE;
JScrollPane ny1ScrollPane = new JScrollPane (ny1);
layout.setConstraints(ny1ScrollPane,gbc);
add (ny1ScrollPane);

gbc.gridx = 1;
gbc.gridy = 1;
gbc.gridwidth= 0;
gbc.gridheight = 1;
gbc.anchor = java.awt.GridBagConstraints.CENTER;
gbc.fill = java.awt.GridBagConstraints.NONE;
JScrollPane ny2ScrollPane = new JScrollPane (ny2);
layout.setConstraints(ny2ScrollPane,gbc);
add (ny2ScrollPane);
ny2.setLineWrap (true);
ny2.setWrapStyleWord (true);
gbc.gridx = 1;
gbc.gridy = 1;
gbc.gridwidth= 0;
gbc.gridheight = 1;
gbc.anchor = java.awt.GridBagConstraints.CENTER;
gbc.fill = java.awt.GridBagConstraints.NONE;
layout.setConstraints(ny3,gbc);
add (ny3);
}//end of Constructor
public static void main(String[] args) {
JFrame frame = new JFrame("Example");
frame.setContentPane(new example());
frame.pack();
frame.setVisible(true);}
}//end of file