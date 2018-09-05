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
		Entrada e4 = new Entrada("One Piece", "Sala 5", "16:59", 128);
		productos.add(e4);
		ProductoSrv.grabarProducto(e);
		ProductoSrv.grabarProducto(e2);
		ProductoSrv.grabarProducto(e4);
		
		
		ArrayList<Producto> prods = new ArrayList<Producto>();
		prods.add(ProductoSrv.getProducto(1));
		prods.add(ProductoSrv.getProducto(2));
		
		ComboPromocional c = new ComboPromocional((float) 10, "Combo loco", prods);
		ProductoSrv.grabarProducto(c);
		
		Entrada entrada = (Entrada) ProductoSrv.getProducto(2);
		ArrayList<Entrada> entraditas = (ArrayList<Entrada>) ProductoSrv.leerEntradas();
		for (Entrada eeee:entraditas)
			System.out.println("" + eeee.getNombre() + eeee.getHorario() + eeee.getSala());
		
		Entrada ent1 = new Entrada("Duro de matar","sala1","22:00",(float)20);
		Entrada ent2 = new Entrada("Jurassic Park","sala 2","19:30",(float)20);
		Entrada ent3 = new Entrada("Pulp Fiction","sala 3","20:40",(float)20);
		Entrada ent4 = new Entrada("North by Northwest","sala 4","17:10",(float)20);
		ProductoSrv.grabarProducto(ent1);
		ProductoSrv.grabarProducto(ent2);
		ProductoSrv.grabarProducto(ent3);
		ProductoSrv.grabarProducto(ent4);
		//adicionales
		Adicional ad1 = new Adicional("pochoclo",(float)80,"comida");
		ProductoSrv.grabarProducto(ad1);

		Adicional ad2 = new Adicional("coca",(float)40,"bebida");
		ProductoSrv.grabarProducto(ad2);
		
		//combos
		ArrayList<Producto> pc = new ArrayList<Producto>();
		pc.add(ProductoSrv.getProducto(10));
		pc.add(ProductoSrv.getProducto(11));
		ComboPromocional com1 = new ComboPromocional((float)20,"coca+pochoclo",pc);
		ProductoSrv.grabarProducto(com1);
		
		Venta venta = new Venta();
		venta.agregarItem(ProductoSrv.getProducto(1), 99);
		VentaSRV.grabarVenta(venta);
		ArrayList<Venta> v = (ArrayList<Venta>)VentaSRV.leerVentas();
		System.out.println(v.get(0).getNumero() + "    " + v.get(0).getTotal() + "    " + v.get(0).getItem(0).getCantidad());
	}

}
