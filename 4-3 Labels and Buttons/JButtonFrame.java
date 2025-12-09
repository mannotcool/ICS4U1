import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class JButtonFrame extends JFrame {

    private JButton xButton;
    private JButton checkButton;
    private JLabel counterLabel;

    private int xCount = 0;
    private int checkCount = 0;

    public JButtonFrame() {

        super("JButton Demo");
        setLayout(new FlowLayout());

        counterLabel = new JLabel("students failed: " + xCount + " students passed: " + checkCount);
        add(counterLabel);

        ImageIcon xIcon = new ImageIcon("redx.png");
        ImageIcon scaledXIcon = new ImageIcon(xIcon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));

        ImageIcon checkIcon = new ImageIcon("checkmark.jpg");
        ImageIcon scaledCheckIcon = new ImageIcon(checkIcon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));

        xButton = new JButton(scaledXIcon);
        checkButton = new JButton(scaledCheckIcon);

        add(xButton);
        add(checkButton);

        // Listener
        ButtonEventListener buttonListener = new ButtonEventListener();

        xButton.addActionListener(buttonListener);
        checkButton.addActionListener(buttonListener);
    }

    private class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == xButton) {
                xCount++;
            } else if (event.getSource() == checkButton) {
                checkCount++;
            }

            counterLabel.setText("students failed: " + xCount + " students passed: " + checkCount);
        }
    }
}