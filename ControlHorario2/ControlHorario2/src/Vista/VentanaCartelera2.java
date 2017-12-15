package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author Chavo
 */
public class VentanaCartelera2 extends JFrame implements ActionListener {

    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel labelTitulo, labelSeleccionar, labelFecha;
    private javax.swing.JPanel miPanelPrincipal, panelTitulo, contenedor;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private final Date Fecha;

    public VentanaCartelera2(Date Fecha) {
        this.Fecha = Fecha;
        initComponents();
        setTitle("Cartelera");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        miPanelPrincipal = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        contenedor = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelSeleccionar = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        botonConsultar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        miPanelPrincipal.setBackground(Color.lightGray);
        miPanelPrincipal.setLayout(null);

        panelTitulo.setBackground(Color.black);
        panelTitulo.setLayout(null);

        labelTitulo.setFont(new java.awt.Font("Arial", 0, 48));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(" **Cartelera**");
        labelTitulo.setForeground(Color.white);
        panelTitulo.add(labelTitulo);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = screenSize.width;
        labelTitulo.setBounds(5, 5, w, 60);

        labelFecha.setFont(new java.awt.Font("Arial", 0, 48));
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
        labelFecha.setText(formatter.format(Fecha));
        labelFecha.setForeground(Color.black);
        contenedor.add(labelFecha, BorderLayout.PAGE_END);

        labelSeleccionar.setFont(new java.awt.Font("Arial", 0, 27));
        labelSeleccionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSeleccionar.setText(" Selecciona una Fecha: ");
        labelSeleccionar.setForeground(Color.black);
        contenedor.add(labelSeleccionar);

        Calendar calendario = Calendar.getInstance();
        jDateChooser1.setCalendar(calendario);
        jDateChooser1.setBounds(5, 5, 600, 60);
        contenedor.add(jDateChooser1);
        contenedor.setBounds((w / 3 - 200), 200, (w / 2) + 200, 400);
        miPanelPrincipal.add(contenedor);

        botonConsultar.setFont(new java.awt.Font("Tahoma", 0, 24));
        botonConsultar.setText("CONSULTAR");
        botonConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        contenedor.add(botonConsultar);
        botonConsultar.addActionListener(this);

        botonRegresar.setFont(new java.awt.Font("Tahoma", 0, 24));
        botonRegresar.setText("REGRESAR");
        botonRegresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPanelPrincipal.add(botonRegresar);
        botonRegresar.setBounds(20, 80, 190, 60);
        botonRegresar.addActionListener(this);

        miPanelPrincipal.setBounds(0, 0, 670, 350);
        panelTitulo.setBounds(0, 0, 1500, 70);

        miPanelPrincipal.add(panelTitulo);
        getContentPane().add(miPanelPrincipal);
        pack();
    }

    public String GetMes() {
        int i = Fecha.getMonth();
        switch (i) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";

            case 3:
                return "Marzo";

            case 4:
                return "Abril";

            case 5:
                return "Mayo";

            case 6:
                return "Junio";

            case 7:
                return "Julio";

            case 8:
                return "Agosto";

            case 9:
                return "Septiembre";

            case 10:
                return "Octubre";

            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";

            default:
                return "";

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonRegresar) {
            VentanaPrincipal admin = new VentanaPrincipal();
            admin.setVisible(true);
            this.dispose();
        }

        if (e.getSource() == botonConsultar) {
            VentanaCartelera2 admin = new VentanaCartelera2(jDateChooser1.getDate());
            admin.setVisible(true);
            this.dispose();
        }

    }
}
