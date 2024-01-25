package it.unibs.se_project.repository.interfaces;

public interface RegistroMagazzinoRepository<T> {
    
    T getRegistroMagazzinoDictionary();
    void updateRegistroMagazzinoDictionary(T registroMagazzino);
}