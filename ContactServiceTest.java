import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    public void setUp() {
        // Initialize the contact service before each test
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        // Test adding a contact
        Contact contact = new Contact("12345", "John", "Doe", "0123456789", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("12345"));
    }

    @Test
    public void testAddDuplicateContact() {
        // Test adding a duplicate contact
        Contact contact = new Contact("12345", "John", "Doe", "0123456789", "123 Main St");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact);
        });
    }

    @Test
    public void testDeleteContact() {
        // Test deleting a contact
        Contact contact = new Contact("12345", "John", "Doe", "0123456789", "123 Main St");
        service.addContact(contact);
        service.deleteContact("12345");
        assertNull(service.getContact("12345"));
    }

    @Test
    public void testDeleteNonExistentContact() {
        // Test deleting a non-existent contact
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("12345");
        });
    }

    @Test
    public void testUpdateFirstName() {
        // Test updating the first name
        Contact contact = new Contact("12345", "John", "Doe", "0123456789", "123 Main St");
        service.addContact(contact);
        service.updateFirstName("12345", "Jane");
        assertEquals("Jane", service.getContact("12345").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        // Test updating the last name
        Contact contact = new Contact("12345", "John", "Doe", "0123456789", "123 Main St");
        service.addContact(contact);
        service.updateLastName("12345", "Smith");
        assertEquals("Smith", service.getContact("12345").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        // Test updating the phone number
        Contact contact = new Contact("12345", "John", "Doe", "0123456789", "123 Main St");
        service.addContact(contact);
        service.updatePhone("12345", "0987654321");
        assertEquals("0987654321", service.getContact("12345").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        // Test updating the address
        Contact contact = new Contact("12345", "John", "Doe", "0123456789", "123 Main St");
        service.addContact(contact);
        service.updateAddress("12345", "456 Elm St");
        assertEquals("456 Elm St", service.getContact("12345").getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        // Test updating a non-existent contact
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("12345", "Jane");
        });
    }
}
