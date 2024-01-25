package it.unibs.se_project.business;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuTematico {
    private String nome;
    private Period periodoValidita;
    private List<String> nomiPiatti;

    @JsonCreator
    public MenuTematico(
        @JsonProperty("nome") String nome,
        @JsonProperty("periodo_validita") String periodoValidita,
        @JsonProperty("nomi_piatti") String[] piatti
    ) {
        this.nome = nome;
        this.periodoValidita = Period.fromString(periodoValidita);
        this.nomiPiatti = List.of(piatti);
    }

    // proprietà derivata
    public double getCaricoLavoroMenuTematico(List<Piatto> piatti) {
        return piatti
            .stream()
            .filter(p -> nomiPiatti.contains(p.getNome()))
            .mapToDouble(p -> p.getCaricoLavoro())
            .sum();
    }

    public String getNome() {
        return this.nome;
    }

    public Period getPeriodoValidita() {
        return this.periodoValidita;
    }

    public List<String> getNomiPiatti() {
        return List.copyOf(this.nomiPiatti);
    }

    public boolean isValid(int caricoLavoroPersona, List<Piatto> piatti) {
        return getCaricoLavoroMenuTematico(piatti) <= (4/3) * caricoLavoroPersona;
    }

    @Override
    public String toString() {
        return "MenuTematico [nome=" + nome
            + ", periodoValidita=" + periodoValidita
            + ", nomiPiatti=" + nomiPiatti + "]";
    }
}
