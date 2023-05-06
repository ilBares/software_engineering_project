package it.unibs.se_project.model;

import it.unibs.se_project.enums.UnitaDiMisura;

public class Config {
    private int anticipoGiorniPrenotazione;
    private int caricoLavoroPersona;
    private int numeroPosti;

    private UnitaDiMisura unitaBevande;
    private UnitaDiMisura unitaGeneriAlimentari;

    public Config(int anticipoGiorniPrenotazione, int caricoLavoroPersona, int numeroPosti,
            UnitaDiMisura unitaBevande, UnitaDiMisura unitaGeneriAlimentari) {
        this.anticipoGiorniPrenotazione = anticipoGiorniPrenotazione;
        this.caricoLavoroPersona = caricoLavoroPersona;
        this.numeroPosti = numeroPosti;
        this.unitaBevande = unitaBevande;
        this.unitaGeneriAlimentari = unitaGeneriAlimentari;
    }

    public int getAnticipoGiorniPrenotazione() {
        return anticipoGiorniPrenotazione;
    }

    public int getCaricoLavoroPersona() {
        return caricoLavoroPersona;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public UnitaDiMisura getUnitaBevande() {
        return unitaBevande;
    }

    public UnitaDiMisura getUnitaGeneriAlimentari() {
        return unitaGeneriAlimentari;
    }
}
