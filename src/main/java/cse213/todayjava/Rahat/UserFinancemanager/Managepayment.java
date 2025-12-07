package cse213.todayjava.Rahat.UserFinancemanager;

import java.io.Serializable;
import java.time.LocalDate;

public class Managepayment implements Serializable {
    private int Transactionid;
    private int AmountPaid;
    private String Paymentstatus;

    public Managepayment(int transactionid, int amountPaid, String paymentstatus) {
        Transactionid = transactionid;
        AmountPaid = amountPaid;
        Paymentstatus = paymentstatus;
    }

    public int getTransactionid() {
        return Transactionid;
    }

    public void setTransactionid(int transactionid) {
        Transactionid = transactionid;
    }

    public int getAmountPaid() {
        return AmountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        AmountPaid = amountPaid;
    }

    public String getPaymentstatus() {
        return Paymentstatus;
    }

    public void setPaymentstatus(String paymentstatus) {
        Paymentstatus = paymentstatus;
    }

    @Override
    public String toString() {
        return "Managepayment{" +
                "Transactionid=" + Transactionid +
                ", AmountPaid=" + AmountPaid +
                ", Paymentstatus='" + Paymentstatus + '\'' +
                '}';
    }
}
