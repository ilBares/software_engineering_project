package it.unibs.se_project.business;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Prenotazione {
    private String cliente;
    private int numeroCoperti;
    // TODO
    // invariante
    // Σ(ordine in ordini).quantita >= numeroCoperti
    // significa che ogni cliente ordina almeno un piatto
    private List<Ordine> ordini;

    @JsonCreator
    public Prenotazione(
        @JsonProperty("cliente") String cliente,
        @JsonProperty("numero_coperti") int numeroCoperti,
        @JsonProperty("ordini") Ordine[] ordini
    ) {
        this.cliente = cliente;
        this.numeroCoperti = numeroCoperti;
        this.ordini = new ArrayList<Ordine>(List.of(ordini));
    }

    public String getNome() {
        return this.cliente;
    }

    public int getNumeroCoperti() {
        return this.numeroCoperti;
    }

    public List<Ordine> getOrdini() {
        return this.ordini;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setNumeroCoperti(int numeroCoperti) {
        this.numeroCoperti = numeroCoperti;
    }

    public void setOrdini(List<Ordine> ordini) {
        this.ordini = ordini;
    }

    public void addOrdine(Ordine ordine) {
        ordini.add(ordine);
    }

    public static Prenotazione emptyPrenotazione(String name, int numeroCoperti) {
        return new Prenotazione(name, numeroCoperti, new Ordine[0]);
    }

    @Override
    public String toString() {
      return "Prenotazione [cliente=" + cliente
        + ", numeroCoperti=" + numeroCoperti
        + ", ordini=" + ordini + "]";
    }
}
