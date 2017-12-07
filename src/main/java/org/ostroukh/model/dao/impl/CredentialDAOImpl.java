package org.ostroukh.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.ostroukh.model.dao.CredentialDAO;
import org.ostroukh.model.entity.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of CredentialDAO interface that work with DB by Hibernate
 * @author Eugene Ostroukh
 */
@Repository("credentialDAO")
public class CredentialDAOImpl implements CredentialDAO {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Credential> getAll() {
        Criteria criteria = getSession().createCriteria(Credential.class);
        return (List<Credential>) criteria.list();
    }

    @Override
    public void save(Credential entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public Credential getById(Integer id) {
        Criteria criteria = getSession().createCriteria(Credential.class);
        criteria.add(Restrictions.eq("id",id));
        return (Credential) criteria.uniqueResult();
    }

    @Override
    public void delete(Credential entity) {
        getSession().delete(entity);
    }
}
