package it.unibs.se_project.repository.interfaces;

public interface ConfigRepository<T> {
    
    T getConfig();
    void updateConfig(T config);
}
