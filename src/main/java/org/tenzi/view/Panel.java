package org.tenzi.view;

import org.tenzi.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Panel class represents the main user interface component of the Worttrainer application.
 * It extends JPanel and displays the input fields, buttons, and game statistics (correct and total guesses).
 * It also displays an image of the current word and allows users to interact with the game.
 *
 * @author Timo Enzi
 * @version 2024-09-26
 */
public class Panel extends JPanel {

    private Controller controller;
    private JLabel correctGuesses, totalGuesses, picture;
    private JButton saveGame, loadGame;
    private JTextField input;
    private String url;

    /**
     * Constructor for the Panel class.
     * Initializes the user interface with input fields, buttons, and statistics labels, and sets up the layout.
     * It also loads and displays the current word's image.
     *
     * @param c the Controller instance to manage user actions and update the game state.
     */
    public Panel(Controller c) {
        this.controller = c;
        this.url = controller.getCurrentUrl();
        this.setLayout(new BorderLayout());

        JPanel input = new JPanel();
        input.setLayout(new GridLayout(2, 1));
        JLabel inputLabel = new JLabel("Welches Wort wird unten dargestellt (Eingabe zum Ueberpruefen)?");

        input.add(inputLabel);
        this.input = new JTextField();
        input.add(this.input);
        this.add(input, BorderLayout.PAGE_START);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1, 1));
        try {
            ImageIcon imageIcon = new ImageIcon(new URL(controller.getCurrentUrl()));

            Image image = imageIcon.getImage();
            image = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            this.picture = new JLabel(new ImageIcon(image));
            center.add(picture);
            this.add(center, BorderLayout.CENTER);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(2, 3));

        this.correctGuesses = new JLabel(String.valueOf(controller.getCorrectGuesses()));
        this.totalGuesses = new JLabel(String.valueOf(controller.getTotalGuesses()));

        this.saveGame = new JButton("Speichern");
        this.loadGame = new JButton("Laden");

        bottom.add(new JLabel("Richtige Woerter: "));
        bottom.add(correctGuesses);
        bottom.add(saveGame);
        bottom.add(new JLabel("Gesamtanzahl:"));
        bottom.add(totalGuesses);
        bottom.add(loadGame);

        this.add(bottom, BorderLayout.PAGE_END);

        this.input.addActionListener(this.controller);
        this.input.setActionCommand("textInput");

        this.saveGame.addActionListener(this.controller);
        this.saveGame.setActionCommand("saveGame");

        this.loadGame.addActionListener(this.controller);
        this.loadGame.setActionCommand("loadGame");
    }

    /**
     * Returns the user's input from the text field.
     *
     * @return a String containing the text input by the user.
     */
    public String getInput() {
        return this.input.getText();
    }

    /**
     * Updates the panel to display the next word and refreshes the statistics labels.
     * The input field is cleared, and the next image is loaded and displayed.
     */
    public void showNextWord() {
        this.input.setText("");
        this.correctGuesses.setText(String.valueOf(this.controller.getCorrectGuesses()));
        this.totalGuesses.setText(String.valueOf(this.controller.getTotalGuesses()));

        JPanel center = new JPanel();
        ImageIcon imageIcon = null;
        try {
            imageIcon = new ImageIcon(new URL(controller.getCurrentUrl()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        this.picture = new JLabel(new ImageIcon(image));
        center.add(picture);
        this.add(center, BorderLayout.CENTER);
    }

    public void next() {
        this.input.setText("");
        this.correctGuesses.setText(String.valueOf(this.controller.getCorrectGuesses()));
        this.totalGuesses.setText(String.valueOf(this.controller.getTotalGuesses()));
    }
}
