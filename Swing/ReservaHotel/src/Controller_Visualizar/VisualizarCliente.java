package Controller_Visualizar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Cliente;
import View_Crear.JCrearCliente;
import View_Visualizar.JVisualizarCliente;

public class VisualizarCliente implements ActionListener
{
	private JVisualizarCliente ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
	public VisualizarCliente(JVisualizarCliente ventana) 
	{
	
		this.ventana = ventana;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		String DNICli = ventana.getDniCli().getText(),nom,ape,tel,corr,dni;
		
		if(DNICli.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Los campos tienen que estar llenos","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			Cliente cl = new Cliente(Integer.parseInt(DNICli));
			try
			{
				Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT DNICLI,NOMCLI, APECLI, TELCLI, CORRCLI FROM cliente where DNICLI = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, cl.getDNI());
				ResultSet rs = st.executeQuery();
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(ventana, "No existe un cliente con el DNI proporcionado", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					dni = rs.getString("DNICLI");
					nom = rs.getString("NOMCLI");
					ape = rs.getString("APECLI");
					tel = rs.getString("TELCLI");
					corr = rs.getString("CORRCLI");
					
					ventana.setVDNI(dni);
					ventana.setVNombre(nom);
					ventana.setVApellido(ape);
					ventana.setVTelefono(tel);
					ventana.setVCorreo(corr);
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
