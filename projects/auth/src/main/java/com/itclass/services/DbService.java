package com.itclass.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.itclass.model.User;

public class DbService {

	private static final String hibernate_show_sql = "true";
    private static final String hibernate_hbm2ddl_auto = "false";
	
    final private SessionFactory sessionFactory;
    
    public long insertUser(User user) {
    	
    	Session session = sessionFactory.openSession();
    	
    	Transaction transaction = session.beginTransaction();
    	session.save(user);
    	transaction.commit();
    	
    	System.out.println(transaction.getStatus());
    	
    	session.close();
    	
    	return user.getId();
    }
    
    public List<User> getAll() {
    	
    	Session session = sessionFactory.openSession();
    	
    	List<User> users = (List<User>) session
    					.createQuery("from User")
    					.list();
    	
    	session.createCriteria(User.class)
    	
    	
    	session.close();
    	
    	return users;
    }
    
    
    
    
    public DbService() {
    	Configuration cnf = getH2Configuration();
    	sessionFactory = createSessionFactory(cnf);
    }
    
    private Configuration getH2Configuration() {
        Configuration configuration = new Configuration();
        
        configuration.addAnnotatedClass(User.class);
        
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:~/tusers");
        configuration.setProperty("hibernate.connection.username", "igor");
        configuration.setProperty("hibernate.connection.password", "123");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        
        return configuration;
    }
    
    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
	
}
