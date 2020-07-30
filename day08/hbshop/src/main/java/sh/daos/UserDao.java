package sh.daos;

import org.hibernate.Session;
import org.hibernate.query.Query;

import sh.entities.Book;
import sh.entities.User;
import sh.util.HbUtil;

public class UserDao {
	public User findByEmail(String email) {
		Session session = HbUtil.getCurrentSession();
		String hql = "from User u where u.email=:p_email";
		Query<User> q = session.createQuery(hql);
		q.setParameter("p_email", email);
		return q.uniqueResult();
	}
}
