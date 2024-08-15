package Controller_Modificar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Cliente;
import Model.Habitacion;
import View_Admin.JLogin;
import View_Modificar.JModificarCliente;
import View_Modificar.JModificarHabitacion;

public class ComboBoxHabitacion implements ActionListener
{
	private JModificarHabitacion ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
	public ComboBoxHabitacion(JModificarHabitacion vent) 
	{
		this.ventana = vent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String numHab = ventana.getNumHab().getText();
		String tipo = "",desc ="";
		String seleccion = (String) ventana.getCampo().getSelectedItem();
		
		if(numHab.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Introduzca un número de habitación","ERROR",JOptionPane.ERROR_MESSAGE);
		}
    	else
    	{
    		Habitacion hab = new Habitacion(Integer.parseInt(numHab));
    		
    		try
			{
    			Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT TIPHAB,DESCHAB FROM habitacion where NUMHAB = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, hab.getNum());
				ResultSet rs = st.executeQuery();
				
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(ventana, "No existe una habitacion  con el numero proporcionado", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					tipo = rs.getString("TIPHAB");
					desc = rs.getString("DESCHAB");
					
					if(seleccion.equalsIgnoreCase("Tipo"))
					{
						ventana.escribirMensaje(tipo);
					}
					else if((seleccion.equalsIgnoreCase("Descripcion")) || (seleccion.equalsIgnoreCase("Descripción")))
					{
						ventana.escribirMensaje(desc);
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