package cse213.todayjava.Milad.UserMaintenanceStaff;


import java.time.LocalDate;

public class DailyMaintanenceTask {
    private String taskId;
    private String taskType;
    private String taskDescricption;
    private String status;
    private LocalDate todayDate;

    public DailyMaintanenceTask(String taskId, String taskType, String taskDescricption, String status) {
        this.taskId = taskId;
        this.taskType = taskType;
        this.taskDescricption = taskDescricption;
        this.status = status;
        this.todayDate = LocalDate.now();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskDescricption() {
        return taskDescricption;
    }

    public void setTaskDescricption(String taskDescricption) {
        this.taskDescricption = taskDescricption;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(LocalDate todayDate) {
        this.todayDate = todayDate;
    }

    @Override
    public String toString() {
        return "DailyMaintanenceTask{" +
                "taskId='" + taskId + '\'' +
                ", taskType='" + taskType + '\'' +
                ", taskDescricption='" + taskDescricption + '\'' +
                ", status='" + status + '\'' +
                ", todayDate=" + todayDate +
                '}';
    }

    public static void saveFile(DailyMaintanenceTask n) {
        try {
            java.io.File file = new java.io.File("dailyTask.bin");
            java.io.ObjectOutputStream oos;

            if (file.exists() && file.length() > 0) {
                oos = new java.io.ObjectOutputStream(
                        new java.io.FileOutputStream("dailyTask.bin", true)) {
                    protected void writeStreamHeader() {
                        // Empty override for appending
                    }
                };
            } else {
                oos = new java.io.ObjectOutputStream(
                        new java.io.FileOutputStream("dailyTask.bin"));
            }

            oos.writeObject(n);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static java.util.ArrayList<DailyMaintanenceTask> loadFile() {
        java.util.ArrayList<DailyMaintanenceTask> newsList = new java.util.ArrayList<>();
        try {
            java.io.File file = new java.io.File("dailyTask.bin");
            if (!file.exists() || file.length() == 0) {
                return newsList;
            }

            java.io.ObjectInputStream ois = new java.io.ObjectInputStream(
                    new java.io.FileInputStream("dailyTask.bin"));

            while (true) {
                try {
                    DailyMaintanenceTask news = (DailyMaintanenceTask) ois.readObject();
                    newsList.add(news);
                } catch (java.io.EOFException e) {
                    break;
                }
            }
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsList;
    }
}
