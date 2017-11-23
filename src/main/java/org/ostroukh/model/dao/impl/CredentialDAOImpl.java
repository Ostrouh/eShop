package org.ostroukh.model.dao.impl;

import org.ostroukh.model.dao.CredentialDAO;
import org.ostroukh.model.entity.Credential;

import java.util.List;

/**
 * Implementation of CredentialDAO interface that work with DB by Hibernate
 * @author Eugene Ostroukh
 */
public class CredentialDAOImpl implements CredentialDAO {
    @Override
    public List<Credential> getAll() {
        return null;
    }

    @Override
    public void save(Credential entity) {

    }

    @Override
    public Credential getById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
