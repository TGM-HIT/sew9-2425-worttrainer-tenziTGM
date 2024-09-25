import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tenzi.model.WordImage;
import org.tenzi.model.WordTrainer;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class WordTrainerTest {

    private WordTrainer wordTrainer;
    @BeforeEach
    void setUp() {
        wordTrainer = new WordTrainer();
    }
    @Test
    @DisplayName("Setting the wordList with empty list is tested")
    void testSetWordListWithEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> {

            wordTrainer.setWordList(new ArrayList<>());
        });
    }

    @Test
    @DisplayName("Setting the wordList with null list is tested")
    void testSetWordListWithNullList() {
        assertThrows(IllegalArgumentException.class, () -> {

            wordTrainer.setWordList(null);
        });
    }

    @Test
    @DisplayName("Setting correctGuesses is tested")
    void testSetCorrectGuesses() {
        assertThrows(IllegalArgumentException.class, () -> {
            wordTrainer.setCorrectGuesses(-1);
        });
    }

    @Test
    @DisplayName("Setting totalGuesses is tested")
    void testSetTotalGuesses() {
        assertThrows(IllegalArgumentException.class, () -> {
            wordTrainer.setTotalGuesses(-1);
        });
    }

    @Test
    @DisplayName("checkInput method is tested")
    void testCheckInput() {
        wordTrainer.setWordList(
                Arrays.asList(
                        new WordImage("Hund","https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg"),
                        new WordImage("Katze", "https://www.alleycat.org/wp-content/uploads/2019/03/FELV-cat.jpg")
                )
        );
        wordTrainer.getRandomWord();
        wordTrainer.checkInput("Hund");
        wordTrainer.checkInput("Katze");

        assertEquals(wordTrainer.getTotalGuesses(),2);
        assertTrue(wordTrainer.getCorrectGuesses()==1);
    }





}
