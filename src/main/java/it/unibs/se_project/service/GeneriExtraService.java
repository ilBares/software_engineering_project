package it.unibs.se_project.service;

import java.util.List;

import it.unibs.se_project.business.GenereExtra;
import it.unibs.se_project.business.dictionary.GeneriExtraDictionary;
import it.unibs.se_project.repository.interfaces.GeneriExtraRepository;

public class GeneriExtraService {
    private final GeneriExtraRepository<GeneriExtraDictionary> repository;

    public GeneriExtraService(GeneriExtraRepository<GeneriExtraDictionary> repository) {
        this.repository = repository;
    }

    public List<GenereExtra> getGeneriExtra() {
        return repository.getGeneriExtraDictionary().getGeneriExtraList();
    }

    public void addGenereExtra(GenereExtra genereExtra) {
        repository.getGeneriExtraDictionary().putGenereExtra(genereExtra);
    }

    public void getGenereExtraFromName(String genereExtraName) {
        repository.getGeneriExtraDictionary().getGenereExtra(genereExtraName);
    }
}
