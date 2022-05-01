package dtu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDevForm extends GUIApplication implements ActionListener {
    private JButton Add_Employee;
    private JPanel panel1;
    private JTextField textField1;
    JFrame frame = new JFrame();
    GUIApplication Gui2;
    AddDevForm(GUIApplication GUI){
        this.Gui2 = GUI;
        Add_Employee.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.add(Add_Employee);
        Add_Employee.setBounds(50,50,150,50);
        frame.add(panel1);
        frame.setSize(1500,1000);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Add_Employee) {
            frame.dispose();
            this.Gui2.Emp.add(new DevelopmentEmployee(textField1.toString()));
            this.Gui2.run();
        };
    }

}
