package integrador;

import java.util.ArrayList;
import java.util.function.Predicate;
public class Buzon implements InterfaceBandejaDeEntrada, InterfaceBusquedaCorreo{
    
    private ArrayList<Correo> correos = new ArrayList<Correo>();
    private ArrayList<Correo> correosEnviados = new ArrayList<Correo>();

    public Buzon() {
    }

    public ArrayList<Correo> getCorreos() {
        return correos;
    }
    
    public void agregarCorreoEnviado(Correo correo){
        correosEnviados.add(correo);
    }
    
    
    @Override
    public void agregarCorreo(Correo correo) {
        correos.add(correo);
    }
    @Override
    public void eliminarCorreo(Correo correo) {
        correos.remove(correo);
    }
    
    @Override
    public void mostrarCorreos() {
        
        
    }

    @Override
    public Correo buscarAsunto(String asunto) {
        Predicate<Correo> filtro = c -> c.getAsunto().equals(asunto);
        return correos.stream().filter(filtro).findFirst().orElse(null);
    }

    @Override
    public Correo buscarRemitente(String remitente) {
        Predicate<Correo> filtro = c -> c.getRemitente().getNombre().equals(remitente);
        return correos.stream().filter(filtro).findFirst().orElse(null);
    }

    @Override
    public Correo buscarDestinatarioNombre(String destinatario) {
        Predicate<Correo> filtro = c -> c.getPara().stream().anyMatch(d -> d.getNombre().equals(destinatario));
        return correos.stream().filter(filtro).findFirst().orElse(null);
    }
    @Override
    public Correo buscarDestinatarioEmail(String email) {
        Predicate<Correo> filtro = c -> c.getPara().stream().anyMatch(d -> d.getEmail().equals(email));
        return correos.stream().filter(filtro).findFirst().orElse(null);
    }
    @Override
    public Correo buscarContenido(String contenido) {
        Predicate<Correo> filtro = c -> c.getContenido().contains(contenido);
        return correos.stream().filter(filtro).findFirst().orElse(null);
    }


}
