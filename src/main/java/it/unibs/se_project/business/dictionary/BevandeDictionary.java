package it.unibs.se_project.business.dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.unibs.se_project.business.Bevanda;

public class BevandeDictionary {
    private HashMap<String, Bevanda> bevandeMap;

    @JsonCreator
    public BevandeDictionary(
        @JsonProperty("bevande") HashMap<String, Bevanda> bevande
    ) {
        this.bevandeMap = bevande;
    }

    public Bevanda getBevanda(String bevandaName) {
        return bevandeMap.get(bevandaName);
    }

    public void putBevanda(Bevanda bevanda) {
        bevandeMap.put(bevanda.getNome(), bevanda);
    }

    public List<Bevanda> getBevandeList() {
        return new ArrayList<>(bevandeMap.values());
    }
}
