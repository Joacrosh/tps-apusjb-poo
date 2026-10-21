public class Reina extends Pieza {

    public Reina() {
        super();
    }

    // Constructor con los atributos que le da el poema "Ajedrez" de Borges
    public Reina(Color color) {
        super(color, "lenta", "armada", "encarnizada");
    }

    public Reina(Color color, String velocidad,
              String comportamiento, String movimiento) {

        super(color, velocidad, comportamiento, movimiento);
    }
}
