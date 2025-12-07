package cse213.todayjava.Rahat.UserFinancemanager;

import java.io.Serializable;
import java.time.LocalDate;

public class Revenuerecord implements Serializable {
    private int Transactionid;
    private int Amount;
    private String Revenuetype;
    private LocalDate Date;

    public Revenuerecord(int transactionid, int amount, String revenuetype, LocalDate date) {
        Transactionid = transactionid;
        Amount = amount;
        Revenuetype = revenuetype;
        Date = date;
    }

    public int getTransactionid() {
        return Transactionid;
    }

    public void setTransactionid(int transactionid) {
        Transactionid = transactionid;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getRevenuetype() {
        return Revenuetype;
    }

    public void setRevenuetype(String revenuetype) {
        Revenuetype = revenuetype;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "Revenuerecord{" +
                "Transactionid=" + Transactionid +
                ", Amount=" + Amount +
                ", Revenuetype='" + Revenuetype + '\'' +
                ", Date=" + Date +
                '}';
    }
}
