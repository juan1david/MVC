package Vista;

import controlador.Controlador;
import modelo.Materia;
import modelo.Usuario;
import modelo.Docente;
import modelo.Estudiante;
import modelo.Padre;

import java.util.Scanner;

public class Vista2 {
    private Scanner scanner;
    private Controlador controlador;

    public Vista2(Controlador controlador) {
        this.controlador = controlador;
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Seleccione su rol: \n1. Docente \n2. Estudiante \n3. Padre");
        int rolSeleccionado = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        Usuario usuario;
        switch (rolSeleccionado) {
            case 1:
                usuario = new Docente(nombre);
                menuDocente();
                break;
            case 2:
                usuario = new Estudiante(nombre);
                menuEstudiantePadre();
                break;
            case 3:
                usuario = new Padre(nombre);
                menuEstudiantePadre();
                break;
            default:
                System.out.println("Rol no válido.");
        }
    }

    private void menuDocente() {
        while (true) {
            System.out.println("Opciones para docente:");
            System.out.println("1. Agregar materia");
            System.out.println("2. Actualizar materia");
            System.out.println("3. Eliminar materia");
            System.out.println("4. Ver lista de materias");
            System.out.println("5. Buscar materia");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    Materia materiaAgregar = obtenerDatosMateria();
                    controlador.agregarMateria(materiaAgregar.getCodigo(), materiaAgregar.getNombre());
                    break;
                case 2:
                    System.out.print("Ingrese el código de la materia a actualizar: ");
                    String codigoActualizar = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre de la materia: ");
                    String nuevoNombre = scanner.nextLine();
                    controlador.actualizarMateria(codigoActualizar, nuevoNombre);
                    break;
                case 3:
                    String codigoEliminar = obtenerCodigoMateria();
                    controlador.eliminarMateria(codigoEliminar);
                    break;
                case 4:
                    controlador.listarMaterias();
                    break;
                case 5:
                    String codigoBuscar = obtenerCodigoMateria();
                    Materia materiaBuscada = controlador.buscarMateria(codigoBuscar);
                    if (materiaBuscada != null) {
                        mostrarMateria(materiaBuscada);
                    } else {
                        System.out.println("Materia no encontrada.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void menuEstudiantePadre() {
        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Ver lista de materias");
            System.out.println("2. Buscar materia");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    controlador.listarMaterias();
                    break;
                case 2:
                    String codigoBuscar = obtenerCodigoMateria();
                    Materia materiaBuscada = controlador.buscarMateria(codigoBuscar);
                    if (materiaBuscada != null) {
                        mostrarMateria(materiaBuscada);
                    } else {
                        System.out.println("Materia no encontrada.");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public Materia obtenerDatosMateria() {
        System.out.print("Ingrese el código de la materia: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese el nombre de la materia: ");
        String nombre = scanner.nextLine();

        return new Materia(codigo, nombre);
    }

    public String obtenerCodigoMateria() {
        System.out.print("Ingrese el código de la materia: ");
        return scanner.nextLine();
    }

    public void mostrarMateria(Materia materia) {
        System.out.println(materia);
    }
}
