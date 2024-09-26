package org.tenzi.view;

import javax.swing.*;

/**
 * Frame class represents the main window of the Worttrainer application.
 * It extends JFrame and serves as the container for the application's main panel.
 *
 * @author Timo Enzi
 * @version 2024-09-26
 */
public class Frame extends JFrame {

    /**
     * Constructor for the Frame class.
     * Initializes the main window with a specified JPanel, sets the window properties, and makes it visible.
     *
     * @param panel the JPanel to be added to the frame, which contains the UI components for the game.
     */
    public Frame(JPanel panel) {
        super("Worttrainer Timo Enzi");
        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
