package com.itclass.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.itclass.model.Role;
import com.itclass.model.User;

public class DbServiceTest {

	private SessionFactory factory;
	
	@Before
	public void before() {
		factory = createSessionFactory(getH2Configuration());
		factory.openSession();
		
		
	}
	
	
	@Test
	public void insertUserTest() {
		DbService f = new DbService(factory);
		f.insertUser( new User("wer","35345",Role.ADMIN) );
		
		Session s = factory
				.getCurrentSession();
		
		Transaction t = s.beginTransaction();
		
		Long count = (Long)s
				.createQuery("select count(user.id) from User as user")
				.uniqueResult();		
		t.commit();
		
		Assert.assertEquals(44L, (long)count);
	}
	
	
	
	private Configuration getH2Configuration() {
        Configuration configuration = new Configuration(); 
        configuration.addAnnotatedClass(User.class);
        
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration
        .setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration
        	.setProperty("hibernate.connection.url", "jdbc:h2:mem:test");
        configuration.setProperty("hibernate.connection.username", "");
        configuration.setProperty("hibernate.connection.password", "");
        configuration
        .setProperty("hibernate.current_session_context_class", "thread");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        
        return configuration;
    }
    
    private SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
