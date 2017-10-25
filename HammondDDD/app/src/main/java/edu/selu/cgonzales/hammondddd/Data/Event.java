package edu.selu.cgonzales.hammondddd.Data;

import java.util.Date;

public class Event extends Entity{

    private Date eventDate;
    private String description;

    public Event(String name, String location,
                 Date eventDate, String description){
        super(name, location);
        this.eventDate = eventDate;
        this.description = description;
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
