import java.util.Date;

class Task {
  private static int taskIdCounter = 1;

  private int taskId;
private String taskName;
private String taskStatus;
private Date startDate;
private Date endDate;

public Task(int taskId, String taskName, String taskStatus,Date startDate, Date endDate) {
        this.taskId = taskIdCounter++;
        this.taskName = taskName;
        this.taskStatus = "TODO"; // Default status
        this.startDate = startDate;
        this.endDate = endDate;
        }

public int getTaskId() {
        return taskId;
        }

        //        public void setTaskId(int TaskId) {
//                this.TaskId = TaskId;
//        }

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

        public Date getStartDate() {
                return startDate;
        }

        public void setStartDate(Date startDate) {
                this.startDate = startDate;
        }

        public Date getEndDate() {
                return endDate;
        }

        public void setEndDate(Date endDate) {
                this.endDate = endDate;
        }
}
