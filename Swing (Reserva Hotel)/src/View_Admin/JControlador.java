package View_Admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import View_Crear.JCrearCliente;
import View_Crear.JCrearHabitacion;
import View_Crear.JCrearReserva;
import View_Crear.JCrearServicio;
import View_Eliminar.JEliminar;
import View_Facturar.JFacturar;
import View_Modificar.JModificarCliente;
import View_Modificar.JModificarHabitacion;
import View_Modificar.JModificarReserva;
import View_Modificar.JModificarServicio;
import View_Visualizar.JVisualizarCliente;
import View_Visualizar.JVisualizarHabitacion;
import View_Visualizar.JVisualizarReserva;
import View_Visualizar.JVisualizarServicio;

public class JControlador extends JDialog {
	
    private final JPanel contentPanel = new JPanel();

    public JControlador() {
        setBounds(100, 100, 322, 262);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        // Crear el JTabbedPane
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPanel.add(tabbedPane, BorderLayout.CENTER);
        
        ////////////////////////////////////////////////////////////////////////

        // Panel de CREAR
        
        JPanel panelCrear = new JPanel();
        tabbedPane.addTab("CREAR", null, panelCrear, null);
        panelCrear.setLayout(null);
        
        // Crear Cliente

        JButton btnCrearCliente = new JButton("CLIENTE");
        btnCrearCliente.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		JCrearCliente nuevoCliente = new JCrearCliente();
        		nuevoCliente.setVisible(true);
        		nuevoCliente.setTitle("NUEVO CLIENTE");
        		dispose();
        	}
        });
        btnCrearCliente.setBounds(10, 10, 125, 30);
        panelCrear.add(btnCrearCliente);

        // Crear Habitación
        
        JButton btnCrearHabitacion = new JButton("HABITACIÓN");
        btnCrearHabitacion.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		JCrearHabitacion nuevaHabitacion = new JCrearHabitacion();
        		nuevaHabitacion.setVisible(true);
        		nuevaHabitacion.setTitle("NUEVA HABITACIÓN");
        		dispose();
        	}
        });
        btnCrearHabitacion.setBounds(10, 50, 125, 30);
        panelCrear.add(btnCrearHabitacion);
        
        // Crear Servicio

        JButton btnCrearServicio = new JButton("SERVICIO");
        btnCrearServicio.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		JCrearServicio nuevoServicio = new JCrearServicio();
        		nuevoServicio.setVisible(true);
        		nuevoServicio.setTitle("NUEVO SERVICIO");
        		dispose();
        	}
        });
        btnCrearServicio.setBounds(10, 90, 125, 30);
        panelCrear.add(btnCrearServicio);
        
        // Crear Reserva

        JButton btnCrearReserva = new JButton("RESERVA");
        
        btnCrearReserva.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		JCrearReserva nuevaReserva = new JCrearReserva();
        		nuevaReserva.setVisible(true);
        		nuevaReserva.setTitle("NUEVA RESERVA");
        		dispose();
        	}
        });
        btnCrearReserva.setBounds(10, 130, 125, 30);
        panelCrear.add(btnCrearReserva);
        
        // Botón vuelta --> JInicio
        
        JButton vueltaCrear = new JButton("VOLVER");
        vueltaCrear.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		JInicio inicio = new JInicio();
        		inicio.setVisible(true);
        		inicio.setTitle("INICIO DE SESIÓN");
        		dispose();
        	}
        });
        vueltaCrear.setBounds(190, 130, 85, 30);
        panelCrear.add(vueltaCrear);
        
        ////////////////////////////////////////////////////////////////////////
        
        // Panel de MODIFICAR

        JPanel panelModificar = new JPanel();
        tabbedPane.addTab("MODIFICAR", null, panelModificar, null);
        panelModificar.setLayout(null);
        
        // Modificar Cliente

        JButton btnModificarCliente = new JButton("CLIENTE");
        btnModificarCliente.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		
        		JModificarCliente modificacionCliente = new JModificarCliente();
        		modificacionCliente.setVisible(true);
        		modificacionCliente.setTitle("MODIFICAR CLIENTE");
        		dispose();
        		
        	}
        });
        btnModificarCliente.setBounds(10, 10, 125, 30);
        panelModificar.add(btnModificarCliente);
        
        // Modificar Habitación

        JButton btnModificarHabitacion = new JButton("HABITACIÓN");
        btnModificarHabitacion.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		JModificarHabitacion modificacionHabitacion = new JModificarHabitacion();
        		modificacionHabitacion.setVisible(true);
        		modificacionHabitacion.setTitle("MODIFICAR HABITACIÓN");
        		dispose();
        	}
        });
        btnModificarHabitacion.setBounds(10, 50, 125, 30);
        panelModificar.add(btnModificarHabitacion);
        
        // Modificar Servicio

        JButton btnModificarServicio = new JButton("SERVICIO");
        btnModificarServicio.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		JModificarServicio modificacionServicio = new JModificarServicio();
        		modificacionServicio.setVisible(true);
        		modificacionServicio.setTitle("MODIFICAR SERVICIO");
        		dispose();
        	}
        });
        btnModificarServicio.setBounds(10, 90, 125, 30);
        panelModificar.add(btnModificarServicio);

        // Modificar Reserva
        
        JButton btnModificarReserva = new JButton("RESERVA");
        btnModificarReserva.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		JModificarReserva modificacionReserva = new JModificarReserva();
        		modificacionReserva.setVisible(true);
        		modificacionReserva.setTitle("MODIFICAR RESERVA");
        		dispose();
        	}
        });
        btnModificarReserva.setBounds(10, 130, 125, 30);
        panelModificar.add(btnModificarReserva);
        
        // Botón vuelta --> JInicio
        
        JButton vueltaModificar = new JButton("VOLVER");
        
        vueltaModificar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JInicio inicio = new JInicio();
        		inicio.setVisible(true);
        		inicio.setTitle("INICIO DE SESIÓN");
        		dispose();
			}
		});
        
        vueltaModificar.setBounds(190, 130, 85, 30);
        panelModificar.add(vueltaModificar);
        
        ////////////////////////////////////////////////////////////////////////
      
        // Panel de ELIMINAR
        
        JPanel panelEliminar = new JPanel();
        tabbedPane.addTab("ELIMINAR", null, panelEliminar, null);
        panelEliminar.setLayout(null);
        
        // Eliminar Reserva

        JButton btnEliminar = new JButton("RESERVA");
        btnEliminar.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		JEliminar eliminar = new JEliminar();
        		eliminar.setVisible(true);
        		eliminar.setTitle("ELIMINAR RESERVA");
        		dispose();
        	}
        });
        btnEliminar.setBounds(10, 10, 125, 30);
        panelEliminar.add(btnEliminar);
        
        // Botón vuelta --> JInicio
        
        JButton vueltaEliminar = new JButton("VOLVER");
        vueltaEliminar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JInicio inicio = new JInicio();
        		inicio.setVisible(true);
        		inicio.setTitle("INICIO DE SESIÓN");
        		dispose();
			}
		});
        vueltaEliminar.setBounds(190, 130, 85, 30);
        panelEliminar.add(vueltaEliminar);
        
        //////////////////////////////////////////////
        
        //PANEL VISUALIZAR
        
        JPanel panelVer = new JPanel();
        tabbedPane.addTab("VISUALIZAR", null, panelVer, null);
        panelVer.setLayout(null);
        
        // Visualizar Cliente
        
        JButton btnVerCliente = new JButton("CLIENTE");
        btnVerCliente.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		
        		JVisualizarCliente visCliente = new JVisualizarCliente();
        		visCliente.setVisible(true);
        		visCliente.setTitle("VISUALIZAR CLIENTE");
        		dispose();
        		
        	}
        });
        btnVerCliente.setBounds(10, 10, 125, 30);
        panelVer.add(btnVerCliente);
        
        // Visualizar Habitación
        
        JButton btnVerHabitacion = new JButton("HABITACIÓN");
        btnVerHabitacion.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		
        		JVisualizarHabitacion visHabitacion = new JVisualizarHabitacion();
        		visHabitacion.setVisible(true);
        		visHabitacion.setTitle("VISUALIZAR HABITACIÓN");
        		dispose();
        		
        	}
        });
        btnVerHabitacion.setBounds(10, 50, 125, 30);
        panelVer.add(btnVerHabitacion);
        
        // Visualizar Servicio
        
        JButton btnVerServicio = new JButton("SERVICIO");
        btnVerServicio.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		
        		JVisualizarServicio visServicio = new JVisualizarServicio();
        		visServicio.setVisible(true);
        		visServicio.setTitle("VISUALIZAR SERVICIO");
        		dispose();
        		
        	}
        });
        btnVerServicio.setBounds(10, 90, 125, 30);
        panelVer.add(btnVerServicio);
        
        // Visualizar Reserva
        
        JButton btnVerReserva_1 = new JButton("RESERVA");
        btnVerReserva_1.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		
        		JVisualizarReserva visReserva = new JVisualizarReserva();
        		visReserva.setVisible(true);
        		visReserva.setTitle("VISUALIZAR RESERVA");
        		dispose();
        		
        	}
        });
        btnVerReserva_1.setBounds(10, 130, 125, 30);
        panelVer.add(btnVerReserva_1);
        
        // Botón vuelta --> JInicio
        
        JButton vueltaVer = new JButton("VOLVER");
        vueltaVer.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		JInicio inicio = new JInicio();
        		inicio.setVisible(true);
        		inicio.setTitle("INICIO DE SESIÓN");
        		dispose();
        	}
        });
        vueltaVer.setBounds(190, 130, 85, 30);
        panelVer.add(vueltaVer);
        
        ////////////////////////////////////////////////////////////////////////
        
        // Panel de FACTURAR

        JPanel panelFacturar = new JPanel();
        tabbedPane.addTab("FACTURAR", null, panelFacturar, null);
        panelFacturar.setLayout(null);

        // Facturar Reserva

        JButton btnFacturar = new JButton("RESERVA");
        btnFacturar.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
			{
				JFacturar facturar = new JFacturar();
				facturar.setVisible(true);
				facturar.setTitle("FACTURAR RESERVA");
				dispose();
			}
		});
        btnFacturar.setBounds(10, 10, 125, 30);
		panelFacturar.add(btnFacturar);
    
		// Botón vuelta --> JInicio
        
        JButton vueltaFacturar = new JButton("VOLVER");
        vueltaFacturar.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		JInicio inicio = new JInicio();
        		inicio.setVisible(true);
        		inicio.setTitle("INICIO DE SESIÓN");
        		dispose();
        	}
        });
        vueltaFacturar.setBounds(190, 130, 85, 30);
        panelFacturar.add(vueltaFacturar);
    }
}
