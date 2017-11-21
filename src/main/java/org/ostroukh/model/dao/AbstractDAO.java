package org.ostroukh.model.dao;

import java.util.List;

public interface AbstractDAO<E, K> {

    /**
     * Reads all entities from the DB
     * @return
     */
    List<E> getAll();

    /**
     * Saves or updates a specific entity
     * @param entity
     */
    void save(E entity);

    /**
     * Gets a specific entity by id
     * @param id
     * @return
     */
    E getById(K id);

    /**
     * Removes an entity from the DB by id
     * @param id
     */
    void delete(K id);


}
