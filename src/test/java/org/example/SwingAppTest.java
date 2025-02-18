package org.example;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class SwingAppTest {
    @Test
    public void testSwingApp() {
        SwingApp App = new SwingApp();
        assertNotNull(App);
        assertEquals("Java Swing Application", App.getTitle());
        assertEquals(500, App.getWidth());
        assertEquals(400, App.getHeight());
    }


    @org.junit.jupiter.api.Test
    void createUserFormPanel() {
        SwingApp App = new SwingApp();
        JPanel userFormPanel = App.createUserFormPanel();
        assertNotNull(userFormPanel);
        assertEquals(7, userFormPanel.getComponentCount());
    }

    @Test
    void createLoginPanel() {
        SwingApp app = new SwingApp();
        JPanel loginPanel = app.createLoginPanel();
        assertNotNull(loginPanel);
        assertEquals(6, loginPanel.getComponentCount());
    }

    @Test
    void createAboutPanel() {
        SwingApp App = new SwingApp();
        JPanel aboutPanel = App.createAboutPanel();
        assertNotNull(aboutPanel);
        assertEquals(2, aboutPanel.getComponentCount());
    }
    @Test
    public void testSaveUserData() {
        SwingApp App = new SwingApp();
        JPanel userFormPanel = App.createUserFormPanel();
        JTextField usernameField = (JTextField) userFormPanel.getComponent(1);
        JTextField emailField = (JTextField) userFormPanel.getComponent(3);
        JTextField phoneField = (JTextField) userFormPanel.getComponent(5);
        JButton saveButton = (JButton) userFormPanel.getComponent(6);

        usernameField.setText("geedi");
        emailField.setText("geedi@gmail.com");
        phoneField.setText("1234567890");

        saveButton.doClick();

        assertEquals("geedi", App.savedUsername);
        assertEquals("geedi@gmail.com", App.savedEmail);
        assertEquals("1234567890", App.savedPhone);
    }


}

