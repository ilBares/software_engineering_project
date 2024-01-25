package it.unibs.se_project.business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Calendario {
    private HashMap<String, WorkingDay> calendarioMap = new HashMap<>();

    @JsonCreator
    public Calendario(
        @JsonProperty("calendario") HashMap<String, WorkingDay> calendarioMap
    ) {
        this.calendarioMap = calendarioMap;
    }

    @JsonProperty("calendario")
    public HashMap<String, WorkingDay> getCalendarioMap() {
        return calendarioMap;
    }

    @JsonIgnore
    public List<Prenotazione> getPrenotazioni() {
        return calendarioMap.values()
            .stream()
            .flatMap(wd -> wd.getPrenotazioni().stream())
            .collect(Collectors.toList());
    }

    public List<Prenotazione> getPrenotazioni(LocalDate date) {
        WorkingDay wd = calendarioMap.get(date.toString());
        return wd != null
            ? wd.getPrenotazioni()
            : new ArrayList<Prenotazione>();
    }

    public void addPrenotazione(Prenotazione prenotazione, MenuCarta menuCarta, List<Bevanda> bevande, List<GenereExtra> generiExtra) {
        String dateString = menuCarta.getDate().toString();
        boolean dayExist = calendarioMap.containsKey(dateString);

        if (!dayExist) {
            _createWorkingDay(dateString);
        }

        WorkingDay wd = calendarioMap.get(dateString);
        wd.addPrenotazione(prenotazione, menuCarta);

        wd.addBevande(bevande, prenotazione.getNumeroCoperti());
        wd.addGeneriExtra(generiExtra, prenotazione.getNumeroCoperti());
    }

    public boolean removeOldPrenotazioni() {
        boolean removed = false;
        final LocalDate now = LocalDate.now();
        
        // Imposta il formato ISO per la lettura delle date
        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;

        Iterator<String> iterator = calendarioMap.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            LocalDate date = LocalDate.parse(key, dateFormatter);

            if (now.compareTo(date) > 0) {
                iterator.remove();
                removed = true;
            }   
        }
        return removed;
    }

    public void _createWorkingDay(String dateString) {
        WorkingDay wd = WorkingDay.emptyWorkingDay();
        calendarioMap.put(dateString, wd);
    }

    public void _itemListaSpesaFromPrenotazione() {
        // ItemListaSpesa item = new ItemListaSpesa(null, 0, null);

    }

    @Override
    public String toString() {
        return "Calendar [calendario=" + calendarioMap + "]";
    }
}
