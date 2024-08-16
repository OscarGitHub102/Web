package Controller_Crear;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Servicio;
import View_Admin.JControlador;
import View_Crear.JCrearHabitacion;
import View_Crear.JCrearServicio;

public class CrearServicio implements ActionListener
{
	
	private JCrearServicio ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
   
    public CrearServicio(JCrearServicio vent)
	{
		ventana = vent;
	}
    
    public void actionPerformed(ActionEvent e)
    {
    	String codigo = ventana.getCodigo().getText();
    	String nombre = ventana.getNombre().getText();
    	String precio = ventana.getPrecio().getText();
    	String descripcion = ventana.getDescripcion().getText();
    	
    	if(nombre.isEmpty() || precio.isEmpty() || descripcion.isEmpty()||codigo.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Los campos tienen que estar llenos","ERROR",JOptionPane.ERROR_MESSAGE);
		}
    	else
    	{
    		
    		Servicio servicio = new Servicio(Integer.parseInt(codigo),nombre, Double.parseDouble(precio), descripcion);
    		
    		try
			{
				
				Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT * FROM servicio where CODSER = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, servicio.getCodigo());
				ResultSet rs = st.executeQuery();
						
				if(rs.next()) 
				{
					JOptionPane.showMessageDialog(ventana, "Servicio ya existente","ERROR",JOptionPane.ERROR_MESSAGE);
     	        }
				else 
				{
					
					String Query = "INSERT INTO servicio (CODSER, NOMSER, PRECSER, DESCSER) VALUES (?, ?, ?, ?)";
					PreparedStatement insertar = con.prepareStatement(Query);
					
					insertar.setInt(1, servicio.getCodigo());
					insertar.setString(2, servicio.getNombre());
					insertar.setDouble(3, servicio.getPrecio());
					insertar.setString(4, servicio.getDescripcion());
     	                  	             
     	            int filasInsertadas = insertar.executeUpdate();
     	             
     	            JOptionPane.showMessageDialog(ventana, "Servicio añadido correctamente", "SERVICIO AÑADIDO",JOptionPane.CLOSED_OPTION);
     	           
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