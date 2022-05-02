package dtu;

import javax.swing.*;
import java.awt.*;

class ButtonListRenderer extends JButton implements ListCellRenderer
{
    public Component getListCellRendererComponent(JList comp, Object value, int index,
                                                  boolean isSelected, boolean hasFocus)
    {
        setEnabled(comp.isEnabled());
        setFont(comp.getFont());
        System.out.println(value);
        setText(value.toString());

        if (isSelected)
        {
            setBackground(comp.getSelectionBackground());
            setForeground(comp.getSelectionForeground());
        }
        else
        {
            setBackground(comp.getBackground());
            setForeground(comp.getForeground());
        }

        return this;
    }
}
