package it.unibs.se_project.business;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.unibs.se_project.enums.UnitaDiMisura;

public class Config {
    private int anticipoGiorniPrenotazione;
    private int caricoLavoroPersona;
    private int numeroPosti;

    private UnitaDiMisura unitaBevande;
    private UnitaDiMisura unitaGeneriExtra;

    @JsonCreator
    public Config(
        @JsonProperty("anticipo_giorni_prenotazione") int anticipoGiorniPrenotazione,
        @JsonProperty("carico_lavoro_persona") int caricoLavoroPersona,
        @JsonProperty("numero_posti") int numeroPosti,
        @JsonProperty("unita_misura_bevande") UnitaDiMisura unitaBevande,
        @JsonProperty("unita_misura_generi_alimentari") UnitaDiMisura unitaGeneriExtra
    ) {
        this.anticipoGiorniPrenotazione = anticipoGiorniPrenotazione;
        this.caricoLavoroPersona = caricoLavoroPersona;
        this.numeroPosti = numeroPosti;
        this.unitaBevande = unitaBevande;
        this.unitaGeneriExtra = unitaGeneriExtra;
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

    public UnitaDiMisura getUnitaGeneriExtra() {
        return unitaGeneriExtra;
    }

    // derivata
    // se rimane senza setter si può anche settare la prima volta se null
    public double getCaricoLavoroSostenibile() {
        // caricoLavoroSostenibile = caricoLavoroPersona * (numeroPosti + 20%)
        return caricoLavoroPersona * (numeroPosti + 0.2 * numeroPosti);
    }

    @Override
    public String toString() {
        return "Config [anticipoGiorniPrenotazione=" + anticipoGiorniPrenotazione
            + ", caricoLavoroPersona=" + caricoLavoroPersona
            + ", numeroPosti=" + numeroPosti
            + ", unitaBevande=" + unitaBevande
            + ", unitaGeneriExtra=" + unitaGeneriExtra + "]";
    }
}
