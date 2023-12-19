import java.util.ArrayList;
import java.util.Date;
import java.util.List;
class TaskDatabase {
        public static List<Task> tasksDatabaseList = new ArrayList<>();

        public static void addATask(Task task) {
            tasksDatabaseList.add(task);
        }

        public static void updateTaskName(int id, String name) {
            for (int i = 0; i < tasksDatabaseList.size(); i++) {
                if (tasksDatabaseList.get(i).getTaskId() == id) {
                    tasksDatabaseList.get(i).setTaskName(name);
                    break;
                }
            }
        }

        public static void updateTaskStatus(int id, String status) {
            for (int i = 0; i < tasksDatabaseList.size(); i++) {
                if (tasksDatabaseList.get(i).getTaskId() == id) {
                    tasksDatabaseList.get(i).setTaskStatus(status);
                    break;
                }
            }
        }

        public static void updateDeadline(int id, Date deadline) {
            for (Task task : tasksDatabaseList) {
                if (task.getTaskId() == id) {
                    task.setEndDate(deadline);
                    break;
                }
            }
        }

        public static Task getTask(int taskId) {
            for (int i = 0; i < tasksDatabaseList.size(); i++) {
                if (tasksDatabaseList.get(i).getTaskId() == taskId) {
                    return tasksDatabaseList.get(i);
                }
            }
            return null;
        }

        public static List<Task> getAllTasks() {
            return tasksDatabaseList;
        }

        public static void deleteTask(int id) {
            for (int i = 0; i < tasksDatabaseList.size(); i++) {
                if (tasksDatabaseList.get(i).getTaskId() == id) {
                    tasksDatabaseList.remove(i);
                    break;
                }
            }
        }
    }