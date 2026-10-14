public class Alfil extends Pieza {

    public Alfil() {
        super();
    }

    // Constructor con los atributos que le da el poema "Ajedrez" de Borges
    public Alfil(Color color) {
        super(color, "lenta", "oblicuo", "sesgo");
    }

    public Alfil(Color color, String velocidad,
              String comportamiento, String movimiento) {

        super(color, velocidad, comportamiento, movimiento);
    }
}
