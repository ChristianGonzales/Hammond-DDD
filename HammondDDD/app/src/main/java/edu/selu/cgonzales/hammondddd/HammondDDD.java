package edu.selu.cgonzales.hammondddd;

import android.app.Application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.selu.cgonzales.hammondddd.Data.Business;
import edu.selu.cgonzales.hammondddd.Data.Event;

public class HammondDDD extends Application{
    /*
        Retrieve the vars using:
            HammondDDD context = (HammondDDD.getApplicationContext();
            do stuff...
     */
//    private Map<String, List<Business>> businessList;
    private List<Event> eventList;

    /**
     * Creates the lists for the application to use, stored in the application's context.
     */
    @Override
    public void onCreate(){
        // TODO - create and fill the business list
        super.onCreate();
        eventList = new ArrayList<>();

        try {
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
            eventList.add(new Event("DDD Board of Directors Meeting", "312 E. Charles St., Hammond, LA 70401",
                    formatter.parse("10/30/2017 5:30 PM"), "DDD Board of Directors Meeting " +
                    "\n5:30pm \nCity Council Chambers"));
            eventList.add(new Event("Shower of Blessings: Halleujah Night", "Downtown Hammond, LA",
                    formatter.parse("10/31/2017 6:00 PM"), "Come out for our annual hallelujah " +
                    "night for a safe and fun environment with lots of candy. " +
                    "It's FREE and open to the public."));
            eventList.add(new Event("Design Committee Meeting", "312 N. Charles St., Hammond, LA 70401",
                    formatter.parse("11/02/2017 11:30 PM"), "Monthly Design Committee Meeting" +
                    " \nThursday, Oct 5, 2017 \n 11:30am \nCity Council Chambers"));
            eventList.add(new Event("Downtown Past Sundown", "Downtown Hammond, LA",
                    formatter.parse("11/16/2017 5:00 PM"), "Ghosts, goblins and creatures of fright " +
                    "are all welcome to our trick-or-treat night!"));
            eventList.add(new Event("Design Committee Meeting", "312 N. Charles St., Hammond, LA 70401",
                    formatter.parse("12/07/2017 11:30 PM"), "Monthly Design Committee Meeting " +
                    "\nThursday, Dec 7, 2017 \n 11:30am \nCity Council Chambers"));
            eventList.add(new Event("Downtown Past Sundown", "Downtown Hammond, LA",
                    formatter.parse("01/18/2018 5:00 PM"), "Ghosts, goblins and creatures of fright " +
                    "are all welcome to our trick-or-treat night!"));
        } catch (ParseException e) {
            System.out.println("Parse Exception");
        }
    }

    public List<Event> getEventList() {
        return eventList;
    }

}
