package org.ostroukh.model.service.impl.util;

import org.ostroukh.model.entity.Credential;
import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.entity.enums.OrderStatus;
import org.ostroukh.model.entity.enums.ProductCategory;
import org.ostroukh.model.entity.enums.UserRole;

/**
 * Creates the entities needed for tests
 */
public class EntityCreator {

    public static User userCreate(){
        User user = new User("Gordon", "Freeman", "BlackMesa", "+1 11 111 11 11", 0 );

        return user;
    }

    public static Credential credentialCreate(User user){
        Credential credential = new Credential();
        credential.setUser(user);
        credential.setLogin("login");
        credential.setPassword("password");
        credential.setEmail("gordon@blackmesa.com");
        credential.setInBlackList(false);
        credential.setRole(UserRole.ROLE_ADMIN);

        user.setCredential(credential);

        return credential;
    }

    public static Order orderCreate(User user){
        Order order = new Order();
        order.setUser(user);
        order.setStatus(OrderStatus.NEW);

        return order;
    }

    public static Product productCreate(){
        Product product = new Product();

        product.setName("Weapon crowbar");
        product.setCategory(ProductCategory.FIRST);
        product.setPrice(100);
        product.setQuantity(1);

        return product;
    }
}
