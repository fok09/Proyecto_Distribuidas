package bean;

public class Alimento extends Producto 
{
	private String nombre;
	private float precio;

	public Alimento(String nombre, float precio) {
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
