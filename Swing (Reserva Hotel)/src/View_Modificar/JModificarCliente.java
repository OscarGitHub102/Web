package View_Modificar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import Controller_Modificar.ModificarCliente;
import View_Admin.JControlador;
import Controller_Modificar.ComboBoxCliente;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JModificarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField dni;
	private JComboBox<String> campo;
	private JTextField antes;
	private JTextField despues;

	public JModificarCliente() {
		setBounds(100, 100, 358, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// Etiqueta DNI
		
		JLabel DNI = new JLabel("INTRODUZCA EL DNI DEL CLIENTE");
		DNI.setHorizontalAlignment(SwingConstants.LEFT);
		DNI.setBounds(41, 30, 318, 13);
		contentPanel.add(DNI);
		
		// TextField DNI
		
		dni = new JTextField();
		dni.setBounds(41, 53, 96, 19);
		contentPanel.add(dni);
		dni.setColumns(10);
		
		// Etiqueta de Seleccionar
		
		JLabel seleccionar = new JLabel("SELECCIONE EL CAMPO");
		seleccionar.setHorizontalAlignment(SwingConstants.LEFT);
		seleccionar.setBounds(41, 99, 174, 13);
		contentPanel.add(seleccionar);
		
		campo = new JComboBox();
		campo.setModel(new DefaultComboBoxModel(new String[] {" - ", "Nombre", "Apellido", "Teléfono", "Correo"}));
		ComboBoxCliente comboBox = new ComboBoxCliente(this);
		campo.addActionListener(comboBox); 
		campo.setBounds(202, 95, 89, 21);
		contentPanel.add(campo);
		
		// Etiqueta Antes
		
		JLabel campoAntes = new JLabel("ANTES");
		campoAntes.setHorizontalAlignment(SwingConstants.CENTER);
		campoAntes.setBounds(41, 140, 115, 13);
		contentPanel.add(campoAntes);
		
		// TextField Campo Antes
		
		antes = new JTextField();
		antes.setEditable(false);
		antes.setBounds(41, 163, 115, 19);
		contentPanel.add(antes);
		antes.setColumns(10);
		
		// Etiqueta Después
		
		JLabel campoDespues = new JLabel("DESPUÉS");
		campoDespues.setHorizontalAlignment(SwingConstants.CENTER);
		campoDespues.setBounds(195, 140, 96, 13);
		contentPanel.add(campoDespues);
		
		// TextField Campo Después
		
		despues = new JTextField();
		despues.setColumns(10);
		despues.setBounds(195, 163, 96, 19);
		contentPanel.add(despues);
		
		// Botón para modificar el cliente
		
		JButton modificar = new JButton("MODIFICAR");
		ModificarCliente modificarCliente = new ModificarCliente(this);
		modificar.addActionListener(modificarCliente); 
		modificar.setBounds(41, 203, 115, 37);
		contentPanel.add(modificar);
		
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
		vuelta.setBounds(195, 203, 96, 37);
		contentPanel.add(vuelta);
	}
	
	/**
	 * Método de escritura de un mensaje en el TextField "antes"
	 * @param mensj
	 */
	public void escribirMensaje(String mensj) 
	{
		antes.setText(mensj);
	}

	public JTextField getDni() {
		return dni;
	}

	public JComboBox<String> getCampo() {
		return campo;
	}

	public JTextField getDespues() {
		return despues;
	}
	
}