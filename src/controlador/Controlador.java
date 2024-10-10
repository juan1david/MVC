package controlador;

import modelo.Materia;
import modelo.gestionMaterias;

public class Controlador {

    private gestionMaterias gestionMaterias;

    public Controlador(gestionMaterias gestionMaterias) {
        this.gestionMaterias = gestionMaterias;
    }

    public boolean agregarMateria(String codigo, String nombre) {
        Materia materia = new Materia(codigo, nombre);
        return gestionMaterias.agregarMateria(materia);
    }

    public boolean actualizarMateria(String codigo, String nombre) {
        return gestionMaterias.actualizarMateria(codigo, nombre);
    }

    public boolean eliminarMateria(String codigo) {
        return gestionMaterias.eliminarMateria(codigo);
    }

    public Materia buscarMateria(String codigo) {
        return gestionMaterias.buscarMateria(codigo);
    }

    public void listarMaterias() {
        gestionMaterias.listarMaterias();
    }
}
