package View_Visualizar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Visualizar.VisualizarCliente;
import Controller_Visualizar.VisualizarReserva;
import View_Admin.JControlador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class JVisualizarReserva extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField CodRes;
	private JTextField VCodRes;
	private JTextField VDNI;
	private JTextField VCodSer;
	private JTextField VnumHab;
	private JTextField VFechSal;
	private JTextField VFechIn;
	private JTextField VEstado;
	private JTextField VPrec;

	public JVisualizarReserva() {
		setBounds(100, 100, 450, 318);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel codres = new JLabel("Introduce el código de la reserva");
			codres.setBounds(22, 10, 270, 13);
			contentPanel.add(codres);
		}
		{
			CodRes = new JTextField();
			CodRes.setBounds(22, 33, 96, 19);
			contentPanel.add(CodRes);
			CodRes.setColumns(10);
		}
		{
			JLabel codigo = new JLabel("Código de la reserva");
			codigo.setBounds(22, 62, 119, 13);
			codigo.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(codigo);
		}
		{
			VCodRes = new JTextField();
			VCodRes.setBounds(22, 85, 119, 19);
			VCodRes.setEditable(false);
			contentPanel.add(VCodRes);
			VCodRes.setColumns(10);
		}
		{
			VDNI = new JTextField();
			VDNI.setBounds(162, 85, 96, 19);
			VDNI.setEditable(false);
			contentPanel.add(VDNI);
			VDNI.setColumns(10);
		}
		{
			JLabel dni = new JLabel("DNI Cliente");
			dni.setBounds(162, 62, 96, 13);
			dni.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(dni);
		}
		{
			JLabel codser = new JLabel("Código del servicio");
			codser.setBounds(285, 62, 119, 13);
			codser.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(codser);
		}
		{
			VCodSer = new JTextField();
			VCodSer.setBounds(285, 85, 119, 19);
			VCodSer.setEditable(false);
			contentPanel.add(VCodSer);
			VCodSer.setColumns(10);
		}
		{
			JLabel numHab = new JLabel("Nº de habitación");
			numHab.setBounds(22, 114, 119, 13);
			numHab.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(numHab);
		}
		{
			VnumHab = new JTextField();
			VnumHab.setBounds(22, 137, 119, 19);
			VnumHab.setEditable(false);
			contentPanel.add(VnumHab);
			VnumHab.setColumns(10);
		}
		{
			JLabel fechasal = new JLabel("Fecha de salida");
			fechasal.setBounds(157, 172, 119, 13);
			fechasal.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(fechasal);
		}
		{
			VFechSal = new JTextField();
			VFechSal.setBounds(157, 195, 119, 19);
			VFechSal.setEditable(false);
			contentPanel.add(VFechSal);
			VFechSal.setColumns(10);
		}
		{
			JLabel fecha = new JLabel("Fecha de entrada");
			fecha.setBounds(22, 173, 120, 13);
			fecha.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(fecha);
		}
		{
			VFechIn = new JTextField();
			VFechIn.setBounds(22, 195, 121, 19);
			VFechIn.setEditable(false);
			contentPanel.add(VFechIn);
			VFechIn.setColumns(10);
		}
		{
			JLabel est = new JLabel("Estado");
			est.setBounds(285, 114, 119, 13);
			est.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(est);
		}
		{
			VEstado = new JTextField();
			VEstado.setBounds(285, 137, 119, 19);
			VEstado.setEditable(false);
			contentPanel.add(VEstado);
			VEstado.setColumns(10);
		}
		{
			JButton Ver = new JButton("VISUALIZAR");
			Ver.setBounds(294, 179, 106, 33);
			VisualizarReserva VC = new VisualizarReserva(this);
			Ver.addActionListener(VC);
			contentPanel.add(Ver);
		}
		{
			JLabel prec = new JLabel("Precio");
			prec.setBounds(162, 114, 96, 13);
			prec.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(prec);
		}
		{
			VPrec = new JTextField();
			VPrec.setBounds(162, 137, 96, 19);
			VPrec.setEditable(false);
			contentPanel.add(VPrec);
			VPrec.setColumns(10);
		}
		
		{
			JButton vuelta = new JButton("VOLVER");
			vuelta.setBounds(21, 229, 106, 33);
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
			contentPanel.add(vuelta);
		}
		
	}

	public JTextField getCodRes() {
		return CodRes;
	}

	public void setVCodRes(String vCodRes) {
		VCodRes.setText(vCodRes);
	}

	public void setVDNI(String vDNI) {
		VDNI.setText(vDNI);
	}

	public void setVCodSer(String vCodSer) {
		VCodSer.setText(vCodSer);
	}

	public void setVnumHab(String vnumHab) {
		VnumHab.setText(vnumHab);
	}

	public void setVFechSal(String vFechSal) {
		VFechSal.setText(vFechSal);
	}

	public void setVFechIn(String vFechIn) {
		VFechIn.setText(vFechIn);
	}

	public void setVEstado(String vEstado) {
		VEstado.setText(vEstado);
	}

	public void setVPrec(String vPrec) {
		VPrec.setText(vPrec + " €");
	}
	
	
	
	
}
