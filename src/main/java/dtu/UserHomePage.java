package dtu;

import javax.swing.*;
import java.util.ArrayList;

public class UserHomePage extends GUIApplication{
    private  JList list1;
    private  JList list2;
    //  private ArrayList<> Users = new ArrayList<>();
    JFrame frame = new JFrame("Time management application");

    public  void GUI(){


      // UserHomePage(){

            frame.setSize(300,300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
          //  frame.add(list1);







    }
    // Noget med at lave en liste af alle users og en tilsvarende --
    // -- liste i GUIApplication, hvor der bliver --
    // --lavet en ny knap pr user.

    // Det kan være der skal være en metode, som --
    // --både laver og tilføjer en ny knap til 'knap-listen' og--
    // --laver og tilføjer en ny user til 'user-listen'
    // Held og lykke
}