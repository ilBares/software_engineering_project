package it.unibs.se_project.business;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// MenuCarta non viene inizializzato da una repository
// ogni giorno viene aggiornato partendo da PiattiRepositoryService
// e badandosi sui soli piatti validi nella data considerata
public class MenuCarta {
    private LocalDate date;
    private HashMap<String, Piatto> piattiMap = new HashMap<>();

    public MenuCarta(LocalDate date, List<Piatto> piatti) {
        this.date = date;
        piatti
            .stream()
            .forEach(p -> piattiMap.put(p.getNome(), p));
    }

    public LocalDate getDate() {
      return date;
    }
    
    public Map<String, Piatto> getPiattiMap() {
        return Collections.unmodifiableMap(piattiMap);
    }

    public List<Piatto> getPiattiList() {
        return List.copyOf(piattiMap.values());
    }

    public List<String> getPiattiNameList() {
        return List.copyOf(piattiMap.keySet());
    }

    public boolean contains(String nomePiatto) {
        return piattiMap.containsKey(nomePiatto);
    }
    // TODO
    
    // getPiatto from name
    // get Ricetta from name
    
}
