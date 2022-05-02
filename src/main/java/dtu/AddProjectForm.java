package dtu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddProjectForm implements ActionListener {
    private JButton add_project;
    private JPanel panel1;
    private JTextField textField1;
    JFrame frame = new JFrame();
    UserHomePage userHomePage;
    ArrayList<Project> temp_projects;
    private Employee current_user;

    AddProjectForm(UserHomePage userHomePage){
        this.userHomePage = userHomePage;
        this.current_user = this.userHomePage.getCurrentUser();
        temp_projects = this.userHomePage.getProjects();
        add_project.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.add(add_project);
        add_project.setBounds(50,50,150,50);
        frame.add(panel1);
        frame.setSize(1500,1000);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_project) {
            frame.dispose();
            temp_projects.add(new Project(textField1.getText()));
            UserHomePage userHomePage = new UserHomePage(temp_projects,this.current_user);
            userHomePage.setup();
        };
    }

}
