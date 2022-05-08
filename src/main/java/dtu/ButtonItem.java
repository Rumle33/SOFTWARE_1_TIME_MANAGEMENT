package dtu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonItem {

    private JButton button;

    // Knap fra ProjectsPAge til AddProjectForm
    public ButtonItem(ProjectsPage projectsPage, String name) {

        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddProjectForm addProject = new AddProjectForm(projectsPage);
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }

    // Knap fra ProjectsPage til UsersPage
    public ButtonItem(Project project, String name) {

        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsersPage usersPage = new UsersPage(project);
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }

    //Knap fra UsersPage til AddDevForm
    public ButtonItem(UsersPage usersPage, String name) {

        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddDevForm addDev = new AddDevForm(usersPage);
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }

    //Knap fra UsersPage til ProjectsPage
    public ButtonItem(ArrayList<Project> projects, String name) {
        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectsPage projectsPage = new ProjectsPage(projects);
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }

    //Knap fra UsersPage til ProjectHomePage
    public ButtonItem(Employee employee, String name, Project project) {

        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectHomePage projectHomePage = new ProjectHomePage(employee, project);
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }


    //Knap fra ProjectHomePage til AddActivityForm
    public ButtonItem(ProjectHomePage projectHomePage, ProjectLeader projectLeader) {

        this.button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectHomePage NewPage = new ProjectHomePage(projectHomePage.getActivities() ,projectHomePage.getCurrentUser(), projectHomePage.getProject(), projectLeader);
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }

    //Knap til ProjectHomePage
    public ButtonItem(Employee employee, String name) {

        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                UsersPage usersPage = new UsersPage(employee, name);
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }


    //Knap fra ProjectHomePage til nye aktiviteter
    public ButtonItem(ProjectHomePage projectHomePage, String name) {

        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddActivityForm addActivityForm = new AddActivityForm(projectHomePage);
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }

    //Knap til ActivityPage
    public ButtonItem(Activity activity, String name) {

        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActivityPage activityPage = new ActivityPage();
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }


    public JButton getButton()
    {
        return button;
    }

    @Override
    public String toString(){
        return button.getText();
    }
}
