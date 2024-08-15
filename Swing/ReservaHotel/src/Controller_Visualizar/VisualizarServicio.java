package Controller_Visualizar;

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
import View_Visualizar.JVisualizarCliente;
import View_Visualizar.JVisualizarHabitacion;
import View_Visualizar.JVisualizarServicio;

public class VisualizarServicio implements ActionListener
{
	private JVisualizarServicio ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
	
	public VisualizarServicio(JVisualizarServicio ventana) {
	
		this.ventana = ventana;
	}

	public void actionPerformed(ActionEvent e) 
	{
		String codSer = ventana.getCodSer().getText(),cod,nom,pre,desc;
		
		if(codSer.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Los campos tienen que estar llenos","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			Servicio se = new Servicio(Integer.parseInt(codSer));
			try
			{
				Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT CODSER,NOMSER, PRECSER, DESCSER  FROM servicio where CODSER = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, se.getCodigo());
				ResultSet rs = st.executeQuery();
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(ventana, "No existe un servicio con el codigo proporcionado", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					cod = rs.getString("CODSER");
					nom = rs.getString("NOMSER");
					pre = rs.getString("PRECSER");
					desc = rs.getString("DESCSER");
					
					
					ventana.setVCodigo(cod);
					ventana.setVNombre(nom);
					ventana.setVPrecio(pre);
					ventana.setVDesc(desc);
					
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
