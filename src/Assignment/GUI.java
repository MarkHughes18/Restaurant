package Assignment;
//importing the libraries for the gui
import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUI extends JFrame
{
    public GUI()
    {
        //creating a frame for the gui
        JFrame frame = new JFrame("Online Restaurant");
        frame.setSize(500, 500);
        frame.setLocation(100,100);

        //creating a window for the gui
        JWindow window = new JWindow();
        window.setSize(7000, 7000);
        window.setLocation(100,100);

        //creating a panels for the gui
        //header panel for the gui
        JPanel top = new JPanel();
        top.setBorder(new TitledBorder("Online Restaurant"));
        this.add(top, BorderLayout.NORTH);

        //ordering panel for the gui
        JPanel left = new JPanel();
        left.setBorder(new TitledBorder("Ordering"));
        this.add(left, BorderLayout.WEST);

        //serving panel for the gui
        JPanel right = new JPanel();
        right.setBorder(new TitledBorder("Serving"));
        this.add(right, BorderLayout.EAST);

        //button panel for the gui
        JPanel bottom = new JPanel();
        this.add(bottom, BorderLayout.SOUTH);
        bottom.setBorder(new BevelBorder(BevelBorder.RAISED));

        //creating a label for the gui
        JLabel label1 = new JLabel("Welcome to the Online Restaurant");
        JLabel label2 = new JLabel("Dish");
        JLabel label3 = new JLabel("Table Number");

        //creating a text field for the gui
        JTextField dish = new JTextField(20);

        //creating a text area for the gui
        JTextArea area = new JTextArea(20, 20);

        //creating a spinner for the gui
        JSpinner tableNumber = new JSpinner();  

        //creating a button for the gui
        JButton order = new JButton("Order");
        //adding an action listener to the button to allow the button to intake the information from the text field and spinner
        order.addActionListener
        (new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //retrieving the information from the text field and spinner
                String item = dish.getText();
                int table = (int)tableNumber.getValue();
                Dish newDish = new Dish(table, item);
                Restaurant restaurant = new Restaurant();
                restaurant.addDish(newDish);
            }
        }
        );

        //adding the labels to the panels
        top.add(label1);
        left.add(label2);
        left.add(dish);
        left.add(label3);
        left.add(tableNumber);
        bottom.add(order);
        right.add(area);
    }
    
    //main method to run the gui
    public static void main(String[] args)
    {
        GUI gui = new GUI();
        gui.pack();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
}
