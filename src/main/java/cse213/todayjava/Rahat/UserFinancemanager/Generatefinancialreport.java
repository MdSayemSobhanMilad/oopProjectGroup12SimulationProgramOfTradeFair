package cse213.todayjava.Rahat.UserFinancemanager;

import java.io.Serializable;

public class Generatefinancialreport  implements Serializable {
    private String Reporttitle;
    private String Reporttype;

    public Generatefinancialreport(String reporttitle, String reporttype) {
        Reporttitle = reporttitle;
        Reporttype = reporttype;
    }

    public String getReporttitle() {
        return Reporttitle;
    }

    public void setReporttitle(String reporttitle) {
        Reporttitle = reporttitle;
    }

    public String getReporttype() {
        return Reporttype;
    }

    public void setReporttype(String reporttype) {
        Reporttype = reporttype;
    }

    @Override
    public String toString() {
        return "Generatefinancialreport{" +
                "Reporttitle='" + Reporttitle + '\'' +
                ", Reporttype='" + Reporttype + '\'' +
                '}';
    }
}
