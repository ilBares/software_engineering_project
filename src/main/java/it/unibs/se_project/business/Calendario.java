package it.unibs.se_project.business;

import java.util.Date;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Calendario {
    private HashMap<Date, WorkingDay> calendar = new HashMap<>();

    @JsonCreator
    public Calendario(
        @JsonProperty("calendario") HashMap<Date, WorkingDay> calendar
    ) {
        this.calendar = calendar;
        // List.of(workingDays)
        //     .stream()
        //     .forEach(wDay -> calendar.put(wDay.getDay(), wDay));
    }

    public HashMap<Date, WorkingDay> getCalendar() {
        return calendar;
    }

    @Override
    public String toString() {
        return "Calendar [calendar=" + calendar + "]";
    }
}
