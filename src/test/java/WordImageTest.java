import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tenzi.model.WordImage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordImageTest {

    @Test
    @DisplayName("Valid WordImage Creation is tested")
    void testWordImageCreation() {
        WordImage wordImage = new WordImage("Hund", "https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg");
        assertEquals("Hund", wordImage.getWord());
        assertEquals("https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg", wordImage.getWordUrl());
    }

    @Test
    @DisplayName("WordImage Creation with empty word is tested")
    void testWordImageCreationWithEmptyWord() {
        assertThrows(IllegalArgumentException.class, () -> {
            WordImage wordImage = new WordImage("","https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg");
        });
    }

    @Test
    @DisplayName("WordImage Creation with null word is tested")
    void testWordImageCreationWithNullWord() {
        assertThrows(IllegalArgumentException.class, () -> {
            WordImage wordImage = new WordImage(null,"https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg");
        });
    }

    @Test
    @DisplayName("WordImage Creation with empty URL is tested")
    void testWordImageCreationWithEmptyUrl() {
        assertThrows(IllegalArgumentException.class, () -> {
            WordImage wordImage = new WordImage("Hund", "");
        });
    }

    @Test
    @DisplayName("WordImage Creation with null URL is tested")
    void testWordImageCreationWithNullUrl() {
        assertThrows(IllegalArgumentException.class, () -> {
            WordImage wordImage = new WordImage("Hund", null);
        });
    }

    @Test
    @DisplayName("WordImage Creation with invalid URL is tested")
    void testWordImageCreationWithInvalidUrl() {
        assertThrows(IllegalArgumentException.class, () -> {
            WordImage wordImage = new WordImage("Hund", "invalid");
        });
    }
}
