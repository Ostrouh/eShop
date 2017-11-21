package org.ostroukh.model.dao.impl;

import org.ostroukh.model.dao.AbstractDAO;
import org.ostroukh.model.entity.Credential;

import java.util.List;

public class CredentialDAO implements AbstractDAO<Credential, Integer> {
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
