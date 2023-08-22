package it.unibs.se_project.business;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Prenotazione {
    private String cliente;
    private int numeroCoperti;
    // TODO
    // invariante
    // Σ(ordine in ordini).quantita >= numeroCoperti
    // significa che ogni cliente ordina almeno un piatto
    private Ordine[] ordini;

    @JsonCreator
    public Prenotazione(
        @JsonProperty("cliente") String cliente,
        @JsonProperty("numero_coperti") int numeroCoperti,
        @JsonProperty("ordini") Ordine[] ordini
    ) {
        this.cliente = cliente;
        this.numeroCoperti = numeroCoperti;
        this.ordini = ordini;
    }

    public String getNome() {
        return this.cliente;
    }

    public int getnumeroCoperti() {
        return this.numeroCoperti;
    }

    public Ordine[] getOrdine() {
        return this.ordini;
    }

    @Override
    public String toString() {
      return "Prenotazione [cliente=" + cliente
        + ", numeroCoperti=" + numeroCoperti
        + ", ordini=" + Arrays.toString(ordini) + "]";
    }
}
