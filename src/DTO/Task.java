package DTO;

public class Task {
    private static int taskIdCounter = 1;

    private int taskId;
    private String taskName;
    private TaskStatusEnum taskStatus;
    private String deadline;

    public Task(String taskName, TaskStatusEnum taskStatus, String deadline) {
        this.taskId = taskIdCounter++;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
        this.deadline = deadline;
}
    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public TaskStatusEnum getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatusEnum taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskStatus=" + taskStatus +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}