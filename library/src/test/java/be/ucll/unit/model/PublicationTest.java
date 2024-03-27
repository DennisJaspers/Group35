import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PublicationTest {

    @Test
    void createPublication_ValidInput_Success() {
        Publication publication = new ConcretePublication("Title", 2022, 10);
        assertEquals("Title", publication.getTitle());
        assertEquals(2022, publication.getPublicationYear());
        assertEquals(10, publication.getAvailableCopies());
    }

    @Test
    void setTitle_Null_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new ConcretePublication(null, 2022, 10));
    }

    @Test
    void setTitle_EmptyString_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new ConcretePublication("", 2022, 10));
    }

    @Test
    void setPublicationYear_NegativeValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new ConcretePublication("Title", -2022, 10));
    }

    @Test
    void setAvailableCopies_NegativeValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new ConcretePublication("Title", 2022, -10));
    }

    @Test
    void setTitle_ValidInput_Success() {
        Publication publication = new ConcretePublication("Old Title", 2022, 10);
        publication.setTitle("New Title");
        assertEquals("New Title", publication.getTitle());
    }

    @Test
    void setPublicationYear_ValidInput_Success() {
        Publication publication = new ConcretePublication("Title", 2022, 10);
        publication.setPublicationYear(2023);
        assertEquals(2023, publication.getPublicationYear());
    }

    @Test
    void setAvailableCopies_ValidInput_Success() {
        Publication publication = new ConcretePublication("Title", 2022, 10);
        publication.setAvailableCopies(20);
        assertEquals(20, publication.getAvailableCopies());
    }

    private static class ConcretePublication extends Publication {
        public ConcretePublication(String title, int publicationYear, int availableCopies) {
            super(title, publicationYear, availableCopies);
        }
    }
}
