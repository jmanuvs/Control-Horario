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

    public Controlador() {
        ControlDeArchivo = new EscribirYLeer();
    }
    public boolean ValidarUsuario (String nombre, String Pass){
        return nombre.equals("Admin") && Pass.equals("123");
    }
    public ListaDeEventos ObtenerLista(){
        try {
            EventList = ControlDeArchivo.ObtenerObjetosDeArchivo();
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            EventList =  null;
        }
        return EventList;        
    }
    public void ActualizarLista(){
        try {
            System.out.println(ControlDeArchivo.EstablecerEscrituraDeArchivo(EventList));
            EventList = ControlDeArchivo.ObtenerObjetosDeArchivo();
        } catch (ClassNotFoundException | IOException ex) {
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
