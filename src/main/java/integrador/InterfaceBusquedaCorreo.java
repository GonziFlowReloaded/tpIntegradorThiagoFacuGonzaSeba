package integrador;

import java.time.LocalDate;
import java.util.function.Predicate;

public interface InterfaceBusquedaCorreo {
    // Busqueda para correo
    public Correo buscar(Predicate<Correo> filtro);

    public Predicate<Correo> crearFiltroAsunto(String asunto);

    public Predicate<Correo> crearFiltroRemitente(String remitente);

    public Predicate<Correo> crearFiltroContenido(String contenido);

    public Predicate<Correo> crearFiltroFecha(LocalDate fecha);

    public Predicate<Correo> combinarFiltros(Predicate<Correo> filtro1, Predicate<Correo> filtro2);



}
