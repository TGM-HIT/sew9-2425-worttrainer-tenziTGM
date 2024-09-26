package org.tenzi.controller;

import org.tenzi.model.WordTrainer;
import org.tenzi.view.Frame;
import org.tenzi.view.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class to manage the interaction between the WordTrainer model and the view components (Frame, Panel).
 * It handles user actions from the GUI, coordinates the game logic, and updates the UI accordingly.
 * Implements the ActionListener interface to handle button and input events.
 *
 * @author Timo Enzi
 * @version 2024-09-26
 */
public class Controller implements ActionListener {
    private final Frame frame;
    private Panel panel;
    private WordTrainer wordTrainer;

    /**
     * Constructor for the Controller class.
     * Initializes the WordTrainer object, loads stored data, creates the view (Panel and Frame),
     * and sets up the game.
     */
    public Controller() {
        this.wordTrainer = new WordTrainer();
        this.wordTrainer.load();

        this.panel = new Panel(this);
        this.frame = new Frame(panel);
    }

    /**
     * Handles action events triggered by user interactions.
     * This method processes the commands for text input and saving/loading the game.
     *
     * @param e the ActionEvent triggered by the user interaction (button clicks, text input).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "textInput":

                this.wordTrainer.checkInput(panel.getInput());
                this.panel.showNextWord();
                break;

            case "saveGame":

                this.wordTrainer.store();
                break;

            case "loadGame":
                
                this.wordTrainer.load();
                this.panel.showNextWord();
                break;
        }
    }



    /**
     * Returns the URL associated with the current word in the game.
     *
     * @return a String representing the URL of the current word.
     */
    public String getCurrentUrl() {
        return wordTrainer.getRandomWord().getWordUrl();
    }

    /**
     * Returns the total number of guesses made by the user during the game.
     *
     * @return an integer representing the total guesses made.
     */
    public int getTotalGuesses() {
        return wordTrainer.getTotalGuesses();
    }

    /**
     * Returns the number of correct guesses made by the user during the game.
     *
     * @return an integer representing the correct guesses made.
     */
    public int getCorrectGuesses() {
        return wordTrainer.getCorrectGuesses();
    }

    /**
     * Main method to start the application. Initializes a new Controller.
     *
     * @param args command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        new Controller();
    }
}
