// Los dos colores del ajedrez: se usan para los casilleros y para las piezas
public enum Color {

    BLANCO("blanco", 1),
    NEGRO("negro", 2);

    private final String nombre;
    private final int idColor;  // coincide con idColor en la tabla 'color' de la BD

    Color(String nombre, int idColor) {
        this.nombre = nombre;
        this.idColor = idColor;
    }

    public String getNombre() {
        return nombre;
    }

    // Devuelve el id que usa la BD para este color (1 = Blanco, 2 = Negro)
    public int getIdColor() {
        return idColor;
    }

    // "B" o "N", para mostrar el color en el tablero
    public String getInicial() {
        return nombre.substring(0, 1).toUpperCase();
    }
}