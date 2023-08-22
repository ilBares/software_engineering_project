package it.unibs.se_project.business;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ordine {
    private String nomePiatto;
    private int quantita;

    @JsonCreator
    public Ordine (
        @JsonProperty("nome_piatto") String nomePiatto,
        @JsonProperty("quantita") int quantita
    ) {
        this.nomePiatto = nomePiatto;
        this.quantita = quantita;
    }

    public String getNomePiatto() {
        return nomePiatto;
    }

    public int getQuantita() {
        return quantita;
    }

    @Override
    public String toString() {
        return "Ordine [nomePiatto=" + nomePiatto + ", quantita=" + quantita + "]";
    }
}
