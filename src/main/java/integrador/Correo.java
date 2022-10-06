package integrador;

import java.util.*;

public class Correo {
    private String contenido;
    private String asunto;
    private Usuario remitente;
    ArrayList<Contacto> para = new ArrayList<Contacto>();

    public Correo(String contenido, String asunto, Usuario remitente, Contacto para) {
        setContenido(contenido);
        setAsunto(asunto);
        setRemitente(remitente);
        this.para.add(para);

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

    public Usuario getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }

    public ArrayList<Contacto> getPara() {
        return para;
    }

    

    @Override
    public String toString() {
        return "Correo{" + "contenido=" + contenido + ", asunto=" + asunto + ", remitente=" + remitente + ", para=" + para + '}';
    }

    
}
