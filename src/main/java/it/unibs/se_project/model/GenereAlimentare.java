package it.unibs.se_project.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.unibs.se_project.enums.UnitaDiMisura;

public class GenereAlimentare extends Item {
    private static UnitaDiMisura defaultUnitaDiMisura = UnitaDiMisura.KG;

    @JsonCreator
    public GenereAlimentare(
        @JsonProperty("nome") String nome,
        @JsonProperty("quantita") double quantita
    ) {
        super(nome, quantita, defaultUnitaDiMisura);
    }

    public static void configure(UnitaDiMisura unitaDiMisura) {
        defaultUnitaDiMisura = unitaDiMisura;
    }
}
