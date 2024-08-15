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
import Model.Reserva;
import Model.Servicio;
import View_Admin.JControlador;
import View_Crear.JCrearReserva;

public class CrearReserva implements ActionListener
{
	private JCrearReserva ventana;
	private String url = "";		// cambiar según url de la BBDD
    private String user_db = "";		// cambiar según nombre de usuario de la BBDD
    private String password = "";		// cambiar según contraseña de la BBDD
    
	public CrearReserva(JCrearReserva vent)
	{
		ventana = vent;
	}
    
	public void actionPerformed(ActionEvent e)
	{
		String codRes = ventana.getCodRes().getText();
		String dni = ventana.getDniCli().getText();
		String numHab = ventana.getNumHab().getText();
		String codSer = ventana.getCodSer().getText();
		String fechIn = ventana.getFechIn().getText();
		String fechSal = ventana.getFechSal().getText();
		String estado = "Activado";
		String prec = ventana.getPrecRes().getText();
		
		
		if(codRes.isEmpty() || dni.isEmpty() || numHab.isEmpty() || codSer.isEmpty() || fechIn.isEmpty() || fechSal.isEmpty() || prec.isEmpty())
		{
			JOptionPane.showMessageDialog(ventana, "Los campos tienen que estar llenos","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		else if(!comprobarDNI(dni))
        {
            JOptionPane.showMessageDialog(ventana, "DNI no encontrado","ERROR",JOptionPane.ERROR_MESSAGE);

        }else if(!comprobarNumHab(numHab))
        {
            JOptionPane.showMessageDialog(ventana, "Número de habitación no encontrado","ERROR",JOptionPane.ERROR_MESSAGE);

        }else if(!comprobarCodSer(codSer))
        {
            JOptionPane.showMessageDialog(ventana, "Código de servicio no encontrado","ERROR",JOptionPane.ERROR_MESSAGE);
        }
		else
		{
			Reserva res = new Reserva(Integer.parseInt(codRes),Integer.parseInt(dni),Integer.parseInt(numHab),fechIn,fechSal,Integer.parseInt(codSer),estado,Double.parseDouble(prec));
			
			try
			{
				
				Connection con = DriverManager.getConnection(url, user_db, password);
				String tsql = "SELECT * FROM reserva where CODRES = ?";
				PreparedStatement st = con.prepareStatement(tsql);
				st.setInt(1, res.getCodigo());
				ResultSet rs = st.executeQuery();
								
				if(rs.next()) 
				{
					JOptionPane.showMessageDialog(ventana, "Reserva ya existente","ERROR",JOptionPane.ERROR_MESSAGE);
     	        }
				else 
				{
					
					String Query = "INSERT INTO reserva (CODRES, DNICLI, FECHIN, FECHSAL, NUMHAB,CODSER,ESTRES,PRECRES) VALUES (?, ?, ?, ?, ?, ?,?,?)";
					PreparedStatement insertar = con.prepareStatement(Query);
					
					insertar.setInt(1, res.getCodigo());
					insertar.setInt(2, res.getDNICliente());
					insertar.setString(3, res.getFechaInicio());
					insertar.setString(4, res.getFechaSalida());
					insertar.setInt(5, res.getNumeroHabitacion());
					insertar.setInt(6, res.getCodServicio());
					insertar.setString(7, res.getEstado());
					insertar.setDouble(8, res.getPrecio());
     	                  	             
     	            int filasInsertadas = insertar.executeUpdate();
     	             
     	            JOptionPane.showMessageDialog(ventana, "Reserva añadida correctamente","RESERVA AÑADIDA",JOptionPane.CLOSED_OPTION);
     	           
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
/***********************************************************************************/
	
	/**
	 * Método de comprobación de cliente con DNI
	 * @param DNI
	 * @return encontrado, si es true significa que hay un cliente con ese DNI
	 */
	public boolean comprobarDNI(String DNI)
	{
		
		boolean encontrado = false;
		
		int dni = Integer.parseInt(DNI);
		
		Cliente cliente = new Cliente(dni);
		
		try
		{
			
			Connection con = DriverManager.getConnection(url, user_db, password);
			String tsql = "SELECT * FROM cliente where DNICLI = ?";
			PreparedStatement st = con.prepareStatement(tsql);
			st.setInt(1, cliente.getDNI());
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) 
			{
				encontrado = true;
 	        }
			
			
		}catch(SQLException e1) 
		{
			System.out.println(e1.getSQLState());
			e1.printStackTrace();
		}
		
		return encontrado;
	}
	
	/***********************************************************************************/
	
	/**
	 * Método de comprobación de habitación con NUMHAB
	 * @param NumHab
	 * @return encontrado, si es true significa que hay una habitación con ese NUMHAB
	 */
	public boolean comprobarNumHab(String NumHab)
	{
		
		boolean encontrado = false;
		
		int numhab = Integer.parseInt(NumHab);
		
		Habitacion habitacion = new Habitacion(numhab);
		
		try
		{
			
			Connection con = DriverManager.getConnection(url, user_db, password);
			String tsql = "SELECT * FROM habitacion where NUMHAB = ?";
			PreparedStatement st = con.prepareStatement(tsql);
			st.setInt(1, habitacion.getNum());
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) 
			{
				encontrado = true;
 	        }
			
			
		}catch(SQLException e1) 
		{
			System.out.println(e1.getSQLState());
			e1.printStackTrace();
		}
		
		return encontrado;
	}
	
	/***********************************************************************************/
	
	/**
	 * Método de comprobación de servicio con CODSER
	 * @param CodSer
	 * @return encontrado, si es true significa que hay un servicio con ese CODSER
	 */
	public boolean comprobarCodSer(String CodSer)
	{
		
		boolean encontrado = false;
		
		int codser = Integer.parseInt(CodSer);
		
		Servicio servicio = new Servicio(codser);
		
		try
		{
			
			Connection con = DriverManager.getConnection(url, user_db, password);
			String tsql = "SELECT * FROM habitacion where NUMHAB = ?";
			PreparedStatement st = con.prepareStatement(tsql);
			st.setInt(1, servicio.getCodigo());
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) 
			{
				encontrado = true;
 	        }
			
			
		}catch(SQLException e1) 
		{
			System.out.println(e1.getSQLState());
			e1.printStackTrace();
		}
		
		return encontrado;
	}
}
