package cse213.todayjava.Milad.UserMaintenanceStaff;

import java.util.Arrays;

public class ChartData {
    private String name;
    private int data;

    public ChartData() {
    }

    public ChartData(String name, int data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ChartData{" +
                "name='" + name + '\'' +
                ", data=" + data +
                '}';
    }
}
