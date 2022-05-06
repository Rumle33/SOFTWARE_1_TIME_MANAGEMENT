package dtu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ProjectHomePage {

    private JTextField project_textfield;
    private JScrollPane scroll_activities;
    private JScrollPane scroll_employees;
    private JLabel label_projectname;
    private JFrame frame;
    private Employee current_user;
    private Project current_project;
    private ArrayList<DevelopmentEmployee> assigned_devs = new ArrayList<DevelopmentEmployee>();
    private ArrayList<Activity> active_activities;
    private ArrayList<ButtonItem> activiy_buttons = new ArrayList<ButtonItem>();
    private JList buttonlist_visual;

    private ButtonItem add_activity = new ButtonItem(this, "Add new activity");

    public ProjectHomePage(ArrayList<Activity> new_active_projects, Employee employee, Project project){
        this.current_user = employee;
        this.current_project = project;
        this.active_activities = project.getActivities();
        this.assigned_devs = project.getDevsInProjects();

        this.setup();
    }

    public ProjectHomePage(Employee employee, Project project) {
        this.current_user = employee;
        this.current_project = project;
        this.active_activities = project.getActivities();
        this.assigned_devs = project.getDevsInProjects();

        this.setup();
    }

    public void setup(){
        for(Activity activity : this.active_activities){
            ButtonItem button = new ButtonItem(activity, activity.getName());
            this.activiy_buttons.add(button);
        }

        int array_len;
        if (this.activiy_buttons.size() <= 0){
            array_len = 0;
        } else {
            array_len = activiy_buttons.size();
        }
        Object[] button_list = new Object[array_len + 1];
        button_list[0] = add_activity;

        for (int i = 1; i <= array_len; i++){
            button_list[i] = this.activiy_buttons.get(i-1);
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
        frame.add(label_projectname);
        label_projectname.setText("Project name: " + this.current_project.getName() );
        frame.setMinimumSize(new Dimension(1000,1000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.scroll_activities = new JScrollPane(buttonlist_visual);
        frame.getContentPane().add(new JScrollPane(this.scroll_activities));
        frame.setResizable(false);
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

}
