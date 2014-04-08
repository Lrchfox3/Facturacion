/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.lrchfox3.fact.swing;

import com.gmail.lrchfox3.basedatos.BD;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chinchillal
 */
public class Start {

    private static final ResourceBundle cnnConfig = ResourceBundle.getBundle("com/gmail/lrchfox3/fact/resources/config");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String mensaje = "";
        BD bd = new BD();
        try {
            bd.iniciarConexion("CONTROL_CLASES", BD.DBMSMSMYSQL,
                    cnnConfig.getString("NombreBaseDatos"),
                    cnnConfig.getString("Usuario"),
                    cnnConfig.getString("Contrasenya"),
                    Integer.valueOf(cnnConfig.getString("Puerto")));
        } catch (SQLException ex) {
            mensaje = "Error de conexión: " + ex.getMessage() + ". ref: Inicio.Main";
            System.out.println(mensaje);
        } catch (Exception ex) {
            mensaje = "Error Desconocido: " + ex.getMessage() + ". ref: Inicio.Main";
            System.out.println(mensaje);
        }

        try {
            com.gmail.lrchfox3.utilitarios.Utileria.lookAndFeelSystem();
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Board().setVisible(true);
            }
        });

//        Login login = new Login();
//        login.setVisible(true);
//
//        User user = login.getUsuario();
//        if (user != null) {
//            new FormularioMaestro(mensaje).setVisible(true);
//        }
    }
}
