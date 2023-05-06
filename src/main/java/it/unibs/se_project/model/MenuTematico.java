package it.unibs.se_project.model;

public class MenuTematico {
    private String nome;
    private String periodoValidita;
    private String[] piatti;

    public MenuTematico(String nome, String periodoValidita, String[] piatti) {
        this.nome = nome;
        this.periodoValidita = periodoValidita;
        this.piatti = piatti;
    }

    public String getNome() {
        return this.nome;
    }

    public String getperiodoValidita() {
        return this.periodoValidita;
    }

    public String[] getPiatti() {
        return this.piatti;
    }
}
