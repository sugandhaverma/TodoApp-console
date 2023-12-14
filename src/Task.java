
class Task {
  private static int taskIdCounter = 1;

  private int taskId;
private String taskName;
private String taskStatus;
private String deadlineStartDate;
private String deadlineEndDate;

public Task(String taskName, String deadlineStartDate, String deadlineEndDate) {
        this.taskId = taskIdCounter++;
        this.taskName = taskName;
        this.taskStatus = "Pending"; // Default status
        this.deadlineStartDate = deadlineStartDate;
        this.deadlineEndDate = deadlineEndDate;
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

public String getTaskStatus() {
        return taskStatus;
        }

public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
        }

public String getDeadlineStartDate() {
        return deadlineStartDate;
        }

public void setDeadlineStartDate(String deadlineStartDate) {
        this.deadlineStartDate = deadlineStartDate;
        }

public String getDeadlineEndDate() {
        return deadlineEndDate;
        }

public void setDeadlineEndDate(String deadlineEndDate) {
        this.deadlineEndDate = deadlineEndDate;
        }
        }
