package org.tenzi.controller;

import org.tenzi.model.WordTrainer;
import org.tenzi.view.Frame;
import org.tenzi.view.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Controller implements ActionListener {
    private final Frame frame;
    private Panel panel;
    private WordTrainer wordTrainer;

    public Controller() {
        this.wordTrainer = new WordTrainer();
        this.wordTrainer.load();

        this.panel = new Panel(this);
        this.frame = new Frame(panel);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch(actionCommand) {
            case "textInput":
                this.wordTrainer.checkInput(panel.getInput());

                this.panel.showNextWord();
                break;

            case "saveGame":
                this.wordTrainer.store();

            case "loadGame":
                this.wordTrainer.load();
                this.panel.showNextWord();
        }
    }

    public static void main(String[] args) {
        new Controller();

    }

    public String getCurrentUrl() {
        return wordTrainer.getRandomWord().getWordUrl();
    }

    public int getTotalGuesses() {
        return wordTrainer.getTotalGuesses();
    }

    public int getCorrectGuesses() {
        return wordTrainer.getCorrectGuesses();
    }
}