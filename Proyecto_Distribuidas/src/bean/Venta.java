package bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Venta implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int proximoNumero;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numero;
	private LocalDate fecha;
	
	@OneToMany (cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="nroventa")
	private List<ItemVenta> items;
	
	public Venta()
	{
		super();
		this.fecha = LocalDate.now();
		this.items = new ArrayList<ItemVenta>();
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
	
	public ItemVenta getItem(int index){
		return items.get(index);
	}
	
	public float getTotal()
	{
		float total = 0;
		for(ItemVenta item : items)
			total += item.getSubtotal();
		return total;
	}
}
