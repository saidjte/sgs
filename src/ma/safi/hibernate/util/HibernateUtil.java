package ma.safi.hibernate.util;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ma.safi.entities.Fornisseur;
import ma.safi.entities.Produit;
import ma.safi.entities.Users;
import ma.safi.entities.Ville;
 
public class HibernateUtil {
	
    private static final SessionFactory sessionFactory;
    
    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
            		.addAnnotatedClass(Fornisseur.class)
            		.addAnnotatedClass(Produit.class)
            		.addAnnotatedClass(Users.class)
            		.addAnnotatedClass(Ville.class)
            		.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static Session openSession() {
    	final Session session = sessionFactory.openSession();
        return session;
    }
}
