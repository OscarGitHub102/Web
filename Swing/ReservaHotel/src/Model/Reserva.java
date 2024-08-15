package Model;

public class Reserva
{
	
	private int Codigo;
	private int CodServicio;
	private int DNICliente;
	private int NumeroHabitacion;
	private String FechaInicio;
	private String FechaSalida;
	private String estado;
	private double precio;
	
	public Reserva(int codigo, int dNICliente, int numeroHabitacion, String fechaInicio, String fechaSalida,int CodSer,String est,double prec) 
	{
	
		Codigo = codigo;
		DNICliente = dNICliente;
		NumeroHabitacion = numeroHabitacion;
		FechaInicio = fechaInicio;
		FechaSalida = fechaSalida;
		CodServicio = CodSer;
		estado = est;
		precio = prec;
		
	}
	

	public Reserva(int codigo)
	{
	
		Codigo = codigo;
	}


	public int getCodigo() {
		return Codigo;
	}

	public int getDNICliente() {
		return DNICliente;
	}

	public int getNumeroHabitacion() {
		return NumeroHabitacion;
	}

	public String getFechaInicio() {
		return FechaInicio;
	}

	public String getFechaSalida() {
		return FechaSalida;
	}

	public int getCodServicio() {
		return CodServicio;
	}

	public String getEstado() {
		return estado;
	}


	public double getPrecio() {
		return precio;
	}

}