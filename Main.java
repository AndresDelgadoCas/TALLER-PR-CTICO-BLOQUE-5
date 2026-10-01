import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante(
            "123456789",
            "Andres",
            "andres@correo.com",
            "EST001",
            "Ingenieria de Software"
        );

        Libro libro = new Libro(
            "978-1234567890",
            "Introduccion a Java"
        );

        Ejemplar ejemplar = new Ejemplar(
            "EJ001",
            libro
        );

        Prestamo prestamo = new Prestamo(
            estudiante,
            ejemplar,
            LocalDate.of(2026, 10, 10)
        );

        System.out.println("=== SMARTLIBRARY ===");
        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Fecha inicial de devolucion: "
                + prestamo.getFechaPrevistaDevolucion());

        System.out.println("\n=== RENOVACION VALIDA ===");

        try {
            prestamo.renovar(LocalDate.of(2026, 10, 15));
            estudiante.notificar("Su prestamo fue renovado.");

            System.out.println("Nueva fecha de devolucion: "
                    + prestamo.getFechaPrevistaDevolucion());
            System.out.println("Cantidad de renovaciones: "
                    + prestamo.getRenovaciones().size());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== RENOVACION INVALIDA ===");

        try {
            prestamo.renovar(LocalDate.of(2026, 10, 12));
            System.out.println("La renovacion fue aceptada.");

        } catch (IllegalArgumentException e) {
            System.out.println("Renovacion rechazada correctamente.");
            System.out.println("Motivo: " + e.getMessage());
        }
    }
}
