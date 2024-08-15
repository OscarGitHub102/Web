package View_Admin;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Admin.Registro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
public class JRegistro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDNI;
	private JPasswordField passwordFieldContra;
	private JTextField textFieldCorreo;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTel;
	
	public JRegistro() {
		
		setBounds(100, 100, 523, 360);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// Etiqueta Registrar
		
		JLabel lblReg = new JLabel("REGISTRAR");
		lblReg.setFont(new Font("Tahoma", Font.ITALIC, 23));
		lblReg.setHorizontalAlignment(SwingConstants.CENTER);
		lblReg.setBounds(167, 30, 190, 39);
		contentPanel.add(lblReg);
	
		// Etiqueta DNI
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(37, 110, 28, 20);
		contentPanel.add(lblDNI);
	
		// Textfield DNI
	
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(119, 110, 100, 20);
		contentPanel.add(textFieldDNI);
		textFieldDNI.setColumns(10);
	
		// Etiqueta Contraseña
	
		JLabel lblContra = new JLabel("Contraseña:");
		lblContra.setBounds(37, 156, 97, 20);
		contentPanel.add(lblContra);
		
		// PasswordField Contraseña
		
		passwordFieldContra = new JPasswordField();
		passwordFieldContra.setColumns(10);
		passwordFieldContra.setBounds(119, 156, 100, 20);
		contentPanel.add(passwordFieldContra);
		
		// Etiqueta Correo
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(37, 202, 60, 20);
		contentPanel.add(lblCorreo);
	
		// Textfield Correo
	
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(119, 202, 100, 20);
		contentPanel.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		// Etiqueta Nombre
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(279, 110, 67, 20);
		contentPanel.add(lblNombre);
	
		// Textfield Nombre
	
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(356, 110, 100, 20);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
	
		// Etiqueta Apellido
	
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(279, 156, 67, 20);
		contentPanel.add(lblApellido);
	
		// Textfield Apellido
	
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(356, 156, 100, 20);
		contentPanel.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		// Etiqueta Teléfono
		
		JLabel lblTel = new JLabel("Teléfono:");
		lblTel.setBounds(279, 202, 60, 20);
		contentPanel.add(lblTel);
	
		// Textfield Teléfono
	
		textFieldTel = new JTextField();
		textFieldTel.setBounds(356, 202, 100, 20);
		contentPanel.add(textFieldTel);
		textFieldTel.setColumns(10);
	
		// Botón para registrarse
	
		JButton Registro = new JButton("REGISTRAR");
		Registro reg = new Registro(this);
		Registro.addActionListener(reg);
		
		Registro.setBounds(98, 248, 121, 35);
		contentPanel.add(Registro);
	
		// Botón hacia JLogin
	
		JButton vuelta = new JButton("VOLVER");
		
		vuelta.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				JInicio jinicio = new JInicio();
				jinicio.setVisible(true);
				jinicio.setTitle("PAGINA PRINCIPAL");
				dispose();
			}
		});
		
		vuelta.setBounds(356, 248, 100, 35);
		contentPanel.add(vuelta);
		
	}

	public JTextField getTextFieldDNI() {
		return textFieldDNI;
	}

	public JPasswordField getPasswordFieldContra() {
		return passwordFieldContra;
	}

	public JTextField getTextFieldCorreo() {
		return textFieldCorreo;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public JTextField getTextFieldApellido() {
		return textFieldApellido;
	}

	public JTextField getTextFieldTel() {
		return textFieldTel;
	}
	
}