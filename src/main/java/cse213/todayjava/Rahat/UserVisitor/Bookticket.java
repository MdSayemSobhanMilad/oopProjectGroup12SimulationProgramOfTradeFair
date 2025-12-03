package cse213.todayjava.Rahat.UserVisitor;

import java.io.Serializable;
import java.time.LocalDate;

public class Bookticket implements Serializable {
    private String Name;
    private Integer phoneNumber;
    private Integer TicketId;
    private String Gender;
    private LocalDate Date;

    public Bookticket(String name, Integer phoneNumber, Integer ticketId, String gender, LocalDate date) {
        Name = name;
        this.phoneNumber = phoneNumber;
        TicketId = ticketId;
        Gender = gender;
        Date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getTicketId() {
        return TicketId;
    }

    public void setTicketId(Integer ticketId) {
        TicketId = ticketId;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "Bookticket{" +
                "Name='" + Name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", TicketId=" + TicketId +
                ", Gender='" + Gender + '\'' +
                ", Date=" + Date +
                '}';
    }
}
