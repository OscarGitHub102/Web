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
import Model.Habitacion;
import View_Admin.JControlador;
import View_Admin.JLogin;
import View_Crear.JCrearCliente;
import View_Crear.JCrearHabitacion;

public class CrearHabitacion implements ActionListener
{
	
	private JCrearHabitacion ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
	public CrearHabitacion(JCrearHabitacion vent)
	{
		ventana = vent;
	}
    
	public void actionPerformed(ActionEvent e)
	{
		String num = ventana.getNum().getText();
		String tipo = (String) ventana.getTipo().getSelectedItem();
		String descripcion = ventana.getDesc().getText();
		
		if(num.isEmpty() || descripcion.isEmpty() )
		{
			JOptionPane.showMessageDialog(ventana, "Los campos tienen que estar llenos","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		else if(tipo.equals(" - "))
		{
			JOptionPane.showMessageDialog(ventana, "Seleccione el tipo de habitación", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
						
			Habitacion hab = new Habitacion(Integer.parseInt(num),tipo, descripcion);
			
			try
			{				
				Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT * FROM habitacion where NUMHAB = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, hab.getNum());
				ResultSet rs = st.executeQuery();
								
				if(rs.next()) 
				{
					JOptionPane.showMessageDialog(ventana, "Habitación ya existente","ERROR",JOptionPane.ERROR_MESSAGE);
     	        }
				else 
				{
					
					String Query = "INSERT INTO habitacion (NUMHAB, TIPHAB, DESCHAB) VALUES (?, ?, ?)";
					PreparedStatement insertar = con.prepareStatement(Query);
					
					insertar.setInt(1, hab.getNum());
					insertar.setString(2, hab.getTipo());
					insertar.setString(3, hab.getDesc());
					     	             
     	           	int filasInsertadas = insertar.executeUpdate();
     	             
     	            JOptionPane.showMessageDialog(ventana, "Habitación añadida correctamente", "HABITACIÓN AÑADIDA",JOptionPane.CLOSED_OPTION);
     	           
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