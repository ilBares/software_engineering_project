package it.unibs.se_project.business;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Prenotazione {
    private String cliente;
    private int numeroCoperti;
    private double caricoLavoroRichiesto;
    // invariante
    // Σ(ordine in ordini).quantita >= numeroCoperti
    // significa che ogni cliente ordina almeno un piatto
    private List<Ordine> ordini;

    @JsonCreator
    public Prenotazione(
        @JsonProperty("cliente") String cliente,
        @JsonProperty("numero_coperti") int numeroCoperti,
        @JsonProperty("carico_lavoro_richiesto") double caricoLavoroRichiesto,
        @JsonProperty("ordini") Ordine[] ordini
    ) {
        this.cliente = cliente;
        this.numeroCoperti = numeroCoperti;
        this.caricoLavoroRichiesto = caricoLavoroRichiesto;
        this.ordini = new ArrayList<Ordine>(List.of(ordini));
    }

    public static Prenotazione emptyPrenotazione(String name, int numeroCoperti) {
        return new Prenotazione(name, numeroCoperti, 0, new Ordine[0]);
    }

    @JsonProperty("cliente")
    public String getCliente() {
        return this.cliente;
    }

    @JsonProperty("numero_coperti")
    public int getNumeroCoperti() {
        return this.numeroCoperti;
    }

    @JsonProperty("ordini")
    public List<Ordine> getOrdini() {
        return this.ordini;
    }
    
    @JsonProperty("carico_lavoro_richiesto")
    public double getCaricoLavoroRichiesto() {
        return caricoLavoroRichiesto;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setNumeroCoperti(int numeroCoperti) {
        this.numeroCoperti = numeroCoperti;
    }
    
    public void setCaricoLavoroRichiesto(double caricoLavoroRichiesto) {
        this.caricoLavoroRichiesto = caricoLavoroRichiesto;
    }

    public void setOrdini(List<Ordine> ordini) {
        this.ordini = ordini;
    }

    public void addOrdine(Ordine ordine) {
        ordini.add(ordine);
    }

    @Override
    public String toString() {
      return "Prenotazione [cliente=" + cliente
        + ", numeroCoperti=" + numeroCoperti
        + ", ordini=" + ordini + "]";
    }
}
