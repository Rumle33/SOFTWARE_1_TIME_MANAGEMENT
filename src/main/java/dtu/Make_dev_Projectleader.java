//Christian

package dtu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Make_dev_Projectleader {

        public ArrayList<Employee> Emp = new ArrayList<Employee>();
        private ArrayList<ButtonItem> ButtonArrayList = new ArrayList<ButtonItem>();

        private JList list1;

        JFrame frame = new JFrame();

        public Make_dev_Projectleader(){

        }


        public void setup(){

            //Laver en liste af knapper med medarbejdere
            for(Employee employee : this.Emp){
                ButtonItem button = new ButtonItem(employee, employee.getInitials());
                ButtonArrayList.add(button);
            }

            //Tilføjer listen til en JList, så den kan interageres med
            this.list1 = new JList(ButtonArrayList.toArray());
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

            frame.setVisible(true);
        }

    //Denne metode tjekker om knapper bliver trykket på
        private void clickButtonAt(Point point)
        {
            int index = list1.locationToIndex(point);
            ButtonItem item = (ButtonItem) list1.getModel().getElementAt(index);
            item.getButton().doClick();
            frame.dispose();
        }

    }


