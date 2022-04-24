package dtu;

import javax.swing.*;

public class GUIApplication extends JFrame{

    private JLabel Label_enter_name;

    public static void main(String[] args) {
        GUIApplication h = new GUIApplication();
        h.setTitle("Application");
        h.setSize(300,300);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

