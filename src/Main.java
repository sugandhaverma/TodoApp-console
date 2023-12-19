import Service.TaskService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add a Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Update a Task");
            System.out.println("4. Delete a Task");
            System.out.println("5. Search a Task");
            System.out.println("6. Sort by Deadline");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    TaskService.addTask(scanner);
                    break;
                case "2":
                    TaskService.viewAllTasks();
                    break;
                case "3":
                    TaskService.updateTask(scanner);
                    break;
                case "4":
                    TaskService.deleteTask(scanner);
                    break;
                case "5":
                    TaskService.searchTask(scanner);
                    break;
                case "6":
                    TaskService.sortByDeadline();
                    break;
                case "7":
                    System.out.println("Exiting ToDo List App. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}