package Controller_Admin;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import View_Admin.JControlador;
import View_Admin.JLogin;

public class Login implements ActionListener
{
	private JLogin vent;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
	public Login(JLogin vent) 
	{
		this.vent = vent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String user = vent.getTfDNI().getText();
		String pass = vent.getpFContra().getText();
		
		try
		{
			
			int DNI = Integer.parseInt(user);
			Connection con = DriverManager.getConnection(url, user_db, password);
			String tsql = "SELECT * FROM admin where DNIEMP = ? AND PASSEMP = ?";
			PreparedStatement st =con.prepareStatement(tsql);
						
			st.setInt(1, DNI);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
						
			if(rs.next())
			{
				JOptionPane.showMessageDialog(vent, "VERIFICACIÓN CONFIRMADA","BIENVENIDO/A",JOptionPane.CLOSED_OPTION);
				JControlador controlador = new JControlador();
				controlador.setVisible(true);
				controlador.setTitle("MENÚ");
				vent.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(vent, "Usuario no encontrado","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e1)
		{
			
		}
		
	}
}
