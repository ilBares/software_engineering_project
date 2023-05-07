package it.unibs.se_project.repository.interfaces;

public interface CalendarioRepository<T> {
    
    T getCalendario();
    void updateCalendario(T calendario);
}
