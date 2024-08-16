package View_Admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Admin.Login;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;

public class JLogin extends JDialog {

	private JPanel contentPanel;
	private JTextField tfDNI;
	private JPasswordField pFContra;
	
	public JLogin() {
		
		setBounds(100, 100, 276, 334);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));	
		
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
	
		// Etiqueta Iniciar Sesión
		
		JLabel lblIS = new JLabel("INICIAR SESIÓN");
		lblIS.setFont(new Font("Tahoma", Font.ITALIC, 23));
		lblIS.setHorizontalAlignment(SwingConstants.CENTER);
		lblIS.setBounds(33, 22, 190, 39);
		contentPanel.add(lblIS);
		
		// Etiqueta DNI
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(33, 102, 28, 20);
		contentPanel.add(lblDNI);
		
		// Textfield DNI
		
		tfDNI = new JTextField();
		tfDNI.setBounds(126, 102, 100, 20);
		contentPanel.add(tfDNI);
		tfDNI.setColumns(10);
		
		// Etiqueta Contraseña
		
		JLabel lblContra = new JLabel("Contraseña:");
		lblContra.setBounds(33, 148, 83, 20);
		contentPanel.add(lblContra);
		
		// PasswordField Contraseña
		
		pFContra = new JPasswordField();
		pFContra.setColumns(10);
		pFContra.setBounds(126, 148, 100, 20);
		contentPanel.add(pFContra);
		
		// Botón para iniciar sesón
		
		JButton login = new JButton("INICIAR SESIÓN");
		Login log = new Login(this);				// crear un objeto Login para comparar datos en la BBDD
		login.addActionListener(log);				// comparar datos en la BBDD
		login.setBounds(53, 194, 151, 35);
		contentPanel.add(login);
		
		// Botón de vuelta a JInicio
		
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
		
		vuelta.setBounds(78, 239, 100, 35);
		contentPanel.add(vuelta);
		
	}

	public JTextField getTfDNI() {
		return tfDNI;
	}

	public JPasswordField getpFContra() {
		return pFContra;
	}

}