package it.unibs.se_project.model;

import it.unibs.se_project.enums.UnitaDiMisura;

public abstract class ItemExtra {
    private String nome;
    private double quantita;
    private UnitaDiMisura unitaDiMisura;

    public ItemExtra(String nome, double quantita, UnitaDiMisura unitaDiMisura) {
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

    public UnitaDiMisura getUnitaDiMisura() {
        return unitaDiMisura;
    }
}
