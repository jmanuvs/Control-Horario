package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Chavo
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel miPanelPrincipal, panelTitulo;



    public VentanaPrincipal() {
        initComponents();
        setTitle("Ventana Principal");
        setSize(450, 250);
        setLocationRelativeTo(null);        
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        
        miPanelPrincipal = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();        
        labelTitulo = new javax.swing.JLabel();
        botonConsultar = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        miPanelPrincipal.setBackground(Color.lightGray);
        miPanelPrincipal.setLayout(null);

        panelTitulo.setBackground(Color.black);      
        panelTitulo.setLayout(null);
        

        labelTitulo.setFont(new java.awt.Font("Arial", 0, 48)); 
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(" **Bienvenido**");
        labelTitulo.setForeground(Color.white);
        panelTitulo.add(labelTitulo);
        labelTitulo.setBounds(5, 5, 380, 60);

        botonConsultar.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        botonConsultar.setText("CONSULTAR");
        miPanelPrincipal.add(botonConsultar);
        botonConsultar.setBounds(230, 80, 190, 60);
        botonConsultar.addActionListener(this);

        botonRegistrar.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        botonRegistrar.setText("ADMIN");
        miPanelPrincipal.add(botonRegistrar);
        botonRegistrar.setBounds(20, 80, 190, 60);
        botonRegistrar.addActionListener(this);


        miPanelPrincipal.setBounds(0, 0, 670, 350);
        panelTitulo.setBounds(0, 0, 1500, 70);
       
        miPanelPrincipal.add(panelTitulo);
        getContentPane().add(miPanelPrincipal);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonRegistrar) {
            VentanaAdministrador admin= new VentanaAdministrador();
            admin.setVisible(true);
            this.dispose();
        }

        if (e.getSource() == botonConsultar) {
            VentanaAdministrador admin= new VentanaAdministrador();
            admin.setVisible(true);
            this.dispose();
        }

    }

}
