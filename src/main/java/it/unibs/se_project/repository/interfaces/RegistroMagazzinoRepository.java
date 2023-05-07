package it.unibs.se_project.repository.interfaces;

public interface RegistroMagazzinoRepository<T> {
    
    T getRegistroMagazzino();
    void updateRegistroMagazzino(T registroMagazzino);
}