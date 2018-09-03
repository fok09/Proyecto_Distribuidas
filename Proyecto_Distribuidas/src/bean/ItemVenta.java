package bean;

public class ItemVenta 
{
	private int cantidad;
	private Producto producto;
	
	public ItemVenta(Producto producto, int cantidad)
	{
		super();
		this.cantidad = cantidad;
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public float getSubtotal()
	{
		return producto.getPrecio() * cantidad;
	}
}
