package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="combo")
@PrimaryKeyJoinColumn(name="codigo") 
public class ComboPromocional extends Producto implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float descuento;
		
//	@ManyToMany(cascade = CascadeType.MERGE)
//	@JoinTable(name="combo_producto", joinColumns=@JoinColumn(name="id_combo"), inverseJoinColumns=@JoinColumn(name="id_producto"))
	
	@OneToMany
	private List<Producto> productos;
	
	public ComboPromocional(float descuento, String nombre, ArrayList<Producto> productos) {
		super(nombre);
		this.descuento = descuento;
		this.productos = productos;
	}
	
	public ComboPromocional() {
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public ArrayList<Producto> getProductos() {
		return (ArrayList<Producto>) productos;
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

	public ProductoView getView()
	{
		String combo = "";
		for(Producto c : productos)
			combo.concat(c.getNombre());
		return new ProductoView(codigo,Integer.toString(codigo)+' '+nombre+' '+combo,getPrecio());
	}
}
