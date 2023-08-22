package it.unibs.se_project.repository.interfaces;

import java.util.List;

public interface GeneriExtraRepository<T> {

    List<T> getGeneriExtra();
    void setGeneriExtra(T[] array);

    void add(T genereExtra);
    boolean delete(T genereExtra);
}
