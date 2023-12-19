package Service;
import DAO.TaskDatabase;
import DTO.Task;
import DTO.TaskStatusEnum;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
public class TaskService {

    public static void addTask(Scanner scanner) {
        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();
        System.out.print("Enter task status (TODO, INPROGRESS, DONE): ");
        TaskStatusEnum taskStatus = TaskStatusEnum.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Enter deadline: ");
        String deadline = scanner.nextLine();

        Task newTask = new Task(taskName, taskStatus, deadline);
        TaskDatabase.tasksDatabaseList.add(newTask);
        System.out.println("Task added successfully.");
    }

    public static void viewAllTasks() {
        for (Task task : TaskDatabase.tasksDatabaseList) {
            System.out.println(task.toString());
        }
    }
    public static void updateTask(Scanner scanner) {
        System.out.print("Enter task ID to update: ");
        int taskId = Integer.parseInt(scanner.nextLine());

        for (Task task : TaskDatabase.tasksDatabaseList) {
            if (task.getTaskId() == taskId) {
                System.out.print("Enter new task name: ");
                task.setTaskName(scanner.nextLine());
                System.out.print("Enter new task status (TODO, INPROGRESS, DONE): ");
                task.setTaskStatus(TaskStatusEnum.valueOf(scanner.nextLine().toUpperCase()));
                System.out.print("Enter new deadline: ");
                task.setDeadline(scanner.nextLine());

                System.out.println("Task updated successfully.");
                return;
            }
        }

        System.out.println("Task not found with ID: " + taskId);
    }

    public static void deleteTask(Scanner scanner) {
        System.out.print("Enter task ID to delete: ");
        int taskId = Integer.parseInt(scanner.nextLine());

        Iterator<Task> iterator = TaskDatabase.tasksDatabaseList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getTaskId() == taskId) {
                iterator.remove();
                System.out.println("Task deleted successfully.");
                return;
            }
        }

        System.out.println("Task not found with ID: " + taskId);
    }

    public static void searchTask(Scanner scanner) {
        System.out.print("Enter task ID to search: ");
        int taskId = Integer.parseInt(scanner.nextLine());

        for (Task task : TaskDatabase.tasksDatabaseList) {
            if (task.getTaskId() == taskId) {
                System.out.println(task.toString());
                return;
            }
        }

        System.out.println("Task not found with ID: " + taskId);
    }
    public static void searchTaskByName(Scanner scanner) {
        System.out.print("Enter task name to search: ");
        String taskName = scanner.nextLine();

        for (Task task : TaskDatabase.tasksDatabaseList) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                System.out.println(task.toString());
                return;
            }
        }

        System.out.println("Task not found with name: " + taskName);
    }

    public static void sortByDeadline() {
        Collections.sort(TaskDatabase.tasksDatabaseList, Comparator.comparing(Task::getDeadline));
        System.out.println("Tasks sorted by deadline.");
    }

}
