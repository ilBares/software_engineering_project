package it.unibs.se_project.service;

import it.unibs.se_project.business.Config;
import it.unibs.se_project.repository.interfaces.ConfigRepository;

class ConfigService {
    private final ConfigRepository<Config> repository;

    public ConfigService(ConfigRepository<Config> configRepository) {
        this.repository = configRepository;
    }

    public Config getConfig() {
        return repository.getConfig();
    }
}