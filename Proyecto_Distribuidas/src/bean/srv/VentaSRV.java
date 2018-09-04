package bean.srv;

import java.util.List;

import bean.Venta;
import bean.dao.VentaDao;


public class VentaSRV {
private static VentaDao dao;
	
	static {
		dao = VentaDao.getInstancia();
	}
	
	public static void grabarVenta(Venta v){
		dao.grabarVenta(v);
	}
	
	public static void grabarVentas(List<Venta> ventas){
		dao.grabarVentas(ventas);
	}
	
	public static List<Venta >leerVentas()
	{
		return dao.leerVentas();
	}
}
