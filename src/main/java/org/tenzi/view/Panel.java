package org.tenzi.view;

import org.tenzi.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Panel extends JPanel {

    private Controller controller;
    private JLabel correctGuesses, totalGuesses, picture;
    private JButton saveGame, loadGame;
    private JTextField input;


    public Panel(Controller c) {
        this.controller = c;
        this.setLayout(new BorderLayout());

        JPanel input = new JPanel();
        input.setLayout(new GridLayout(2,1));
        JLabel inputLabel = new JLabel("Welches Wort wird unten dargestellt (Eingabe zum Ueberpruefen)?");

        input.add(inputLabel);
        this.input = new JTextField();
        input.add(this.input);
        this.add(input, BorderLayout.PAGE_START);


        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,1));
        try {
            ImageIcon imageIcon = new ImageIcon(new URL(controller.getCurrentUrl()));

            Image image = imageIcon.getImage();
            image = image.getScaledInstance(250,250,Image.SCALE_SMOOTH);
            this.picture = new JLabel(new ImageIcon(image));
            center.add(picture);
            this.add(center, BorderLayout.CENTER);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(2,3));

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

    public String getInput() {
        return this.input.getText();
    }

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
        image = image.getScaledInstance(250,250, Image.SCALE_SMOOTH);
        this.picture = new JLabel(new ImageIcon(image));
        center.add(picture);
        this.add(center, BorderLayout.CENTER);
    }
}
