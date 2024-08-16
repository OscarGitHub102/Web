package View_Visualizar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Visualizar.VisualizarCliente;
import Controller_Visualizar.VisualizarHabitacion;
import View_Admin.JControlador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class JVisualizarHabitacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField NumHab;
	private JTextField VNumHab;
	private JTextField VTipo;
	private JTextField VDesc;

	public JVisualizarHabitacion() {
		setBounds(100, 100, 308, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel Numero = new JLabel("Introduce el número de la habitación");
			Numero.setBounds(29, 20, 293, 13);
			contentPanel.add(Numero);
		}
		{
			NumHab = new JTextField();
			NumHab.setBounds(29, 43, 96, 19);
			contentPanel.add(NumHab);
			NumHab.setColumns(10);
		}
		{
			JLabel numhab = new JLabel("Nº de habitación");
			numhab.setHorizontalAlignment(SwingConstants.CENTER);
			numhab.setBounds(29, 92, 114, 13);
			contentPanel.add(numhab);
		}
		{
			VNumHab = new JTextField();
			VNumHab.setEditable(false);
			VNumHab.setBounds(29, 115, 114, 19);
			contentPanel.add(VNumHab);
			VNumHab.setColumns(10);
		}
		{
			JLabel Tipo = new JLabel("Tipo");
			Tipo.setHorizontalAlignment(SwingConstants.CENTER);
			Tipo.setBounds(172, 92, 96, 13);
			contentPanel.add(Tipo);
		}
		{
			VTipo = new JTextField();
			VTipo.setEditable(false);
			VTipo.setBounds(172, 115, 96, 19);
			contentPanel.add(VTipo);
			VTipo.setColumns(10);
		}
		{
			JLabel Desc = new JLabel("Descripción");
			Desc.setHorizontalAlignment(SwingConstants.CENTER);
			Desc.setBounds(29, 155, 239, 13);
			contentPanel.add(Desc);
		}
		{
			VDesc = new JTextField();
			VDesc.setEditable(false);
			VDesc.setBounds(29, 173, 239, 19);
			contentPanel.add(VDesc);
			VDesc.setColumns(10);
		}
		{
			JButton Ver = new JButton("VISUALIZAR");
			Ver.setBounds(29, 210, 114, 31);
			VisualizarHabitacion VC = new VisualizarHabitacion(this);
			Ver.addActionListener(VC);
			contentPanel.add(Ver);
		}
		{
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
			vuelta.setBounds(163, 210, 105, 31);
			contentPanel.add(vuelta);
		}
	}

	public JTextField getNumHab() {
		return NumHab;
	}

	public void setVNumHab(String vNumHab) {
		VNumHab.setText(vNumHab); 
	}

	public void setVTipo(String vTipo) {
		VTipo.setText(vTipo); 
	}

	public void setVDesc(String vDesc) {
		VDesc.setText(vDesc); 
	}
	
}
