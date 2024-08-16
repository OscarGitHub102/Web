package Controller_Modificar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Cliente;
import View_Admin.JControlador;
import View_Modificar.JModificarCliente;

public class ModificarCliente implements ActionListener
{
	private JModificarCliente ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
    public ModificarCliente(JModificarCliente vent)
   	{
   		ventana = vent;
   	}
    
    public void actionPerformed(ActionEvent e) 
	{
    	boolean encontrado = false;
    	boolean vacio = false;
		boolean valido = true;
		String DNI = ventana.getDni().getText();
		String campo = (String) ventana.getCampo().getSelectedItem();
		
		if(DNI.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Introduzca un DNI","ERROR",JOptionPane.ERROR_MESSAGE);
			
		}else if(campo.equals(" - "))
		{
			JOptionPane.showMessageDialog(ventana, "Seleccione el campo a modificar", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
		}
    	else
    	{
    		Cliente cliente = new Cliente(Integer.parseInt(DNI));
    		
    		try
			{
				
				Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT * FROM cliente where DNICLI = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, cliente.getDNI());
				ResultSet rs = st.executeQuery();
				
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(ventana, "No existe un cliente con el DNI proporcionado", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					
					encontrado = true;
				}
				
				if(encontrado == true)
				{
									
					if(campo.equals("Nombre"))
					{
						campo = "NOMCLI";
					
					}else if(campo.equals("Apellido"))
					{
						campo = "APECLI";
						
						
					}else if(campo.equals("Teléfono"))
					{
						campo = "TELCLI";
						
						
					}else if(campo.equals("Correo"))
					{
						
						campo = "CORRCLI";
												
					}
						
					String nuevoValor = ventana.getDespues().getText();
					
					if(nuevoValor.isEmpty())
					{
						JOptionPane.showMessageDialog(ventana, "Nuevo valor vacío", "ERROR",JOptionPane.ERROR_MESSAGE);
						vacio = true;
					}
					
					if(vacio == false)
					{
						
						if(campo.equalsIgnoreCase("CORRCLI"))
						{
							if(cliente.ComprobarCorreo(nuevoValor) == false)	
							{
								JOptionPane.showMessageDialog(ventana, "Formato del correo inválido: @", "ERROR",JOptionPane.ERROR_MESSAGE);
								valido = false;
							}
					
						}
						
						if(valido == true)
						{
							String Query = "UPDATE cliente SET " + campo + " = " + "'" + nuevoValor + "'" + " WHERE DNICLI = ?";
							PreparedStatement modificar = con.prepareStatement(Query);
							modificar.setInt(1, cliente.getDNI());
										 	             
			 	            int filasModificadas = modificar.executeUpdate();
			 	            
			 	            if(filasModificadas > 0)
			 	            {
			 	            	
			 	            	JOptionPane.showMessageDialog(ventana, "El cliente ha sido modificado correctamente", "CLIENTE MODIFICADO",JOptionPane.INFORMATION_MESSAGE);
			 	            	JControlador controlador = new JControlador();
			 	            	controlador.setVisible(true);
			 	            	controlador.setTitle("MENÚ");
			 	            	ventana.dispose();
			 	            	
			 	            }
			 	            else
			 	            {
			 	            	JOptionPane.showMessageDialog(ventana, "Error interno a la hora de modificar", "ERROR",JOptionPane.ERROR_MESSAGE);
			 	            }
			 	            
						}
					
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