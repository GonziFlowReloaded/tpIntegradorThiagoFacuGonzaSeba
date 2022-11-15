package integrador;
import java.util.*;
public class Registro{
    
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public Registro(){
        
    }

    public void registrarUsuario(Usuario usuario){
        usuarios.add(usuario);
        
    }


}
