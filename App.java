package Com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    //Calculate button
    private JButton calcbutton;
    //miles textfield
    private JTextField miletext;
    //reset button
    private JButton resetbutton;
    private JLabel milefield;
    private JPanel panel1;
    //display cost
    private JLabel display;

    public App() {
        calcbutton.addActionListener(new ActionListener() {
            @Override
            //calculate Listener
            public void actionPerformed(ActionEvent e) {
                //set flat value 2.80$
                double flat = 2.80;
                //inti miles to 0
                double miles = 0.0;
                //inti total to 0
                double total = 0.0;
                String milesstring;
                //get input from user from the field
                milesstring = miletext.getText();
                try {
                    //try to change string to double
                    miles =  Double.parseDouble(milesstring);
                    } catch (NumberFormatException er) {
                    //if failed send an error massage because the miles is not numeric
                    JOptionPane.showMessageDialog(panel1, "Error,miles not numeric.");
                }
                //calc total
                total = flat + (miles * 1.80);
                //show it in the display label
                display.setText(Double.toString(total));


            }
        });
        resetbutton.addActionListener(new ActionListener() {
            @Override
            //reset button listener
            public void actionPerformed(ActionEvent e) {
                //empty the 2 input strings
                display.setText("");
                miletext.setText("");
            }
        });
    }
//main function
    public static void main(String[] args) {
        //sent frame
        JFrame jframe = new JFrame("App");
        //add frame to app
        jframe.setContentPane(new App().panel1);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();
        //set is as visible
        jframe.setVisible(true);
    }
}
