package miniprosjekt.GUI;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import java.awt.Component;
/**
 * Class for Custom renderer on table column
 * @author Kevin
 * @author Kristoffer
 *
 */
public class ColorRenderer extends JLabel implements TableCellRenderer {

  
	private static final long serialVersionUID = -8139799299608461239L;
	private TableCellRenderer delegate;
    private Component component;

    /**
     * Constructor
     * @param defaultRenderer
     */
    public ColorRenderer(TableCellRenderer defaultRenderer)
    {
        this.delegate = defaultRenderer;
    }

	/**
	 * Overides the Rendere and sets the tekst color to Red
	 * 
	 * @return component
	 */
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		component = delegate.getTableCellRendererComponent(table, value,
				isSelected, hasFocus, row, column);

		component.setForeground(Color.RED);

		return component;
		// return this;
	}

  
}