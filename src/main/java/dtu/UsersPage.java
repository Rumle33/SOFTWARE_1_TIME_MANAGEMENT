package dtu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UsersPage {
    private ArrayList<DevelopmentEmployee> devs = new ArrayList<DevelopmentEmployee>();
    private ArrayList<ButtonItem> ButtonArrayList = new ArrayList<ButtonItem>();

    private JList list1;
    private ButtonItem add_emp = new ButtonItem(this, "Add new developmentemployee");
    private ButtonItem BACKBUTTON;
    private Project current_project;
    private JPanel JpanelFORM;


    JFrame frame = new JFrame();

    public UsersPage(Project project){
        this.current_project = project;

        this.setup();
    }

    public UsersPage(Project project, ArrayList<DevelopmentEmployee> new_devs){
        this.current_project = project;
        this.devs = new_devs;

        this.setup();
    }

    public void setup(){


        //Laver en liste af knapper med medarbejdere
        for(DevelopmentEmployee dev : this.devs){
            ButtonItem button = new ButtonItem(dev, dev.getInitials(), this.current_project);
            ButtonArrayList.add(button);
        }

        //Tilføjer en knap til at tilføje nye medarbejdere i toppen af listen
        int array_length = ButtonArrayList.size();
        Object[] button_list = new Object[array_length + 1];
        button_list[0] = add_emp;
        for (int i = 1; i <= array_length; i++) {
            button_list[i] = ButtonArrayList.get(i-1);
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
        frame.pack();
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

    public ArrayList<DevelopmentEmployee> getDevs(){
        return this.devs;
    }

}


