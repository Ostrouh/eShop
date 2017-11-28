package org.ostroukh.model.persistence.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.ostroukh.model.entity.Credential;
import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.persistence.hibernate.interceptor.TimestampInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SessionFactoryBuilder {
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionFactoryBuilder.class);
    private final SessionFactory sessionFactory;

    public SessionFactoryBuilder() {
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(loadProperties()).build();

        MetadataSources sources = new MetadataSources(registry);

        sources.addAnnotatedClass(User.class);
        sources.addAnnotatedClass(Credential.class);
        sources.addAnnotatedClass(Product.class);
        sources.addAnnotatedClass(Order.class);

        org.hibernate.boot.SessionFactoryBuilder builder = sources.getMetadataBuilder().build().getSessionFactoryBuilder()
                .applyInterceptor(new TimestampInterceptor());

        sessionFactory = builder.build();
    }

    private Properties loadProperties(){
        try(InputStream input = SessionFactoryBuilder.class.getClassLoader().getResourceAsStream("app.properties")){
            Properties properties = new Properties();
            properties.load(input);

            return properties;
        }
        catch (IOException e){
            LOGGER.error(e.getMessage());
            throw new HibernateException(e);
        }
    }

    /**
     * Returns single instance of session factory
     * @return
     */
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    @PreDestroy
    public void shutdown(){
        if (sessionFactory != null){
            sessionFactory.close();
        }
    }
}
