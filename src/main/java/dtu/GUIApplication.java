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

        casperButton.setBounds(100,160,200,40);
        casperButton.setFocusable(false);
        casperButton.addActionListener(this);

        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jensButton) {
            frame.dispose();
            window_2_jens myWindow = new window_2_jens();
        }
        if (e.getSource() == casperButton){
            frame.dispose();
            window_3_casper myWindow = new window_3_casper();
        }
    }
}


