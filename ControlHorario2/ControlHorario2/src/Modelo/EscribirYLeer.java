package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EscribirYLeer {

    ListaDeEventos EventList;
    File Archivo;

    public EscribirYLeer(ListaDeEventos EventList) {
        this.EventList = EventList;

    }

    

    public EscribirYLeer() throws IOException {        
    }
    public void VerificarArchivo() throws IOException {
        Archivo = new File("Eventos.txt");
        if (!Archivo.exists()) {
            System.out.println("No existe");
            Archivo.createNewFile();
            Evento ev = new Evento("Primer evento de prueba", 2015, 7, 29);
            EventList = new ListaDeEventos();
            EventList.Añadir(ev);
            Escribir(EventList);
        }
    }

    public String Escribir(ListaDeEventos list) throws FileNotFoundException, IOException {
        String msg = "Actualizacion realizada";

        FileOutputStream ParaEscribir = new FileOutputStream(Archivo);
        ObjectOutputStream Salida = new ObjectOutputStream(ParaEscribir);

        for (int i = 0; i < list.GetTam(); i++) {
            Salida.writeObject(list.GetEvento(i));
        }
        System.out.println(msg);
        return msg;
    }

    public ListaDeEventos leer() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        ListaDeEventos list = new ListaDeEventos();
        try {

            FileInputStream fis = new FileInputStream(Archivo);
            ois = new ObjectInputStream(fis);
            while (true) {
                Evento ev = (Evento) ois.readObject();
                list.Añadir(ev);
                System.out.println(ev.getNombreEvento());
            }
        } catch (IOException io) {

        } finally {
            ois.close();
        }
        return list;
    }
}
