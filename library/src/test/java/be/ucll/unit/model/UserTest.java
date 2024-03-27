package be.ucll.model.unit.UserTest;

import be.ucll.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testValidUser() {
        User user = new User("John Doe", "john@example.com", 25, "password123");
        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals(25, user.getAge());
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testInvalidName() {
        assertThrows(DomainException.class, () -> new User(null, "john@example.com", 25, "password123"));
        assertThrows(DomainException.class, () -> new User("", "john@example.com", 25, "password123"));
        assertThrows(DomainException.class, () -> new User(" ", "john@example.com", 25, "password123"));
    }

    @Test
    public void testInvalidEmail() {
        assertThrows(DomainException.class, () -> new User("John Doe", null, 25, "password123"));
        assertThrows(DomainException.class, () -> new User("John Doe", "", 25, "password123"));
        assertThrows(DomainException.class, () -> new User("John Doe", "invalid-email", 25, "password123"));
    }

    @Test
    public void testInvalidAge() {
        assertThrows(DomainException.class, () -> new User("John Doe", "john@example.com", -1, "password123"));
        assertThrows(DomainException.class, () -> new User("John Doe", "john@example.com", 0, "password123"));
        assertThrows(DomainException.class, () -> new User("John Doe", "john@example.com", 101, "password123"));
    }

    @Test
    public void testInvalidPassword() {
        assertThrows(DomainException.class, () -> new User("John Doe", "john@example.com", 25, null));
        assertThrows(DomainException.class, () -> new User("John Doe", "john@example.com", 25, ""));
        assertThrows(DomainException.class, () -> new User("John Doe", "john@example.com", 25, "short"));
    }
}
