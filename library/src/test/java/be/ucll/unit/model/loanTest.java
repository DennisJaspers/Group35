import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class LoanTest {

    @Test
    void createLoan_ValidInput_Success() {
        User user = new User("John Doe", "john@example.com");
        Publication publication = new Book("Title", "Author", "ISBN", 2022, 1);
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(7);
        Loan loan = new Loan(user, startDate, endDate);
        assertEquals(user, loan.getUser());
        assertTrue(loan.getPublications().isEmpty());
        assertEquals(startDate, loan.getStartDate());
        assertEquals(endDate, loan.getEndDate());
    }

    @Test
    void setPublications_ValidInput_Success() {
        User user = new User("John Doe", "john@example.com");
        Publication publication = new Book("Title", "Author", "ISBN", 2022, 1);
        Loan loan = new Loan(user, LocalDate.now(), LocalDate.now().plusDays(7));
        loan.setPublications(Collections.singletonList(publication));
        assertEquals(1, loan.getPublications().size());
        assertEquals(publication, loan.getPublications().get(0));
    }

    @Test
    void setPublications_NoAvailableCopies_ThrowsIllegalStateException() {
        User user = new User("John Doe", "john@example.com");
        Publication publication = new Book("Title", "Author", "ISBN", 2022, 0);
        Loan loan = new Loan(user, LocalDate.now(), LocalDate.now().plusDays(7));
        assertThrows(IllegalStateException.class, () -> loan.setPublications(Collections.singletonList(publication)));
    }

    @Test
    void returnPublications_Success() {
        User user = new User("John Doe", "john@example.com");
        Publication publication = new Book("Title", "Author", "ISBN", 2022, 1);
        Loan loan = new Loan(user, LocalDate.now(), LocalDate.now().plusDays(7));
        loan.setPublications(Collections.singletonList(publication));
        loan.returnPublications();
        assertTrue(loan.getPublications().isEmpty());
    }

    @Test
    void returnPublications_NoPublications_ReturnsEmpty() {
        User user = new User("John Doe", "john@example.com");
        Loan loan = new Loan(user, LocalDate.now(), LocalDate.now().plusDays(7));
        loan.returnPublications();
        assertTrue(loan.getPublications().isEmpty());
    }
}
