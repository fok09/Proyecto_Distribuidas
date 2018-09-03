package bean;

public abstract class Producto 
{
	protected static int proximoNumero;
	protected int codigo;

	public Producto() 
	{
		super();
		this.codigo = getProximoNumero();
	}
	
	private int getProximoNumero()
	{
		return proximoNumero++;
	}
	
	public abstract float getPrecio();
}
