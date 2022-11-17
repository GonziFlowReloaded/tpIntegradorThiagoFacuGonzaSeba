package integrador;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;


public class Usuario implements InterfaceBusquedaContacto{
    

    private String usuario;
    private String password;
    private String nombre;
    private String email;
    private Correo correo;
    ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    private Buzon buzon = new Buzon();
    private Correo correoActual;
    

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
    public void setCorreoActual(Correo correo){
        this.correoActual = correo;
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
    public Buzon getBuzon() {
        return buzon;
    }

    public void crearCorreo(String contenido, String asunto, Contacto destinatario, LocalDate fecha) {
        correo = new Correo(contenido, asunto,new Contacto(this.getNombre(), this.getEmail()), destinatario, fecha);
        this.setCorreoActual(correo);

    }

    public void crearContacto(String nombre, String email) {
        Contacto contacto = new Contacto(nombre, email);
        contactos.add(contacto);
    }
    
    public Correo getCorreoActual(){
        return correoActual;
    }

    public void enviarCorreo(Correo correo, Registro registro){
        buzon.agregarCorreoEnviado(correo);
        for (Contacto destinatario : correo.getPara()){
            // registro.usuarios.stream().filter(u -> u.getEmail().equals(destinatario.getEmail())).findFirst().orElse(null).getBuzon().agregarCorreo(correo);
            registro.usuarios.stream().filter(u -> u.getEmail().equals(destinatario.getEmail())).findFirst().get().getBuzon().agregarCorreo(correo);
            
        }
    }



    public ArrayList<Contacto> getContactos() {
        return contactos;
    }
    

    
    
    
    
    
    
    @Override
    public Contacto buscarContactoEmail(String email) {
        Predicate<Contacto> p = c -> c.getEmail().equals(email);
        return contactos.stream().filter(p).findFirst().orElse(null);
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

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", password=" + password + ", nombre=" + nombre + ", email=" + email + ", contactos=" + contactos + '}';
    }
    

    
}
