package org.tenzi.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A strategy class for persisting and retrieving the state of the WordTrainer object
 * using JSON format. This class implements the PersistenceStrategy}interface.
 * The data is stored in a file named "wordtrainer_data.json".
 *
 * @author Timo Enzi
 * @version 2024-09-25
 */
public class JSONStrategy implements PersistenceStrategy {

    /**
     * Default constructor for the JSONStrategy.
     * Initializes the strategy with no additional parameters.
     */
    public JSONStrategy() {
    }

    /**
     * Loads the state of the WordTrainer object from a JSON file.
     * It populates the provided WordTrainer object with the data from the file,
     * such as the word list, total guesses, and correct guesses.
     *
     * @param wordTrainer the WordTrainer object to populate with loaded data.
     *                    The object's state will be updated with data from the file.
     */
    @Override
    public void load(WordTrainer wordTrainer) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("wordtrainer_data.json")) {
            // Deserialize the WordTrainer object from the JSON file
            WordTrainer loaded = gson.fromJson(reader, WordTrainer.class);

            // Update the provided wordTrainer instance with the loaded data
            wordTrainer.setWordList(loaded.getWordList());
            wordTrainer.setCorrectGuesses(loaded.getCorrectGuesses());
            wordTrainer.setTotalGuesses(loaded.getTotalGuesses());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Stores the current state of the provided WordTrainer}object into a JSON file.
     * The data is serialized into JSON format and written to a file named "wordtrainer_data.json".
     * This file will contain the word list, total guesses, and correct guesses.
     *
     * @param wordTrainer the WordTrainer object whose state is to be stored in the file.
     */
    @Override
    public void store(WordTrainer wordTrainer) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("wordtrainer_data.json")) {
            // Serialize the WordTrainer object into JSON and write it to the file
            gson.toJson(wordTrainer, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}