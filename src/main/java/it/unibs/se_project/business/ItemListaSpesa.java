package it.unibs.se_project.business;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.unibs.se_project.enums.UnitaDiMisura;

public class ItemListaSpesa extends Item {

    @JsonCreator
    public ItemListaSpesa(
        @JsonProperty("nome") String nome,
        @JsonProperty("quantita") double quantita,
        @JsonProperty("unita_misura") UnitaDiMisura unitaMisura
    ) {
        super(nome, quantita, unitaMisura);
    }
}
