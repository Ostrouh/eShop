package org.ostroukh.model.service;

import org.ostroukh.model.entity.Credential;

import java.util.List;
import java.util.Optional;

public interface CredentialService {

    List<Credential> getAllCredentials();

    void saveCredential(Credential credential);

    Optional<Credential> getCredentialById(Integer id);

    void deleteCredential(Credential credential);
}
