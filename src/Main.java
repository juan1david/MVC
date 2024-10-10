import modelo.gestionMaterias;
import Vista.Vista2;
import controlador.Controlador;

public class Main {
    public static void main(String[] args) {
        gestionMaterias gestionMaterias = new gestionMaterias();
        Controlador controlador = new Controlador(gestionMaterias);
        Vista2 vista = new Vista2(controlador);
        vista.iniciar();
    }
}
