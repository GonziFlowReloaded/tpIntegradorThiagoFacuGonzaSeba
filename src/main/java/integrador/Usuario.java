package integrador;

public class Usuario {
    

    private String usuario;
    private String password;
    private String nombre;
    private String email;

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
    
}
