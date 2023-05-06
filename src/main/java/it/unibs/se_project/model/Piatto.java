package it.unibs.se_project.model;

public class Piatto {
    private String nome;
    private String periodoValidita;

    public Piatto(String nome, String periodoValidita) {
        this.nome = nome;
        this.periodoValidita = periodoValidita;
    }

    public String getNome() {
        return this.nome;
    }

    public String getperiodoValidita() {
        return this.periodoValidita;
    }
}
