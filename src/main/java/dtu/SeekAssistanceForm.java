//Anders

package dtu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SeekAssistanceForm {

    private JFrame frame;
    private ArrayList<ButtonItem> dev_buttons = new ArrayList<ButtonItem>();
    private JList buttonlist_visual;
    private JScrollPane scrollPane;
    private ArrayList<DevelopmentEmployee> devsInProject = new ArrayList<DevelopmentEmployee>();
    private ActivityPage activityPage;

    public SeekAssistanceForm(ActivityPage activityPage) {
        this.devsInProject = activityPage.getDevsInProject();
        this.activityPage = activityPage;
        this.setup();
    }

    public void setup(){
        for(DevelopmentEmployee dev : this.devsInProject){
            ButtonItem button = new ButtonItem(this.activityPage, dev, dev.getInitials(), "SeekAssistanceForm");
            this.dev_buttons.add(button);
        }

        buttonlist_visual = new JList(dev_buttons.toArray());
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

    //Denne metode tjekker om knapper bliver trykket på
    private void clickButtonAt(Point point)
    {
        int index = buttonlist_visual.locationToIndex(point);
        ButtonItem item = (ButtonItem) buttonlist_visual.getModel().getElementAt(index);
        item.getButton().doClick();
        frame.dispose();
    }

}
