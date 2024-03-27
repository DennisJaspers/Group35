package be.ucll.unit.model;

import be.ucll.model.Magazine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MagazineTest {

    @Test
    public void testConstructorAndGetters() {
        Magazine magazine = new Magazine("Title", "Editor", "1234-5678", 2024);

        assertEquals("Title", magazine.getTitle());
        assertEquals("Editor", magazine.getEditor());
        assertEquals("1234-5678", magazine.getIssn());
        assertEquals(2024, magazine.getPublicationYear());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTitle_Null() {
        Magazine magazine = new Magazine(null, "Editor", "1234-5678", 2024);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTitle_Empty() {
        Magazine magazine = new Magazine("", "Editor", "1234-5678", 2024);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetEditor_Null() {
        Magazine magazine = new Magazine("Title", null, "1234-5678", 2024);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetEditor_Empty() {
        Magazine magazine = new Magazine("Title", "", "1234-5678", 2024);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIssn_Null() {
        Magazine magazine = new Magazine("Title", "Editor", null, 2024);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIssn_Empty() {
        Magazine magazine = new Magazine("Title", "Editor", "", 2024);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIssn_InvalidFormat() {
        Magazine magazine = new Magazine("Title", "Editor", "12345-6789", 2024);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPublicationYear_Negative() {
        Magazine magazine = new Magazine("Title", "Editor", "1234-5678", -2024);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPublicationYear_Future() {
        Magazine magazine = new Magazine("Title", "Editor", "1234-5678", 2023);
    }
}
