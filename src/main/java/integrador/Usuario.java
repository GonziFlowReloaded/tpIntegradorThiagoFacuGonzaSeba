package integrador;

public class Usuario {
    

    private String usuario;
    private String password;

    public Usuario(String usuario, String password) {
        setUsuario(usuario);
        setPassword(password);
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
    
}
