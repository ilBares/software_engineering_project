package it.unibs.se_project.model;

public class RegistroMagazzino {
    private String merce;
    private double quantita;
    private String unitaMisura;

    public RegistroMagazzino(String merce, double quantita, String unitaMisura) {
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
