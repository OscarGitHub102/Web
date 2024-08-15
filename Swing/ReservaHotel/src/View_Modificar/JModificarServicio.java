package View_Modificar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller_Modificar.ComboBoxCliente;
import Controller_Modificar.ComboBoxServicio;
import Controller_Modificar.ModificarCliente;
import Controller_Modificar.ModificarServicio;
import View_Admin.JControlador;

public class JModificarServicio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField codigo;
	private JComboBox<String> campo;
	private JTextField antes;
	private JTextField despues;

	public JModificarServicio() {
		setBounds(100, 100, 356, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// Etiqueta Código Servicio
		
		JLabel codigoServicio = new JLabel("INTRODUZCA EL CÓDIGO DEL SERVICIO");
		codigoServicio.setHorizontalAlignment(SwingConstants.LEFT);
		codigoServicio.setBounds(41, 30, 318, 13);
		contentPanel.add(codigoServicio);
		
		// TextField Código Servicio
		
		codigo = new JTextField();
		codigo.setBounds(41, 53, 96, 19);
		contentPanel.add(codigo);
		codigo.setColumns(10);
		
		// Etiqueta de Seleccionar
		
		JLabel seleccionar = new JLabel("SELECCIONE EL CAMPO");
		seleccionar.setHorizontalAlignment(SwingConstants.LEFT);
		seleccionar.setBounds(41, 99, 174, 13);
		contentPanel.add(seleccionar);
		
		campo = new JComboBox();
		campo.setModel(new DefaultComboBoxModel(new String[] {" - ", "Nombre", "Precio", "Descripción"}));
		ComboBoxServicio comboBox = new ComboBoxServicio(this);
		campo.addActionListener(comboBox); 
		campo.setBounds(202, 95, 100, 21);
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
		ModificarServicio modificarServicio = new ModificarServicio(this);
		modificar.addActionListener(modificarServicio); 
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

	public JTextField getDespues() {
		return despues;
	}

	public JComboBox<String> getCampo() {
		return campo;
	}

	public JTextField getCodigo() {
		return codigo;
	}
	
}