public class Task {
    private final String taskID; // Required unique id less than 10 char, not null, not updatable
    private String name;// Required name less than 20 char and not null
    private String description;// Required description less than 50 char and not null

    // Constructor to initialize a Task object
    public Task(String taskID, String name, String description) {
    	// Validate taskID
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Task ID must be non-null and at most 10 characters.");
        }
        // Validate name
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must be non-null and at most 20 characters.");
        }
        // Validate description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and at most 50 characters.");
        }
        this.taskID = taskID;
        this.name = name;
        this.description = description;
    }

    // Getters for taskID, name, and description
    public String getTaskID() {
        return taskID;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    // Setter for name with validation
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must be non-null and at most 20 characters.");
        }
        this.name = name;
    }
    // Setter for description with validation
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and at most 50 characters.");
        }
        this.description = description;
    }
}