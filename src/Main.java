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
            System.out.println("Task Menu");
            System.out.println("1. Add a task | 2. Update a task | 3. Get all tasks | 4. Search by ID | 5. Search by name | 6. Filter by status");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // consume the invalid input
            }
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.next();
                    System.out.print("Enter start date (yyyy-MM-dd): ");


                    // Date startDate = new Date(scanner.next()); // this is wrong way to Date format it will show error need to convert
                    // to String format EEE MMM dd HH:mm:ss zzz yyyy" when using the toString

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date startDate = null;
                    try {
                        startDate = dateFormat.parse(scanner.next());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    System.out.print("Enter end date (yyyy-MM-dd): ");
                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                    Date endDate = null;
                    try {
                        endDate = dateFormat1.parse(scanner.next());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    System.out.print("Enter task status (pending, progress, or done): ");
                    String status = scanner.next();

                    Task newTask = new Task(0, name, status, startDate, endDate);
                    TaskDatabase.addATask(newTask);
                    break;


                case 2:
                    System.out.print("Enter task ID to update: ");
                    int  taskIdToUpdate = scanner.nextInt();
                    System.out.print("Enter updated task name: ");
                    String updatedName = scanner.next();
                    TaskDatabase.updateTaskName( taskIdToUpdate, updatedName);
                    System.out.print("Enter updated task status (pending, progress, or done): ");
                    String updatedStatus = scanner.next();
                    TaskDatabase.updateTaskStatus(taskIdToUpdate, updatedStatus);

                    System.out.print("Enter updated end date (yyyy-MM-dd): ");
                    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
                    Date updatedEndDate = null;
                    try {
                        updatedEndDate = dateFormat2.parse(scanner.next());
                    } catch (ParseException e) {
                        e.printStackTrace();
                        break;
                    }
                    TaskDatabase.updateDeadline(taskIdToUpdate, updatedEndDate);
                    break;
                case 3:
                    List<Task> allTasks = TaskDatabase.getAllTasks();
                    for (int i = 0; i < allTasks.size(); i++) {
                        Task task = allTasks.get(i);
                        System.out.println("Task ID: " + task.getTaskId() +
                                " | Task Name: " + task.getTaskName() +
                                " | Status: " + task.getTaskStatus() +
                                " | Deadline: " + task.getEndDate());
                    }
                    break;
                case 4:
                    System.out.print("Enter task ID to search: ");
                    int searchId = scanner.nextInt();
                    Task searchedTask = TaskDatabase.getTask(searchId);
                    if (searchedTask != null) {
                        System.out.println("Task found - ID: " + searchedTask.getTaskId() +
                                " | Name: " + searchedTask.getTaskName() +
                                " | Status: " + searchedTask.getTaskStatus() +
                                " | Deadline: " + searchedTask.getEndDate());
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter task name to search: ");
                    String searchName = scanner.next();
                    // Implement the search by name logic
                    break;
                case 6:
                    System.out.print("Enter task status to filter: ");
                    String filterStatus = scanner.next();
                    // Implement the filter by status logic
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
