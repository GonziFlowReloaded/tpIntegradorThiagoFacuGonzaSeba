package integrador;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import java.time.*;
import java.util.function.Predicate;

public class AppTest {

    @Test
    public void debeCrearUsuario() {
        Usuario usuario = new Usuario("JuanRiquelme", "1234", "Roberto", "JuanPerez@gmail.com");
        assertEquals("JuanRiquelme", usuario.getUsuario());
        assertEquals("1234", usuario.getPassword());
        assertEquals("Roberto", usuario.getNombre());
        assertEquals("JuanPerez@gmail.com", usuario.getEmail());
    }

    @Test
    public void debeAgregarContacto() {
        Usuario usuario = new Usuario("JuanRiquelme", "1234", "Roberto", "JuanPerez@gmail.com");
        usuario.crearContacto("Roberto Monzon", "RobertoCop69@yahoo.es");
        assertEquals("Roberto Monzon", usuario.getContactos().get(0).getNombre());
        assertEquals("RobertoCop69@yahoo.es", usuario.getContactos().get(0).getEmail());
    }

    @Test
    public void debeCrearCorreo() {

        LocalDate fecha = LocalDate.now();

        Usuario usuario = new Usuario("JuanRiquelme", "1234", "Roberto", "JuanPerez@gmail.com");

        usuario.crearContacto("Jorgemite", "roberto@mail.com");
        usuario.crearCorreo("Hola, como estas?", "Saludo", usuario.getContactos().get(0), fecha);

        assertEquals("Hola, como estas?", usuario.getCorreoActual().getContenido());
        assertEquals("Saludo", usuario.getCorreoActual().getAsunto());
        assertEquals("Jorgemite", usuario.getCorreoActual().getPara().get(0).getNombre());
        assertEquals("Roberto", usuario.getCorreoActual().getRemitente().getNombre());
        assertEquals(fecha, usuario.getCorreoActual().getFecha());
    }

