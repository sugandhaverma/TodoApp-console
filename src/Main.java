import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printTaskMenu();
            int userInput = getUserInput(scanner);

            switch (userInput) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    updateTask(scanner);
                    break;
                case 3:
                    displayAllTasks();
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static void printTaskMenu() {
        System.out.println("Task Menu");
        System.out.println("1. Add a task | 2. Update a task | 3. Get all tasks | 4. Exit");
    }

    private static int getUserInput(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
            return -1;
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter deadline start date: ");
        String startDate = scanner.nextLine();
        System.out.print("Enter deadline end date: ");
        String endDate = scanner.nextLine();
        System.out.print("Enter task status (Pending, In Progress, Done): ");
        String status = scanner.nextLine();

        Task newTask = new Task(name, startDate, endDate);
        newTask.setTaskStatus(status);
        TaskDatabase.addATask(newTask);
        System.out.println("Task added successfully!");
    }
    private static void updateTask(Scanner scanner) {
        System.out.print("Enter task ID to update: ");
        int updateId = getUserInput(scanner);
        Task taskToUpdate = TaskDatabase.getTask(updateId);

        if (taskToUpdate != null) {
            System.out.print("Enter updated task name: ");
            String updatedName = scanner.nextLine();
            taskToUpdate.setTaskName(updatedName);

            System.out.print("Enter updated status (Pending, In Progress, Done): ");
            String updatedStatus = scanner.nextLine();
            taskToUpdate.setTaskStatus(updatedStatus);

            TaskDatabase.updateTask(updateId, taskToUpdate);
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Task not found!");
        }
    }

    private static void displayAllTasks() {
        List<Task> allTasks = TaskDatabase.getAllTasks();
        for (Task task : allTasks) {
            System.out.println("ID: " + task.getTaskId() +
                    " | Name: " + task.getTaskName() +
                    " | Status: " + task.getTaskStatus() +
                    " | Deadline: " + task.getDeadlineStartDate() + " - " + task.getDeadlineEndDate());
        }
    }
}