package it.unibs.se_project.model;

public class Prenotazione {
    private String nome;
    private int numeroCoperti;
    private String ordine;


    public Prenotazione(String nome, int numeroCoperti, String ordine) {
        this.nome = nome;
        this.numeroCoperti = numeroCoperti;
        this.ordine = ordine;
    }

    public String getNome() {
        return this.nome;
    }

    public int getnumeroCoperti() {
        return this.numeroCoperti;
    }

    public String getOrdine() {
        return this.ordine;
    }
}
