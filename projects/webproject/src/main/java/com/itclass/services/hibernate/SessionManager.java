package com.itclass.services.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.itclass.model.User;

public class SessionManager {
	
	private static SessionFactory sessionFactory;
	
	private SessionManager() {
	}
	
	public static Session openSession() {
		
		if(sessionFactory==null) {
			 Configuration configuration = getH2Configuration();
		     sessionFactory = createSessionFactory(configuration);
		}
		
		return sessionFactory.openSession();
	}
	
	private static Configuration getH2Configuration() {
        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(User.class);
        
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:~/newsdb");
        configuration.setProperty("hibernate.connection.username", "igor");
        configuration.setProperty("hibernate.connection.password", "123");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "false");

        return configuration;
    }
	
	private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
