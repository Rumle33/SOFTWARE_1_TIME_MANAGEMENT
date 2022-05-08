package dtu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UsersPage {
    private ArrayList<ButtonItem> ButtonArrayList = new ArrayList<ButtonItem>();
    private ArrayList<Project> allProjects = new ArrayList<Project>();


    private JList list1;
    private ButtonItem add_emp = new ButtonItem(this, "Add new developmentemployee");
    private ButtonItem backButton;
    private Project current_project;
    private JPanel JpanelFORM;


    JFrame frame = new JFrame();

    public UsersPage(ArrayList<Project> allProjects, Project project){
        this.current_project = project;
        this.allProjects = allProjects;
        this.backButton = new ButtonItem(allProjects, "Back");

        this.setup();
    }

    public UsersPage(ArrayList<Project> allProjects, Project project, ArrayList<DevelopmentEmployee> new_devs){
        this.current_project = project;
        this.current_project.setDevsInProject(new_devs);
        this.allProjects = allProjects;
        this.backButton = new ButtonItem(allProjects, "Back");

        this.setup();
    }

    public void setup(){


        //Laver en liste af knapper med medarbejdere
        for(DevelopmentEmployee dev : this.current_project.getDevsInProjects()){
            ButtonItem button = new ButtonItem(this.allProjects, dev, dev.getInitials(), this.current_project);
            ButtonArrayList.add(button);
        }

        //Tilføjer en knap til at tilføje nye medarbejdere i toppen af listen
        int array_length = ButtonArrayList.size() + 1; // + 1 fordi back button skal være der som den sidste knap
        Object[] button_list = new Object[array_length + 1]; // + 1 fordi add employee skal være der som første knap
        button_list[0] = add_emp;
        for (int i = 1; i <= array_length; i++) {
            if(i == array_length){
                button_list[i] = backButton;
            } else {
            button_list[i] = ButtonArrayList.get(i-1);
            }
        }

        //Tilføjer listen til en JList, så den kan interageres med
        this.list1 = new JList(button_list);
        list1.setCellRenderer(new ButtonListRenderer());
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setVisibleRowCount(5);
        list1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent event)
            {
                clickButtonAt(event.getPoint());
            }
        });
        frame.setMinimumSize(new Dimension(500,1000));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scroll_pane = new JScrollPane(list1);
        scroll_pane.setPreferredSize(new Dimension(500,1000));
        frame.getContentPane().add(scroll_pane);
        frame.pack(); //Denne her laver fejl når man instantierer klassen fra AddDevForm
        frame.setResizable(false);
        frame.setSize(1000,1000);
        frame.add(JpanelFORM);
        frame.setVisible(true);
    }

    private void clickButtonAt(Point point)
    {
        int index = list1.locationToIndex(point);
        ButtonItem item = (ButtonItem) list1.getModel().getElementAt(index);
        item.getButton().doClick();
        frame.dispose();
    }

    public Project getProject(){
        return this.current_project;
    }

    public ArrayList<Project> getAllProjects(){
        return this.allProjects;
    }

    public ArrayList<DevelopmentEmployee> getDevs(){
        return this.current_project.getDevsInProjects();
    }

}


