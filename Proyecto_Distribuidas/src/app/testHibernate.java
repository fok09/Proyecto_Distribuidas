package app;



import java.util.ArrayList;
import java.util.List;

import org.dom4j.util.ProxyDocumentFactory;
import org.hibernate.SessionFactory;

import bean.Adicional;
import bean.Producto;
import bean.ComboPromocional;
import bean.Entrada;
import bean.srv.ProductoSrv;
import hbt.HibernateUtil;

public class testHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = null;
		sf = HibernateUtil.getSessionFactory();
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		
		Adicional a = new Adicional("Fanta",15,"Bebida");
		productos.add(a);
		ProductoSrv.grabarProducto(a);
		
		Entrada e = new Entrada("Star Wars", "Sala 2", "16:15", 120);
		productos.add(e);
		ProductoSrv.grabarProducto(e);
		
		ArrayList<Producto> prods = new ArrayList<Producto>();
		prods.add(ProductoSrv.getProducto(1));
		prods.add(ProductoSrv.getProducto(2));
		
		ComboPromocional c = new ComboPromocional((float) 0.1, "Combo loco", prods);
		ProductoSrv.grabarProducto(c);
	}

}
