/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import vista.VentanaPrincipal;

/**
 *
 * @author chavo
 */
public class Iniciador {

    public Iniciador() {

    }

    public void iniciarSistema() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            VentanaPrincipal Intro = new VentanaPrincipal();
            Intro.setVisible(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Iniciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

}
