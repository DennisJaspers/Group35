import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class BookTest {

    @Test
    public void testConstructorAndGetters() {
        Book book = new Book("Title", "Author", "978-0-545-01022-1", 2022);

        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals("978-0-545-01022-1", book.getIsbn());
        assertEquals(2022, book.getPublicationYear());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTitle_Null() {
        Book book = new Book(null, "Author", "978-0-545-01022-1", 2022);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTitle_Empty() {
        Book book = new Book("", "Author", "978-0-545-01022-1", 2022);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAuthor_Null() {
        Book book = new Book("Title", null, "978-0-545-01022-1", 2022);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAuthor_Empty() {
        Book book = new Book("Title", "", "978-0-545-01022-1", 2022);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIsbn_Null() {
        Book book = new Book("Title", "Author", null, 2022);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIsbn_Empty() {
        Book book = new Book("Title", "Author", "", 2022);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIsbn_InvalidFormat() {
        Book book = new Book("Title", "Author", "1234", 2022);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPublicationYear_Negative() {
        Book book = new Book("Title", "Author", "978-0-545-01022-1", -2022);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPublicationYear_Future() {
        Book book = new Book("Title", "Author", "978-0-545-01022-1", 2023);
    }
}
