import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaGUI extends JFrame{
    private JPanel Main;
    private JTextField Nametxt;
    private JButton lavProjektButton;

    public JavaGUI(){
        lavProjektButton.addActionListener(new ActionListener() {
            String Name = Nametxt.getText();
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"you project " + Name + "has been created");
            }
        });
    }

    public static void main(String args[]){
        JavaGUI j = new JavaGUI();
        j.setContentPane(new JavaGUI().Main);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setPreferredSize(new Dimension(1200, 1000));
        j.pack();
        j.setVisible(true);



    }
}
