package it.unibs.se_project.business;

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
        // TODO
        // initializePiatti(nomiPiatti);
        // function che "prende" i nomi dalla JsonPiattiRepository
        // o, in alternativa, PiattiRepositoryService
        // e ottiene gli oggetti associati
        // ovvero aggiugni una funzione a PiattiRepositoryService
        // che restituisce un oggetto piatto dal nome (se presente)
        // restituisce solo i piatti disponibili nella data presente
        // PiattiRepositoryService.getAvailablePiattoObject(String nome)
        this.nomiPiatti = piatti;
    }

    // proprietà derivata
    public double getCaricoLavoroMenuTematico() {
        // TODO
        // invariante di classe
        // la somma del carico di lavoro di tutti i piatti contenuti
        // 
        return 0;
    }

    public String getNome() {
        return this.nome;
    }

    public String getPeriodoValidita() {
        return this.periodoValidita;
    }

    public String[] getPiatti() {
        return this.nomiPiatti;
    }

    @Override
    public String toString() {
        return "MenuTematico [nome=" + nome
            + ", periodoValidita=" + periodoValidita
            + ", nomiPiatti=" + Arrays.toString(nomiPiatti) + "]";
    }
}
