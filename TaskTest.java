import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        // Test task creation with valid input
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        assertEquals("12345", task.getTaskID());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test task description.", task.getDescription());
    }

    @Test
    public void testTaskIDTooLong() {
        // Test task creation with task ID longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Test Task", "This is a test task description.");
        });
    }

    @Test
    public void testTaskIDNull() {
        // Test task creation with null task ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Test Task", "This is a test task description.");
        });
    }

    @Test
    public void testTaskNameTooLong() {
        // Test task creation with name longer than 20 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "This task name is definitely too long", "This is a test task description.");
        });
    }

    @Test
    public void testTaskNameNull() {
        // Test task creation with null name
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", null, "This is a test task description.");
        });
    }

    @Test
    public void testTaskDescriptionTooLong() {
        // Test task creation with description longer than 50 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Test Task", "This description is definitely too long and exceeds the fifty characters limit.");
        });
    }

    @Test
    public void testTaskDescriptionNull() {
        // Test task creation with null description
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Test Task", null);
        });
    }

    @Test
    public void testSetName() {
        // Test setting a valid name
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        task.setName("Updated Name");
        assertEquals("Updated Name", task.getName());
    }

    @Test
    public void testSetDescription() {
        // Test setting a valid description
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        task.setDescription("Updated description.");
        assertEquals("Updated description.", task.getDescription());
    }

    @Test
    public void testSetNameTooLong() {
        // Test setting a name longer than 20 characters
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("This task name is definitely too long");
        });
    }

    @Test
    public void testSetNameNull() {
        // Test setting a null name
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }

    @Test
    public void testSetDescriptionTooLong() {
        // Test setting a description longer than 50 characters
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("This description is definitely too long and exceeds the fifty characters limit.");
        });
    }

    @Test
    public void testSetDescriptionNull() {
        // Test setting a null description
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
    }
}