import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeCalculatorFrame extends JFrame {
    private JTextField amountField;
    private JTextField tooniesField;
    private JTextField looniesField;
    private JTextField quartersField;
    private JTextField dimesField;
    private JTextField nickelsField;
    private JTextField penniesField;
    
    public ChangeCalculatorFrame() {
        super("Change Calculator");
        setLayout(new GridLayout(8, 2, 5, 5));
        
        // i row
        add(new JLabel("Enter amount: $"));
        amountField = new JTextField(10);
        add(amountField);
        
        // calc button row
        JButton calculateButton = new JButton("Calculate Change");
        calculateButton.addActionListener(new CalculateButtonListener());
        add(new JLabel("")); // Empty cell
        add(calculateButton);
        
        // output rows
        add(new JLabel("Toonies ($2): "));
        tooniesField = new JTextField(10);
        tooniesField.setEditable(false);
        add(tooniesField);
        

        // coins
        add(new JLabel("Loonies ($1): "));
        looniesField = new JTextField(10);
        looniesField.setEditable(false);
        add(looniesField);
        
        add(new JLabel("Quarters ($0.25): "));
        quartersField = new JTextField(10);
        quartersField.setEditable(false);
        add(quartersField);
        
        add(new JLabel("Dimes ($0.10): "));
        dimesField = new JTextField(10);
        dimesField.setEditable(false);
        add(dimesField);
        
        add(new JLabel("Nickels ($0.05): "));
        nickelsField = new JTextField(10);
        nickelsField.setEditable(false);
        add(nickelsField);
        
        add(new JLabel("Pennies ($0.01): "));
        penniesField = new JTextField(10);
        penniesField.setEditable(false);
        add(penniesField);
    }
    
    class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double amount = Double.parseDouble(amountField.getText());
            
            // make sure amount is non-negative
            if (amount < 0) {
                JOptionPane.showMessageDialog(null, 
                    "please enter a positive amount", 
                    "Invalid Input", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Convert to cents and truncate to 2 decimal places
            int cents = (int)(amount * 100);
            
            int toonies = cents / 200;
            cents %= 200;
            
            int loonies = cents / 100;
            cents %= 100;
            
            int quarters = cents / 25;
            cents %= 25;
            
            int dimes = cents / 10;
            cents %= 10;
            
            int nickels = cents / 5;
            cents %= 5;
            
            int pennies = cents;
            
            // Display results
            tooniesField.setText(String.valueOf(toonies));
            looniesField.setText(String.valueOf(loonies));
            quartersField.setText(String.valueOf(quarters));
            dimesField.setText(String.valueOf(dimes));
            nickelsField.setText(String.valueOf(nickels));
            penniesField.setText(String.valueOf(pennies));
        }
    }
}