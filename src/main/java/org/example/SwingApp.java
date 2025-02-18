package org.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingApp extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    String savedUsername = "";
    String savedEmail = "";
    String savedPhone = "";

    public SwingApp() {
        setTitle("Java Swing Application");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem userFormMenuItem = new JMenuItem("User");
        JMenuItem loginMenuItem = new JMenuItem("Login");
        JMenuItem aboutMenuItem = new JMenuItem("About Us");
        JMenuItem secretWordMenuItem = new JMenuItem("Secret Word");

        menu.add(userFormMenuItem);
        menu.add(loginMenuItem);
        menu.add(aboutMenuItem);
        menu.add(secretWordMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("Welcome to the Home Page"));

        JPanel userFormPanel = createUserFormPanel();
        JPanel loginPanel = createLoginPanel();
        JPanel aboutPanel = createAboutPanel();

        mainPanel.add(homePanel, "Home");
        mainPanel.add(userFormPanel, "UserForm");
        mainPanel.add(loginPanel, "Login");
        mainPanel.add(aboutPanel, "About");

        add(mainPanel);

        userFormMenuItem.addActionListener(e -> cardLayout.show(mainPanel, "UserForm"));
        loginMenuItem.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        aboutMenuItem.addActionListener(e -> cardLayout.show(mainPanel, "About"));

        secretWordMenuItem.addActionListener(e -> openSecretWordPanel());

        cardLayout.show(mainPanel, "Home");
    }

    public JPanel createUserFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(15);
        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField(15);
        JButton saveButton = new JButton("Save");

        gbc.gridx = 0; gbc.gridy = 0; panel.add(userLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(userField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(emailLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(emailField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(phoneLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(phoneField, gbc);
        gbc.gridx = 1; gbc.gridy = 4; panel.add(saveButton, gbc);

        saveButton.addActionListener(e -> {
            savedUsername = userField.getText();
            savedEmail = emailField.getText();
            savedPhone = phoneField.getText();
            JOptionPane.showMessageDialog(null, "User Data Saved!");
        });
        return panel;
    }

    public JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");
        JTextArea userInfoArea = new JTextArea(5, 25);
        userInfoArea.setEditable(false);

        gbc.gridx = 0; gbc.gridy = 0; panel.add(userLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(userField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(passLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(passField, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(loginButton, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; panel.add(new JScrollPane(userInfoArea), gbc);

        loginButton.addActionListener(e -> {
            userInfoArea.setText("User Details:\n");
            userInfoArea.append("Username: " + savedUsername + "\n");
            userInfoArea.append("Email: " + savedEmail + "\n");
            userInfoArea.append("Phone: " + savedPhone + "\n");
        });
        return panel;
    }

    public JPanel createAboutPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel textLabel = new JLabel("<html><h3>About Us</h3><p>We strive for excellence through unity and teamwork. Together, we believe in achieving perfection and delivering great work. Join us in creating something truly outstanding!</p></html>", SwingConstants.CENTER);
        textLabel.setOpaque(true);
        textLabel.setBackground(new Color(255, 255, 255, 200));
        textLabel.setPreferredSize(new Dimension(500, 100));
        textLabel.setBackground(Color.WHITE); // Solid white background
        textLabel.setOpaque(true);

        JLabel imageLabel = new JLabel(new ImageIcon("C:/GitHub/Menus-and-Panels-in-Java-Swing/AppManagement/src/main/java/org/example/8614c929-c95d-4e89-8b01-7b86bf44b8a9.jpeg"));
        panel.add(textLabel, BorderLayout.NORTH);
        panel.add(imageLabel, BorderLayout.CENTER);

        return panel;
    }

    private void openSecretWordPanel() {
        JFrame secretFrame = new JFrame("Secret Word Panel");
        secretFrame.setSize(400, 200);
        secretFrame.setLocationRelativeTo(this);
        secretFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SecretPanel secretPanel = new SecretPanel();
        secretFrame.add(secretPanel);
        secretFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingApp().setVisible(true));
    }

}

class SecretPanel extends JPanel {
    private JTextField inputField;
    private JButton submitButton;
    private JLabel resultLabel;

    public SecretPanel() {
        setLayout(new FlowLayout());
        setBackground(new Color(19, 128, 0));

        JLabel label = new JLabel("Enter your secret word:");
        label.setForeground(Color.WHITE);
        inputField = new JTextField(15);
        submitButton = new JButton("Submit");
        resultLabel = new JLabel("Your secret word will appear here.");
        resultLabel.setForeground(Color.WHITE);

        add(label);
        add(inputField);
        add(submitButton);
        add(resultLabel);

        submitButton.addActionListener(e -> {
            String secretWord = inputField.getText();
            resultLabel.setText("Entered Secret Word: " + secretWord);
            System.out.println("Secret Word entered: " + secretWord);
        });
    }

}

