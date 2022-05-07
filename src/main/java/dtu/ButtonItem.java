package dtu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ButtonItem {



    private JButton button;

    //Knap til nye development employee
    public ButtonItem(GUIApplication gui, String name) {

        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddDevForm addDev = new AddDevForm(gui);
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }

    //Knap til UserHomePage
    public ButtonItem(Employee employee, String name) {

        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserHomePage homePage = new UserHomePage(employee);
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }

    //Knap til nye projekter
    public ButtonItem(UserHomePage userHomePage, String name) {

        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddProjectForm addProject = new AddProjectForm(userHomePage);
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }

    //Knap til UserProjectPage
    public ButtonItem(Employee employee, Project project, String name) {

        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectHomePage projectHomePage = new ProjectHomePage(employee, project);
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }


    //Knap til nye aktiviteter
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
