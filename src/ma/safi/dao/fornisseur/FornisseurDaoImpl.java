package ma.safi.dao.fornisseur;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ma.safi.entities.Fornisseur;
import ma.safi.entities.Ville;
import ma.safi.hibernate.util.*;

public class FornisseurDaoImpl implements FornisseurDao {

	@Override
	public List<Fornisseur> getlistFornisseurs() {
		List<Fornisseur> listFornisseur = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			listFornisseur = session.createQuery("from Fornisseur").getResultList();
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
		return listFornisseur;
	}

	@Override
	public Fornisseur getFornisseurByIdDao(int id) {
		Fornisseur fornisseurById = new Fornisseur();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			fornisseurById = session.get(Fornisseur.class, id);
			System.out.println(fornisseurById.getListeProduits());		
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
		return fornisseurById;
	}

	@Override
	public void deleteFornisseur(int id) {
		Fornisseur fornisseurById = new Fornisseur();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			fornisseurById = session.get(Fornisseur.class, id);
			session.delete(fornisseurById);
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
	public void modifierFornisseur(Fornisseur fornisseur, int id ,int idville) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Fornisseur fornisseurdao = session.get(Fornisseur.class, id);
			fornisseurdao.setNomFournisseur(fornisseur.getNomFournisseur());
			fornisseurdao.setPreNomFournisseur(fornisseur.getPreNomFournisseur());
			fornisseurdao.setAdresse(fornisseur.getAdresse());
			Ville ville = session.get(Ville.class, idville);
			fornisseurdao.setVille(ville);
			
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
	public void addFornisseur(Fornisseur fornisseur, int idville) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Ville ville = session.get(Ville.class, idville);
			fornisseur.setVille(ville);
			session.persist(fornisseur);
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
