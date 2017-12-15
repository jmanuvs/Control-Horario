package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EscribirYLeer {
    ListaDeEventos EventList;

    public EscribirYLeer() {
    }
    
    
    /**
     * @param L_Eventos
     * @return 
     * @throws java.io.IOException
     */
    public String EstablecerEscrituraDeArchivo(ListaDeEventos L_Eventos) throws IOException {
        String msg="Actualizacion realizada";
        File Archivo = new File("Eventos.obj");
        FileOutputStream ParaEscribir = new FileOutputStream(Archivo);
        try (ObjectOutputStream Salida = new ObjectOutputStream(ParaEscribir)) {
            Salida.writeObject(L_Eventos);
            /*for (int i = 0; i < L_Eventos.GetTam(); i++) {
            Salida.writeObject(new Evento());
            }*/
        }catch(IOException e){
            msg=e.getLocalizedMessage();
        }
        return msg;
    }

    public ListaDeEventos ObtenerObjetosDeArchivo() throws ClassNotFoundException, IOException {
        ObjectInputStream Escuchador = null;
        EventList = new ListaDeEventos();
        try {
            File Archivo = new File("Eventos.obj");
            FileInputStream EntradaDeArchivo = new FileInputStream(Archivo);
            Escuchador = new ObjectInputStream(EntradaDeArchivo);
            if (true) {
                EventList = (ListaDeEventos) Escuchador.readObject();
                System.out.println(EventList.toString());
            }
        } catch (IOException io) {
            System.out.println("Fin");
        } finally {
            Escuchador.close();
        }
        return EventList;
    }
}
