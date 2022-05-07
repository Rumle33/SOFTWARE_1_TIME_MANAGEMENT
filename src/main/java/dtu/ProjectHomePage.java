package dtu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ProjectHomePage implements ActionListener {
    private Object[] button_list;
    private JTextField project_textfield;
    private JScrollPane scroll_activities;
    private JScrollPane scroll_employees;
    private JLabel label_projectname;
    private JButton ASSprojectleader;
    private JFrame frame;
    private Employee current_user;
    private Project current_project;
    private ArrayList<DevelopmentEmployee> assigned_devs = new ArrayList<DevelopmentEmployee>();
    private ArrayList<Activity> active_activities;
    private ArrayList<ButtonItem> activiy_buttons = new ArrayList<ButtonItem>();
    private JList buttonlist_visual;

    private ButtonItem add_activity = new ButtonItem(this, "Add new activity");

    public ProjectHomePage(Employee employee, Project project) {
        this.current_user = employee;
        this.current_project = project;
        this.active_activities = project.getActivities();
        this.assigned_devs = project.getDevsInProjects();

        this.setup();
    }

    public ProjectHomePage(ArrayList<Activity> new_active_activities, Employee employee, Project project){
        this.current_user = employee;
        this.current_project = project;
        this.active_activities = project.getActivities();
        this.assigned_devs = project.getDevsInProjects();

        this.setup();
    }

    public ProjectHomePage(ArrayList<Activity> new_active_activities, Employee employee, Project project,ProjectLeader projectleader){
        this.current_user = employee;
        this.current_project = project;
        this.active_activities = project.getActivities();
        this.assigned_devs = project.getDevsInProjects();

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


        if(current_user.getClass() == ProjectLeader.class) {
            button_list = new Object[array_len + 1];
            button_list[0] = add_activity;
            for (int i = 1; i <= array_len; i++){
                button_list[i] = this.activiy_buttons.get(i-1);
            }
        } else if(array_len < 0) {
            button_list = new Object[array_len];
            for (int i = 0; i <= array_len; i++){
                button_list[i] = this.activiy_buttons.get(i);
            }
        }
        button_list = new Object[array_len];

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

        frame.add(ASSprojectleader);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ASSprojectleader) {
            frame.dispose();
            Make_dev_Projectleader Leader = new Make_dev_Projectleader();
            Leader.setup();
        };
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

}
