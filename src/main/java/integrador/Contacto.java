package integrador;

public class Contacto {
    private String nombre;
    private String email;

    public Contacto(String nombre, String email) {
        setNombre(nombre);
        
        setEmail(email);
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

    public void vincularUsuario(Usuario usuario) {
        usuario.getContactos().add(this);
    }


    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", email=" + email + '}';
    }
    
}
