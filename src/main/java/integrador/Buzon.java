package integrador;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.time.*;

public class Buzon implements InterfaceBandejaDeEntrada, InterfaceBusquedaCorreo {

    private ArrayList<Correo> correos = new ArrayList<Correo>();
    private ArrayList<Correo> correosEnviados = new ArrayList<Correo>();

    public Buzon() {
    }

    public ArrayList<Correo> getCorreos() {
        return correos;
    }

    public void agregarCorreoEnviado(Correo correo) {
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
    public Correo buscar(Predicate<Correo> filtro) {

        return correos.stream().filter(filtro).findFirst().orElse(null);
    }

    @Override
    public Predicate<Correo> crearFiltroAsunto(String asunto) {
        Predicate<Correo> filtro = c -> c.getAsunto().equals(asunto);
        return filtro;
    }

    @Override
    public Predicate<Correo> crearFiltroRemitente(String remitente) {
        Predicate<Correo> filtro = c -> c.getRemitente().equals(remitente);
        return filtro;
    }

    @Override
    public Predicate<Correo> crearFiltroContenido(String contenido) {
        Predicate<Correo> filtro = c -> c.getContenido().equals(contenido);
        return filtro;
    }

    @Override
    public Predicate<Correo> crearFiltroFecha(LocalDate fecha) {
        Predicate<Correo> filtro = c -> c.getFecha().equals(fecha);
        return filtro;
    }

    @Override
    public Predicate<Correo> combinarFiltros(Predicate <Correo> filtro1, Predicate <Correo> filtro2) {
        Predicate<Correo> filtro = c -> filtro1.test(c) && filtro2.test(c);
        return filtro;
    }

    
}
