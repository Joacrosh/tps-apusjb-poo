public class Peon extends Pieza {

    public Peon() {
        super();
    }

    // Constructor con los atributos que le da el poema "Ajedrez" de Borges
    public Peon(Color color) {
        super(color, "lenta", "agresor", "ladino");
    }

    public Peon(Color color, String velocidad,
              String comportamiento, String movimiento) {

        super(color, velocidad, comportamiento, movimiento);
    }
}
