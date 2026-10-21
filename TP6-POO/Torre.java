public class Torre extends Pieza {

    public Torre() {
        super();
    }

    // Constructor con los atributos que le da el poema "Ajedrez" de Borges
    public Torre(Color color) {
        super(color, "lenta", "homérica", "directa");
    }

    public Torre(Color color, String velocidad,
              String comportamiento, String movimiento) {

        super(color, velocidad, comportamiento, movimiento);
    }
}
