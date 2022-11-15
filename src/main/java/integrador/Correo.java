package integrador;

import java.util.*;
import java.time.*;

public class Correo {
    private String contenido;
    private String asunto;
    private Contacto remitente;
    private LocalDate fecha;
    ArrayList<Contacto> paraArray = new ArrayList<Contacto>();

    public Correo(String contenido, String asunto, Contacto remitente, Contacto para, LocalDate fecha) {
        setContenido(contenido);
        setAsunto(asunto);
        setRemitente(remitente);
        paraArray.add(para);
        setFecha(fecha);

    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Contacto getRemitente() {
        return remitente;
    }

    public void setRemitente(Contacto remitente) {
        this.remitente = remitente;
    }

    public ArrayList<Contacto> getPara() {
        return paraArray;
    }

    public void agregarDestinatario(Contacto destinatario) {
        paraArray.add(destinatario);
    }
    
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    

    @Override
    public String toString() {
        return "Correo{" + "contenido=" + contenido + ", asunto=" + asunto + ", remitente=" + remitente + ", para=" + paraArray + ", fecha=" + fecha + '}';
    }

    
}
