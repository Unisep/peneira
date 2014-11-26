package br.edu.unisep.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("unchecked")
public class GenericDAO<T> {

	public void save(T objeto) {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		try {
			session.save(objeto);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
		session.close();
	}

	public void update(T objeto) {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		try {
			session.update(objeto);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
		session.close();
	}

	public void destroy(T object) {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		try {
			session.delete(object);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}

		session.close();
	}

	public List<T> list(Class<T> classe) {
		Session session = HibernateSessionFactory.getSession();
		Criteria crit = session.createCriteria(classe);
		List<T> lista = null;

		crit.addOrder(Order.desc("id"));
		lista = crit.list();
		
		session.close();

		return lista;
	}

	public T select(Class<T> classe, Object id) {
		Session session = HibernateSessionFactory.getSession();

		Criteria crit = session.createCriteria(classe);
		crit.add(Restrictions.eq("id", id));

		T retorno = (T) crit.uniqueResult();

		session.close();

		return retorno;
	}
}
