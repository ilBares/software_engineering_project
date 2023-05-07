package it.unibs.se_project.repository.interfaces;

import java.util.List;

public interface GeneriAlimentariRepository<T> {

    List<T> getGeneriAlimentari();
    void setGeneriAlimentari(T[] array);

    void add(T genereAlimentare);
    boolean delete(T genereAlimentare);
}
