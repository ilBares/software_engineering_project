package it.unibs.se_project.service;

import it.unibs.se_project.business.Config;
import it.unibs.se_project.repository.interfaces.ConfigRepository;

public class ConfigService {
    private final ConfigRepository<Config> repository;

    public ConfigService(ConfigRepository<Config> repository) {
        this.repository = repository;
    }

    public Config getConfig() {
        return repository.getConfig();
    }

    public int getCaricoLavoroPersona() {
        return repository.getConfig().getCaricoLavoroPersona();
    }

    public double getCaricoLavoroSostenibile() {
        return repository.getConfig().getCaricoLavoroSostenibile();
    }

    public int getNumeroPosti() {
        return repository.getConfig().getNumeroPosti();
    }

    public int getAnticipoGiorniPrenotazione() {
        return repository.getConfig().getAnticipoGiorniPrenotazione();
    }
}