package View_Crear;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Crear.CrearHabitacion;
import Controller_Crear.CrearReserva;
import View_Admin.JControlador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.SwingConstants;

public class JCrearReserva extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField dniCli;
	private JTextField numHab;
	private JTextField codSer;
	private JTextField fechIn;
	private JTextField fechSal;
	private JTextField codRes;
	private JTextField PrecRes;

	public JCrearReserva() {
		setBounds(100, 100, 432, 266);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// Etiqueta DNI Cliente
		
		JLabel dniCliente = new JLabel("DNI CLIENTE");
		dniCliente.setHorizontalAlignment(SwingConstants.CENTER);
		dniCliente.setBounds(37, 28, 77, 13);
		contentPanel.add(dniCliente);
		
		// TextField DNI Cliente
		
		dniCli = new JTextField();
		dniCli.setBounds(37, 51, 77, 19);
		contentPanel.add(dniCli);
		dniCli.setColumns(10);
		
		// Etiqueta Nº Habitación
		
		JLabel numeroHabitacion = new JLabel("Nº HABITACIÓN");
		numeroHabitacion.setHorizontalAlignment(SwingConstants.CENTER);
		numeroHabitacion.setBounds(145, 28, 107, 13);
		contentPanel.add(numeroHabitacion);
		
		// TextField Nº Habitación
		
		numHab = new JTextField();
		numHab.setColumns(10);
		numHab.setBounds(145, 51, 107, 19);
		contentPanel.add(numHab);
		
		// Etiqueta Código Servicio
		
		JLabel codServicio = new JLabel("CÓDIGO SERVICIO");
		codServicio.setHorizontalAlignment(SwingConstants.CENTER);
		codServicio.setBounds(267, 28, 119, 13);
		contentPanel.add(codServicio);
		
		// TextField Código Servicio
		
		codSer = new JTextField();
		codSer.setColumns(10);
		codSer.setBounds(267, 51, 119, 19);
		contentPanel.add(codSer);
	
		// Etiqueta Fecha Ingreso
	
		JLabel fechaIngreso = new JLabel("INGRESO");
		fechaIngreso.setHorizontalAlignment(SwingConstants.CENTER);
		fechaIngreso.setBounds(27, 92, 101, 13);
		contentPanel.add(fechaIngreso);
		
		// TextField Fecha Ingreso
		
		fechIn = new JTextField();
		fechIn.setColumns(10);
		fechIn.setBounds(27, 115, 101, 19);
		contentPanel.add(fechIn);
		
		// Etiqueta Fecha Salida
	
		JLabel fechaSalida = new JLabel("SALIDA");
		fechaSalida.setHorizontalAlignment(SwingConstants.CENTER);
		fechaSalida.setBounds(145, 92, 107, 13);
		contentPanel.add(fechaSalida);
		
		// TextField Fecha Salida
		
		fechSal = new JTextField();
		fechSal.setColumns(10);
		fechSal.setBounds(145, 115, 107, 19);
		contentPanel.add(fechSal);
		
		// Etiqueta Código Reserva
		
		JLabel codigoReserva = new JLabel("CÓDIGO RESERVA");
		codigoReserva.setHorizontalAlignment(SwingConstants.CENTER);
		codigoReserva.setBounds(267, 92, 119, 13);
		contentPanel.add(codigoReserva);
		
		// TextField Código Reserva
		
		codRes = new JTextField();
		codRes.setColumns(10);
		codRes.setBounds(267, 115, 119, 19);
		contentPanel.add(codRes);
		
		// Botón para añadir la reserva
		
		JButton aniadirReserva = new JButton("CREAR");

		CrearReserva reserva = new CrearReserva(this);
		aniadirReserva.addActionListener(reserva);
		
		aniadirReserva.setBounds(142, 166, 110, 37);
		contentPanel.add(aniadirReserva);
		
		// Botón vuelta --> JControlador
		
		JButton vuelta = new JButton("VOLVER");
		vuelta.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				JControlador con = new JControlador();
				con.setVisible(true);
				con.setTitle("MENÚ");
				dispose();
			}
		});
		vuelta.setBounds(276, 166, 110, 37);
		contentPanel.add(vuelta);
		
		JLabel Prec = new JLabel("PRECIO");
		Prec.setHorizontalAlignment(SwingConstants.CENTER);
		Prec.setBounds(47, 161, 61, 13);
		contentPanel.add(Prec);
		
		PrecRes = new JTextField();
		PrecRes.setColumns(10);
		PrecRes.setBounds(47, 184, 61, 19);
		contentPanel.add(PrecRes);
		
	}

	public JTextField getDniCli() {
		return dniCli;
	}

	public JTextField getNumHab() {
		return numHab;
	}

	public JTextField getCodSer() {
		return codSer;
	}

	public JTextField getFechIn() {
		return fechIn;
	}

	public JTextField getFechSal() {
		return fechSal;
	}
	
	public JTextField getCodRes() {
		return codRes;
	}

	public void setCodRes(JTextField codRes) {
		this.codRes = codRes;
	}

	public JTextField getPrecRes() {
		return PrecRes;
	}
	
}