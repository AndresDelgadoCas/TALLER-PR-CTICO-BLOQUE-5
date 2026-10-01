public class Ejemplar {

    private String codigo;
    private Libro libro;

    public Ejemplar(String codigo, Libro libro) {
        this.codigo = codigo;
        this.libro = libro;
    }

    public String getCodigo() {
        return codigo;
    }

    public Libro getLibro() {
        return libro;
    }
}
