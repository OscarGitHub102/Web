package Model;

public class Habitacion
{
	
	private int num;
	private String tipo;
	private String desc;
	
	
	public Habitacion(int numero, String tipoDeHabitacion, String descripcion)
	{
		num = numero;
		tipo = tipoDeHabitacion;
		desc = descripcion;
		
	}
	
	public Habitacion(int num) 
	{
	
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDesc() {
		return desc;
	}	

}