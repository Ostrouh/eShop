package org.ostroukh.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ostroukh.model.dao.CredentialDAO;
import org.ostroukh.model.entity.Credential;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of CredentialDAO interface that work with DB by Hibernate
 * @author Eugene Ostroukh
 */
@Repository("credentialDAO")
public class CredentialDAOImpl implements CredentialDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(CredentialDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Credential> getAll() {
        List<Credential> credentials = getSession().createQuery("from Credential").list();

        for(Credential credential: credentials){
            LOGGER.info("Credential list: " + credential);
        }
        return credentials;
    }

    @Override
    public void save(Credential entity) {
        entity.prePersist();
        getSession().saveOrUpdate(entity);

        LOGGER.info("Save or update successful. Credential details: " + entity);
    }

    @Override
    public Credential getById(Integer id) {
        Credential credential = getSession().get(Credential.class, id);

        LOGGER.info("Successfully loaded. Credential details: " + credential);
        return credential;
    }

    @Override
    public void delete(Credential entity) {
        getSession().delete(entity);

        LOGGER.info("Successfully deleted. Credential details: " + entity);
    }
}
