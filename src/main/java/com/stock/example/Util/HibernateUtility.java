package com.stock.example.Util;

import com.stock.example.Exception.DAOException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() throws Exception {

        if (sessionFactory == null) {

            try {
                System.out.println("Configuration");
                Configuration cfg = new Configuration();
                //cfg.configure("hibernate.cfg.xml");
                // configuration file


                System.out.println("Session Factory");
                // creating seession factory object
                SessionFactory factory = cfg.buildSessionFactory();


                System.out.println("Registry");
                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();


                System.out.println("MetadataSources");
                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);


                System.out.println("Metadata");
                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();


                System.out.println("Session Factory");
                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
                System.out.println("Exception in HibernateUtility[getSessionFactory()] "+e);
                e.printStackTrace();
                throw new DAOException("Unable to Connect to Database", "1001");
            }
        }

        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
