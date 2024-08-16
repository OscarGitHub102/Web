package View_Crear;

import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller_Admin.Registro;
import Controller_Crear.CrearCliente;
import View_Admin.JControlador;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCrearCliente extends JDialog
{
	private final JPanel contentPanel = new JPanel();
	private JTextField dni;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField telefono;
	private JTextField correo;

	public JCrearCliente() {
		
		setBounds(100, 100, 335, 322);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// Etiqueta DNI
		
		JLabel DNI = new JLabel("DNI");
		DNI.setBounds(36, 31, 92, 26);
		DNI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DNI.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(DNI);
		
		// Textfield DNI
		
		dni = new JTextField();
		dni.setBounds(36, 62, 96, 19);
		contentPanel.add(dni);
		dni.setColumns(10);
		
		// Etiqueta Nombre
		
		JLabel NOMBRE = new JLabel("NOMBRE");
		NOMBRE.setBounds(36, 105, 92, 26);
		NOMBRE.setHorizontalAlignment(SwingConstants.CENTER);
		NOMBRE.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(NOMBRE);
		
		// Textfield Nombre
		
		nombre = new JTextField();
		nombre.setBounds(36, 137, 96, 19);
		nombre.setColumns(10);
		contentPanel.add(nombre);
		
		// Etiqueta Apellido
		
		JLabel APELLIDO = new JLabel("APELLIDO");
		APELLIDO.setBounds(36, 187, 92, 26);
		APELLIDO.setHorizontalAlignment(SwingConstants.CENTER);
		APELLIDO.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(APELLIDO);
		
		// Textfield Apellido
		
		apellido = new JTextField();
		apellido.setBounds(36, 223, 96, 19);
		apellido.setColumns(10);
		contentPanel.add(apellido);
		
		// Etiqueta Teléfono
		
		JLabel TELEFONO = new JLabel("TELÉFONO");
		TELEFONO.setBounds(183, 31, 96, 26);
		TELEFONO.setHorizontalAlignment(SwingConstants.CENTER);
		TELEFONO.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(TELEFONO);
		
		// Textfield Teléfono
		
		telefono = new JTextField();
		telefono.setBounds(183, 62, 96, 19);
		telefono.setColumns(10);
		contentPanel.add(telefono);
		
		// Etiqueta Correo
		
		JLabel CORREO = new JLabel("CORREO");
		CORREO.setBounds(183, 105, 96, 26);
		CORREO.setHorizontalAlignment(SwingConstants.CENTER);
		CORREO.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(CORREO);
		
		// Textfield Correo
		
		correo = new JTextField();
		correo.setBounds(183, 137, 96, 19);
		correo.setColumns(10);
		contentPanel.add(correo);
		
		// Botón para añadir al cliente
		
		JButton aniadirCliente = new JButton("CREAR");
		
		CrearCliente cliente = new CrearCliente(this);
		aniadirCliente.addActionListener(cliente);
		
		aniadirCliente.setBounds(183, 191, 96, 26);
		contentPanel.add(aniadirCliente);
		
		// Botón vuelta --> JControlador
		
		JButton vuelta = new JButton("VOLVER");
		vuelta.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JControlador con = new JControlador();
				con.setVisible(true);
				dispose();
			}
		});
		vuelta.setBounds(183, 229, 96, 26);
		contentPanel.add(vuelta);
		
	}

	public JTextField getDni() {
		return dni;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public JTextField getApellido() {
		return apellido;
	}

	public JTextField getTelefono() {
		return telefono;
	}

	public JTextField getCorreo() {
		return correo;
	}

	
}