package cse213.todayjava.Milad.UserSecurityPersonnel;

import java.time.LocalDateTime;
import java.util.Map;

public class Watchlist {
    private String entryId;
    private String personNameDescription;
    private String reason;


    public Watchlist() {}

    public Watchlist(String entryId, String personNameDescription, String reason) {
        this.entryId = entryId;
        this.personNameDescription = personNameDescription;
        this.reason = reason;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getPersonNameDescription() {
        return personNameDescription;
    }

    public void setPersonNameDescription(String personNameDescription) {
        this.personNameDescription = personNameDescription;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Watchlist{" +
                "entryId='" + entryId + '\'' +
                ", personNameDescription='" + personNameDescription + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
