// importing java swing
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

// Now I will use my main method within the party gui class to display a gui
public class UseDinnerParty {
    // we are retrieving these from the class and the subclass
    private static int numGuests;

    // This is my main class
    public static void main(String[] args) {
        // creating a JFrame for the GUI
        JFrame frame = new JFrame("Please come to my party!");
        // Need to specific Exit on Close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        // Within the JFrame we can create specific JPanels to incorporate parts of program
        JPanel panel = new JPanel();

        // We will use JRadio Buttons as they seem best for the task
        String input = JOptionPane.showInputDialog(null, "Enter Number of Guests");
        numGuests = Integer.parseInt(input); // We need use the parse int for the GUI

        // Again now we will use a JRadio button to also get menu choices
        JRadioButton steak = new JRadioButton("Beef");
        JRadioButton chicken = new JRadioButton("Chicken");
        JRadioButton veg = new JRadioButton("Vegetarian");

        // Set action commands
        steak.setActionCommand("1");
        chicken.setActionCommand("2");
        veg.setActionCommand("3");

        // Now we will now use the button group method, this was new to me here is the documentation that I used
        // https://docs.oracle.com/javase/8/docs/api/javax/swing/ButtonGroup.html
        ButtonGroup group = new ButtonGroup();
        group.add(steak);
        group.add(chicken);
        group.add(veg);

        // Adding radio buttons to the panel
        panel.add(chicken);
        panel.add(steak);
        panel.add(veg);

        // Now create a continue button
        JButton continueButton = new JButton("Continue");
        // the Override button is crucial, acts like a break, or while statement in python
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // most important part of the program, here we see numGuests is being inherated
                DinnerParty dinnerParty = new DinnerParty(); // Create Instance
                dinnerParty.setNumGuests(numGuests); // this is where I implement my set and get methods

                // Check if a radio button has been selected
                if (group.getSelection() != null) {
                    // Here we enumerate "button" almost creating a defacto list that we can check
                        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
                            AbstractButton button = buttons.nextElement();
                            // break if button is continue button is selected
                            if (button.isSelected()) {
                                dinnerParty.setDinnerChoice(button.getText());
                                break;
                            }
                        }
                } else {
                    // Creativity: here we are excepting if nothing is selected
                    JOptionPane.showMessageDialog(null, "Please select a dinner option.");
                    return; // Exit the method acts like a break
                }

                // Now display chosen radioButton
                JOptionPane.showMessageDialog(null, "The dinner Party has " + dinnerParty.getNumGuests()+" guests \n Menu Options " + dinnerParty.getDinnerChoice());

                // Dispose of the Frame, aka close after chosen
                frame.dispose();
            }
        });
        // We now need to add the continue button to the pane
        panel.add(continueButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
