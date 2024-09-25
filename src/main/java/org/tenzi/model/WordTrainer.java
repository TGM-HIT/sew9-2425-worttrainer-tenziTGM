package org.tenzi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class provides functionality for managing a list of {@code WordImage} objects
 * and checking user inputs against randomly selected words from the list.
 * It tracks the current word, the total guesses, and the number of correct guesses made by the user.
 *
 * @author Timo Enzi
 * @version 2024-09-25
 */
public class WordTrainer {
    private List<WordImage> wordList;
    private transient int currentWordIndex = -1;
    private int totalGuesses = 0;
    private int correctGuesses = 0;

    private transient PersistenceStrategy storage = new JSONStrategy();

    /**
     * Constructs a new WordTrainer object.
     */
    public WordTrainer() {
        wordList = new ArrayList<>();
    }

    /**
     * Returns the list of WordImage objects used in the trainer.
     *
     * @return the word list.
     */
    public List<WordImage> getWordList() {
        return wordList;
    }

    /**
     * Sets the list of WordImage objects for the trainer.
     *
     * @param wordList the list of {@code WordImage} objects to set.
     * @throws IllegalArgumentException if the word list is null or empty.
     */
    public void setWordList(List<WordImage> wordList) {
        if (wordList == null || wordList.isEmpty()) {
            throw new IllegalArgumentException("Word List cannot be null or empty");
        }
        this.wordList = wordList;
    }

    /**
     * Returns the total number of guesses made by the user.
     *
     * @return the total number of guesses.
     */
    public int getTotalGuesses() {
        return totalGuesses;
    }

    /**
     * Sets the total number of guesses made by the user.
     *
     * @param totalGuesses the total number of guesses.
     * @throws IllegalArgumentException if the total guesses are less than 0.
     */
    public void setTotalGuesses(int totalGuesses) {
        if (totalGuesses < 0) {
            throw new IllegalArgumentException("Total Guesses need to be at least 0");
        }
        this.totalGuesses = totalGuesses;
    }

    /**
     * Returns the total number of correct guesses made by the user.
     *
     * @return the total number of correct guesses.
     */
    public int getCorrectGuesses() {
        return correctGuesses;
    }

    /**
     * Sets the total number of correct guesses made by the user.
     *
     * @param correctGuesses the number of correct guesses.
     * @throws IllegalArgumentException if the correct guesses are less than 0.
     */
    public void setCorrectGuesses(int correctGuesses) {
        if (correctGuesses < 0) {
            throw new IllegalArgumentException("Correct Guesses need to be at least 0");
        }
        this.correctGuesses = correctGuesses;
    }

    /**
     * Returns a random WordImage from the word list, ensuring that it is different
     * from the currently selected word.
     *
     * @return a randomly selected WordImage.
     */
    public WordImage getRandomWord() {
        int randomIndex;
        do {
            randomIndex = new Random().nextInt(wordList.size());
        } while (randomIndex == currentWordIndex); // Avoid selecting the current word again
        currentWordIndex = randomIndex;

        return wordList.get(currentWordIndex);
    }

    /**
     * Checks if the input provided by the user matches the word of the current WordImage.
     * Comparison is case-insensitive.
     *
     * @param input the input word to check.
     * @return true if the input matches the word, otherwise false.
     */
    public boolean checkInput(String input) {

        totalGuesses++;

        boolean isCorrect = wordList.get(currentWordIndex).getWord().toLowerCase().equals(input.toLowerCase());

        if(isCorrect) {
            correctGuesses++;

        }
        return isCorrect;
    }

    /**
     * Loads a WordTrainer from a file
     */
    public void load() {
        this.storage.load(this);
    }


    /**
     * Stores this WordTrainer in a file
     */
    public void store() {
        this.storage.store(this);
    }
}