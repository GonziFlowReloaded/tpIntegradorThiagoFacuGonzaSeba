package integrador;

public interface InterfaceBusquedaCorreo {
    //Busqueda para correo
    public Correo buscarAsunto(String asunto);
    public Correo buscarRemitente(String remitente);
    public Correo buscarDestinatarioNombre(String nombre);
    public Correo buscarDestinatarioEmail(String email);
    public Correo buscarContenido(String contenido);
    


}
