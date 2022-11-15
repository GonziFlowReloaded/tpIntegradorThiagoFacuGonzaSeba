package integrador;

import java.time.LocalDate;

public interface InterfaceBusquedaCorreo {
    // Busqueda para correo
    public Correo buscarAsunto(String asunto);

    public Correo buscarRemitente(String remitente);

    public Correo buscarContenido(String contenido);

    public Correo buscarDestinatarioNombreEmail(String nombre, String email);

    public Correo buscarFechaNombreRemitente(LocalDate fecha, String nombre);

}
