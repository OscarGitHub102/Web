package Model;

public class Cliente 
{
	private int DNI;
	private String Nombre;
	private String Apellido;
	private String Telefono;
	private String Correo;
	
	public Cliente(int dni, String nombre, String apellido, String telefono, String correo) {
	
		DNI = dni;
		Nombre = nombre;
		Apellido = apellido;
		Telefono = telefono;
		Correo = correo;
		
	}
	
	public Cliente(int dNI) 
	{
		
		DNI = dNI;
	}

	/**
	 * Método de comprobación de formato de correo: @
	 * @param correo
	 * @return encontrado, si es true significa que el formato es correcto
	 */
	public boolean ComprobarCorreo(String correo)
	{
		 if (correo == null || correo.isEmpty())
		 {
	            return false;
		 }
		 return correo.indexOf("@") != -1;
	}

	public int getDNI() {
		return DNI;
	}

	public String getNombre() {
		return Nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public String getTelefono() {
		return Telefono;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}
	
}