package Controller_Crear;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Cliente;
import View_Admin.JControlador;
import View_Admin.JLogin;
import View_Crear.JCrearCliente;

public class CrearCliente implements ActionListener
{
	
	private JCrearCliente ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
	public CrearCliente(JCrearCliente vent)
	{
		ventana = vent;
	}
    
	public void actionPerformed(ActionEvent e)
	{
		String DNI = ventana.getDni().getText();
		String Nombre = ventana.getNombre().getText();
		String Apellido = ventana.getApellido().getText();
		String Telefono = ventana.getTelefono().getText();
		String Correo = ventana.getCorreo().getText(); 
		
		if(DNI.isEmpty() || Nombre.isEmpty() || Apellido.isEmpty() || Telefono.isEmpty() || Correo.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Los campos tienen que estar llenos","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			
			boolean salida = false;
			
			Cliente cliente = new Cliente(Integer.parseInt(DNI), Nombre, Apellido, Telefono, Correo);
			
			if(cliente.ComprobarCorreo(Correo))
			{
				salida = true;
			}
			else
			{
				JOptionPane.showMessageDialog(ventana, "El correo no tiene el formato adecuado","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			
			if(salida == true)
			{
				try
				{					
					Connection con = DriverManager.getConnection(url, user_db, password);
					String tsql = "SELECT * FROM cliente where DNICLI = ?";
					PreparedStatement st = con.prepareStatement(tsql);
					st.setInt(1, cliente.getDNI());
					ResultSet rs = st.executeQuery();
										
					if(rs.next()) 
					{
						JOptionPane.showMessageDialog(ventana, "Cliente ya existente","ERROR",JOptionPane.ERROR_MESSAGE);
	     	        }
					else 
					{						
						String Query = "INSERT INTO cliente (DNICLI, NOMCLI, APECLI, TELCLI, CORRCLI) VALUES (?, ?, ?, ?, ?)";
						PreparedStatement insertar = con.prepareStatement(Query);
						
						insertar.setInt(1, cliente.getDNI());
						insertar.setString(2, cliente.getNombre());
						insertar.setString(3, cliente.getApellido());
						insertar.setString(4, cliente.getTelefono());
						insertar.setString(5, cliente.getCorreo());
	     	             	     	             
	     	             int filasInsertadas = insertar.executeUpdate();
	     	             
	     	            JOptionPane.showMessageDialog(ventana, "Cliente añadido correctamente","CLIENTE AÑADIDO",JOptionPane.CLOSED_OPTION);
	     	           
						JControlador controlador = new JControlador();
		        		controlador.setVisible(true);
		        		controlador.setTitle("MENÚ");
	                	ventana.dispose();
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

}
