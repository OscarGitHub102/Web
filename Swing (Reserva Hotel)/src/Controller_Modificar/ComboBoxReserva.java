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
import View_Modificar.JModificarCliente;
import View_Modificar.JModificarReserva;

public class ComboBoxReserva implements ActionListener 
{
	private JModificarReserva ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
	public ComboBoxReserva(JModificarReserva vent) 
	{
		this.ventana = vent;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		String codRes = ventana.getCodres().getText();
		String est = "",en ="",sal ="",prec = "";
		String seleccion = (String) ventana.getCampo().getSelectedItem();
		
		if(codRes.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Introduzca el código","ERROR",JOptionPane.ERROR_MESSAGE);
		}
    	else
    	{
    		Reserva reserva = new Reserva(Integer.parseInt(codRes));
    		
    		try
			{
    			Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT FECHIN,FECHSAL,ESTRES,PRECRES FROM reserva where CODRES = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, reserva.getCodigo());
				ResultSet rs = st.executeQuery();
				
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(ventana, "No existe una reserva con el código proporcionado", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					est = rs.getString("ESTRES");
					en = rs.getString("FECHIN");
					sal = rs.getString("FECHSAL");
					prec = rs.getString("PRECRES");
					prec = prec +" €";
					
					if(seleccion.equalsIgnoreCase("Estado"))
					{
						ventana.escribirMensaje(est);
					}
					else if(seleccion.equalsIgnoreCase("Fecha de entrada"))
					{
						ventana.escribirMensaje(en);
					}
					else if(seleccion.equalsIgnoreCase("Fecha de salida"))
					{
						ventana.escribirMensaje(sal);
					}
					else if(seleccion.equalsIgnoreCase("Precio"))
					{
						ventana.escribirMensaje(prec);
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