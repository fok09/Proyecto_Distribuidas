package bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="adicional")
@PrimaryKeyJoinColumn(name="codigo") 
public class Adicional extends Producto implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tipo;
	private float precio;


	public Adicional(String nombre, float precio, String tipo) {

		super(nombre);
		this.precio = precio;
		this.tipo = tipo;
	}
	
	public Adicional() {
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getPrecio()
	{
		return precio;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ProductoView getView()
	{
		return new ProductoView(codigo,Integer.toString(codigo)+' '+tipo+' '+nombre,precio);
	}
}
