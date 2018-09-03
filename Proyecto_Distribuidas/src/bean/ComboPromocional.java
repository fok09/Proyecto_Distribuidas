package bean;

import java.util.ArrayList;

public class ComboPromocional extends Producto 
{
	private float descuento;
	private String nombre;
	private ArrayList<Producto> productos;
	
	public ComboPromocional(float descuento, String nombre, ArrayList<Producto> productos) {
		super();
		this.descuento = descuento;
		this.nombre = nombre;
		this.productos = productos;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public float getPrecio() 
	{
		int subtotal = 0;
		for(Producto p : productos)
			subtotal += p.getPrecio();
		return subtotal * (1 - descuento/100);
	}

}
