package cse213.todayjava.Milad.UserMaintenanceStaff;

import java.time.LocalDate;

public class ReportParameters {
    private LocalDate startMonth;
    private LocalDate endMonth;
    private int absence;

    public ReportParameters() {
    }

    public ReportParameters(LocalDate startMonth, LocalDate endMonth, int absence) {
        this.startMonth = startMonth;
        this.endMonth = endMonth;
        this.absence = absence;
    }

    @Override
    public String toString() {
        return "ReportParameters{" +
                "startMonth=" + startMonth +
                ", endMonth=" + endMonth +
                ", absence=" + absence +
                '}';
    }

    public LocalDate getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(LocalDate startMonth) {
        this.startMonth = startMonth;
    }

    public LocalDate getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(LocalDate endMonth) {
        this.endMonth = endMonth;
    }

    public int getAbsence() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }

    public int getSalary(){
        int a = this.endMonth.getDayOfMonth();
        int b = this.startMonth.getDayOfMonth();

        int workingDay = a - b - absence;

        return (workingDay * 1000);
    }
}
