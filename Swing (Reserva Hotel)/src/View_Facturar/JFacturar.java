package View_Facturar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Facturar.Facturar;
import View_Admin.JControlador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFacturar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField CodRes;

	public JFacturar() {
		setBounds(100, 100, 267, 176);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel codres = new JLabel("Introduce el código de la reserva");
		codres.setBounds(23, 25, 208, 13);
		contentPanel.add(codres);
		
		CodRes = new JTextField();
		CodRes.setBounds(23, 53, 197, 19);
		contentPanel.add(CodRes);
		CodRes.setColumns(10);
		
		JButton Facturar = new JButton("FACTURAR");
		Facturar factura = new Facturar(this);
		Facturar.addActionListener(factura);
		Facturar.setBounds(23, 82, 103, 30);
		contentPanel.add(Facturar);
		
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
		Vuelta.setBounds(136, 82, 84, 30);
		contentPanel.add(Vuelta);
	}

	public JTextField getCodRes() {
		return CodRes;
	}
	
}