package Controller_Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import View_Admin.JLogin;
import View_Admin.JRegistro;
import Model.Admin;


public class Registro implements ActionListener
{
	private JRegistro vent;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
	public Registro(JRegistro vent) 
	{
		this.vent = vent;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String DNI = vent.getTextFieldDNI().getText();
		String Contra = vent.getPasswordFieldContra().getText();
		String Correo = vent.getTextFieldCorreo().getText();
		String Nombre = vent.getTextFieldNombre().getText();
		String Apellido = vent.getTextFieldApellido().getText();
		String Telefono = vent.getTextFieldTel().getText();
		
		if(DNI.isEmpty() || Contra.isEmpty() || Correo.isEmpty()|| Nombre.isEmpty() || Apellido.isEmpty() || Telefono.isEmpty())
		{
			JOptionPane.showMessageDialog(vent, "Los campos tienen que estar llenos","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			boolean exist = false;
			boolean salida = false;
			
			Admin admin = new Admin(Integer.parseInt(DNI), Contra, Correo, Nombre, Apellido, Telefono);
			
			if(admin.ComprobarCorreo(Correo))
			{
				salida = true;
			}
			else
			{
				JOptionPane.showMessageDialog(vent, "El correo no tiene el formato adecuado","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			
			if(salida == true)
			{
				
				try
				{					
					Connection con = DriverManager.getConnection(url, user_db, password);
					String tsql = "SELECT * FROM admin where DNIEMP = ?";
					PreparedStatement st = con.prepareStatement(tsql);
					st.setInt(1, admin.getDNI());
					ResultSet rs = st.executeQuery();
										
					if(rs.next()) 
					{
						JOptionPane.showMessageDialog(vent, "Usuario ya existente","ERROR",JOptionPane.ERROR_MESSAGE);
	     	        }
					else 
					{
						
						String Query = "INSERT INTO admin (DNIEMP, PASSEMP, CORREMP, NOMEMP, APEEMP, TELEMP) VALUES (?, ?, ?, ?, ?, ?)";
						PreparedStatement insertar = con.prepareStatement(Query);
						
						insertar.setInt(1, admin.getDNI());
						insertar.setString(2, admin.getContra());
						insertar.setString(3, admin.getCorreo());
						insertar.setString(4, admin.getNombre());
						insertar.setString(5, admin.getApellido());
						insertar.setString(6, admin.getTel());
	     	              	             
 	             		int filasInsertadas = insertar.executeUpdate();
		     	             		
		     	        JOptionPane.showMessageDialog(vent, "BIENVENIDO/A", "USUARIO AÑADIDO/A",JOptionPane.INFORMATION_MESSAGE);
		     	        
		     	        JLogin login = new JLogin();
		        		login.setVisible(true);
		        		login.setTitle("INICIO DE SESIÓN");
		        		vent.dispose();
	     	             		
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
