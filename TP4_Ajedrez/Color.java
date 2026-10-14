// Los dos colores del ajedrez: se usan para los casilleros y para las piezas
public enum Color {

    BLANCO("blanco"),
    NEGRO("negro");

    private final String nombre;

    Color(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // "B" o "N", para mostrar el color en el tablero
    public String getInicial() {
        return nombre.substring(0, 1).toUpperCase();
    }
}