    @Test
    public void debeBuscarContacto() {
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
    public void debeEnviarCorreo() {
        LocalDate fecha = LocalDate.now();
        Registro paginaWeb = new Registro();
        Usuario usuario = new Usuario("JuanRiquelme", "1234", "Roberto", "JuanPerez@gmail.com");
        Usuario usuario2 = new Usuario("Roberto", "1234", "Roberto Perez", "RobertoPerez@gmail.com");
        Usuario usuario3 = new Usuario("Maria", "1234", "Maria Perez", "Maria@gmail.com");

        paginaWeb.registrarUsuario(usuario);
        paginaWeb.registrarUsuario(usuario2);
        paginaWeb.registrarUsuario(usuario3);

        usuario.crearContacto(usuario2.getNombre(), usuario2.getEmail());
        usuario.crearCorreo("Buenardo", "Soy fan de coscu", usuario.getContactos().get(0), fecha);
        // usuario.getCorreoActual().agregarDestinatario(new
        // Contacto(usuario2.getNombre(), usuario2.getEmail()));
        usuario.crearContacto(usuario3.getNombre(), usuario3.getEmail());

        usuario.getCorreoActual().agregarDestinatario(usuario.getContactos().get(1));

        usuario.enviarCorreo(usuario.getCorreoActual(), paginaWeb);

        assertEquals("Buenardo", usuario2.getBuzon().getCorreos().get(0).getContenido());
        assertEquals("Soy fan de coscu", usuario3.getBuzon().getCorreos().get(0).getAsunto());

    }

    @Test
    public void debeFiltrarPorAsunto() {
        LocalDate fecha = LocalDate.now();
        Registro paginaWeb = new Registro();
        Usuario usuario = new Usuario("JuanRiquelme", "1234", "Roberto", "JuanPerez@gmail.com");
        Usuario usuario2 = new Usuario("Roberto", "1234", "Roberto Perez", "RobertoPerez@gmail.com");
        Usuario usuario3 = new Usuario("Maria", "1234", "Maria Perez", "Maria@gmail.com");

        paginaWeb.registrarUsuario(usuario);
        paginaWeb.registrarUsuario(usuario2);
        paginaWeb.registrarUsuario(usuario3);

        usuario.crearContacto(usuario2.getNombre(), usuario2.getEmail());
        usuario.crearCorreo("Buenardo", "hola", usuario.getContactos().get(0), fecha);

        usuario.crearContacto(usuario3.getNombre(), usuario3.getEmail());

        usuario.getCorreoActual().agregarDestinatario(usuario.getContactos().get(1));

        usuario.enviarCorreo(usuario.getCorreoActual(), paginaWeb);

        Buzon buzon = usuario2.getBuzon();

        Predicate<Correo> filtro1 = buzon.crearFiltroAsunto("hola");

        assertEquals("hola", buzon.buscar(filtro1).getAsunto());

    }

    @Test
    public void debeFiltrarPorRemitente() {
        LocalDate fecha = LocalDate.now();
        Registro paginaWeb = new Registro();
        Usuario usuario = new Usuario("JuanRiquelme", "1234", "JuanRiquelme", "JuanPerez@gmail.com");

        Usuario usuario2 = new Usuario("Roberto", "1234", "Roberto Perez", "RobertoPerez@gmail.com");

        paginaWeb.registrarUsuario(usuario);
        paginaWeb.registrarUsuario(usuario2);

        usuario.crearContacto(usuario2.getNombre(), usuario2.getEmail());

        usuario.crearCorreo("Buenardo", "Soy fan de coscu", usuario.getContactos().get(0), fecha);

        usuario.enviarCorreo(usuario.getCorreoActual(), paginaWeb);

        Buzon buzon = usuario2.getBuzon();

        Predicate<Correo> filtro1 = buzon.crearFiltroRemitente("JuanRiquelme");

        assertEquals("JuanRiquelme", buzon.buscar(filtro1).getRemitente().getNombre());
        


    }

    @Test
    public void debeFiltrarPorContenido() {
        LocalDate fecha = LocalDate.now();
        Registro paginaWeb = new Registro();
        Usuario usuario = new Usuario("JuanRiquelme", "1234", "JuanRiquelme", "JuanPerez@gmail.com");
        Usuario usuario2 = new Usuario("Roberto", "1234", "Roberto Perez", "RobertoPerez@gmail.com");

        paginaWeb.registrarUsuario(usuario);

        paginaWeb.registrarUsuario(usuario2);

        usuario.crearContacto(usuario2.getNombre(), usuario2.getEmail());

        usuario.crearCorreo("Buenardo", "Soy fan de coscu", usuario.getContactos().get(0), fecha);

        usuario.enviarCorreo(usuario.getCorreoActual(), paginaWeb);

        // Buzon buzon = usuario2.getBuzon();

        // assertEquals("Buenardo", buzon.buscarContenido("Buenardo").getContenido());

    }

    @Test
    public void debeFiltrarPorNombreEmailDestinatario() {
        LocalDate fecha = LocalDate.now();
        Registro paginaWeb = new Registro();
        Usuario usuario = new Usuario("JuanRiquelme", "1234", "JuanRiquelme", "JuanPerez@gmail.com");
        Usuario usuario2 = new Usuario("Roberto", "1234", "Roberto Perez", "RobertoPerez@gmail.com");

        paginaWeb.registrarUsuario(usuario);

        paginaWeb.registrarUsuario(usuario2);

        usuario.crearContacto(usuario2.getNombre(), usuario2.getEmail());

        usuario.crearCorreo("Buenardo", "Soy fan de coscu", usuario.getContactos().get(0), fecha);

        usuario.enviarCorreo(usuario.getCorreoActual(), paginaWeb);

        // Buzon buzon = usuario2.getBuzon();

        // assertEquals("Roberto Perez",
        //         buzon.buscarDestinatarioNombreEmail("Roberto Perez", "RobertoPerez@gmail.com").getPara().get(0)
        //                 .getNombre());

    }

    @Test
    public void debeFiltrarPorFechaNombreDestinatario() {
        LocalDate fecha = LocalDate.now();
        Registro paginaWeb = new Registro();
        Usuario usuario = new Usuario("JuanRiquelme", "1234", "JuanRiquelme", "JuanPerez@gmail.com");
        Usuario usuario2 = new Usuario("Roberto", "1234", "Roberto Perez", "RobertoPerez@gmail.com");

        paginaWeb.registrarUsuario(usuario);

        paginaWeb.registrarUsuario(usuario2);

        usuario.crearContacto(usuario2.getNombre(), usuario2.getEmail());

        usuario.crearCorreo("Buenardo", "Soy fan de coscu", usuario.getContactos().get(0), fecha);

        usuario.enviarCorreo(usuario.getCorreoActual(), paginaWeb);

        // Buzon buzon = usuario2.getBuzon();

        // assertEquals(fecha, buzon.buscarFechaNombreRemitente(fecha, "JuanRiquelme").getFecha());

    }

    @Test
    public void probandoNuevosFiltros(){

        Usuario usuario = new Usuario("JuanRiquelme", "1234", "JuanRiquelme", "JuanPerez@gmail.com");

        Correo correo = new Correo("Hola", "SoyFan De coscu", null, null, null);
        Correo correo2 = new Correo("Holaa", "SoyFan De momo", null, null, null);
        Correo correo3 = new Correo("Holaaa", "SoyFan De figueredo", null, null, null);
        
        usuario.getBuzon().agregarCorreo(correo);
        usuario.getBuzon().agregarCorreo(correo2);
        usuario.getBuzon().agregarCorreo(correo3);

        Predicate<Correo> filtro1 = usuario.getBuzon().crearFiltroContenido("Hola");
        Predicate<Correo> filtro2 = usuario.getBuzon().crearFiltroAsunto("SoyFan De coscu");

        
        Predicate<Correo> filtro3 = usuario.getBuzon().combinarFiltros(filtro1, filtro2);


        System.out.println(usuario.getBuzon().buscar(filtro1, filtro2).getAsunto());
        System.out.println(usuario.getBuzon().buscar(filtro3).getContenido());
        // assertEquals(, usuario.getBuzon().buscar(filtro1,filtro2));
    }
}