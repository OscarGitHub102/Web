package View_Visualizar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Visualizar.VisualizarCliente;
import Controller_Visualizar.VisualizarServicio;
import View_Admin.JControlador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class JVisualizarServicio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField CodSer;
	private JTextField VCodigo;
	private JTextField VNombre;
	private JTextField VPrecio;
	private JTextField VDesc;

	public JVisualizarServicio() {
		setBounds(100, 100, 420, 255);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel cod = new JLabel("Introduce el código del servicio");
			cod.setBounds(21, 20, 232, 13);
			contentPanel.add(cod);
		}
		{
			CodSer = new JTextField();
			CodSer.setBounds(21, 43, 96, 19);
			contentPanel.add(CodSer);
			CodSer.setColumns(10);
		}
		{
			JLabel codigo = new JLabel("Código");
			codigo.setHorizontalAlignment(SwingConstants.CENTER);
			codigo.setBounds(21, 80, 96, 13);
			contentPanel.add(codigo);
		}
		{
			VCodigo = new JTextField();
			VCodigo.setEditable(false);
			VCodigo.setBounds(21, 103, 96, 19);
			contentPanel.add(VCodigo);
			VCodigo.setColumns(10);
		}
		{
			JLabel Nombre = new JLabel("Nombre");
			Nombre.setHorizontalAlignment(SwingConstants.CENTER);
			Nombre.setBounds(139, 80, 126, 13);
			contentPanel.add(Nombre);
		}
		{
			VNombre = new JTextField();
			VNombre.setEditable(false);
			VNombre.setBounds(139, 103, 126, 19);
			contentPanel.add(VNombre);
			VNombre.setColumns(10);
		}
		{
			JLabel Precio = new JLabel("Precio");
			Precio.setHorizontalAlignment(SwingConstants.CENTER);
			Precio.setBounds(285, 80, 96, 13);
			contentPanel.add(Precio);
		}
		{
			VPrecio = new JTextField();
			VPrecio.setEditable(false);
			VPrecio.setBounds(285, 103, 96, 19);
			contentPanel.add(VPrecio);
			VPrecio.setColumns(10);
		}
		{
			JLabel Descripcion = new JLabel("Descripción");
			Descripcion.setHorizontalAlignment(SwingConstants.CENTER);
			Descripcion.setBounds(21, 144, 146, 13);
			contentPanel.add(Descripcion);
		}
		{
			VDesc = new JTextField();
			VDesc.setEditable(false);
			VDesc.setBounds(21, 167, 146, 19);
			contentPanel.add(VDesc);
			VDesc.setColumns(10);
		}
		{
			JButton Ver = new JButton("VISUALIZAR");
			Ver.setBounds(186, 156, 102, 30);
			VisualizarServicio Vs = new VisualizarServicio(this);
			Ver.addActionListener(Vs);
			contentPanel.add(Ver);
		}
		{
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
			Vuelta.setBounds(296, 156, 85, 30);
			contentPanel.add(Vuelta);
		}
	}

	public JTextField getCodSer() {
		return CodSer;
	}

	public void setVCodigo(String vCodigo) {
		VCodigo.setText(vCodigo);
	}

	public void setVNombre(String vNombre) {
		VNombre.setText(vNombre); 
	}

	public void setVPrecio(String vPrecio) {
		VPrecio.setText(vPrecio);
	}

	public void setVDesc(String vDesc) {
		VDesc.setText(vDesc); 
	}
	
}
