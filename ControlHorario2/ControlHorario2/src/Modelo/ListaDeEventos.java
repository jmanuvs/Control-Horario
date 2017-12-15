/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author chavo
 */
public class ListaDeEventos implements Serializable {

    ArrayList<Evento> ListaDeEventos = new ArrayList<>();

    public ListaDeEventos() {
    }

    public ListaDeEventos BuscarPorFecha(Date dat) {
        SimpleDateFormat ParaComparar = new SimpleDateFormat("EEEE, MMM dd, yyyy");
        ParaComparar.format(dat);
        System.out.println("Buscando");
        ListaDeEventos lis = new ListaDeEventos();
        for (int i = 0; i < ListaDeEventos.size(); i++) {
            System.out.println(ParaComparar.format(dat) +" *** " +ParaComparar.format(ListaDeEventos.get(i).getFechaEvento()) );
            if (ParaComparar.format(dat).equals(ParaComparar.format(ListaDeEventos.get(i).getFechaEvento()))) {
                
                lis.Añadir(ListaDeEventos.get(i));
            }
        }
        return  lis;
    }

    public int GetTam() {
        return ListaDeEventos.size();
    }

    public Evento GetEvento(int i) {
        return ListaDeEventos.get(i);
    }

    public void Añadir(Evento e) {
        ListaDeEventos.add(e);
    }

    public boolean EstaVacia() {
        return ListaDeEventos.isEmpty();
    }

}
