/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chavo
 */
public class Controlador {
    ListaDeEventos EventList;
    EscribirYLeer ControlDeArchivo;

    public Controlador() throws IOException {
        ControlDeArchivo = new EscribirYLeer();
        ControlDeArchivo.VerificarArchivo();
    }
    public boolean ValidarUsuario (String nombre, String Pass){
        return nombre.equals("Admin") && Pass.equals("123");
    }
    public ListaDeEventos ObtenerLista() throws IOException, ClassNotFoundException{
        EventList = new ListaDeEventos();
        EventList = ControlDeArchivo.leer();
        System.out.println("Leido");
        if(EventList!=null){
            System.out.println("Corre");
        }
        return EventList;
    }
    public void ActualizarLista() throws ClassNotFoundException{
        try {
            System.out.println(ControlDeArchivo.Escribir(EventList));
            EventList = ControlDeArchivo.leer();
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            EventList =  null;
        }
    }
    
    public void AñadirEvento(Evento e){
        try {
            EventList.Añadir(e);
            ActualizarLista();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    } 
}
