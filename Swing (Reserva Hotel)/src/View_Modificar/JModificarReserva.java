package View_Modificar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Controller_Modificar.ComboBoxReserva;
import Controller_Modificar.ModificarReserva;
import View_Admin.JControlador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JModificarReserva extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTextField CodRes;
	private JComboBox<String> campo;
	private JTextField antes;
	private JComboBox<String> estado;
	private JTextField resto;

	public JModificarReserva() {
		setBounds(100, 100, 382, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel codser = new JLabel("INTRODUZCA EL CÓDIDO DE LA RESERVA");
		codser.setHorizontalAlignment(SwingConstants.LEFT);
		codser.setBounds(41, 30, 318, 13);
		contentPanel.add(codser);
		
		CodRes = new JTextField();
		CodRes.setColumns(10);
		CodRes.setBounds(41, 53, 96, 19);
		contentPanel.add(CodRes);
		
		JLabel seleccionar = new JLabel("SELECCIONE EL CAMPO");
		seleccionar.setHorizontalAlignment(SwingConstants.LEFT);
		seleccionar.setBounds(41, 99, 174, 13);
		contentPanel.add(seleccionar);
		
		// ComboBox que aparecerá si se quiere modificar el tipo de habitación
		
		estado = new JComboBox();
		estado.setModel(new DefaultComboBoxModel(new String[] {" - ", "Activo", "Inactivo","Desactivado"}));
		estado.setBounds(195, 163, 96, 19);
		contentPanel.add(estado);
		estado.setVisible(false);
		
		// TextField que aparecerá si se quiere modificar la descripción
		
		resto = new JTextField();
		resto.setColumns(10);
		resto.setBounds(195, 163, 96, 19);
		contentPanel.add(resto);
		resto.setVisible(false);
		
		campo = new JComboBox();
		campo.setModel(new DefaultComboBoxModel(new String[] {" - ", "Fecha de entrada", "Fecha de salida", "Estado", "Precio"}));
		campo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
			
				String opcionSeleccionada = (String) campo.getSelectedItem();
				
				if(opcionSeleccionada.equals("Estado"))
				{
					
					estado.setVisible(true);
					resto.setVisible(false);
					
				}else if(opcionSeleccionada.equals("Fecha de entrada") || opcionSeleccionada.equalsIgnoreCase("Fecha de salida"))
				{
			
					resto.setVisible(true);
					estado.setVisible(false);
			
				}

			}
			
		});
		ComboBoxReserva comboBox = new ComboBoxReserva(this);
		campo.addActionListener(comboBox); 
		campo.setBounds(202, 95, 130, 21);
		contentPanel.add(campo);
		
		JLabel campoAntes = new JLabel("ANTES");
		campoAntes.setHorizontalAlignment(SwingConstants.CENTER);
		campoAntes.setBounds(41, 140, 115, 13);
		contentPanel.add(campoAntes);
		
		antes = new JTextField();
		antes.setEditable(false);
		antes.setColumns(10);
		antes.setBounds(41, 163, 115, 19);
		contentPanel.add(antes);
		
		JButton modificar = new JButton("MODIFICAR");
		modificar.setBounds(41, 203, 115, 37);
		ModificarReserva modificarHabitacion = new ModificarReserva(this);
		modificar.addActionListener(modificarHabitacion);
		contentPanel.add(modificar);
		
		JLabel campoDespues = new JLabel("DESPUÉS");
		campoDespues.setHorizontalAlignment(SwingConstants.CENTER);
		campoDespues.setBounds(195, 140, 96, 13);
		contentPanel.add(campoDespues);
		
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

	public JTextField getCodres() {
		return CodRes;
	}

	public JComboBox<String> getCampo() {
		return campo;
	}

	public JComboBox<String> getEstado() {
		return estado;
	}
	
	public JTextField getResto() {
		return resto;
	}
	
}