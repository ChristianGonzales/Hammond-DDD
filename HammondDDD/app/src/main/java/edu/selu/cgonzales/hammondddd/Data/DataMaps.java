package edu.selu.cgonzales.hammondddd.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataMaps {

    private Map<String, List<Business>> businessList;
    private List<Event> eventList;

    public DataMaps(){
        this.businessList = new HashMap<>();
        this.eventList = new ArrayList<>();

        // TODO - fill the maps with data in the constructor
    }

    public Map<String, List<Business>> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(Map<String, List<Business>> businessList) {
        this.businessList = businessList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
