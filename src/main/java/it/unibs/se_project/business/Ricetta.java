package it.unibs.se_project.business;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ricetta {
    private int porzioni;
    // caricoLavoroPorzione < Config.caricoLavoroPersona
    private double caricoLavoroPorzione;
    private List<Ingrediente> ingredienti;

    @JsonCreator
    public Ricetta(
        @JsonProperty("porzioni") int porzioni,
        @JsonProperty("carico_lavoro_porzione") double caricoLavoroPorzione,
        @JsonProperty("ingredienti") List<Ingrediente> ingredienti
    ) {
        this.porzioni = porzioni;
        this.caricoLavoroPorzione = caricoLavoroPorzione;
        this.ingredienti = ingredienti;
    }

    public int getPorzioni() {
        return this.porzioni;
    }

    public double getCaricoLavoroPorzione() {
        return this.caricoLavoroPorzione;
    }

    public List<Ingrediente> getIngredienti() {
        return this.ingredienti;
    }

    @Override
    public String toString() {
        return "Ricetta [porzioni=" + porzioni
            + ", caricoLavoroPorzione=" + caricoLavoroPorzione
            + ", ingredienti=" + ingredienti + "]";
    }   
}
