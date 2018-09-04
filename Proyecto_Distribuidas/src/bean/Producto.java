package bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "productos")
public abstract class Producto implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static int proximoNumero;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int codigo;

	
	public Producto() 
	{
		super();
		this.codigo = getProximoNumero();
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	private int getProximoNumero()
	{
		return proximoNumero++;
	}
	
	public abstract float getPrecio();
}
