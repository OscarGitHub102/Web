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
import Model.Habitacion;
import View_Visualizar.JVisualizarCliente;
import View_Visualizar.JVisualizarHabitacion;

public class VisualizarHabitacion implements ActionListener
{
	private JVisualizarHabitacion ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
	public VisualizarHabitacion(JVisualizarHabitacion ventana)
	{
	
		this.ventana = ventana;
	}


	public void actionPerformed(ActionEvent e) 
	{
		String numHab = ventana.getNumHab().getText(),num,tip,desc;
		
		if(numHab.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Los campos tienen que estar llenos","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			Habitacion ha = new Habitacion(Integer.parseInt(numHab));
			try
			{
				Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT NUMHAB,TIPHAB, DESCHAB FROM habitacion where NUMHAB = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, ha.getNum());
				ResultSet rs = st.executeQuery();
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(ventana, "No existe una habitación con el numero proporcionado", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					num = rs.getString("NUMHAB");
					tip = rs.getString("TIPHAB");
					desc = rs.getString("DESCHAB");
					
					
					ventana.setVNumHab(numHab);
					ventana.setVTipo(tip);
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
