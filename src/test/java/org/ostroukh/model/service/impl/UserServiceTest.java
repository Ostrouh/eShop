package org.ostroukh.model.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ostroukh.config.TestDataBaseConfig;
import org.ostroukh.model.entity.Credential;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.entity.enums.UserRole;
import org.ostroukh.model.service.CredentialService;
import org.ostroukh.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class UserServiceTest {

    private User user;
    private final static int DEFAULT_USER_ID = 1;

    @Autowired
    private UserService service;

    @Autowired
    private CredentialService credentialService;

    @Before
    public void setup(){
        user = new User("Gordon", "Freeman", "BlackMesa", "+1 11 111 11 11", 0 );
        user.prePersist();

        Credential credential = user.addCredential();
        credential.setLogin("login");
        credential.setPassword("password");
        credential.setEmail("gordon@blackmesa.com");
        credential.setInBlackList(false);
        credential.setRole(UserRole.ADMIN);
        credential.prePersist();

        credentialService.saveCredential(credential);
        service.saveUser(user);
    }

//    @Test
//    public void testGetUserById(){
//        Optional<User> foundUser = service.getUserById(DEFAULT_USER_ID);
//
//        assertTrue(foundUser.isPresent());
//        assertEquals(foundUser.get().getId(), DEFAULT_USER_ID);
//
//    }

    @Test
    public void testGetUserByIdNotFound(){
        Optional<User> foundUser = service.getUserById(Integer.MAX_VALUE);

        assertFalse(foundUser.isPresent());
    }

    @Test
    public void testGetUserBySurnameSuccess(){
        List<User> fromDB = service.getUserBySurname("Freeman");

        assertEquals(user.getName(), fromDB.get(0).getName());
    }

    @Test
    public void testGetUserByNameAndSurnameSuccess(){
        List<User> fromDB = service.getUserByNameAndSurname("Gordon", "Freeman");

        assertEquals(user.getName(), fromDB.get(0).getName());
        assertEquals(user.getSurname(), fromDB.get(0).getSurname());
    }

    @Test
    public void testGetUserBySurnameNotFound(){
        List<User> fromDB = service.getUserBySurname("NotFreeman");

        assertTrue(fromDB.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveNullUser(){
        service.saveUser(null);

        assertTrue(false);
    }

    @After
    public void clearDB(){
        credentialService.deleteCredential(user.getCredential());
        service.deleteUser(user);

    }
}
