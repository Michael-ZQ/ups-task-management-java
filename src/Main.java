import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManagementService taskService = new TaskManagementService();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTask Management System:");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Delete Task");
            System.out.println("4. View Pending Tasks");
            System.out.println("5. View Next Task");
            System.out.println("6. View complete Tasks");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the task to add: ");
                    String taskToAdd = scanner.nextLine();
                    taskService.addTask(taskToAdd);
                    break;
                case 2:
                    taskService.completeTask();
                    break;
                case 3:
                    System.out.print("Enter the task to delete: ");
                    String taskToDelete = scanner.nextLine();
                    taskService.deletePendingTask(taskToDelete);
                    break;
                case 4:
                    taskService.displayPendingTasks();
                    break;
                case 5:
                    taskService.displayNextTask();
                    break;
                case 6:
                    taskService.displayCompletedTasks();
                    break;
                case 7:
                    System.out.println("Exiting Task Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
