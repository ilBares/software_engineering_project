package it.unibs.se_project.model;

import java.util.List;

public class Ricetta {
    private int porzione;
    private double caricoLavoroPorzione;
    private List<Ingrediente> ingredienti;

    public Ricetta(int porzione, double caricoLavoroPorzione, List<Ingrediente> ingredienti) {
        this.porzione = porzione;
        this.caricoLavoroPorzione = caricoLavoroPorzione;
        this.ingredienti = ingredienti;
    }

    public int getPorzione() {
        return this.porzione;
    }

    public double getCaricoLavoroPorzione() {
        return this.caricoLavoroPorzione;
    }

    public List<Ingrediente> getIngredienti() {
        return this.ingredienti;
    }
}
