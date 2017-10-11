package edu.selu.cgonzales.hammondddd.Data;

import java.util.Date;

public class Event {

    private String name;
    private Date eventDate;
    private String description;

    public Event(String name, Date eventDate, String description) {
        this.name = name;
        this.eventDate = eventDate;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
