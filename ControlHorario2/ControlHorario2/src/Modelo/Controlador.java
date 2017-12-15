/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author chavo
 */
public class Controlador {

    public Controlador() {
    }
    public boolean ValidarUsuario (String nombre, String Pass){
        return nombre.equals("Admin") && Pass.equals("123");
    }
}
