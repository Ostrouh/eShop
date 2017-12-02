package org.ostroukh.model.service;

import org.ostroukh.model.entity.Credential;

import java.util.List;

public interface CredentialService {

    List<Credential> getAllCredentials();

    void saveCredential(Credential credential);

    Credential getCredentialById(Integer id);
}
