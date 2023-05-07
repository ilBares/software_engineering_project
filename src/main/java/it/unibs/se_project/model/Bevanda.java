package it.unibs.se_project.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.unibs.se_project.enums.UnitaDiMisura;

public class Bevanda extends Item {
    private static UnitaDiMisura defaultUnitaDiMisura = UnitaDiMisura.L;

    @JsonCreator
    public Bevanda(
        @JsonProperty("nome") String nome,
        @JsonProperty("quantita") double quantita
    ) {
        super(nome, quantita, defaultUnitaDiMisura);
    }

    public static void configure(UnitaDiMisura unitaDiMisura) {
        defaultUnitaDiMisura = unitaDiMisura;
    }
}
