package org.ostroukh.model.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ostroukh.config.TestDataBaseConfig;
import org.ostroukh.model.entity.Credential;
import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.service.CredentialService;
import org.ostroukh.model.service.OrderService;
import org.ostroukh.model.service.UserService;
import org.ostroukh.model.service.impl.util.EntityCreator;
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

/**
 * Contains unit-tests for {@link OrderServiceImpl}
 * @author Eugene Ostroukh
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class OrderServiceTest {

    private User user;
    private Order order;
    private Credential credential;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CredentialService credentialService;

    @Before
    public void setup(){
        user = EntityCreator.userCreate();
        credential = EntityCreator.credentialCreate(user);
        order = EntityCreator.orderCreate(user);

        credentialService.saveCredential(credential);
        userService.saveUser(user);
        orderService.saveOrder(order);
    }

    @Test
    public void testGetOrdersByUserSuccess(){
        List<Order> fromDB = orderService.getOrdersByUser(user);

        assertTrue(fromDB.size() == 1);
        assertEquals(user.getId(), fromDB.get(0).getUser().getId());
    }

    @Test
    public void testGetAllOrdersSuccess(){
        List<Order> fromDB = orderService.getAllOrders();

        assertTrue(fromDB.size() == 1);
    }

    @Test
    public void testGetUserByIdNotFound(){
        Optional<Order> foundOrder = orderService.getOrderById(Integer.MAX_VALUE);

        assertFalse(foundOrder.isPresent());
    }

    @After
    public void clearDB(){
        orderService.deleteOrder(order);
        credentialService.deleteCredential(user.getCredential());
        userService.deleteUser(user);
    }
}
