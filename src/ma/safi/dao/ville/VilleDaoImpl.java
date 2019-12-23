package ma.safi.dao.ville;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ma.safi.entities.Ville;
import ma.safi.hibernate.util.HibernateUtil;

public class VilleDaoImpl implements VilleDao {

	@Override
	public List<Ville> getlistVille() {
		List<Ville> listVilles = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			listVilles = session.createQuery("from Ville").list();
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
		return listVilles;

	}

}
