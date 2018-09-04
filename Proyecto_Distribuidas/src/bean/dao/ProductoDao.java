package bean.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Adicional;
import hbt.HibernateUtil;

public class ProductoDao {
	private static ProductoDao instancia = null;
	private static SessionFactory sf = null;

	public static ProductoDao getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new ProductoDao();
		}
		return instancia;
	}

	public Adicional get(int id) {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Adicional result = (Adicional) session.get(Adicional.class, id);
		session.getTransaction().commit();
		return result;
	}

	public void grabarAdicional(Adicional adicional) {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.merge(adicional);
		session.flush();
		session.getTransaction().commit();
	}
}
