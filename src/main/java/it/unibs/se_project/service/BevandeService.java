package it.unibs.se_project.service;

import java.util.List;

import it.unibs.se_project.business.Bevanda;
import it.unibs.se_project.business.dictionary.BevandeDictionary;
import it.unibs.se_project.repository.interfaces.BevandeRepository;

public class BevandeService {
    private final BevandeRepository<BevandeDictionary> repository;

    public BevandeService(BevandeRepository<BevandeDictionary> repository) {
        this.repository = repository;
    }

    public List<Bevanda> getBevande() {
        return repository.getBevandeDictionary().getBevandeList();
    }

    public void addBevanda(Bevanda bevanda) {
        repository.getBevandeDictionary().putBevanda(bevanda);
    }

    public void getBevandaFromName(String bevandaName) {
        repository.getBevandeDictionary().getBevanda(bevandaName);
    }
}
