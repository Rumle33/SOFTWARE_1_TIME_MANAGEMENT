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
    ProjectsPage projectsPage;
    ArrayList<Project> temp_projects;

    AddProjectForm(ProjectsPage projectsPage){
        this.projectsPage = projectsPage;
        temp_projects = this.projectsPage.getProjects();
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
            temp_projects.add(new Project(textField1.getText()));
            ProjectsPage projectsPage = new ProjectsPage(temp_projects);
            projectsPage.setup();
        };
    }

}
