import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentTest {
    private Date futureDate;  // Future date for the appointment

    @BeforeEach
    public void setUp() {
        // Generate a future date before each test
        futureDate = new Date(System.currentTimeMillis() + 100000);
    }

    @Test
    public void testAppointmentCreation() {
    	// Test creating an appointment
        Appointment appointment = new Appointment("12345", futureDate, "Test description");
        assertAll("appointment",
            () -> assertEquals("12345", appointment.getAppointmentID()),
            () -> assertEquals(futureDate, appointment.getAppointmentDate()),
            () -> assertEquals("Test description", appointment.getDescription())
        );
    }

    @Test
    public void testAppointmentIDTooLong() {
    	// Test invalid appointment ID 
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Test description");
        });
    }
    
    @Test
    public void testAppointmentIDNull() {
    	// Test appointment ID Null
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Test description");
        });
    }

    @Test
    public void testAppointmentDateInPast() {
    	// Test invalid appointment date in the past
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", pastDate, "Test description");
        });
    }
    
    @Test
    public void testAppointmentDateNull() {
    	// Test appointment with date Null
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Test description");
        });
    }

    @Test
    public void testAppointmentDescriptionTooLong() {
    	// Test invalid appointment description
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, "This description is far too long and should throw an exception");
        });
    }

    @Test
    public void testAppointmentDescriptionNull() {
    	// Test appointment with description null
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, null);
        });
    }
    
    @Test
    public void testGetters() {
        // Test getters for retrieving fields
        String appointmentID = "12345";
        String description = "Initial description";
        Appointment appointment = new Appointment(appointmentID, futureDate, description);
        
        assertAll(
                () -> assertEquals(appointmentID, appointment.getAppointmentID()),
                () -> assertEquals(futureDate, appointment.getAppointmentDate()),
                () -> assertEquals(description, appointment.getDescription())
        );
    }
    
    @Test
    public void testSetValidDescription() {
        // Test setter for updating description
        Appointment appointment = new Appointment("12345", futureDate, "Initial description");
        String newDescription = "Updated valid description";
        appointment.setDescription(newDescription);

        assertEquals(newDescription, appointment.getDescription());
    }
    @Test
    public void testSetNullDescription() {
        // Test setting description to null
        Appointment appointment = new Appointment("12345", futureDate, "Initial description");
        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setDescription(null);
        });
    }

    @Test
    public void testSetDescriptionTooLong() {
        // Test setting description that is too long
        Appointment appointment = new Appointment("12345", futureDate, "Initial description");
        String longDescription = "This description is definitely longer than fifty characters in length.";
        
        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setDescription(longDescription);
        });
    }
}