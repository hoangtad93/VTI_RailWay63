package com.vti.ultis;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;

public class HibernateUtils {

	private static HibernateUtils instance;

	private Configuration configuration;
	private SessionFactory sessionFactory;

//	getInstance(): Dùng để tạo ra 1 instance HibernateUtils
	public static HibernateUtils getInstance() {
		if (null == instance) {
			instance = new HibernateUtils();
		}
		return instance;
	}

	private HibernateUtils() {
		configure();
	}

	private void configure() {
		// load configuration
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// add entity
		configuration.addAnnotatedClass(Account.class);
		configuration.addAnnotatedClass(Position.class);
		configuration.addAnnotatedClass(Department.class);
	}

	private SessionFactory buildSessionFactory() {
		if (null == sessionFactory || sessionFactory.isClosed()) {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}

		return sessionFactory;
	}

	public void closeFactory() {
		if (null != sessionFactory && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}

//	Hàm mở ra 1 Session
	public Session openSession() {
		buildSessionFactory();
		return sessionFactory.openSession();
	}

}
