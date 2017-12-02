package org.ostroukh.model.service.impl;

import org.ostroukh.model.dao.CredentialDAO;
import org.ostroukh.model.entity.Credential;
import org.ostroukh.model.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("credentialService")
@Transactional
public class CredentialServiceImpl implements CredentialService {

    @Autowired
    CredentialDAO dao;

    @Override
    public List<Credential> getAllCredentials() {
        return dao.getAll();
    }

    @Override
    public void saveCredential(Credential credential) {
        dao.save(credential);
    }

    @Override
    public Credential getCredentialById(Integer id) {
        return dao.getById(id);
    }
}
