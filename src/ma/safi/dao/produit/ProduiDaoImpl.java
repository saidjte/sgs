package ma.safi.dao.produit;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ma.safi.entities.Fornisseur;
import ma.safi.entities.Produit;
import ma.safi.hibernate.util.*;

public class ProduiDaoImpl implements ProduiDao {

	@Override
	public List<Produit> getlistPoduits() {
		List<Produit> listPoduits = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			listPoduits = session.createQuery("from Produit").list();
			tx.commit();
			session.close();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return listPoduits;
	}

	@Override
	public Produit getProduitByIdDao(int id) {
		Produit produitById = new Produit();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			produitById = session.get(Produit.class, id);
			tx.commit();
			session.close();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return produitById;
	}

	@Override
	public void deleteProduit(int id) {
		Produit produitById = new Produit();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			produitById = session.get(Produit.class, id);
			session.delete(produitById);
			tx.commit();
			session.close();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}

		
	}

	@Override
	public void modifierProduit(Produit produit, int id,int idfornisseur) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Produit produitdao = session.get(Produit.class, id);
			produitdao.setNomProduit(produit.getNomProduit());
			produitdao.setPrixUnitaire(produit.getPrixUnitaire());
			produitdao.setQuantite(produit.getQuantite());
			produitdao.setDescription(produit.getDescription());
			Fornisseur fornisseur = session.get(Fornisseur.class, idfornisseur);
			produitdao.setFounisseur(fornisseur);
			session.getTransaction().commit();
			session.close();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void addproduit(Produit produit, int idfournisseur) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Fornisseur fornisseur = session.get(Fornisseur.class, idfournisseur);
			produit.setFounisseur(fornisseur);
			session.persist(produit);
			tx.commit();
		}catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

}
