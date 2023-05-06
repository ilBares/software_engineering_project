package it.unibs.se_project.model;

import java.util.List;

public class MenuCarta {
    private List<Piatto> piatti;

    public MenuCarta(List<Piatto> piatti) {
        this.piatti = piatti;
    }

    public List<Piatto> getPiatti() {
        return this.piatti;
    }
}
