package Controller_Modificar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Servicio;
import View_Modificar.JModificarServicio;

public class ComboBoxServicio implements ActionListener
{
	private JModificarServicio ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
	public ComboBoxServicio(JModificarServicio vent) 
	{
		this.ventana = vent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String codigo = ventana.getCodigo().getText();
		String nombre = "";
		int precio;
		String descripcion = "";
		String seleccion = (String) ventana.getCampo().getSelectedItem();
		
		if(codigo.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Introduzca el código","ERROR",JOptionPane.ERROR_MESSAGE);
		}
    	else
    	{
    		Servicio servicio = new Servicio(Integer.parseInt(codigo));
    		
    		try
			{
    			
    			Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT NOMSER, PRECSER, DESCSER FROM servicio where CODSER = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, servicio.getCodigo());
				ResultSet rs = st.executeQuery();
				
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(ventana, "No existe un servicio con el código proporcionado", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					nombre = rs.getString("NOMSER");
					precio = rs.getInt("PRECSER");
					descripcion = rs.getString("DESCSER");
					
					if(seleccion.equalsIgnoreCase("Nombre"))
					{
						ventana.escribirMensaje(nombre);
					}
					else if(seleccion.equalsIgnoreCase("Precio"))
					{
						ventana.escribirMensaje(String.valueOf(precio));
					}
					else if(seleccion.equalsIgnoreCase("Descripción"))
					{
						ventana.escribirMensaje(descripcion);
					}
					
				}
				
			}
    		catch(SQLException e1) 
			{
				System.out.println(e1.getSQLState());
				e1.printStackTrace();
			}
    	}
	}
}