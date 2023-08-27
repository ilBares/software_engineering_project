package it.unibs.se_project.repository.interfaces;

import java.util.HashMap;
import java.util.List;

public interface PiattiRepository<T> {
    
    List<T> getPiatti();
    void setPiatti(T[] array);

    void add(T piatto);
    boolean delete(T piatto);
}
