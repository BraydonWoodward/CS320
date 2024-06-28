

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreation() {
        // Test valid contact creation
        Contact contact = new Contact("12345", "John", "Doe", "0123456789", "123 Main St");
        assertAll(
                () -> assertEquals("12345", contact.getContactID()),
                () -> assertEquals("John", contact.getFirstName()),
                () -> assertEquals("Doe", contact.getLastName()),
                () -> assertEquals("0123456789", contact.getPhone()),
                () -> assertEquals("123 Main St", contact.getAddress())
        );
    }

    @Test
    public void testInvalidContactID() {
        // Test invalid contact ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "0123456789", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "0123456789", "123 Main St");
        });
    }

    @Test
    public void testInvalidFirstName() {
        // Test invalid first name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "0123456789", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "JohnJohnJohn", "Doe", "0123456789", "123 Main St");
        });
    }

    @Test
    public void testInvalidLastName() {
        // Test invalid last name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "0123456789", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "DoeDoeDoeDoe", "0123456789", "123 Main St");
        });
    }

    @Test
    public void testInvalidPhone() {
        // Test invalid phone number
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null, "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "01234", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "abcdefghij", "123 Main St");
        });
    }

    @Test
    public void testInvalidAddress() {
        // Test invalid address
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "0123456789", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "0123456789", "This address is way too long for the requirement.");
        });
    }

    @Test
    public void testSetters() {
        // Test setters for updating fields
        Contact contact = new Contact("12345", "John", "Doe", "0123456789", "123 Main St");
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Elm St");
        
        assertAll(
                () -> assertEquals("Jane", contact.getFirstName()),
                () -> assertEquals("Smith", contact.getLastName()),
                () -> assertEquals("0987654321", contact.getPhone()),
                () -> assertEquals("456 Elm St", contact.getAddress())
        );
    }
}
