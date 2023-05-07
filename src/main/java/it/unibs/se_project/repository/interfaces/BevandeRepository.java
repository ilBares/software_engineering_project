package it.unibs.se_project.repository.interfaces;

import java.util.List;

public interface BevandeRepository<T> {

    List<T> getBevande();
    void setBevande(T[] array);

    void add(T bevanda);
    boolean delete(T bevanda);
}
