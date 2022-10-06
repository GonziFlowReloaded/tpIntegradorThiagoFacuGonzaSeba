package integrador;

public class Contacto {
    private String nombre;
    private String apellido;
    private String email;

    public Contacto(String nombre, String apellido, String email) {
        setNombre(nombre);
        setApellido(apellido);
        setEmail(email);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + '}';
    }
    
}
