package Model;

public class Admin 
{
	private int DNI;
	private String Contra;
	private String Correo;
	private String Nombre;
	private String Apellido;
	private String Tel;
	
	public Admin(int dni, String contra, String correo, String nombre, String apellido, String tel)
	{
		DNI = dni;
		Contra = contra;
		Correo = correo;
		Nombre = nombre;
		Apellido = apellido;
		Tel = tel;
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
		 
		 return correo.indexOf("@") != -1; // no es falso
	}

	public int getDNI() {
		return DNI;
	}

	public String getContra() {
		return Contra;
	}

	public String getCorreo() {
		return Correo;
	}

	public String getNombre() {
		return Nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public String getTel() {
		return Tel;
	}

		
}