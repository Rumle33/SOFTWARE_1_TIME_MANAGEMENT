package dtu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AcceptAssistanceForm {

    private JFrame frame;
    private ArrayList<ButtonItem> activity_buttons = new ArrayList<ButtonItem>();
    private JList buttonlist_visual;
    private JScrollPane scrollPane;
    private ActivityPage activityPage;
    private ArrayList<Activity> assistingActivities;

    public AcceptAssistanceForm(ActivityPage activityPage) {
        this.activityPage = activityPage;
        this.setup();
    }

    public void setup(){
        for(Activity activity : this.activityPage.getCurrentUser().getAssistingActivities()){
            ButtonItem button = new ButtonItem(this.activityPage, activity, activity.getName());
            this.activity_buttons.add(button);
        }

        buttonlist_visual = new JList(activity_buttons.toArray());
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
        frame = new JFrame("Devs in project");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.scrollPane = new JScrollPane(buttonlist_visual);
        frame.getContentPane().add(this.scrollPane);
        frame.setResizable(false);
        frame.setSize(1000,1000);
        frame.setVisible(true);

    }

    private void clickButtonAt(Point point)
    {
        int index = buttonlist_visual.locationToIndex(point);
        ButtonItem item = (ButtonItem) buttonlist_visual.getModel().getElementAt(index);
        item.getButton().doClick();
        frame.dispose();
    }

}
