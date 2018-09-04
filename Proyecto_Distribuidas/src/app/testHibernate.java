package app;



import java.util.ArrayList;
import java.util.List;

import org.dom4j.util.ProxyDocumentFactory;
import org.hibernate.SessionFactory;

import bean.Adicional;
import bean.Producto;
import bean.Venta;
import bean.ComboPromocional;
import bean.Entrada;
import bean.ItemVenta;
import bean.srv.ProductoSrv;
import bean.srv.VentaSRV;
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
		Entrada e2 = new Entrada("Barney", "Sala 3", "18:15", 167);
		productos.add(e2);
		Entrada e3 = new Entrada("Emanuelle", "Sala 4", "20:15", 459);
		productos.add(e3);
		Entrada e4 = new Entrada("One Piece", "Sala 5", "16:59", 128);
		productos.add(e4);
		ProductoSrv.grabarProducto(e);
		ProductoSrv.grabarProducto(e2);
		ProductoSrv.grabarProducto(e3);
		ProductoSrv.grabarProducto(e4);
		
		
		ArrayList<Producto> prods = new ArrayList<Producto>();
		prods.add(ProductoSrv.getProducto(1));
		prods.add(ProductoSrv.getProducto(2));
		
		ComboPromocional c = new ComboPromocional((float) 0.1, "Combo loco", prods);
		ProductoSrv.grabarProducto(c);
		
		Entrada entrada = (Entrada) ProductoSrv.getProducto(2);
		ArrayList<Entrada> entraditas = (ArrayList<Entrada>) ProductoSrv.leerEntradas();
		for (Entrada eeee:entraditas)
			System.out.println("" + eeee.getNombre() + eeee.getHorario() + eeee.getSala());
		
		Venta venta = new Venta();
		venta.agregarItem(ProductoSrv.getProducto(1), 99);
		VentaSRV.grabarVenta(venta);
		ArrayList<Venta> v = (ArrayList<Venta>)VentaSRV.leerVentas();
		System.out.println(v.get(0).getNumero() + "    " + v.get(0).getTotal() + "    " + v.get(0).getItem(0).getCantidad());
		
	}

}
