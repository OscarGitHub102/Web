package Controller_Eliminar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Cliente;
import Model.Reserva;
import View_Admin.JControlador;
import View_Eliminar.JEliminar;
import View_Modificar.JModificarCliente;

public class Eliminar implements ActionListener
{
	private JEliminar ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    	
	public Eliminar(JEliminar vent) 
	{
		ventana = vent;
	}
	public void actionPerformed(ActionEvent e) 
	{
		String codRes = ventana.getCodRes().getText();
		boolean eliminado = ventana.isEliminado(),encontrado = false;
		String dniCli = ventana.getDniCli().getText();
		String idNuevo = ventana.getIdNuevo().getText();
	
		
		if(codRes.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Introduzca un código","ERROR",JOptionPane.ERROR_MESSAGE);
			
		}
		else
		{
			Reserva re = new Reserva(Integer.parseInt(codRes));
			
			try
			{
				Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT * FROM reserva where CODRES = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, re.getCodigo());
				ResultSet rs = st.executeQuery();
				
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(ventana, "No existe una reserva con el código proporcionado", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					
					encontrado = true;
				}
				
				if(encontrado == true && eliminado == true)
				{
					if(dniCli.isEmpty() || idNuevo.isEmpty())
					{
						JOptionPane.showMessageDialog(ventana, "Introduzca un valor","ERROR",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						
						String query="UPDATE cliente SET DNICLI = "+idNuevo+", NOMCLI = 'xxxxxx',APECLI = 'yyyyyyyyy',TELCLI = '123456',CORRCLI = 'AA@a' WHERE DNICLI = "+dniCli;
						PreparedStatement modificar = con.prepareStatement(query);
					
						int filasModificadas = modificar.executeUpdate();
			 	            
		 	            if(filasModificadas > 0)
		 	            {
		 	            		String query2 ="UPDATE reserva SET ESTRES = 'Anulado' WHERE CODRES = ?";
		 	            		PreparedStatement modi = con.prepareStatement(query2);
		 	            		modi.setInt(1, re.getCodigo());
		 	            		
		 	            		int res = modi.executeUpdate();
		 	            		
		 	            		if(res > 0)
		 	            		{
			 	            		JOptionPane.showMessageDialog(ventana, "La reserva ha sido modificada correctamente", "CLIENTE MODIFICADO",JOptionPane.INFORMATION_MESSAGE);
				 	            	JControlador controlador = new JControlador();
				 	            	controlador.setVisible(true);
				 	            	controlador.setTitle("MENÚ");
				 	            	ventana.dispose();
		 	            		}
		 	            		else
		 	            		{
		 	            			JOptionPane.showMessageDialog(ventana, "Error interno a la hora de modificar la reserva", "ERROR",JOptionPane.ERROR_MESSAGE);
		 	            		}
		 	            }
		 	            else
		 	            {
		 	            	JOptionPane.showMessageDialog(ventana, "Error interno a la hora de modificar el cliente", "ERROR",JOptionPane.ERROR_MESSAGE);
		 	            }
					}
				}
				else if(eliminado == false)
				{
					String query3 = "UPDATE reserva SET ESTRES = 'Desactivado' WHERE CODRES = ?";
					PreparedStatement update = con.prepareStatement(query3);
 	            	update.setInt(1, re.getCodigo());
 	            	int modi = update.executeUpdate();
 	            	
 	            	if(modi > 0)
 	            	{
 	            		JOptionPane.showMessageDialog(ventana, "La reserva ha sido modificada correctamente", "CLIENTE MODIFICADO",JOptionPane.INFORMATION_MESSAGE);
	 	            	JControlador controlador = new JControlador();
	 	            	controlador.setVisible(true);
	 	            	controlador.setTitle("MENÚ");
	 	            	ventana.dispose();
	            	}
 	            	else
 	            	{
 	            		JOptionPane.showMessageDialog(ventana, "Error interno a la hora de modificar la reserva", "ERROR",JOptionPane.ERROR_MESSAGE);
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
