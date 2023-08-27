package it.unibs.se_project.business;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ordine {
    private String nomePiatto;
    private int numeroPersone;

    @JsonCreator
    public Ordine(
        @JsonProperty("nome_piatto") String nomePiatto,
        @JsonProperty("numero_persone") int numeroPersone
    ) {
        this.nomePiatto = nomePiatto;
        this.numeroPersone = numeroPersone;
    }

    public String getNomePiatto() {
        return nomePiatto;
    }

    public int getNumeroPersone() {
        return numeroPersone;
    }

    @Override
    public String toString() {
        return "Ordine [nomePiatto=" + nomePiatto
            + ", numeroPersone=" + numeroPersone + "]";
    }
}
