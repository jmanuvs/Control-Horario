package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Evento implements Serializable{
    private String _nombreEvento;
    private Date fechaEvento;
    
    public Evento(String nom, int anio, int mes, int dia, int hora, int min){
        
        _nombreEvento=nom;
        
        GregorianCalendar fecha = new GregorianCalendar(anio,mes+1,dia,hora, min);
        
        fechaEvento = fecha.getTime();
    }

    public String getNombreEvento() {
        return _nombreEvento;
    }

    public void setNombreEvento(String _nombreEvento) {
        this._nombreEvento = _nombreEvento;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }
    
}
