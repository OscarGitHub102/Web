package View_Visualizar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Visualizar.VisualizarCliente;
import View_Admin.JControlador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class JVisualizarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField DniCli;
	private JTextField VNombre;
	private JTextField VApellido;
	private JTextField VTelefono;
	private JTextField VCorreo;
	private JTextField VDNI;

	public JVisualizarCliente() {
		setBounds(100, 100, 450, 317);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel dnicli = new JLabel("Introduce el DNI del cliente a visualizar");
		dnicli.setBounds(23, 22, 234, 13);
		contentPanel.add(dnicli);
		
		DniCli = new JTextField();
		DniCli.setBounds(23, 45, 96, 19);
		contentPanel.add(DniCli);
		DniCli.setColumns(10);
		
		JLabel nombre = new JLabel("Nombre");
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setBounds(150, 85, 96, 13);
		contentPanel.add(nombre);
		
		VNombre = new JTextField();
		VNombre.setEditable(false);
		VNombre.setBounds(150, 108, 96, 19);
		contentPanel.add(VNombre);
		VNombre.setColumns(10);
		
		JLabel Apellido = new JLabel("Apellido");
		Apellido.setHorizontalAlignment(SwingConstants.CENTER);
		Apellido.setBounds(272, 85, 96, 13);
		contentPanel.add(Apellido);
		
		VApellido = new JTextField();
		VApellido.setEditable(false);
		VApellido.setBounds(272, 108, 96, 19);
		contentPanel.add(VApellido);
		VApellido.setColumns(10);
		
		JLabel Telefono = new JLabel("Teléfono");
		Telefono.setHorizontalAlignment(SwingConstants.CENTER);
		Telefono.setBounds(23, 157, 96, 13);
		contentPanel.add(Telefono);
		
		VTelefono = new JTextField();
		VTelefono.setEditable(false);
		VTelefono.setBounds(23, 180, 106, 19);
		contentPanel.add(VTelefono);
		VTelefono.setColumns(10);
		
		JLabel Correo = new JLabel("Correo");
		Correo.setHorizontalAlignment(SwingConstants.CENTER);
		Correo.setBounds(150, 157, 96, 13);
		contentPanel.add(Correo);
		
		VCorreo = new JTextField();
		VCorreo.setEditable(false);
		VCorreo.setBounds(150, 180, 96, 19);
		contentPanel.add(VCorreo);
		VCorreo.setColumns(10);
		
		JButton Ver = new JButton("VISUALIZAR");
		VisualizarCliente VC = new VisualizarCliente(this);
		Ver.addActionListener(VC);
		Ver.setBounds(23, 224, 106, 31);
		contentPanel.add(Ver);
		
		JButton Vuelta = new JButton("VOLVER");
		Vuelta.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JControlador con = new JControlador();
				con.setVisible(true);
				con.setTitle("MENÚ");
				dispose();
			}
		});
		Vuelta.setBounds(150, 223, 96, 32);
		contentPanel.add(Vuelta);
		
		JLabel dni = new JLabel("DNI");
		dni.setHorizontalAlignment(SwingConstants.CENTER);
		dni.setBounds(23, 85, 106, 13);
		contentPanel.add(dni);
		
		VDNI = new JTextField();
		VDNI.setEditable(false);
		VDNI.setBounds(23, 108, 106, 19);
		contentPanel.add(VDNI);
		VDNI.setColumns(10);
	}

	public JTextField getDniCli() {
		return DniCli;
	}
	public void setVDNI(String vDNI) {
		VDNI.setText(vDNI); 
	}
	public void setVNombre(String vNombre) {
		VNombre.setText(vNombre); 
	}

	public void setVApellido(String vApellido) {
		VApellido.setText(vApellido);
	}

	public void setVTelefono(String vTelefono) {
		VTelefono.setText(vTelefono);
	}

	public void setVCorreo(String vCorreo) {
		VCorreo.setText(vCorreo); 
	}
	
}
