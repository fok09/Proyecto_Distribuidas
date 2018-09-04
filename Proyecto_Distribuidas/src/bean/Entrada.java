package bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="entrada")
@PrimaryKeyJoinColumn(name="codigo") 
public class Entrada extends Producto implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String pelicula;
	private String sala;
	private String horario;
	private float precio;
	
	public Entrada(String pelicula, String sala, String horario, float precio) 
	{
		super();
		this.pelicula = pelicula;
		this.sala = sala;
		this.horario = horario;
		this.precio = precio;
	}

	public Entrada(){
	}
	
	public String getPelicula() {
		return pelicula;
	}

	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getPrecio() 
	{
		return precio;
	}	
}
