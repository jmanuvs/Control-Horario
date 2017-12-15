package Controlador;

import Modelo.EscribirYLeer;
import Modelo.ListaDeEventos;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chavo
 */
public class ControladorPrincipal {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Iniciador miAplicacion = new Iniciador();
        miAplicacion.iniciarSistema();
    }
}
