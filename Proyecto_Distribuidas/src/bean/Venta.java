package bean;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venta
{
	private static int proximoNumero;
	private int numero;
	private LocalDate fecha;
	private ArrayList<ItemVenta> items;
	
	public Venta(int numero, LocalDate fecha)
	{
		super();
		this.numero = getProximoNumero();
		this.fecha = LocalDate.now();
		this.items = new ArrayList<ItemVenta>();
	}

	public static int getProximoNumero()
	{
		return proximoNumero++;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	
	
	public void agregarItem(Producto producto, int cantidad)
	{
		ItemVenta item = new ItemVenta(producto,cantidad);
		items.add(item);
	}
	
	public float getTotal()
	{
		float total = 0;
		for(ItemVenta item : items)
			total += item.getSubtotal();
		return total;
	}
}
