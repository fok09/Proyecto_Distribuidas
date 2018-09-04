package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bean.Adicional;
import bean.Venta;
import bean.ComboPromocional;
import bean.Entrada;
import bean.ItemVenta;
import bean.Producto;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			Configuration config = new Configuration();
			config.addAnnotatedClass(Adicional.class);
			config.addAnnotatedClass(Entrada.class);
			config.addAnnotatedClass(Producto.class);
			config.addAnnotatedClass(Venta.class);
			config.addAnnotatedClass(ComboPromocional.class);
			config.addAnnotatedClass(ItemVenta.class);
			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
