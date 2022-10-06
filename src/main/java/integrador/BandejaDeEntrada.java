package integrador;
import java.util.*;

public class BandejaDeEntrada {
    ArrayList<Correo> correosNoLeidos = new ArrayList<Correo>();
    ArrayList<Correo> correosLeidos = new ArrayList<Correo>();
    ArrayList<Correo> correosEnviados = new ArrayList<Correo>();


    public BandejaDeEntrada() {
    }

    public ArrayList<Correo> getCorreosNoLeidos() {
        return correosNoLeidos;
    }
    public ArrayList<Correo> getCorreosLeidos() {
        return correosLeidos;
    }

    public void agregarCorreoNoLeido(Correo correo) {
        correosNoLeidos.add(correo);
    }

    public void leerCorreo(Correo correo) {
        System.out.println("Nombre: " + correo.getRemitente().getNombre() + " Asunto: " + correo.getAsunto()
                + " Contenido: " + correo.getContenido() + " Para: ");
        correo.getPara().forEach((c) -> System.out.println(c.getNombre()));
        correosNoLeidos.remove(correo);
        correosLeidos.add(correo);
    }
    
    public void agregarCorreoEnviado(Correo correo) {
        correosEnviados.add(correo);
    }



}
