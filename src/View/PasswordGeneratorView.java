package View;

import Controller.PasswordGeneratorController;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import javax.swing.*;

public class PasswordGeneratorView extends JFrame {
    private JLabel passwordLabel;
    private JTextField passwordField;
    private JButton generateButton;
    private JLabel lengthLabel;
    private JSpinner lengthSpinner;
    private PasswordGeneratorController controller;

    public PasswordGeneratorView(PasswordGeneratorController controller) {
        this.controller = controller;

        // Set up the UI
        setTitle("Password Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // Set window icon
        ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"/"+"resources/frame_icon.jpg");
        setIconImage(icon.getImage());

        // Disable window maximize
        setResizable(false);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Password label and field
        passwordLabel = new JLabel("Generated Password:");
        passwordField = new JTextField(20);
        passwordField.setEditable(false);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (passwordField.getText().length() > 0) {
                    StringSelection selection = new StringSelection(passwordField.getText());
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(selection, null);
                }
            }
        });

        // Generate button
        generateButton = new JButton("Generate");
        generateButton.setBackground(new Color(60, 179, 113));
        generateButton.setForeground(Color.WHITE);
        generateButton.setFont(new Font("Arial", Font.BOLD, 18));
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int length = (Integer) lengthSpinner.getValue();
                controller.generatePassword(length);
            }
        });

        // Length label and spinner
        lengthLabel = new JLabel("Password Length:");
        lengthLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        SpinnerNumberModel lengthModel = new SpinnerNumberModel(12, 6, 128, 1);
        lengthSpinner = new JSpinner(lengthModel);
        lengthSpinner.setFont(new Font("Arial", Font.PLAIN, 18));

        // Add components to the frame
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(lengthLabel);
        panel.add(lengthSpinner);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // empty label for layout
        panel.add(generateButton);
        add(panel, BorderLayout.CENTER);
    }

    public void setPassword(String password) {
        passwordField.setText(password);
    }
}
