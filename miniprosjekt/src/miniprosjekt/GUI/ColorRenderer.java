package miniprosjekt.GUI;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import miniprosjekt.model.MyModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;

public class ColorRenderer extends JLabel implements TableCellRenderer {

    private TableCellRenderer delegate;
    private Component component;

    public ColorRenderer(TableCellRenderer defaultRenderer)
    {
        this.delegate = defaultRenderer;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                           boolean isSelected, boolean hasFocus, int row, int column)
    {
        component = delegate.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
      //  component.setBackground(Color.cyan);
        component.setForeground(Color.RED);
        
        return component;
        // return this;
    }

  
}