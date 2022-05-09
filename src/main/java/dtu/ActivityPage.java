//Anders

package dtu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActivityPage implements ActionListener {
    private JButton registerHours;
    private JButton seekAssistance;
    private JButton acceptAssistance;
    private JButton setTimeEstimate;
    private JButton assignNewDevelopmentemployee;
    private JButton setExpectedHours;
    private JPanel panel1;
    private JTextField registerHoursField;
    private JLabel infoLabel;
    private JTextField startDateField;
    private JTextField expectedHoursField;
    private JTextField endDateField;
    private JButton backButton;
    private JFrame frame = new JFrame();
    private Activity activity;
    private Project project;

    private Employee current_user;
    private ArrayList<DevelopmentEmployee> devsInProject;
    private ArrayList<DevelopmentEmployee> devsInActivity = new ArrayList<DevelopmentEmployee>();
    private ArrayList<Project> allProjects = new ArrayList<Project>();

    public ActivityPage(Activity activity, ProjectHomePage projectHomePage){
        this.devsInProject = projectHomePage.getDevsInProject();
        this.activity = activity;
        this.project = projectHomePage.getProject();
        this.current_user = projectHomePage.getCurrentUser();
        this.allProjects = projectHomePage.getAllProjects();
        this.setup();
    }

    public ActivityPage(ActivityPage activityPage){
        this.allProjects = activityPage.getAllProjects();
        this.devsInProject = activityPage.getDevsInProject();
        this.devsInActivity = activityPage.getDevsInActivity();
        this.activity = activityPage.activity;
        this.current_user = activityPage.getCurrentUser();
        this.setup();
    }

    public void setup(){
        this.infoLabel.setText("Aktivitet: " + this.activity.getName() + ". Hours worked: " + this.activity.getHoursWorked() + " out of " + this.activity.getEstimatedTime()
        + ". Start date: " + this.activity.getStartDate() + ". End date: " + this.activity.getEndDate());
        registerHours.addActionListener(this);
        seekAssistance.addActionListener(this);
        acceptAssistance.addActionListener(this);
        setTimeEstimate.addActionListener(this);
        assignNewDevelopmentemployee.addActionListener(this);
        setExpectedHours.addActionListener(this);
        backButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        //Fjern nogle knapper hvis ikke brugeren er projectleader
        if (this.current_user.getClass() != ProjectLeader.class){
            panel1.remove(assignNewDevelopmentemployee);
            panel1.remove(setExpectedHours);
            panel1.remove(setTimeEstimate);
            panel1.remove(expectedHoursField);
            panel1.remove(startDateField);
            panel1.remove(endDateField);
        }

        frame.add(panel1);
        frame.setResizable(false);
        frame.setSize(1000,1000);

        frame.setVisible(true);
    }

    //Styrer hvad der sker når der bliver trykket på en knap
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == assignNewDevelopmentemployee) {

            AssignNewDev assignNewDev = new AssignNewDev(this);
            frame.dispose();


        } else if (e.getSource() == seekAssistance) {

            SeekAssistanceForm seekAssistanceForm = new SeekAssistanceForm(this);
            frame.dispose();

        } else if (e.getSource() == acceptAssistance) {

            AcceptAssistanceForm acceptAssistanceForm = new AcceptAssistanceForm(this);
            frame.dispose();

        } else if (e.getSource() == backButton){

            ProjectHomePage projectHomePage = new ProjectHomePage(this);
            frame.dispose();

        } else if (e.getSource() == registerHours){
            try {
                Double hours = Double.parseDouble(registerHoursField.getText());
                this.activity.addHoursWorked(hours);
            } catch (Exception exception) {
                System.out.println("Indtast et decimaltal");
            }
            this.infoLabel.setText("Aktivitet: " + this.activity.getName() + ". Hours worked: " + this.activity.getHoursWorked() + " out of " + this.activity.getEstimatedTime()
                    + ". Start date: " + this.activity.getStartDate() + ". End date: " + this.activity.getEndDate());

        } else if (e.getSource() == setTimeEstimate) {

            if (startDateField.getText() != null){
                this.activity.setStartDate(startDateField.getText());
            }
            if (endDateField.getText() != null){
                this.activity.setEndDate(endDateField.getText());
            }
            this.infoLabel.setText("Aktivitet: " + this.activity.getName() + ". Hours worked: " + this.activity.getHoursWorked() + " out of " + this.activity.getEstimatedTime()
            + ". Start date: " + this.activity.getStartDate() + ". End date: " + this.activity.getEndDate());

        } else if (e.getSource() == setExpectedHours) {

            try {
                Double hours = Double.parseDouble(expectedHoursField.getText());
                this.activity.setEstimatedTime(hours);
            } catch (Exception exception) {
                System.out.println("Indtast et decimaltal");
            }
            this.infoLabel.setText("Aktivitet: " + this.activity.getName() + ". Hours worked: " + this.activity.getHoursWorked() + " out of " + this.activity.getEstimatedTime()
                    + ". Start date: " + this.activity.getStartDate() + ". End date: " + this.activity.getEndDate());
        }

    }

    public ArrayList<DevelopmentEmployee> getDevsInProject(){
        return this.devsInProject;
    }

    public void addDevToActivity(DevelopmentEmployee dev){
        this.devsInActivity.add(dev);
    }

    public Employee getCurrentUser(){
        return this.current_user;
    }

    public ArrayList<DevelopmentEmployee> getDevsInActivity(){
        return this.devsInActivity;
    }

    public Project getProject(){
        return this.project;
    }

    public Activity getActivity(){
        return this.activity;
    }

    public ArrayList<Project> getAllProjects(){
        return this.allProjects;
    }
}
