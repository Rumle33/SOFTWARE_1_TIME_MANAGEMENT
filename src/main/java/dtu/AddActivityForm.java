package dtu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddActivityForm implements ActionListener {
    private JButton add_activity;
    private JPanel panel1;
    private JTextField startDateField;
    private JTextField endDateField;
    private JTextField nameField;
    JFrame frame = new JFrame();
    ProjectHomePage projectHomePage;
    ArrayList<Activity> temp_activity;
    private Employee current_user;
    private Project current_project;

    AddActivityForm(ProjectHomePage projectHomePage){
        this.projectHomePage = projectHomePage;
        this.current_project = this.projectHomePage.getProject();
        this.current_user = this.projectHomePage.getCurrentUser();
        temp_activity = this.projectHomePage.getActivities();
        add_activity.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.add(add_activity);
        add_activity.setBounds(50,50,150,50);
        frame.add(panel1);
        frame.setResizable(false);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_activity) {
            frame.dispose();
            temp_activity.add(new Activity(startDateField.getText(), endDateField.getText(), nameField.getText(), this.current_project));
            ProjectHomePage projectHomePage = new ProjectHomePage(temp_activity, this.current_user, this.current_project);
            projectHomePage.setup();
        };
    }

}
