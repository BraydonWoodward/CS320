import java.util.HashMap;
import java.util.Map;

public class TaskService {
    // In-memory data structure to store tasks
    private Map<String, Task> tasks;

    // Constructor to initialize the task service
    public TaskService() {
        tasks = new HashMap<>();
    }
    // Method to add a task
    public void addTask(Task task) {	
        // validate if task is null or already exists
        if (task == null || tasks.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task already exists or is null.");
        }
        tasks.put(task.getTaskID(), task);
    }

    // Method to delete a task by ID
    public void deleteTask(String taskID) {	
        // Validate if taskID is null or does not exist
        if (taskID == null || !tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        tasks.remove(taskID);
    }

    // Method to update the name of a task by ID
    public void updateTaskName(String taskID, String name) {
        // Get the validated task and update its name
        Task task = getValidatedTask(taskID);
        task.setName(name);
    }

    // Method to update the description of a task by ID
    public void updateTaskDescription(String taskID, String description) {
        // Get the validated task and update its description
        Task task = getValidatedTask(taskID);
        task.setDescription(description);
    }

    // Method to get a task by ID with validation
    public Task getTask(String taskID) {
        // Return the validated task
        return getValidatedTask(taskID);
    }

    // Private method to validate the task ID and retrieve the task
    private Task getValidatedTask(String taskID) {
        // Validate if taskID is null or does not exist
        if (taskID == null || !tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        return tasks.get(taskID);
    }
}
