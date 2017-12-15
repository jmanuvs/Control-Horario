package vista;

import Modelo.Controlador;
import Modelo.ListaDeEventos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Chavo
 */
public class VentanaCartelera2 extends JFrame implements ActionListener {

    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel labelTitulo, labelSeleccionar, labelFecha;
    private javax.swing.JTextArea JTextFieldEventos;
    private javax.swing.JPanel miPanelPrincipal, panelTitulo, contenedor, Subpanel1, Subpanel2, events;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private final Date Fecha;

    public VentanaCartelera2(Date Fecha) {
        this.Fecha = Fecha;
        initComponents();
        setTitle("Cartelera");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        miPanelPrincipal = new javax.swing.JPanel();
        Subpanel1 = new javax.swing.JPanel();
        Subpanel2 = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        contenedor = new javax.swing.JPanel();
        events = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelSeleccionar = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        botonConsultar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        JTextFieldEventos = new JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = screenSize.width;

        miPanelPrincipal.setBackground(Color.lightGray);
        miPanelPrincipal.setLayout(null);
        panelTitulo.add(labelTitulo, BorderLayout.NORTH);
        miPanelPrincipal.add(contenedor, BorderLayout.CENTER);
        contenedor.setBounds((w / 3 - 200), 200, (w / 2) + 200, 400);

        Subpanel2.setBounds(200, 5, w, 100);
        Subpanel1.setBounds(5, 5, w, 100);
        contenedor.add(Subpanel2, BorderLayout.EAST);
        contenedor.add(Subpanel1, BorderLayout.WEST);
        Subpanel2.add(labelSeleccionar);
        Subpanel2.add(jDateChooser1);
        Subpanel2.add(botonConsultar, BorderLayout.EAST);
        miPanelPrincipal.add(events, BorderLayout.EAST);

        panelTitulo.setBackground(Color.black);
        panelTitulo.setLayout(null);

        labelTitulo.setFont(new java.awt.Font("Arial", 0, 48));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(" **Cartelera**");
        labelTitulo.setForeground(Color.white);

        labelTitulo.setBounds(5, 5, w, 60);

        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
        

        Subpanel1.add(labelFecha, BorderLayout.PAGE_END);

        JTextFieldEventos.setFont(new java.awt.Font("Arial", 0, 16));
        JTextFieldEventos.setEditable(false); // set textArea non-editable
        JScrollPane scroll = new JScrollPane(JTextFieldEventos);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Subpanel1.setBorder(new TitledBorder(new EtchedBorder(), "Eventos: " + formatter.format(Fecha)));

        ListaDeEventos list;
        Controlador cont;
        try {
            cont = new Controlador();
            list = cont.ObtenerLista();

            if (list.EstaVacia()) {
                JTextFieldEventos.setText(" *No hay eventos aun*");
            } else {
                list = list.BuscarPorFecha(Fecha);
                if (list.EstaVacia()) {
                    JTextFieldEventos.setText(" **No hay eventos aun**");
                } else {
                    JTextFieldEventos.setText("");
                    String temp;
                    for (int i = 0; i < list.GetTam(); i++) {
                        temp = JTextFieldEventos.getText();

                        JTextFieldEventos.setText(temp + "\n " + "Evento: " + list.GetEvento(i).getNombreEvento() + " \n Fecha: " + formatter.format(list.GetEvento(i).getFechaEvento()) + " \n ******************************");

                    }
                }

            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(VentanaAgregarEvento.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al actualizar los archivos: " + ex.getMessage(), "Error en los archivos", JOptionPane.ERROR_MESSAGE);
        }
        Subpanel1.add(scroll);
        Subpanel1.add(JTextFieldEventos);

        labelSeleccionar.setFont(new java.awt.Font("Arial", 0, 27));
        labelSeleccionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSeleccionar.setText(" Selecciona una Fecha: ");
        labelSeleccionar.setForeground(Color.black);

        Calendar calendario = Calendar.getInstance();
        jDateChooser1.setCalendar(calendario);
        jDateChooser1.setBounds(5, 5, 600, 60);

        Subpanel2.setBounds((w / 3 - 200), 200, (w / 2) + 200, 400);

        botonConsultar.setFont(new java.awt.Font("Tahoma", 0, 24));
        botonConsultar.setText("CONSULTAR");
        botonConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        botonConsultar.addActionListener(this);

        botonRegresar.setFont(new java.awt.Font("Tahoma", 0, 24));
        botonRegresar.setText("REGRESAR");
        botonRegresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPanelPrincipal.add(botonRegresar, BorderLayout.NORTH);

        botonRegresar.setBounds(20, 80, 190, 60);
        botonRegresar.addActionListener(this);

        //miPanelPrincipal.setBounds(0, 0, 670, 350);
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
