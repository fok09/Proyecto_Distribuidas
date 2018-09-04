package bean.srv;

import java.util.List;

import bean.ComboPromocional;
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
	
	public static List<Producto >leerProductos()
	{
		return dao.leerProductos();
	}
}

