package org.tenzi.model;

/**
 * Interface for different Persistence Strategies to make persistence exchangeable.
 * @author Timo Enzi
 * @version 2024-09-25
 */
public interface PersistenceStrategy {

    void load(WordTrainer wordTrainer);
    void store(WordTrainer wordTrainer);
}
