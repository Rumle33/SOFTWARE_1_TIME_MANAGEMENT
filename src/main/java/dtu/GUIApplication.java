package dtu;
import javax.swing.*;
import java.util.ArrayList;

public class GUIApplication implements Runnable {
    private ArrayList<Employee> Emp = new ArrayList<Employee>();
    private ArrayList<ButtonItem> ButtonArrayList = new ArrayList<ButtonItem>();

    public JPanel panel1;
    private JList list1;
    private JButton CasperButton;

    JFrame frame = new JFrame("Time management application");

    GUIApplication() {
        frame.setSize(1000, 1000);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel1);
        frame.getContentPane().add(new JScrollPane(list1));
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setVisibleRowCount(5);
        list1.setCellRenderer(new ButtonListRenderer());
        frame.add(list1);
        //frame.add(CasperButton);

        frame.setVisible(true);
    }

    public void run(){
        Project Pro = new Project("SOFTWARE");
        ProjectLeader casper = new ProjectLeader(Pro, "Casp");
        Emp.add(casper);



        for(Employee employee : this.Emp){
            ButtonItem button = new ButtonItem(employee.getInitials());
            ButtonArrayList.add(button);

        }
        list1 = new JList( ButtonArrayList.toArray());

        }

    }


