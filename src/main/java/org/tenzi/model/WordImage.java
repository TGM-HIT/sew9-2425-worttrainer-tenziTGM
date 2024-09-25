package org.tenzi.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

/**
 * This class represents a word and its associated URL that points to an image.
 * It provides functionality to set and retrieve the word and the URL, while also validating the URL.
 */
public class WordImage {
    private String word;
    private String wordUrl;

    /**
     * Constructs a new WordImage object with the specified word and URL.
     *
     * @param word    the word to be associated with the image.
     * @param wordUrl the URL of the image associated with the word.
     * @throws IllegalArgumentException if the word is null, empty, or if the URL is invalid.
     */
    public WordImage(String word, String wordUrl) {
        setWord(word);
        setWordUrl(wordUrl);
    }

    /**
     * Returns the word associated with the image.
     *
     * @return the word associated with the image.
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the word associated with the image.
     *
     * @param word the word to set.
     * @throws IllegalArgumentException if the word is null or empty.
     */
    public void setWord(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }
        this.word = word;
    }

    /**
     * Returns the URL of the image associated with the word.
     *
     * @return the URL of the image associated with the word.
     */
    public String getWordUrl() {
        return wordUrl;
    }

    /**
     * Sets the URL of the image associated with the word.
     *
     * @param wordUrl the URL to set.
     * @throws IllegalArgumentException if the URL is invalid or empty.
     */
    public void setWordUrl(String wordUrl) {
        if (!isValidUrl(wordUrl) || wordUrl.isEmpty()) {
            throw new IllegalArgumentException("Url is invalid or empty");
        }
        this.wordUrl = wordUrl;
    }

    /**
     * Validates if the given URL string is in a proper format.
     *
     * @param url the URL string to validate.
     * @return true if the URL is valid, otherwise false.
     */
    public static boolean isValidUrl(String url) {
        String URL_REGEX = "^(https?://)?(www\\.)?([a-zA-Z0-9-]+\\.[a-zA-Z]{2,})(/.*)?$";
        Pattern pattern = Pattern.compile(URL_REGEX);

        if (!pattern.matcher(url).matches()) {
            return false;
        }

        try {
            new URL(url); // Check if the URL can be constructed properly.
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}

