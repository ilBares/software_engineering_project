package it.unibs.se_project.repository.interfaces;

public interface MenuTematiciRepository<T> {
    
    T getMenuTematiciDictionary();
    void setMenuTematiciDictionary(T menuTematici);

    // void add(T menuTematico);
    // boolean delete(T menuTematico);
}
