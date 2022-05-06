package dtu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddDevForm implements ActionListener {
    private JButton add_project;
    private JPanel panel1;
    private JTextField textField1;


    JFrame frame = new JFrame();
    GUIApplication Gui2;
    ArrayList<Employee> temp_emp;


    AddDevForm(GUIApplication GUI){
        this.Gui2 = GUI;
        temp_emp = Gui2.Emp;
        add_project.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.add(add_project);
        add_project.setBounds(50,50,150,50);
        frame.add(panel1);
        frame.setResizable(false);
        frame.setSize(1000,1000);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_project) {
            frame.dispose();
            temp_emp.add(new DevelopmentEmployee(textField1.getText()));
            GUIApplication gui_app = new GUIApplication(temp_emp);
            gui_app.setup();
        };
    }

}
