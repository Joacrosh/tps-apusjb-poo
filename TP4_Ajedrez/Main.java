public class Main {

    public static void main(String[] args) {

        // Crear el tablero con sus 64 casilleros y ubicar las piezas
        Tablero tablero = new Tablero();
        tablero.colocarPiezasIniciales();

        // Mostrar el tablero armado
        System.out.println("TABLERO");
        tablero.mostrarTablero();

        // Imprimir las piezas de cada color
        imprimirPiezas(tablero, Color.BLANCO);
        imprimirPiezas(tablero, Color.NEGRO);
    }

    private static void imprimirPiezas(Tablero tablero, Color color) {

        Pieza[] piezas = tablero.getPiezas(color);

        System.out.println();
        System.out.println(
            "PIEZAS DE COLOR " + color.getNombre().toUpperCase()
            + " (" + piezas.length + ")"
        );

        for (Pieza pieza : piezas) {
            System.out.println(pieza.getDescripcion());
            System.out.println("--------------------");
        }
    }
}
