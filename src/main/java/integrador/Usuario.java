package integrador;
import java.util.*;
import java.util.function.Predicate;

public class Usuario implements InterfaceBusquedaContacto{
    

    private String usuario;
    private String password;
    private String nombre;
    private String email;
    private Correo correo;
    ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    

    public Usuario(String usuario, String password, String nombre, String email) {
        setUsuario(usuario);
        setPassword(password);
        setNombre(nombre);
        setEmail(email);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void crearCorreo(String contenido, String asunto, Contacto destinatario) {
        correo = new Correo(contenido, asunto, destinatario, new Contacto(this.getNombre(), this.getEmail()));

    }

    public void crearContacto(String nombre, String email) {
        Contacto contacto = new Contacto(nombre, email);
        contactos.add(contacto);
    }
    
    public Correo getCorreoActual(){
        return correo;
    }
    public void mostrarContactos() {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }
    
    
    
    
    
    
    
    @Override
    public Contacto buscarContactoEmail(String email) {
        Predicate<Contacto> p = c -> c.getEmail().equals(email);
        return contactos.stream().filter(p).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", password=" + password + ", nombre=" + nombre + ", email=" + email + ", contactos=" + contactos + '}';
    }

    @Override
    public Contacto buscarContactoNombre(String nombre) {
        Predicate<Contacto> p = c -> c.getNombre().equals(nombre);
        return contactos.stream().filter(p).findFirst().orElse(null);
        
    }

    @Override
    public Contacto buscarContacto(Contacto contacto) {
        Predicate<Contacto> p = c -> c.equals(contacto);
        return contactos.stream().filter(p).findFirst().orElse(null);
    }

    
    

    
}
