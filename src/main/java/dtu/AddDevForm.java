package dtu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddDevForm implements ActionListener {
    private JButton add_developer;
    private JPanel panel1;
    private JTextField textField1;


    JFrame frame = new JFrame();
    UsersPage usersPage;
    ArrayList<DevelopmentEmployee> temp_dev;
    private Project current_project;
    private ArrayList<Project> allProjects = new ArrayList<Project>();


    AddDevForm(UsersPage usersPage){
        this.usersPage = usersPage;
        this.current_project = usersPage.getProject();
        this.allProjects = usersPage.getAllProjects();
        temp_dev = this.usersPage.getDevs();
        add_developer.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.add(add_developer);
        add_developer.setBounds(50,50,150,50);
        frame.add(panel1);
        frame.setResizable(false);
        frame.setSize(1000,1000);

        frame.setVisible(true);
    }

    //Denne metode tjekker om knapper bliver trykket på
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_developer) {
            frame.dispose();
            this.temp_dev.add(new DevelopmentEmployee(textField1.getText()));
            UsersPage usersPage = new UsersPage(this.allProjects, this.current_project, this.temp_dev);
        };
    }

}
