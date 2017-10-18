package edu.selu.cgonzales.hammondddd.Data;

import java.util.Date;

public class Event {

    private String name;
    public String subName;
    private Date eventDate;
    private String description;

    public Event(String name, String subName, Date eventDate, String description) {
        this.name = name;
        this.subName = subName;

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

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }
}
