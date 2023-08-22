package it.unibs.se_project.business;

import java.util.List;

// MenuCarta non viene inizializzato da una repository
// ogni giorno viene aggiornato partendo da PiattiRepositoryService
// e badandosi sui soli piatti validi nella data considerata
public class MenuCarta {
    private List<Piatto> piatti;

    public MenuCarta(List<Piatto> piatti) {
        this.piatti = piatti;
    }

    public List<Piatto> getPiatti() {
        return this.piatti;
    }
}
