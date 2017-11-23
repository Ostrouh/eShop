package org.ostroukh.model.entity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Contains unit-tests to check functionality of {@link User} class
 * @author Eugene Ostroukh
 */
public class UserTest {
    private User user;

    @Before
    public void setup(){
        user = new User();
    }

    @Test
    public void testAddValidOrderSuccess() {
        Order order = user.addOrder();

        assertTrue(containsOrder(user, order));
        assertEquals(user, order.getUser());
    }

    @Test
    public void testRemoveOrderSuccess(){
        Order order = user.addOrder();

        user.removeOrder(order);
        assertTrue(user.getOrders().isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNullOrderFailure(){
        user.removeOrder(null);

        assertTrue(false);
    }

    private boolean containsOrder(User user, Order order) {
        return user.getOrders().contains(order);
    }
}
