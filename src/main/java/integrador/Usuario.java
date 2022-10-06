package integrador;
import java.util.*;

public class Usuario {
    

    private String usuario;
    private String password;
    private String nombre;
    private String email;
    ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    

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

    public void crearCorreo() {
        //Pedir datos para crear correo
        Scanner sc = new Scanner(System.in);

        if (contactos.isEmpty()) {
            System.out.println("No tiene contactos");
        } else {
            System.out.println("Ingrese el asunto");
            String asunto = sc.nextLine();
            System.out.println("Ingrese el contenido");
            String contenido = sc.nextLine();
            System.out.println("Ingrese el destinatario");
            String destinatario = sc.nextLine();
            Contacto para = buscarContacto(destinatario);
            if (para == null) {
                System.out.println("No existe el contacto");
            } else {
                Correo correo = new Correo(contenido, asunto, this, para);
                System.out.println("Correo creado");
            }
        }   
    }

    public void crearContacto() {
        //Pedir datos para crear contacto
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el apellido");
        String apellido = sc.nextLine();
        System.out.println("Ingrese el email");
        String email = sc.nextLine();
        Contacto contacto = new Contacto(nombre, apellido, email);
        contactos.add(contacto);
        System.out.println("Contacto creado");
    }

    public Contacto buscarContacto(String email) {
        for (Contacto contacto : contactos) {
            if (contacto.getEmail().equals(email)) {
                return contacto;
            }
        }
        return null;
    }

    public void mostrarContactos() {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", password=" + password + ", nombre=" + nombre + ", email=" + email + ", contactos=" + contactos + '}';
    }
    
    
    
}
