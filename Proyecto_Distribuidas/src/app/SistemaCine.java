package app;

import java.util.ArrayList;

import bean.Producto;
import bean.Venta;

public class SistemaCine 
{
	private ArrayList<Producto> productos;
	private ArrayList<Venta> ventas;
	
	private static SistemaCine instancia = null;
	
	private SistemaCine()
	{
		productos = new ArrayList<Producto>();
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
	
	
	
	public void registrarVenta()
	{
		
	}
}
