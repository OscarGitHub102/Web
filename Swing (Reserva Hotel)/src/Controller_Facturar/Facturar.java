package Controller_Facturar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import View_Admin.JControlador;
import View_Eliminar.JEliminar;
import View_Facturar.JFacturar;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class Facturar implements ActionListener
{
    private JFacturar ventana;
    private String url = "";        // cambiar según url de la BBDD
    private String user_db = "";        // cambiar según nombre de usuario de la BBDD
    private String password = "";        // cambiar según contraseña de la BBDD


    public Facturar(JFacturar ventana) {

        this.ventana = ventana;
    }


    public void actionPerformed(ActionEvent e) 
    {
        String codRes = ventana.getCodRes().getText();

        try (Connection con = DriverManager.getConnection(url, user_db, password))
        {
            Map parametros = new HashMap();
            parametros.put("Codres", codRes);
            JasperPrint print = JasperFillManager.fillReport("C:\\Users\\oscar\\eclipse-workspace\\ReservaHotel\\Facturas\\Factura.jasper", parametros, con); // (ruta, parámetros, conexión)
            JasperExportManager.exportReportToPdfFile(print,"C:\\Users\\oscar\\eclipse-workspace\\ReservaHotel\\Facturas\\Factura" + codRes + ".pdf");

            JControlador controlador = new JControlador();
            controlador.setVisible(true);
            controlador.setTitle("MENÚ");
            ventana.dispose();

        } catch (Exception e1) {
            // TODO: handle exception
            e1.printStackTrace();
        }

    }

}