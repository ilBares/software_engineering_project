package it.unibs.se_project.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Calendario {
    private HashMap<String, WorkingDay> calendar = new HashMap<>();

    @JsonCreator
    public Calendario(
        @JsonProperty("calendario") HashMap<String, WorkingDay> calendar
    ) {
        this.calendar = calendar;
        // List.of(workingDays)
        //     .stream()
        //     .forEach(wDay -> calendar.put(wDay.getDay(), wDay));
    }

    public HashMap<String, WorkingDay> getCalendar() {
        return calendar;
    }

    public List<Prenotazione> getPrenotazioni() {
        return calendar.values()
            .stream()
            .flatMap(wd -> wd.getPrenotazioni().stream())
            .collect(Collectors.toList());
    }

    public List<Prenotazione> getPrenotazioni(LocalDate date) {
        WorkingDay wd = calendar.get(date.toString());
        return wd != null
            ? wd.getPrenotazioni()
            : new ArrayList<Prenotazione>();
    }

    public boolean addPrenotazione(Prenotazione prenotazione, LocalDate date, List<Piatto> piatti) {
        String dateString = date.toString();

        boolean contained = calendar.containsKey(dateString);

        if (!contained) {
            _createWorkingDay(date, prenotazione, piatti);
        } else {

        }

        // calendar.put(date.toString(), );
        return true;
    }

    public void _createWorkingDay(LocalDate date, Prenotazione prenotazioni, List<Piatto> piatti) {
        
        // WorkingDay wd = new WorkingDay(prenotazioni, null);
    }

    public void _itemListaSpesaFromPrenotazione() {
        ItemListaSpesa item = new ItemListaSpesa(null, 0, null);

    }

    @Override
    public String toString() {
        return "Calendar [calendar=" + calendar + "]";
    }
}
