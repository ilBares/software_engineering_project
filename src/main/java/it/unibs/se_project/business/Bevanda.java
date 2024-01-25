package it.unibs.se_project.business;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.unibs.se_project.business.enums.UnitaDiMisura;

public class Bevanda extends Item {
    private static UnitaDiMisura defaultUnitaDiMisura = UnitaDiMisura.L;

    @JsonCreator
    public Bevanda(
        @JsonProperty("nome") String nome,
        @JsonProperty("quantita") double quantita
    ) {
        // "quantita" fa riferimento al "consumo pro capite" della bevanda
        super(nome, quantita, defaultUnitaDiMisura);
    }

    public static void configure(UnitaDiMisura unitaDiMisura) {
        defaultUnitaDiMisura = unitaDiMisura;
    }
}
