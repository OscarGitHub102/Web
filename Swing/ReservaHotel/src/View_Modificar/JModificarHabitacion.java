package View_Modificar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Modificar.ComboBoxCliente;
import Controller_Modificar.ComboBoxHabitacion;
import Controller_Modificar.ModificarHabitacion;
import View_Admin.JControlador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JModificarHabitacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField numHab;
	private JComboBox<String> campo;
	private JTextField antes;
	private JComboBox<String> tipo;
	private JTextField descripcion;

	public JModificarHabitacion() {
		setBounds(100, 100, 368, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel numhab = new JLabel("INTRODUZCA EL NÚMERO DE LA HABITACIÓN");
		numhab.setHorizontalAlignment(SwingConstants.LEFT);
		numhab.setBounds(41, 30, 318, 13);
		contentPanel.add(numhab);
		
		numHab = new JTextField();
		numHab.setColumns(10);
		numHab.setBounds(41, 53, 96, 19);
		contentPanel.add(numHab);
		
		JLabel seleccionar = new JLabel("SELECCIONE EL CAMPO");
		seleccionar.setHorizontalAlignment(SwingConstants.LEFT);
		seleccionar.setBounds(41, 99, 174, 13);
		contentPanel.add(seleccionar);
		
		// ComboBox que aparecerá si se quiere modificar el tipo de habitación
		
		tipo = new JComboBox();
		tipo.setModel(new DefaultComboBoxModel(new String[] {" - ", "Individual", "Matrimonio"}));
		tipo.setBounds(195, 163, 96, 19);
		contentPanel.add(tipo);
		tipo.setVisible(false);
		
		// TextField que aparecerá si se quiere modificar la descripción
		
		descripcion = new JTextField();
		descripcion.setColumns(10);
		descripcion.setBounds(195, 163, 96, 19);
		contentPanel.add(descripcion);
		descripcion.setVisible(false);
		
		campo = new JComboBox();
		campo.setModel(new DefaultComboBoxModel(new String[] {" - ", "Tipo", "Descripción"}));
		campo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
			
				String opcionSeleccionada = (String) campo.getSelectedItem();
				
				if(opcionSeleccionada.equals("Tipo"))
				{
					
					tipo.setVisible(true);
					descripcion.setVisible(false);
					
				}else if(opcionSeleccionada.equals("Descripción"))
				{
			
					descripcion.setVisible(true);
					tipo.setVisible(false);
			
				}

			}
			
		});
		ComboBoxHabitacion comboBox = new ComboBoxHabitacion(this);
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
		
		JButton modificar = new JButton("MODIFICAR");
		modificar.setBounds(41, 203, 115, 37);
		ModificarHabitacion modificarHabitacion = new ModificarHabitacion(this);
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
	
	public JTextField getNumHab() {
		return numHab;
	}

	public JComboBox<String> getCampo() {
		return campo;
	}

	public JComboBox<String> getTipo() {
		return tipo;
	}
	
	public JTextField getDescripcion() {
		return descripcion;
	}
	
}