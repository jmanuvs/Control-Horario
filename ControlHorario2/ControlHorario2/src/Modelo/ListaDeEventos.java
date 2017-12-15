/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author chavo
 */
public class ListaDeEventos implements Serializable {

    ArrayList<Evento> ListaDeEventos = new ArrayList<>();

    public ListaDeEventos() {
    }
    public int GetTam (){
        return ListaDeEventos.size();
    }
    public void Añadir(Evento e){
        ListaDeEventos.add(e);
    }

}
