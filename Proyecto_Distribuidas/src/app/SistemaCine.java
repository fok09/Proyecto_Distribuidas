package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import bean.Producto;
import bean.ProductoView;
import bean.Venta;
import bean.VentaView;

public class SistemaCine 
{
	private List<Producto> entradas;
	private List<Producto> adicionales;
	private List<Producto> combos;
	private List<Venta> ventas;
	private Venta ventaActual;
	
	private static SistemaCine instancia = null;
	
	private SistemaCine()
	{
		entradas = new ArrayList<Producto>();
		adicionales = new ArrayList<Producto>();
		combos = new ArrayList<Producto>();
		ventas = new ArrayList<Venta>();
	}
	
	public static SistemaCine getInstance()
	{
		if(instancia == null) 
		{
			instancia = new SistemaCine();
	    }
		return instancia;
	}
	
	public VentaView iniciarVenta()
	{
		ventaActual = new Venta();
		return ventaActual.getView();
	}
	
	public void agregarProducto(ProductoView prod, int cantidad)
	{
		Producto p = buscarProducto(prod.getCodigo());
		ventaActual.agregarItem(p, cantidad);
	}
	
	public VentaView actualizarVistaVenta()
	{
		return ventaActual.getView();
	}
	
	public float registrarVenta()
	{
		ventas.add(ventaActual);
		return ventaActual.getTotal();
		//aca va la bajada a base de datos
	}
	
	private Producto buscarProducto(int codigo)
	{
		for(Producto p : entradas)
			if(p.getCodigo() == codigo)
				return p;
		for(Producto p : adicionales)
			if(p.getCodigo() == codigo)
				return p;
		for(Producto p : combos)
			if(p.getCodigo() == codigo)
				return p;
		return null;
	}
	
	public Vector<ProductoView> getEntradas()
	{
		Vector<ProductoView> ent = new Vector<ProductoView>();
		for(Producto p : entradas)
			ent.add(p.getView());
		return ent;
	}
	
	public Vector<ProductoView> getAdicionales()
	{
		Vector<ProductoView> ad = new Vector<ProductoView>();
		for(Producto p : adicionales)
			ad.add(p.getView());
		return ad;
	}
	
	public ProductoView getProducto(int codigo)
	{
		Producto p = buscarProducto(codigo);
		if(p != null)
			return p.getView();
		return null;
	}
	
	public Vector<ProductoView> getCombos()
	{
		Vector<ProductoView> co = new Vector<ProductoView>();
		for(Producto p : combos)
			co.add(p.getView());
		return co;
	}
	
	public ProductoView buscarEntrada(String nombre)
	{
		Vector<ProductoView> ents = getEntradas();
		for(int i = 0; i < ents.size(); i++)
			if(ents.elementAt(i).getNombre().equals(nombre))
				return ents.elementAt(i);
		return null;
	}
	
	public ProductoView buscarAdicional(String nombre)
	{
		Vector<ProductoView> ads = getAdicionales();
		for(int i = 0; i < ads.size(); i++)
			if(ads.elementAt(i).getNombre().equals(nombre))
				return ads.elementAt(i);
		return null;		
	}
	
	public ProductoView buscarCombo(String nombre)
	{
		Vector<ProductoView> combs = getCombos();
		for(int i = 0; i < combs.size(); i++)
			if(combs.elementAt(i).getNombre().equals(nombre))
				return combs.elementAt(i);
		return null;		
	}
	
}
