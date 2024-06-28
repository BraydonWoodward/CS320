import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    private TaskService service;

    @BeforeEach
    public void setUp() {
        // Initialize the task service before each test
        service = new TaskService();
    }

    @Test
    public void testAddTask() {
        // Test adding a task
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        service.addTask(task);
        assertEquals(task, service.getTask("12345"));
    }

    @Test
    public void testAddDuplicateTask() {
        // Test adding a duplicate task
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        service.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task);
        });
    }

    @Test
    public void testDeleteTask() {
        // Test deleting a task
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        service.addTask(task);
        service.deleteTask("12345");
        assertThrows(IllegalArgumentException.class, () -> {
            service.getTask("12345");
        });
    }

    @Test
    public void testDeleteNonExistentTask() {
        // Test deleting a non-existent task
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("12345");
        });
    }

    @Test
    public void testUpdateTaskName() {
        // Test updating the name of a task
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        service.addTask(task);
        service.updateTaskName("12345", "Updated Name");
        assertEquals("Updated Name", service.getTask("12345").getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        // Test updating the description of a task
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        service.addTask(task);
        service.updateTaskDescription("12345", "Updated description.");
        assertEquals("Updated description.", service.getTask("12345").getDescription());
    }

    @Test
    public void testUpdateNonExistentTask() {
        // Test updating a non-existent task
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskName("12345", "Updated Name");
        });
    }
}
