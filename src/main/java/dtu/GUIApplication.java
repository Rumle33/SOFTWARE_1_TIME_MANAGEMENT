package dtu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GUIApplication implements Runnable {
    private ArrayList<Employee> Emp = new ArrayList<Employee>();
    private ArrayList<ButtonItem> ButtonArrayList = new ArrayList<ButtonItem>();

    private JList list1;

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new GUIApplication());
    }

    public void run(){

        Project Pro = new Project("SOFTWARE");
        ProjectLeader casper = new ProjectLeader(Pro, "Casp");
        Emp.add(casper);
        DevelopmentEmployee Jens = new DevelopmentEmployee ("Jens");
        Emp.add(Jens);

        for(Employee employee : this.Emp){
            ButtonItem button = new ButtonItem(employee.getInitials());
            ButtonArrayList.add(button);

        }
        this.list1 = new JList( ButtonArrayList.toArray());
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
        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(list1));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void clickButtonAt(Point point)
    {
        int index = list1.locationToIndex(point);
        ButtonItem item = (ButtonItem) list1.getModel().getElementAt(index);
        item.getButton().doClick();
    }
}


