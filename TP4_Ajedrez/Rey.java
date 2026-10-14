public class Rey extends Pieza {

    public Rey() {
        super();
    }

    // Constructor con los atributos que le da el poema "Ajedrez" de Borges
    public Rey(Color color) {
        super(color, "lenta", "tenue", "postrero");
    }

    public Rey(Color color, String velocidad,
              String comportamiento, String movimiento) {

        super(color, velocidad, comportamiento, movimiento);
    }
}
