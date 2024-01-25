package it.unibs.se_project.business;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.unibs.se_project.business.enums.UnitaDiMisura;

public class Item {
    private String nome;
    private double quantita;
    private UnitaDiMisura unitaDiMisura;

    @JsonCreator
    public Item(
        @JsonProperty("nome") String nome,
        @JsonProperty("quantita") double quantita,
        @JsonProperty("unita_misura") UnitaDiMisura unitaDiMisura
    ) {
        this.nome = nome;
        this.quantita = quantita;
        this.unitaDiMisura = unitaDiMisura;
    }

    public String getNome() {
        return nome;
    }

    public double getQuantita() {
        return quantita;
    }

    @JsonProperty("unita_misura")
    public UnitaDiMisura getUnitaDiMisura() {
        return unitaDiMisura;
    }

    public void setUnitaDiMisura(UnitaDiMisura unitaDiMisura) {
        this.unitaDiMisura = unitaDiMisura;
    }

    public void updateQuantita(double additional) {
        quantita += additional;
    }

    @Override
    public String toString() {
        return "ItemExtra [nome=" + nome + ", quantita=" + quantita + ", unitaDiMisura=" + unitaDiMisura + "]";
    }
}
