import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // In-memory data structure to store contacts
    private Map<String, Contact> contacts;

    // Constructor to initialize the contact service
    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Method to add a contact
    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact already exists or is null");
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Method to delete a contact by ID
    public void deleteContact(String contactID) {
        if (contactID == null || !contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactID);
    }

    // Method to update the first name of a contact by ID
    public void updateFirstName(String contactID, String firstName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contact.setFirstName(firstName);
    }

    // Method to update the last name of a contact by ID
    public void updateLastName(String contactID, String lastName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contact.setLastName(lastName);
    }

    // Method to update the phone number of a contact by ID
    public void updatePhone(String contactID, String phone) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contact.setPhone(phone);
    }

    // Method to update the address of a contact by ID
    public void updateAddress(String contactID, String address) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contact.setAddress(address);
    }

    //Method to get a contact by ID with validation
    public Contact getContact(String contactID) {
        return getValidatedContact(contactID);
    }

    // Private method to validate the contact ID and retrieve the contact
    private Contact getValidatedContact(String contactID) {
        if (contactID == null || !contacts.containsKey(contactID)) {
            return null; // Change this line to return null for non-existent contacts
        }
        return contacts.get(contactID);
    }
}