package cse213.todayjava.Rahat.UserFinancemanager;

import java.io.Serializable;

public class Monitorbudget  implements Serializable {
    private int Categoryname;
    private int Amountspend;
    private String Budgetcategory;

    public Monitorbudget(int categoryname, int amountspend, String budgetcategory) {
        Categoryname = categoryname;
        Amountspend = amountspend;
        Budgetcategory = budgetcategory;
    }

    public int getCategoryname() {
        return Categoryname;
    }

    public void setCategoryname(int categoryname) {
        Categoryname = categoryname;
    }

    public int getAmountspend() {
        return Amountspend;
    }

    public void setAmountspend(int amountspend) {
        Amountspend = amountspend;
    }

    public String getBudgetcategory() {
        return Budgetcategory;
    }

    public void setBudgetcategory(String budgetcategory) {
        Budgetcategory = budgetcategory;
    }

    @Override
    public String toString() {
        return "Monitorbudget{" +
                "Categoryname=" + Categoryname +
                ", Amountspend=" + Amountspend +
                ", Budgetcategory='" + Budgetcategory + '\'' +
                '}';
    }
}
