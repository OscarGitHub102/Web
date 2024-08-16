package View_Admin;

/**
 * Clase principal del proyecto "ReservaHotel"
 * @version 1.01
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;

public class JInicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInicio frame = new JInicio();
					frame.setTitle("PAGINA PRINCIPAL");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public JInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Botón de inicio de sesión
		
		JButton login = new JButton("INICIAR SESIÓN");
		login.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JLogin jlogin = new JLogin();
				jlogin.setVisible(true);
				jlogin.setTitle("INICIO DE SESIÓN");
				dispose();
			}
		});
		
		// Etiqueta de Título
		
		JLabel titulo = new JLabel("Hotel Barcardi");
		titulo.setBounds(73, 38, 220, 52);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(titulo);
		
		login.setBounds(108, 136, 150, 35);
		contentPane.add(login);
		
		// Botón de registro
		
		JButton registro = new JButton("REGISTRARSE");
		registro.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				JRegistro jregistro = new JRegistro();
				jregistro.setVisible(true);
				jregistro.setTitle("REGISTRO");
				dispose();
			}
		});
		
		registro.setBounds(108, 213, 150, 35);
		contentPane.add(registro);
		
	}
	
}