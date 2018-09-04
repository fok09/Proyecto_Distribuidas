package hbt;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import bean.Producto;
import bean.Venta;
import bean.ItemVenta;


 
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	
        	Configuration config = new Configuration();
//            config.addAnnotatedClass(Venta.class);
//            config.addAnnotatedClass(ItemVenta.class);
//            config.addAnnotatedClass(Alimento.class);
//            config.addAnnotatedClass(Bebida.class);
//          config.addAnnotatedClass(Entrada.class);
//          config.addAnnotatedClass(ComboPromocional.class);
            sessionFactory = config.buildSessionFactory();
                         
        	
            
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
