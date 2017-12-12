package org.ostroukh.model.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ostroukh.config.TestDataBaseConfig;
import org.ostroukh.model.entity.Credential;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.service.CredentialService;
import org.ostroukh.model.service.UserService;
import org.ostroukh.model.service.impl.util.EntityCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Contains unit-tests for {@link CredentialServiceImpl}
 * @author Eugene Ostroukh
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class CredentialServiceTest {

    private User user;
    private Credential credential;

    @Autowired
    private UserService userService;

    @Autowired
    private CredentialService credentialService;

    @Before
    public void setup(){
        user = EntityCreator.userCreate();
        credential = EntityCreator.credentialCreate(user);

        credentialService.saveCredential(credential);
        userService.saveUser(user);
    }

    @Test
    public void testGetCredentialByIdNotFound(){
        Optional<Credential> foundUser = credentialService.getCredentialById(Integer.MAX_VALUE);

        assertFalse(foundUser.isPresent());
    }

    @Test
    public void testGetAllCredentialsSuccess(){
        List<Credential> fromDB = credentialService.getAllCredentials();

        assertTrue(fromDB.size() == 1);
    }

    @After
    public void clearDB(){
        credentialService.deleteCredential(user.getCredential());
        userService.deleteUser(user);
    }
}
