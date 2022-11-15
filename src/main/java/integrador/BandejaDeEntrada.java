package integrador;

public interface BandejaDeEntrada {
    
    public void agregarCorreo(Correo correo);
    public void eliminarCorreo(Correo correo);
    public void buscarCorreo(InterfaceBusqueda busqueda);
    public void mostrarCorreos();
    
}
