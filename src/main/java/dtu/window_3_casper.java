package dtu;

import javax.swing.*;

public class window_3_casper {
    JFrame frame = new JFrame("Application");
    private JLabel LABELCASPER;
    private JPanel panel1;


    window_3_casper() {

        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(LABELCASPER);
        frame.setVisible(true);
        frame.add(panel1);

    }
}