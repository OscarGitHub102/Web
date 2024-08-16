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
import Model.Reserva;
import View_Visualizar.JVisualizarCliente;
import View_Visualizar.JVisualizarReserva;

public class VisualizarReserva implements ActionListener
{
	private JVisualizarReserva ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
	public VisualizarReserva(JVisualizarReserva ventana)
	{
		this.ventana = ventana;
	}


	public void actionPerformed(ActionEvent e) 
	{
		String codRes = ventana.getCodRes().getText(),cod,dni,num,codser,fechain,fechasal,est,prec;
		
		if(codRes.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Los campos tienen que estar llenos","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			Reserva re = new Reserva(Integer.parseInt(codRes));
			try
			{
				Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT CODRES,DNICLI,NUMHAB,CODSER,FECHIN,FECHSAL,PRECRES,ESTRES FROM reserva where CODRES = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, re.getCodigo());
				ResultSet rs = st.executeQuery();
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(ventana, "No existe un cliente con el DNI proporcionado", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{	
					cod = rs.getString("CODRES");
					dni = rs.getString("DNICLI");
					num = rs.getString("NUMHAB");
					codser = rs.getString("CODSER");
					fechain = rs.getString("FECHIN");
					fechasal = rs.getString("FECHSAL");
					prec = rs.getString("PRECRES");
					est = rs.getString("ESTRES");
					
					ventana.setVCodRes(codRes);
					ventana.setVDNI(dni);
					ventana.setVnumHab(num);
					ventana.setVCodSer(codser);
					ventana.setVFechIn(fechain);
					ventana.setVFechSal(fechasal);
					ventana.setVFechIn(fechain);
					ventana.setVEstado(est);
					ventana.setVPrec(prec);
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
