import java.util.Date;

public class Appointment {
    private final String appointmentID;  // Unique ID for the appointment, not updatable, 10 char or less
    private final Date appointmentDate;  // Date of the appointment, must be in the future and not null
    private String description;          // Description of the appointment, can be updated, not null, 50 char or less

    // Constructor with validation to ensure requirements are met
    public Appointment(String appointmentID, Date appointmentDate, String description) {
        // Validate appointment ID
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Appointment ID must be non-null and at most 10 characters.");
        }
        // Validate appointment date
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment Date must be non-null and not in the past.");
        }
        // Validate description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and at most 50 characters.");
        }
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters for AppointmentId, AppointmentDate, Description
    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    // Setter for description with validation to ensure requirements are met
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and at most 50 characters.");
        }
        this.description = description;
    }
}

