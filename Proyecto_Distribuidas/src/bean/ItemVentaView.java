package bean;

import java.util.Vector;

public class ItemVentaView 
{
	private Vector<String> detalle;
	public ItemVentaView(int codigo,String nombre, int cantidad)
	{
		detalle = new Vector<String>();
		detalle.add(String.valueOf(codigo));
		detalle.add(nombre);
		detalle.add(String.valueOf(cantidad));
	}
	public Vector<String> getDetalle() {
		return detalle;
	}
	public void setDetalle(Vector<String> detalle) {
		this.detalle = detalle;
	}
}
