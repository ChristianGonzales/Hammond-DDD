package edu.selu.cgonzales.hammondddd.Data;

import java.util.Date;

public class Event extends Entity{

    public String subName;
    private Date eventDate;
    private String description;

    public Event(String name, String location, String subName,
                 Date eventDate, String description){
        super(name, location);
        this.subName = subName;
        this.eventDate = eventDate;
        this.description = description;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
