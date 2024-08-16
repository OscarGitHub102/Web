package Model;

public class Servicio
{
	
	private int codigo;
	private String nombre;
	private double precio;
	private String descripcion;
	
	
	public Servicio(int cod, String nom, double prec, String desc)
	{
		codigo = cod;
		nombre = nom;
		precio = prec;
		descripcion = desc;
		
	}
	
	public Servicio(int codigo) 
	{

		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
}