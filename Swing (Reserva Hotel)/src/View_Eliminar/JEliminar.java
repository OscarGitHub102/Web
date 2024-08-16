package View_Eliminar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Eliminar.Eliminar;
import View_Admin.JControlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JEliminar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField CodRes;
	private JTextField dniCli;
	private JTextField idNuevo;
	private JLabel dni;
	private JLabel id;
	private boolean eliminado = false,cancel = false;

	public JEliminar() 
	{
		int resul = 0;
		resul = JOptionPane.showConfirmDialog(JEliminar.this, "¿Desea eliminar al cliente?", "Confirmar",JOptionPane.YES_NO_OPTION);
		switch(resul)
		{
			case 0: // JOptionPane.YES_OPTION
				eliminado = true;
                break;
            case 1: // JOptionPane.NO_OPTION
               eliminado = false;
                break;

            case JOptionPane.CLOSED_OPTION:
            	JOptionPane.showMessageDialog(JEliminar.this, "Debe marcar SI o NO", "ERROR",JOptionPane.ERROR_MESSAGE);
            	cancel = true;
                break;
			
		}
		if(cancel == false)
		{
			setBounds(100, 100, 380, 300);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Introduce el código de la reserva que desa eliminar");
			lblNewLabel.setBounds(30, 26, 290, 13);
			contentPanel.add(lblNewLabel);
		
			CodRes = new JTextField();
			CodRes.setBounds(40, 49, 78, 19);
			contentPanel.add(CodRes);
			CodRes.setColumns(10);
			
			JButton eliminar = new JButton("ELIMINAR");
			eliminar.setBounds(40, 202, 96, 26);
			Eliminar el = new Eliminar (this);
			eliminar.addActionListener(el);
			contentPanel.add(eliminar);
			
			
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
			vuelta.setBounds(220, 202, 96, 26);
			contentPanel.add(vuelta);
			
			dni = new JLabel("Introduzca el DNI del cliente a eliminar");
			dni.setBounds(30, 83, 220, 13);
			dni.setVisible(false);
			contentPanel.add(dni);
			
			dniCli = new JTextField();
			dniCli.setBounds(40, 106, 78, 19);
			contentPanel.add(dniCli);
			dniCli.setVisible(false);
			dniCli.setColumns(10);
			
			id = new JLabel("Introduzca ID (Usuario genérico: 1)");
			id.setBounds(30, 140, 200, 13);
			id.setVisible(false);
			contentPanel.add(id);
			
			idNuevo = new JTextField();
			idNuevo.setBounds(40, 163, 78, 19);
			contentPanel.add(idNuevo);
			idNuevo.setVisible(false);
			idNuevo.setColumns(10);
			
			if(eliminado == true)
			{
				dni.setVisible(true);
				dniCli.setVisible(true);
				id.setVisible(true);
				idNuevo.setVisible(true);
			}
		}
		else
		{
			JControlador con = new JControlador();
			con.setVisible(true);
			con.setTitle("MENÚ");
			dispose();
		}
	}
	public JTextField getCodRes() {
		return CodRes;
	}

	public JTextField getDniCli() {
		return dniCli;
	}

	public JTextField getIdNuevo() {
		return idNuevo;
	}

	public JLabel getDni() {
		return dni;
	}

	public JLabel getId() {
		return id;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	
}
