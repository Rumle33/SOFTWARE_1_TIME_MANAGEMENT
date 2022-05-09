package dtu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ProjectHomePage{
    private Object[] button_list;
    private JFrame frame;
    private JScrollPane scroll_activities;
    private Employee current_user;
    private Project current_project;
    private ArrayList<Project> allProjects = new ArrayList<Project>();
    private ArrayList<DevelopmentEmployee> assigned_devs = new ArrayList<DevelopmentEmployee>();
    private ArrayList<Activity> active_activities;
    private ArrayList<ButtonItem> activiy_buttons = new ArrayList<ButtonItem>();
    private JList buttonlist_visual;

    private ButtonItem backButton;
    private ButtonItem Assign_Projectleader;
    private ButtonItem add_activity = new ButtonItem(this, "Add new activity");


    public ProjectHomePage(ArrayList<Project> allProjects, Employee employee, Project project) {
        this.current_user = employee;
        this.current_project = project;
        this.active_activities = project.getActivities();
        this.assigned_devs = project.getDevsInProjects();
        this.allProjects = allProjects;

        this.setup();
    }

    public ProjectHomePage(ArrayList<Project> allProjects, ArrayList<Activity> new_active_activities, Employee employee, Project project){
        this.current_user = employee;
        this.current_project = project;
        this.current_project.setActivities(new_active_activities);
        this.active_activities = this.current_project.getActivities();
        this.assigned_devs = project.getDevsInProjects();
        this.allProjects = allProjects;

        this.setup();
    }

    public ProjectHomePage(ArrayList<Project> allProjects, ArrayList<Activity> new_active_activities, Employee employee, Project project, ProjectLeader projectleader){
        this.current_user = employee;
        this.current_project = project;
        this.active_activities = project.getActivities();
        this.assigned_devs = project.getDevsInProjects();
        this.allProjects = allProjects;

        try{
            if(this.current_user.getClass() == DevelopmentEmployee.class){
                DevelopmentEmployee tempDev = (DevelopmentEmployee) this.current_user;
                this.current_project.makeDevProjectleader(tempDev, this.current_project);
            }
        } catch (Exception e){
            System.out.println("Error: " + e);
        }

        this.setup();
    }

    public ProjectHomePage(ActivityPage activityPage){
        this.current_user = activityPage.getCurrentUser();
        this.current_project = activityPage.getProject();
        this.active_activities = activityPage.getProject().getActivities();
        this.assigned_devs = this.current_project.getDevsInProjects();
        this.allProjects = activityPage.getAllProjects();

        try{
            if(this.current_user.getClass() == DevelopmentEmployee.class){
                DevelopmentEmployee tempDev = (DevelopmentEmployee) this.current_user;
                this.current_project.makeDevProjectleader(tempDev, this.current_project);
            }
        } catch (Exception e){
            System.out.println("Error: " + e);
        }

        this.setup();
    }

    public void setup(){
        this.backButton = new ButtonItem(this.current_project.getDevsInProjects(), this.allProjects, this.current_project, "Back");

        for(Activity activity : this.active_activities){
            ButtonItem button = new ButtonItem(this, activity, activity.getName());

            this.activiy_buttons.add(button);
        }

        int array_len;

        if(current_user.getClass() == ProjectLeader.class) {
            array_len = activiy_buttons.size() + 2; //+1 for hver knap der tilføje
            button_list = new Object[array_len];
            button_list[0] = this.backButton;
            button_list[1] = add_activity;

            for (int i = 2; i < array_len; i++){
                button_list[i] = this.activiy_buttons.get(i - 2);
            }
        } else if (this.current_user.getClass() == DevelopmentEmployee.class){
            if (this.current_project.getProjectLeader() != null){
                array_len = activiy_buttons.size() + 1;
                button_list = new Object[array_len];
                button_list[0] = this.backButton;

                for (int i = 1; i < array_len; i++){
                    button_list[i] = this.activiy_buttons.get(i-1);
                }
            } else {
                array_len = activiy_buttons.size() + 2;
                this.Assign_Projectleader = new ButtonItem(this, (DevelopmentEmployee) this.current_user, "Assign projectleader" );
                button_list = new Object[array_len];
                button_list[0] = this.backButton;
                button_list[1] = this.Assign_Projectleader;

                for (int i = 2; i < array_len; i++){ // i er + 1 for hver nye knap der tilføjes
                    button_list[i] = this.activiy_buttons.get(i - 2);
                }
            }
        }

        buttonlist_visual = new JList(button_list);
        buttonlist_visual.setCellRenderer(new ButtonListRenderer());
        buttonlist_visual.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        buttonlist_visual.setVisibleRowCount(5);
        buttonlist_visual.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent event)
            {
                clickButtonAt(event.getPoint());
            }
        });

        frame = new JFrame("User: " + this.current_user.getInitials());
//        frame.add(label_projectname);
//        label_projectname.setText("Project name: " + this.current_project.getName() );

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.scroll_activities = new JScrollPane(buttonlist_visual);
        this.scroll_activities.setSize(new Dimension(500, 1000));
        frame.getContentPane().add(this.scroll_activities);
        frame.setResizable(false);
        frame.setSize(new Dimension(1000, 1000));

        frame.setVisible(true);
    }


    private void clickButtonAt(Point point)
    {
        int index = buttonlist_visual.locationToIndex(point);
        ButtonItem item = (ButtonItem) buttonlist_visual.getModel().getElementAt(index);
        item.getButton().doClick();
        frame.dispose();
    }

    public ArrayList<Activity> getActivities(){
        return active_activities;
    }

    public Employee getCurrentUser(){
        return current_user;
    }

    public Project getProject(){
        return current_project;
    }

    public ArrayList<Project> getAllProjects(){
        return this.allProjects;
    }

    public ArrayList<DevelopmentEmployee> getDevsInProject(){
        return this.assigned_devs;
    }

    public ProjectLeader getProjectLeader(){
        return this.current_project.getProjectLeader();
    }

}
