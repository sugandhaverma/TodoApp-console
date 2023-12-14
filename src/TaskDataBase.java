import java.util.ArrayList;
import java.util.List;
class TaskDatabase {
    public static List<Task> tasksDatabaseList = new ArrayList<>();

    public static void addATask(Task task) {
        tasksDatabaseList.add(task);
    }

    public static void updateTask(int id, Task task) {
        for (Task t : tasksDatabaseList) {
            if (t.getTaskId() == id) {
                t.setTaskName(task.getTaskName());
                t.setTaskStatus(task.getTaskStatus());
                t.setDeadlineStartDate(task.getDeadlineStartDate());
                t.setDeadlineEndDate(task.getDeadlineEndDate());
                break;
            }
        }
    }

    public static Task getTask(int taskId) {
        for (Task t : tasksDatabaseList) {
            if (t.getTaskId() == taskId) {
                return t;
            }
        }
        return null;
    }

    public static List<Task> getAllTasks() {
        return tasksDatabaseList;
    }

    public static void deleteTask(int id) {
        tasksDatabaseList.removeIf(task -> task.getTaskId() == id);
    }
}
