package it.unibs.se_project.repository.interfaces;

import java.util.List;

public interface MenuTematiciRepository<T> {
    
    List<T> getMenuTematici();
    void setMenuTematici(T[] array);

    void add(T menuTematico);
    boolean delete(T menuTematico);
}
