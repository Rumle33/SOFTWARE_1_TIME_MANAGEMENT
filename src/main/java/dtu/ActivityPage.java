package dtu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextField timeEstimateField;
    private JTextField expectedHoursField;
    private JFrame frame = new JFrame();
    private Activity activity;

    private Employee current_user;

    public ActivityPage(Activity activity, ProjectHomePage projectHomePage){
        this.activity = activity;
        this.current_user = projectHomePage.getCurrentUser();
        this.setup();
    }

    public void setup(){
        registerHours.addActionListener(this);
        seekAssistance.addActionListener(this);
        acceptAssistance.addActionListener(this);
        setTimeEstimate.addActionListener(this);
        assignNewDevelopmentemployee.addActionListener(this);
        setExpectedHours.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.add(registerHours);
        frame.add(seekAssistance);
        frame.add(acceptAssistance);

        if (this.current_user.getClass() == ProjectLeader.class){
            frame.add(setTimeEstimate);
            frame.add(assignNewDevelopmentemployee);
            frame.add(setExpectedHours);

            setTimeEstimate.setBounds(500, 150, 500, 50);
            timeEstimateField.setBounds(0, 150, 500, 50);
            assignNewDevelopmentemployee.setBounds(0, 200, 1000, 50);
            setExpectedHours.setBounds(500, 250, 500, 50);
            expectedHoursField.setBounds(0, 250, 500, 50);

            setTimeEstimate.setVisible(true);
            timeEstimateField.setVisible(true);
            assignNewDevelopmentemployee.setVisible(true);
            setExpectedHours.setVisible(true);
            expectedHoursField.setVisible(true);
        } else {
            setTimeEstimate.setVisible(false);
            timeEstimateField.setVisible(false);
            assignNewDevelopmentemployee.setVisible(false);
            setExpectedHours.setVisible(false);
            expectedHoursField.setVisible(false);
        }

        registerHours.setBounds(500,0,500,50);
        registerHoursField.setBounds(0, 0, 500, 50);

        seekAssistance.setBounds(0,50,1000,50);
        acceptAssistance.setBounds(0,100,1000,50);
        frame.add(panel1);
        frame.setResizable(false);
        frame.setSize(1000,1000);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerHours){
            frame.dispose();
        } else if (e.getSource() == acceptAssistance) {
            frame.dispose();
        } else if (e.getSource() == setTimeEstimate) {
            frame.dispose();
        } else if (e.getSource() == assignNewDevelopmentemployee) {
            frame.dispose();
        } else if (e.getSource() == setExpectedHours) {
            frame.dispose();
        }

    }
}
