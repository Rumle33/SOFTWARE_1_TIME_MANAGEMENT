//Anders

package dtu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


//Denne klasse virker som knapper mellem siderne. Den findes fordi man ikke kan få jbuttons til at være i en liste som vi gerne ville have dem
public class ButtonItem {

    private JButton button;

    // Knap fra ProjectsPage til AddProjectForm
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
    public ButtonItem(ProjectsPage projectsPage, Project project, String name) {

        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsersPage usersPage = new UsersPage(projectsPage.getProjects(), project);
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

    //Knap til at assigne projectleader
    public ButtonItem(ProjectHomePage projectHomePage, DevelopmentEmployee Dev, String name) {
        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Dev.getClass() == DevelopmentEmployee.class ){
                    projectHomePage.getProject().setProjectleader(new ProjectLeader(projectHomePage.getProject(), Dev.getInitials()));
                    projectHomePage.getDevsInProject().remove(Dev);
                    projectHomePage.getProject().setDevsInProject(projectHomePage.getDevsInProject());
                    ProjectHomePage newpage = new ProjectHomePage(projectHomePage.getAllProjects(), projectHomePage.getActivities(), projectHomePage.getProjectLeader(), projectHomePage.getProject());
                }
            }
        });
    }



    //Knap fra UsersPage til ProjectHomePage
    public ButtonItem(ArrayList<Project> allProjects, Employee employee, String name, Project project) {

        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectHomePage projectHomePage = new ProjectHomePage(allProjects, employee, project);
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }

    //Knap fra ProjectsPage til UsersPage
    public ButtonItem(ArrayList<DevelopmentEmployee> devs, ArrayList<Project> projects, Project currentProject, String name) {
        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsersPage usersPage = new UsersPage(projects, currentProject, devs);
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }

    //Knap fra AssignNewDev til ActivityPage
    public ButtonItem(ActivityPage activityPage, DevelopmentEmployee dev, String name, String buttonType) {
        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonType.equals("AssignNewDev")){
                    activityPage.addDevToActivity(dev);
                    ActivityPage activityPage1 = new ActivityPage(activityPage);
                } else if (buttonType.equals("SeekAssistanceForm")){
                    activityPage.getCurrentUser().seekAssistance(dev, activityPage.getProject(), activityPage.getActivity());
                    ActivityPage activityPage1 = new ActivityPage(activityPage);
                }
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }

    //Knap fra AssignNewDev til ActivityPage
    public ButtonItem(ActivityPage activityPage, Activity activity, String name) {
        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activityPage.getCurrentUser().acceptAssistance(activity);
                ActivityPage activityPage1 = new ActivityPage(activityPage);
                System.out.println(button.getText() + " was clicked.");
            }
        });
    }





    //Knap fra ProjectHomePage til AddActivityForm
    public ButtonItem(ArrayList<Project> allProjects, ProjectHomePage projectHomePage, ProjectLeader projectLeader) {

        this.button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectHomePage NewPage = new ProjectHomePage(allProjects, projectHomePage.getActivities() ,projectHomePage.getCurrentUser(), projectHomePage.getProject(), projectLeader);
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

    //Knap fra ProjectHomePage til ActivityPage
    public ButtonItem(ProjectHomePage projectHomePage, Activity activity, String name) {

        this.button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActivityPage activityPage = new ActivityPage(activity, projectHomePage);
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
