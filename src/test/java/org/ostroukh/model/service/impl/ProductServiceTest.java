package org.ostroukh.model.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ostroukh.config.TestDataBaseConfig;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.service.ProductService;
import org.ostroukh.model.service.impl.util.EntityCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit-tests for {@link ProductServiceImpl}
 * @author Eugene Ostroukh
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class ProductServiceTest {

    Product product;

    @Autowired
    ProductService productService;

    @Before
    public void setup(){
        product = EntityCreator.productCreate();

        productService.saveProduct(product);
    }

    @Test
    public void testGetProductByNameSuccess(){
        Product fromDB = productService.getProductByName("Weapon crowbar");

        assertEquals(product.getName(), fromDB.getName());
    }

    @Test
    public void testGetProductByCategorySuccess(){
        Product fromDB = productService.getProductByName("Weapon crowbar");

        assertEquals(product.getCategory(), fromDB.getCategory());
    }

    @After
    public void clearDB(){
        productService.deleteProduct(product);
    }
}
