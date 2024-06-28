import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentServiceTest {
    private AppointmentService service;  // Service to be tested
    private Date futureDate;             // Future date for the appointment
    private Date pastDate;               // Past date for the appointment

    @BeforeEach
    public void setUp() {
        // Initialize the service and generate a future date before each test
        service = new AppointmentService();
        futureDate = new Date(System.currentTimeMillis() + 100000);
    }

    @Test
    public void testAddAppointment() {
    	// Test adding an Appointment
        Appointment appointment = new Appointment("12345", futureDate, "Test description");
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("12345"));
    }

    @Test
    public void testAddDuplicateAppointment() {
    	// Test adding a duplicate appointment
        Appointment appointment = new Appointment("12345", futureDate, "Test description");
        service.addAppointment(appointment);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment);
        });
    }
    
    @Test
    public void testAddAppointmentWithNullID() {
    	// Test adding null ID appointment
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(new Appointment(null, futureDate, "Test description"));
        });
    }
    
    @Test
    public void testAddAppointmentWithNullDate() {
    	// Test adding appointment with null date
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(new Appointment("12345", null, "Test description"));
        });
    }
    
    @Test
    public void testAddAppointmentWithPastDate() {
    	// Test adding an appointment with a date in the past
    	 pastDate = new Date(System.currentTimeMillis() - 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(new Appointment("12345", pastDate, "Test description"));
        });
    }

    @Test
    public void testDeleteAppointment() {
    	// Test deleting an appointment
        Appointment appointment = new Appointment("12345", futureDate, "Test description");
        service.addAppointment(appointment);
        service.deleteAppointment("12345");
        assertThrows(IllegalArgumentException.class, () -> {
            service.getAppointment("12345");
        });
    }

    @Test
    public void testDeleteNonExistentAppointment() {
    	// Test deleting a non existing appointment
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("12345");
        });
    }
    
    
}