import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TaskManagementService {

    private final Stack<String> pendingTasks;
    private final Queue<String> completedTasks;

    public TaskManagementService() {
        this.pendingTasks = new Stack<>();
        this.completedTasks = new LinkedList<>();
    }

    // Method to add a new task to the pending tasks stack
    public void addTask(String task) {
        pendingTasks.push(task);
        System.out.println("Task added: " + task);
    }

    // Method to mark the top pending task as completed
    public void completeTask() {
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks to complete.");
            return;
        }
        String completedTask = pendingTasks.pop();
        completedTasks.offer(completedTask);
        System.out.println("Task completed: " + completedTask);
    }

    // Method to delete a specific pending task
    public void deletePendingTask(String task) {
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks to delete.");
            return;
        }
        Stack<String> tempStack = new Stack<>();
        boolean found = false;

        while (!pendingTasks.isEmpty()) {
            String currentTask = pendingTasks.pop();
            if (currentTask.equals(task)) {
                found = true;
                break;
            } else {
                tempStack.push(currentTask);
            }
        }

        while (!tempStack.isEmpty()) {
            pendingTasks.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Task deleted: " + task);
        } else {
            System.out.println("Task not found: " + task);
        }
    }

    // Method to display all pending tasks
    public void displayPendingTasks() {
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
            return;
        }
        System.out.println("Pending Tasks:");
        for (int i = pendingTasks.size() - 1; i >= 0; i--) {
            System.out.println("- " + pendingTasks.get(i));
        }
    }

    // Method to display the next task to be completed
    public void displayNextTask() {
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            System.out.println("Next Task: " + pendingTasks.peek());
        }
    }

    // Method to display all completed tasks
    public void displayCompletedTasks() {
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
            return;
        }
        System.out.println("Completed Tasks:");
        for (String task : completedTasks) {
            System.out.println("- " + task);
        }
    }
}
