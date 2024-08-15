package View_Crear;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import Controller_Crear.CrearCliente;
import Controller_Crear.CrearHabitacion;
import View_Admin.JControlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class JCrearHabitacion extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField num;
    private JComboBox<String> tipo;
    private JTextArea desc;

    public JCrearHabitacion() {
    	
        setBounds(100, 100, 245, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        // Etiqueta Nº Habitación
        
        JLabel numeroHabitacion = new JLabel("Nº HABITACIÓN");
        numeroHabitacion.setBounds(22, 35, 117, 13);
        contentPanel.add(numeroHabitacion);
        
        // TextField Nº Habitación
        
        num = new JTextField();
        num.setBounds(133, 32, 77, 19);
        contentPanel.add(num);
        num.setColumns(10);

        // Etiqueta Tipo Habitación
        
        JLabel tipoHabitacion = new JLabel("TIPO");
        tipoHabitacion.setBounds(22, 83, 128, 13);
        contentPanel.add(tipoHabitacion);

        // JComboBox --> Tipo
        
        tipo = new JComboBox<String>();
        tipo.setModel(new DefaultComboBoxModel(new String[] {" - ", "Individual", "Matrimonio"}));
        tipo.setBounds(76, 79, 134, 21);
        contentPanel.add(tipo);
        
        // Etiqueta Descripción Habitación
        
        JLabel descripcionHabitacion = new JLabel("DESCRIPCIÓN");
        descripcionHabitacion.setBounds(22, 129, 86, 13);
        contentPanel.add(descripcionHabitacion);
        
        // JTextArea --> Descripción
        
        desc = new JTextArea();
        desc.setColumns(1);
        desc.setRows(3);
        desc.setBounds(22, 152, 188, 28);
        contentPanel.add(desc);
        
       // Botón para añadir la habitación
        
        JButton aniadirHabitacion = new JButton("CREAR");
        
        CrearHabitacion habitacion = new CrearHabitacion(this);
        aniadirHabitacion.addActionListener(habitacion);
		
        aniadirHabitacion.setBounds(23, 205, 85, 37);
        contentPanel.add(aniadirHabitacion);
        
        // Botón vuelta --> JControlador
        
        JButton vuelta = new JButton("VOLVER");
        vuelta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		JControlador con = new JControlador();
				con.setVisible(true);
				con.setTitle("MENÚ");
				dispose();
        	}
        });
        vuelta.setBounds(125, 205, 85, 37);
        contentPanel.add(vuelta);
        
    }
    
	public JTextField getNum() {
		return num;
	}

	public JComboBox<String> getTipo() {
		return tipo;
	}

	public JTextArea getDesc() {
		return desc;
	}
}