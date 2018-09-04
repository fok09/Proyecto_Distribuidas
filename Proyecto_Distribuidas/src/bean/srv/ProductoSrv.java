package bean.srv;

import java.util.List;

import bean.Producto;
import bean.dao.ProductoDao;


public class ProductoSrv {
private static ProductoDao dao;
	
	static {
		dao = ProductoDao.getInstancia();
	}
	
	public static void grabarAdicional(Producto p){
		dao.grabarProducto(p);
	}
	
	public static void grabarProductos(List<Producto> Productos){
		dao.grabarProductos(Productos);
	}
	
	public static List<Producto >leerProductos()
	{
		return dao.leerProductos();
	}
}

