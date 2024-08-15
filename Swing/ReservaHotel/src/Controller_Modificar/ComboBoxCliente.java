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
import View_Admin.JLogin;
import View_Modificar.JModificarCliente;

public class ComboBoxCliente implements ActionListener
{
	private JModificarCliente ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
	public ComboBoxCliente(JModificarCliente vent) 
	{
		this.ventana = vent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String DNI = ventana.getDni().getText();
		String nom = "";
		String ape = "";
		String tel = "";
		String corr = "";
		String selected = (String) ventana.getCampo().getSelectedItem();
		
		if(DNI.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Introduzca el DNI","ERROR",JOptionPane.ERROR_MESSAGE);
		}
    	else
    	{
    		Cliente cliente = new Cliente(Integer.parseInt(DNI));
    		
    		try
			{
    			
    			Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT NOMCLI, APECLI, TELCLI, CORRCLI FROM cliente where DNICLI = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, cliente.getDNI());
				ResultSet rs = st.executeQuery();
				
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(ventana, "No existe un cliente con el DNI proporcionado", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					nom = rs.getString("NOMCLI");
					ape = rs.getString("APECLI");
					tel = rs.getString("TELCLI");
					corr = rs.getString("CORRCLI");
					
					if(selected.equalsIgnoreCase("Nombre"))
					{
						ventana.escribirMensaje(nom);
					}
					else if(selected.equalsIgnoreCase("Apellido"))
					{
						ventana.escribirMensaje(ape);
					}
					else if(selected.equalsIgnoreCase("Teléfono"))
					{
						ventana.escribirMensaje(tel);
					}
					else if(selected.equalsIgnoreCase("Correo"))
					{
						ventana.escribirMensaje(corr);
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