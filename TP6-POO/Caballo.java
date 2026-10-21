public class Caballo extends Pieza {

    public Caballo() {
        super();
    }

    // Constructor con los atributos que le da el poema "Ajedrez" de Borges
    public Caballo(Color color) {
        super(color, "ligero", "", "");
    }

    public Caballo(Color color, String velocidad,
              String comportamiento, String movimiento) {

        super(color, velocidad, comportamiento, movimiento);
    }
}
