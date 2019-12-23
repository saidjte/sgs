package ma.safi.dao.users;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ma.safi.entities.Users;
import ma.safi.hibernate.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public Users getUserByloginDao(String login)  {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Users user = null;
		try {	
			tx = session.beginTransaction();
			Query query = session.createQuery("from Users u where u.login=:theLogin");
			query.setParameter("theLogin", login);
			user = (Users)query.uniqueResult();
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
		return user;
	}

}
