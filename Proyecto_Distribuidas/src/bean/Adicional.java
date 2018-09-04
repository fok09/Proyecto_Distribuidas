package bean;

public class Adicional extends Producto 
{
	private String nombre, tipo;
	private int id;
	private float precio;


	public Adicional(String nombre, int id, float precio, String tipo) {

		super();
		this.nombre = nombre;
		this.id = id;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

}
