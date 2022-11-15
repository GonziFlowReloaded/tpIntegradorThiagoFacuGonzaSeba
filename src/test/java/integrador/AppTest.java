package integrador;
import static org.junit.Assert.assertEquals;
import org.junit.*;

public class AppTest {
    
    @Test
    public void debeCrearUsuario(){
        Usuario usuario = new Usuario("JuanRiquelme", "1234", "Roberto", "JuanPerez@gmail.com");
        assertEquals("JuanRiquelme", usuario.getUsuario());
        assertEquals("1234", usuario.getPassword());
        assertEquals("Roberto", usuario.getNombre());
        assertEquals("JuanPerez@gmail.com", usuario.getEmail());
    }


    @Test
    public void debeAgregarContacto(){
        Usuario usuario = new Usuario("JuanRiquelme", "1234", "Roberto", "JuanPerez@gmail.com");
        usuario.crearContacto("Roberto Monzon", "RobertoCop69@yahoo.es");
        assertEquals("Roberto Monzon", usuario.getContactos().get(0).getNombre());
        assertEquals("RobertoCop69@yahoo.es", usuario.getContactos().get(0).getEmail());
    }

    @Test
    public void debeCrearCorreo(){
        Usuario usuario = new Usuario("JuanRiquelme", "1234", "Roberto", "JuanPerez@gmail.com");

        usuario.crearContacto("Jorgemite", "roberto@mail.com");
        usuario.crearCorreo("Hola, como estas?", "Saludo", usuario.getContactos().get(0));

        
        assertEquals("Hola, como estas?", usuario.getCorreoActual().getContenido());
        assertEquals("Saludo", usuario.getCorreoActual().getAsunto());
        assertEquals("Jorgemite", usuario.getCorreoActual().getPara().get(0).getNombre());
        assertEquals("Roberto", usuario.getCorreoActual().getRemitente().getNombre());
    }

    @Test
    public void debeBuscarContacto(){
        Usuario usuario = new Usuario("JuanRiquelme", "1234", "Roberto", "JuanPerez@gmail.com");
        usuario.crearContacto("Jorgemite", "roberto@mail.com");
        usuario.crearContacto("Maria", "Maria@mail.com");
        usuario.crearContacto("Villa", "Violenciaintrafamiliar@mail.com");
        usuario.crearContacto("Riquelme", "roberto@mail.com");

        assertEquals("Maria", usuario.buscarContactoNombre("Maria").getNombre());
        assertEquals("Maria@mail.com", usuario.buscarContactoNombre("Maria").getEmail());

        assertEquals("Villa", usuario.buscarContactoEmail("Violenciaintrafamiliar@mail.com").getNombre());

    }

    @Test
    public void debeEnviarCorreo(){
        Registro paginaWeb = new Registro();
        Usuario usuario = new Usuario("JuanRiquelme", "1234", "Roberto", "JuanPerez@gmail.com");
        Usuario usuario2 = new Usuario("Roberto", "1234", "Roberto Perez", "RobertoPerez@gmail.com");
        paginaWeb.registrarUsuario(usuario);
        paginaWeb.registrarUsuario(usuario2);

        usuario.crearCorreo("Buenardo", "Soy fan de coscu", null);
        usuario.getCorreoActual().agregarDestinatario(new Contacto(usuario2.getNombre(), usuario2.getEmail()));
    
        usuario.enviarCorreo(usuario.getCorreoActual(), paginaWeb);

        assertEquals("Buenardo", usuario2.getBuzon().getCorreos().get(0).getContenido());
    
    }
}

