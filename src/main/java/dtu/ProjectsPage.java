package dtu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ProjectsPage implements Runnable {

    private JFrame frame;
    private ArrayList<Project> active_projects = new ArrayList<Project>();
    private ArrayList<ButtonItem> project_buttons = new ArrayList<ButtonItem>();
    private JList buttonlist_visual;
    private JScrollPane scrollPane;
    private ButtonItem add_project = new ButtonItem(this, "Add new project");
    private Object[] button_list;

    public ProjectsPage() {

    }

    public ProjectsPage(ArrayList<Project> new_projects){
        this.active_projects = new_projects;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ProjectsPage());
    }

    @Override
    public void run() {

    }

    public void setup(){
        for(Project project : this.active_projects){
            ButtonItem button = new ButtonItem(project, project.getName());
            this.project_buttons.add(button);
        }

        int array_len;
        array_len = project_buttons.size();
        button_list = new Object[array_len + 1];
        button_list[0] = add_project;
        for (int i = 1; i <= array_len; i++){
            button_list[i] = this.project_buttons.get(i-1);
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
        frame = new JFrame("Active projects");

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

    public ArrayList<Project> getProjects(){
        return active_projects;
    }

}
