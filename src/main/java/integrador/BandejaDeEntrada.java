package integrador;
import java.util.*;

public class BandejaDeEntrada {
    ArrayList<Correo> correosNoLeidos = new ArrayList<Correo>();
    ArrayList<Correo> correosLeidos = new ArrayList<Correo>();

    public BandejaDeEntrada() {
    }

    public ArrayList<Correo> getCorreosNoLeidos() {
        return correosNoLeidos;
    }
    public ArrayList<Correo> getCorreosLeidos() {
        return correosLeidos;
    }

    

}
