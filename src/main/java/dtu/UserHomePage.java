package dtu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UserHomePage extends GUIApplication{

    private JFrame frame;
    private ArrayList<Project> active_projects;
    private ArrayList<ButtonItem> project_buttons;
    private JList buttonlist_visual;

    public UserHomePage(Employee employee){
        this.active_projects = employee.getProjects();

        for(Project project : this.active_projects){
            ButtonItem button = new ButtonItem(project.getName());
            project_buttons.add(button);
        }

        buttonlist_visual = new JList(project_buttons.toArray());
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
        frame = new JFrame("user " + employee.getInitials());
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(buttonlist_visual));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void clickButtonAt(Point point)
    {
        int index = buttonlist_visual.locationToIndex(point);
        ButtonItem item = (ButtonItem) buttonlist_visual.getModel().getElementAt(index);
        item.getButton().doClick();
    }

}