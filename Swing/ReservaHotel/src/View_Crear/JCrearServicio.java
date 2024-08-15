package View_Crear;

import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller_Admin.Registro;
import Controller_Crear.CrearCliente;
import Controller_Crear.CrearServicio;
import View_Admin.JControlador;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class JCrearServicio extends JDialog
{
	private final JPanel contentPanel = new JPanel();
	private JTextField codigo;
	private JTextField nombre;
	private JTextField precio;
	private JTextArea descripcion;

	public JCrearServicio() {
		
		setBounds(100, 100, 391, 273);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// Etiqueta Código
		
		JLabel cod = new JLabel("CÓDIGO");
		cod.setHorizontalAlignment(SwingConstants.CENTER);
		cod.setBounds(27, 24, 85, 13);
		contentPanel.add(cod);
		
		// TextField Código
		
		codigo = new JTextField();
		codigo.setColumns(10);
		codigo.setBounds(25, 54, 96, 19);
		contentPanel.add(codigo);
		
		// Etiqueta Nombre
		
		JLabel nom = new JLabel("NOMBRE");
		nom.setHorizontalAlignment(SwingConstants.CENTER);
		nom.setBounds(143, 24, 96, 13);
		contentPanel.add(nom);
		
		// TextField Nombre
		
		nombre = new JTextField();
		nombre.setBounds(143, 54, 96, 19);
		contentPanel.add(nombre);
		nombre.setColumns(10);
		
		// Etiqueta Precio
		
		JLabel prec = new JLabel("PRECIO");
		prec.setHorizontalAlignment(SwingConstants.CENTER);
		prec.setBounds(260, 24, 96, 13);
		contentPanel.add(prec);
		
		// TextField Precio
		
		precio = new JTextField();
		precio.setColumns(10);
		precio.setBounds(260, 54, 96, 19);
		contentPanel.add(precio);
		
		// Etiqueta Descripción
		
		JLabel desc = new JLabel("DESCRIPCIÓN");
		desc.setBounds(27, 98, 103, 13);
		contentPanel.add(desc);
		
		// TextArea Descripción
		
		descripcion = new JTextArea();
		descripcion.setColumns(1);
		descripcion.setRows(3);
		descripcion.setBounds(27, 128, 329, 37);
		contentPanel.add(descripcion);
		
		// Botón para añadir el servicio
		
		JButton aniadirServicio = new JButton("CREAR");
		
		CrearServicio servicio = new CrearServicio(this);
		aniadirServicio.addActionListener(servicio);
		
		aniadirServicio.setBounds(25, 182, 100, 37);
		contentPanel.add(aniadirServicio);
		
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
		vuelta.setBounds(256, 182, 100, 37);
		contentPanel.add(vuelta);
		
	}

	public JTextField getCodigo() {
		return codigo;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public JTextField getPrecio() {
		return precio;
	}

	public JTextArea getDescripcion() {
		return descripcion;
	}
}