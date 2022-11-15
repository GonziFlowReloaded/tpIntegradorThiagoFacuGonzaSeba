package integrador;

public interface InterfaceBusquedaContacto{
    //Busqueda para contacto
    public Contacto buscarContactoNombre(String nombre);
    public Contacto buscarContactoEmail(String email);
    public Contacto buscarContacto(Contacto contacto);
}