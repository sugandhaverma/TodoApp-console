package Validator;

import DTO.Task;
import DTO.TaskStatusEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskValidator {

    public static boolean isTaskNameValid(String taskName) {
        return taskName != null && !taskName.trim().isEmpty();
    }

    public static boolean isTaskStatusValid(TaskStatusEnum taskStatus) {
        return taskStatus != null;
    }

    public static boolean isDeadlineValid(String deadline) {
        // Validate that the deadline is the current date or in the future
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        try {
            Date currentDate = new Date();
            Date inputDate = dateFormat.parse(deadline);

            return !inputDate.before(currentDate);
        } catch (ParseException e) {
            return false; // If parsing fails, consider it invalid
        }
    }

    public static boolean validateTask(Task task) {
        boolean isTaskNameValid = isTaskNameValid(task.getTaskName());
        boolean isTaskStatusValid = isTaskStatusValid(task.getTaskStatus());
        boolean isDeadlineValid = isDeadlineValid(task.getDeadline());

        return isTaskNameValid && isTaskStatusValid && isDeadlineValid;
    }
}
