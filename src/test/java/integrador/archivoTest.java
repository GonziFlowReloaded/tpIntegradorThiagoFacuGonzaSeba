package integrador;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class archivoTest {

    @Test
    public void debeCrearUsuario() {
        Usuario usuario = new Usuario("Juan12", "juan123", "Juan", "juan@correo.com");
        assertEquals("Juan12", usuario.getUsuario());
        assertEquals("juan123", usuario.getPassword());
        assertEquals("Juan", usuario.getNombre());
        assertEquals("juan@correo.com", usuario.getEmail());

    }

    @Test
    public void debeCrearContacto() {
        Contacto contacto = new Contacto("Pedro", "pedro@correo.com");
        assertEquals("Pedro", contacto.getNombre());
        assertEquals("pedro@correo.com", contacto.getEmail());

    }

    @Test
    public void debeCrearCorreo() {
        Usuario usuario = new Usuario("Juan12", "juan123", "Juan", "juan@correo.com");
        Contacto contacto = new Contacto("Pedro", "pedro@correo.com");
        Correo correo = new Correo("Hola", "Saludo", usuario, contactos);

        assertEquals("Hola", correo.getContenido());
        assertEquals("Saludo", correo.getAsunto());
        assertEquals(usuario, correo.getRemitente());
        assertEquals(contacto, correo.getPara().get(0));

    }

    @Test
    public void debeEnviarVariosCorreos() {
        ArrayList<Contacto> contactos = new ArrayList<Contacto>();
        Usuario usuario = new Usuario("Juan12", "juan123", "Juan", "juan@correo.com");
        Contacto contacto1 = new Contacto("Pedro", "pedro@correo.com");
        Contacto contacto2 = new Contacto("Maria", "maria@correo.com");

       
        usuario.


        

        



        

    }
}
