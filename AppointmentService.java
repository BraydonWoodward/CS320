import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

	private final Map<String, Appointment> appointments;  // In-memory storage for appointments

    // Constructor to initialize the appointments map
    public AppointmentService() {
        appointments = new HashMap<>();
    }

    // Method to add an appointment, ensuring unique ID
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment ID must be unique.");
        }
        appointments.put(appointment.getAppointmentID(), appointment);
    }

    // Method to delete an appointment by ID, validating the ID exists
    public void deleteAppointment(String appointmentID) {
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
        appointments.remove(appointmentID);
    }

    // Method to get an appointment by ID, validating the ID exists
    public Appointment getAppointment(String appointmentID) {
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
        return appointments.get(appointmentID);
    }

}
