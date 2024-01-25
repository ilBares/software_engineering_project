package it.unibs.se_project.repository.interfaces;

public interface BevandeRepository<T> {

    T getBevandeDictionary();
    void setBevandeDictionary(T bevande);

    // void add(T bevanda);
    // boolean delete(T bevanda);
}
