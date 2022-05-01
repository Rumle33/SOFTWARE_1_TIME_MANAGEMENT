package dtu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonItem {



    private JButton button;

    public ButtonItem(String name) {
        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }


    public JButton getButton()
    {
        return button;
    }

    @Override
    public String toString(){
        return button.getText();
    }
}
