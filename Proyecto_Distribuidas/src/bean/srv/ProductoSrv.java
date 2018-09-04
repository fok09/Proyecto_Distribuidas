package bean.srv;

import java.util.List;

import bean.Adicional;
import bean.ComboPromocional;
import bean.Entrada;
import bean.Producto;
import bean.dao.ProductoDao;


public class ProductoSrv {
private static ProductoDao dao;
	
	static {
		dao = ProductoDao.getInstancia();
	}
	
	public static void grabarProducto(Producto p){
		dao.grabarProducto(p);
	}
	
	public static void grabarCombo(ComboPromocional combo){
		dao.grabarCombo(combo);
	}
	
	public static Producto getProducto(int codigo){
		return dao.get(codigo);
	}
	
	public static Entrada getEntrada(int codigo){
//		return (Entrada) dao.get(codigo);
		return  dao.getEntrada(codigo);
	}
	
	public static Adicional getAdicional(int codigo){
//		return (Adicional) dao.get(codigo);
		return  dao.getAdicional(codigo);
	}
	
	public static ComboPromocional getCombo(int codigo){
//		return (ComboPromocional) dao.get(codigo);
		return  dao.getCombo(codigo);
	}
	
	public static List<Producto>leerProductos()
	{
		return dao.leerProductos();
	}
	
	public static List<Entrada>leerEntradas()
	{
		return dao.leerEntradas();
	}
	
	public static List<Adicional>leerAdicional()
	{
		return dao.leerAdicional();
	}
	
	public static List<ComboPromocional>leerCombos()
	{
		return dao.leerCombos();
	}
	
	
}

