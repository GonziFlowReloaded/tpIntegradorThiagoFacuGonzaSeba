package integrador;
import java.util.*;
import java.util.function.Predicate;

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
        ArrayList<Contacto> para = new ArrayList<Contacto>();
        Boolean flag = true;
        //Pedir datos para crear correo
        Scanner sc = new Scanner(System.in);


        if (contactos.isEmpty()) {
            System.out.println("No tiene contactos");
        } else {
            System.out.println("Ingrese el asunto");
            //String asunto = sc.nextLine();
            String asunto = "asunto";
            System.out.println("Ingrese el contenido");
            //String contenido = sc.nextLine();
            String contenido = "contenido";
            
            while(flag){
                System.out.println("Ingrese el destinatario");
                String destinatario = sc.nextLine();
                Contacto destinatariosAux = buscarContacto(destinatario);
                if(destinatariosAux != null){
                    para.add(destinatariosAux);}
                else{
                    System.out.println("No existe el destinatario");
                }
                System.out.println("Desea agregar otro destinatario? (s/n)");
                String respuesta = sc.nextLine();
                if(respuesta.equals("n")){
                    flag = false;
                }
            }
            sc.close();

            Correo correo = new Correo(contenido, asunto, this, para);
            System.out.println("Correo creado");
        }   
    }

    public void crearContacto() {
        //Pedir datos para crear contacto
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el email");
        String email = sc.nextLine();
        Contacto contacto = new Contacto(nombre, email);
        contactos.add(contacto);
        sc.close();
        System.out.println("Contacto creado");
    }

    public Contacto buscarContacto(String email) {
        Predicate<Contacto> p = c -> c.getEmail().equals(email);
        return contactos.stream().filter(p).findFirst().orElse(null);
    }

    public void mostrarContactos() {
        for (Contacto contacto : contactos) {
            System.out.println(contacto.toString());
        }
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }
    
    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    





    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", password=" + password + ", nombre=" + nombre + ", email=" + email + ", contactos=" + contactos + '}';
    }
    

    
}
