package be.ucll.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import be.ucll.unit.model.DomainException;
import be.ucll.model.User;

public class UserTest {

    @Test
    public void givenValidValues_whenCreatingUser_thenUserIsCreatedWithThoseValues() {
        User user = new User("John Doe", "john.doe@ucll.be", 56, "john1234");

        assertEquals("John Doe", user.getName());
        assertEquals(56, user.getAge());
        assertEquals("john.doe@ucll.be", user.getEmail());
        assertEquals("john1234", user.getPassword());
    }


    @Test
    void createUser_InvalidName_ThrowsException() {
        assertThrows(DomainException.class, () -> new User(null, 25, "", ""));
        assertThrows(DomainException.class, () -> new User("", 25, "", ""));
    }

    @Test
    void createUser_MissingEmail_ThrowsException() {
        assertThrows(DomainException.class, () -> new User("John Doe", 25, "", ""));
        assertThrows(DomainException.class, () -> new User("John Doe", "invalid-email", 25, "password"));
    }

    @Test
    void createUser_MissingPassword_ThrowsException() {
        assertThrows(DomainException.class, () -> new User("John Doe", 25, "john@example.com", ""));
        assertThrows(DomainException.class, () -> new User("John Doe", "john.doe@ucll.be", 150, "password"));
    }
}
