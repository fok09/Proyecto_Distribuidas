package app;

import org.hibernate.SessionFactory;

import hbt.HibernateUtil;

public class testHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = null;
		sf = HibernateUtil.getSessionFactory();
	}

}
