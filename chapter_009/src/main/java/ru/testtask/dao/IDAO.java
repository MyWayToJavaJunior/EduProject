package ru.testtask.dao;

import java.util.List;

/**
 * Created by nikolay on 08/10/17.
 * @param <T> - type.
 */
public interface IDAO<T> {
    /**
     * Add.
     * @param t - element.
     */
    void add(T t);
    /**
     * Gell all.
     * @return - list of elements.
     */
    List<T> getAll();
    /**
     * get one.
     * @param t - elem.
     * @return - list of elems.
     */
    T getOne(T t);
    /**
     * edit.
     * @param t - elem.
     */
    void edit(T t);
    /**
     * delete.
     * @param t - elem.
     */
    void delete(T t);
}
