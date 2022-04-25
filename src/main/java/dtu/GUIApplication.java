package dtu;

import javax.swing.*;
import java.awt.event.*;


public class GUIApplication implements ActionListener {

    public JPanel panel1;
    public JButton casperButton;
    public JButton jensButton;
    JFrame frame = new JFrame("Time management application");

    GUIApplication() {

        jensButton.setBounds(100,160,200,40);
        jensButton.setFocusable(false);
        jensButton.addActionListener(this);

        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GUIApplication().panel1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jensButton) {
            frame.dispose();
            window_2 myWindow = new window_2();
        }
    }
}


