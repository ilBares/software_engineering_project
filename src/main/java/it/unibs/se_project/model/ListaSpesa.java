package it.unibs.se_project.model;

public class ListaSpesa {
    private String merce;
    private double quantita;
    private String unitaMisura;

    public ListaSpesa(String merce, double quantita, String unitaMisura) {
        this.merce = merce;
        this.quantita = quantita;
        this.unitaMisura = unitaMisura;
    }

    public String getMerce() {
        return this.merce;
    }

    public double getQuantita() {
        return this.quantita;
    }

    public String getUnitaMisura() {
        return this.unitaMisura;
    }
}
