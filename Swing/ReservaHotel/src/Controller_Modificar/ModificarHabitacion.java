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
import Model.Habitacion;
import View_Admin.JControlador;
import View_Modificar.JModificarCliente;
import View_Modificar.JModificarHabitacion;

public class ModificarHabitacion implements ActionListener
{
	private JModificarHabitacion ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
    public ModificarHabitacion(JModificarHabitacion vent)
   	{
   		ventana = vent;
   	}
    
    public void actionPerformed(ActionEvent e) 
	{
		boolean encontrado = false;
		boolean vacio = false;
		String numHab = ventana.getNumHab().getText();
		String campo = (String) ventana.getCampo().getSelectedItem();
		String nuevoValor = "";
		
		
		if(numHab.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Introduzca un número de habitación","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		else if(campo.equals(" - "))
		{
			JOptionPane.showMessageDialog(ventana, "Seleccione el campo a modificar", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
		}
    	else
    	{
    		Habitacion hab = new Habitacion(Integer.parseInt(numHab));
    		
    		try
			{
				
				Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT * FROM habitacion where NUMHAB = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, hab.getNum());
				ResultSet rs = st.executeQuery();
				
				
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(ventana, "No existe una habitación con el número proporcionado", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					
					encontrado = true;
				}
				
				if(encontrado == true)
				{
					
					if(campo.equalsIgnoreCase("Tipo"))
					{
						campo = "TIPHAB";
						nuevoValor = (String) ventana.getTipo().getSelectedItem();
					
					}else if(campo.equalsIgnoreCase("Descripcion"))
					{
						campo = "DESCHAB";
						nuevoValor = ventana.getDescripcion().getText();
						
					}	
										
					if(nuevoValor.isEmpty())
					{
						JOptionPane.showMessageDialog(ventana, "Nuevo valor vacío", "ERROR",JOptionPane.ERROR_MESSAGE);
						vacio = true;
					
					}else if(nuevoValor.equals(" - "))
					{
						
						JOptionPane.showMessageDialog(ventana, "Seleccione el tipo", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
						vacio = true;
						
					}
					
					if(vacio == false)
					{
						
						String Query = "UPDATE habitacion SET " + campo + " = " + "'" + nuevoValor + "'" + " WHERE NUMHAB = ?";
						PreparedStatement modificar = con.prepareStatement(Query);
						modificar.setInt(1, hab.getNum());
								 	             
		 	            int filasModificadas = modificar.executeUpdate();
		 	            
		 	            if(filasModificadas > 0)
		 	            {
		 	            	
		 	            	JOptionPane.showMessageDialog(ventana, "La habitación ha sido modificada correctamente", "CLIENTE MODIFICADO",JOptionPane.INFORMATION_MESSAGE);
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