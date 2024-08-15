package Controller_Modificar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Habitacion;
import Model.Reserva;
import View_Admin.JControlador;
import View_Modificar.JModificarHabitacion;
import View_Modificar.JModificarReserva;

public class ModificarReserva implements ActionListener
{
	private JModificarReserva ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
    public ModificarReserva(JModificarReserva vent)
   	{
   		ventana = vent;
   	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		boolean encontrado = false;
		boolean vacio = false;
		String codRes = ventana.getCodres().getText();
		String campo = (String) ventana.getCampo().getSelectedItem();
		//String nuevoValor = "";
		double precio;
		
		
		if(codRes.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Introduzca un código de reserva","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		else if(campo.equals(" - "))
		{
			JOptionPane.showMessageDialog(ventana, "Seleccione el campo a modificar", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
		}
    	else
    	{
    		Reserva res = new Reserva(Integer.parseInt(codRes));
    		
    		try
			{
				
				Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT * FROM reserva where CODRES = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, res.getCodigo());
				ResultSet rs = st.executeQuery();
				
				
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(ventana, "No existe una reserva con el codigo proporcionado", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					
					encontrado = true;
				}
				
				if(encontrado == true)
				{
													
					if(campo.equalsIgnoreCase("Estado"))
					{
						campo = "ESTRES";
						//nuevoValor = (String) ventana.getEstado().getSelectedItem();
					
					}else if(campo.equalsIgnoreCase("Fecha de entrada"))
					{
						campo = "FECHIN";
						//nuevoValor = ventana.getResto().getText();
						
					}
					else if(campo.equalsIgnoreCase("Fecha de salida"))
					{
						campo = "FECHSAL";
						//nuevoValor = ventana.getResto().getText();
					}
					else if(campo.equalsIgnoreCase("Precio"))
					{
						campo = "PRECRES";
						//nuevoValor = ventana.getResto().getText();
					}
					
					String nuevoValor = ventana.getResto().getText();
										
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
						if(campo.equalsIgnoreCase("PRECRES"))
						{
							precio = Double.parseDouble(nuevoValor);
							String Query = "UPDATE reserva SET " + campo + " = " + "'" + nuevoValor + "'" + " WHERE CODRES = ?";
							PreparedStatement modificar = con.prepareStatement(Query);
							modificar.setInt(1, res.getCodigo());
			 	             
			 	            int filasModificadas = modificar.executeUpdate();
			 	            
			 	            if(filasModificadas > 0)
			 	            {
			 	            	
			 	            	JOptionPane.showMessageDialog(ventana, "La reserva ha sido modificada correctamente", "CLIENTE MODIFICADO",JOptionPane.INFORMATION_MESSAGE);
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