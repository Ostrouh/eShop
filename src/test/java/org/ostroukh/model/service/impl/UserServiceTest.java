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

import static org.junit.Assert.*;

/**
 * Contains unit-tests for {@link UserServiceImpl}
 * @author Eugene Ostroukh
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class UserServiceTest {

    private User user;
    private Credential credential;
    private final static int DEFAULT_USER_ID = 1;

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

//    @Test
//    public void testGetUserById(){
//        Optional<User> foundUser = userService.getUserById(DEFAULT_USER_ID);
//
//        assertTrue(foundUser.isPresent());
//        assertEquals(foundUser.get().getId(), DEFAULT_USER_ID);
//
//    }

    @Test
    public void testGetUserByIdNotFound(){
        Optional<User> foundUser = userService.getUserById(Integer.MAX_VALUE);

        assertFalse(foundUser.isPresent());
    }

    @Test
    public void testGetUserBySurnameSuccess(){
        List<User> fromDB = userService.getUserBySurname("Freeman");

        assertEquals(user.getName(), fromDB.get(0).getName());
    }

    @Test
    public void testGetUserByNameAndSurnameSuccess(){
        List<User> fromDB = userService.getUserByNameAndSurname("Gordon", "Freeman");

        assertEquals(user.getName(), fromDB.get(0).getName());
        assertEquals(user.getSurname(), fromDB.get(0).getSurname());
    }

    @Test
    public void testGetUserByNameAndSurnameNotFound(){
        List<User> fromDB = userService.getUserByNameAndSurname("NotGordon", "Freeman");

        assertTrue(fromDB.isEmpty());
    }

    @Test
    public void testGetUserBySurnameNotFound(){
        List<User> fromDB = userService.getUserBySurname("NotFreeman");

        assertTrue(fromDB.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testSaveNullUser(){
        userService.saveUser(null);

        assertTrue(false);
    }

    @Test
    public void testGetAllUsersSuccess(){
        List<User> fromDB = userService.getAllUsers();

        assertTrue(fromDB.size() == 1);
    }

    @After
    public void clearDB(){
        credentialService.deleteCredential(user.getCredential());
        userService.deleteUser(user);
    }
}
