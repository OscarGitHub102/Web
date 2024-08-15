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
import Model.Servicio;
import View_Admin.JControlador;
import View_Modificar.JModificarServicio;

public class ModificarServicio implements ActionListener
{
	
	private JModificarServicio ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
    public ModificarServicio(JModificarServicio vent)
    {
    	
    	ventana = vent;
    	
    }
    
    public void actionPerformed(ActionEvent e) 
	{
    	boolean encontrado = false;
    	boolean vacio = false;
		boolean valido = true;
		double precio;
		int filasModificadas;
		String codigo = ventana.getCodigo().getText();
		String campo = (String) ventana.getCampo().getSelectedItem();
		
		if(codigo.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Introduzca un Código de Servicio","ERROR",JOptionPane.ERROR_MESSAGE);
			
		}else if(campo.equals(" - "))
		{
			JOptionPane.showMessageDialog(ventana, "Seleccione el campo a modificar", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
		}
    	else
    	{
    		Servicio servicio = new Servicio(Integer.parseInt(codigo));
    		
    		try
			{				
				Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT * FROM servicio where CODSER = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, servicio.getCodigo());
				ResultSet rs = st.executeQuery();
				
				
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(ventana, "No existe un servicio con el código proporcionado", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					
					encontrado = true;
				}
				
				if(encontrado == true)
				{
					
					if(campo.equals("Nombre"))
					{
						campo = "NOMSER";
					
					}else if(campo.equals("Precio"))
					{
						campo = "PRECSER";
						
						
					}else if(campo.equals("Descripción"))
					{
						campo = "DESCSER";
						
					}
						
					String nuevoValor = ventana.getDespues().getText();
					
					if(nuevoValor.isEmpty())
					{
						JOptionPane.showMessageDialog(ventana, "Nuevo valor vacío", "ERROR",JOptionPane.ERROR_MESSAGE);
						vacio = true;
					}
					
					if(vacio == false)
					{
						
						if(campo.equals("PRECSER"))
						{
							
							precio = Double.parseDouble(nuevoValor);
							String Query = "UPDATE servicio SET " + campo + " = " + "'" + nuevoValor + "'" + " WHERE CODSER = ?";
							PreparedStatement modificar = con.prepareStatement(Query);
							modificar.setInt(1, servicio.getCodigo());
										 	             
			 	            filasModificadas = modificar.executeUpdate();
							
						}
						else
						{
							
							String Query = "UPDATE servicio SET " + campo + " = " + "'" + nuevoValor + "'" + " WHERE CODSER = ?";
							PreparedStatement modificar = con.prepareStatement(Query);
							modificar.setInt(1, servicio.getCodigo());
										 	             
			 	            filasModificadas = modificar.executeUpdate();
							
						}
						
		 	            if(filasModificadas > 0)
		 	            {
		 	            	
		 	            	JOptionPane.showMessageDialog(ventana, "El servicio ha sido modificado correctamente", "SERVICIO MODIFICADO",JOptionPane.INFORMATION_MESSAGE);
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
			catch(SQLException e1) 
			{
				System.out.println(e1.getSQLState());
				e1.printStackTrace();
			}
    		
    	}
			
	}

}