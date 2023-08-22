package it.unibs.se_project.business;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Piatto {
    // denominazione che compare nei menu
    private String nome;
    // un piatto può non essere disponibile per tutto l'arco dell'anno
    private String periodoValidita;
    private Ricetta ricetta;

    @JsonCreator
    public Piatto(
        @JsonProperty("nome_piatto") String nome,
        @JsonProperty("periodo_validita") String periodoValidita,
        @JsonProperty("ricetta") Ricetta ricetta
    ) {
        this.nome = nome;
        this.periodoValidita = periodoValidita;
        this.ricetta = ricetta;
    }

    public String getNome() {
        return this.nome;
    }

    public String getPeriodoValidita() {
        return periodoValidita;
    }

    public Ricetta getRicetta() {
        return ricetta;
    }

    public double getCaricoLavoro() {
        return ricetta.getCaricoLavoroPorzione();
    }

    @Override
    public String toString() {
        return "Piatto [nome=" + nome
            + ", periodoValidita=" + periodoValidita
            + ", ricetta=" + ricetta + "]";
    }
}
