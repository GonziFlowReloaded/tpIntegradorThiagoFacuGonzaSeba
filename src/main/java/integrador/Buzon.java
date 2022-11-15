package integrador;

import java.util.ArrayList;
import java.util.function.Predicate;
public class Buzon implements InterfaceBandejaDeEntrada, InterfaceBusquedaCorreo{
    
    private ArrayList<Correo> correos = new ArrayList<Correo>();

    public Buzon() {
    }

    public ArrayList<Correo> getCorreos() {
        return correos;
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
        
        for (Correo correo : correos) {
            System.out.println(correo);
        }
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
    public Correo buscarDestinatario(String destinatario) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Correo buscarContenido(String contenido) {
        // TODO Auto-generated method stub
        return null;
    }


}
