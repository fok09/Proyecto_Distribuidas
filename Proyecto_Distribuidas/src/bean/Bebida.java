package bean;

public class Bebida extends Producto {
	
	private String nombre;
	private float precio;
	
	public Bebida(String nombre, float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getPrecio() 
	{
		return precio;
	}

}
