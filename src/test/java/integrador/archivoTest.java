package integrador;

import org.junit.Test;
import static org.junit.Assert.*;

public class archivoTest {

    @Test
    public void debeCrearUsuario() {
        Usuario usuario = new Usuario("Juan12", "juan123", "Juan", "juan@correo.com");
        assertEquals("Juan12", usuario.getUsuario());
        assertEquals("juan123", usuario.getPassword());
        assertEquals("Juan", usuario.getNombre());
        assertEquals("juan@correo.com", usuario.getEmail());

        
    }
    
}
