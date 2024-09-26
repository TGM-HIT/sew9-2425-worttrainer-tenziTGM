import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tenzi.model.WordImage;
import org.tenzi.model.WordTrainer;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Class for JSONStrategy
 *
 * @author Timo Enzi
 * @version 2024-09-25
 */
public class JSONStrategyTest {

    @Test
    @DisplayName("Load method is tested")
    void test() {
        WordTrainer wordTrainer = new WordTrainer();
        wordTrainer.load();
        assertEquals(5,wordTrainer.getCorrectGuesses());
        assertEquals(12, wordTrainer.getTotalGuesses());
        assertEquals("Hund", wordTrainer.getWordList().get(0).getWord());
    }
    @DisplayName("Store Method is tested")
    @Test
    void testStore() {
        WordTrainer wordTrainer = new WordTrainer();
        wordTrainer.setWordList(
                Arrays.asList(
                        new WordImage("Hund","https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg"),
                        new WordImage("Katze", "https://www.alleycat.org/wp-content/uploads/2019/03/FELV-cat.jpg")
                )
        );
        wordTrainer.setCorrectGuesses(5);
        wordTrainer.setTotalGuesses(12);
        wordTrainer.store();

        WordTrainer wordTrainer2 = new WordTrainer();
        wordTrainer2.load();

        assertEquals(5,wordTrainer2.getCorrectGuesses());
        assertEquals(12, wordTrainer2.getTotalGuesses());
        assertEquals("Hund", wordTrainer2.getWordList().get(0).getWord());

    }

}
