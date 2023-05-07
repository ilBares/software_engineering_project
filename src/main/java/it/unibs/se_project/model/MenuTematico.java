package it.unibs.se_project.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuTematico {
    private String nome;
    private String periodoValidita;
    private String[] nomiPiatti;

    @JsonCreator
    public MenuTematico(
        @JsonProperty("nome") String nome,
        @JsonProperty("periodo_validita") String periodoValidita,
        @JsonProperty("nomi_piatti") String[] piatti
    ) {
        this.nome = nome;
        this.periodoValidita = periodoValidita;
        this.nomiPiatti = piatti;
    }

    public String getNome() {
        return this.nome;
    }

    public String getperiodoValidita() {
        return this.periodoValidita;
    }

    public String[] getPiatti() {
        return this.nomiPiatti;
    }

    @Override
    public String toString() {
        return "MenuTematico [nome=" + nome + ", periodoValidita=" + periodoValidita + ", nomiPiatti="
                + Arrays.toString(nomiPiatti) + "]";
    }
}
