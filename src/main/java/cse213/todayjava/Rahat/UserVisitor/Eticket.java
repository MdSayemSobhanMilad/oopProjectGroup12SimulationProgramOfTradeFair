package cse213.todayjava.Rahat.UserVisitor;

import java.io.Serializable;
import java.time.LocalDate;

public class Eticket implements Serializable {
    private String Name;
    private int Number;
    private String Eventtype;
    private String Tickettype;
    private LocalDate Eventdate;

    public Eticket(String name, int number, String eventtype, String tickettype, LocalDate eventdate) {
        Name = name;
        Number = number;
        Eventtype = eventtype;
        Tickettype = tickettype;
        Eventdate = eventdate;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getEventtype() {
        return Eventtype;
    }

    public void setEventtype(String eventtype) {
        Eventtype = eventtype;
    }

    public String getTickettype() {
        return Tickettype;
    }

    public void setTickettype(String tickettype) {
        Tickettype = tickettype;
    }

    public LocalDate getEventdate() {
        return Eventdate;
    }

    public void setEventdate(LocalDate eventdate) {
        Eventdate = eventdate;
    }

    @Override
    public String toString() {
        return "Eticket{" +
                "Name='" + Name + '\'' +
                ", Number=" + Number +
                ", Eventtype='" + Eventtype + '\'' +
                ", Tickettype='" + Tickettype + '\'' +
                ", Eventdate=" + Eventdate +
                '}';
    }
}
