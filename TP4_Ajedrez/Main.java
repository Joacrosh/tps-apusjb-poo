public class Main {

    public static void main(String[] args) {

        // Crear el tablero con sus 64 casilleros
        Tablero tablero = new Tablero();

        // Mostrar los casilleros
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {

                Casillero casillero =
                    tablero.getCasillero()[fila][columna];

                System.out.print(
                    casillero.getCoordenadas()
                    + "-"
                    + casillero.getColor()
                    + " "
                );
            }

            System.out.println();
        }

        // Crear las piezas de ambos colores
        Pieza[] piezasBlancas = crearPiezas("blanco");
        Pieza[] piezasNegras = crearPiezas("negro");

        System.out.println();
        System.out.println(
            "Cantidad de piezas blancas: "
            + piezasBlancas.length
        );

        System.out.println(
            "Cantidad de piezas negras: "
            + piezasNegras.length
        );

        // Imprimir las piezas blancas
        System.out.println();
        System.out.println("PIEZAS BLANCAS");
        imprimirPiezas(piezasBlancas);

        // Imprimir las piezas negras
        System.out.println();
        System.out.println("PIEZAS NEGRAS");
        imprimirPiezas(piezasNegras);
    }

    private static Pieza[] crearPiezas(String color) {

        Pieza[] piezas = new Pieza[16];

        piezas[0] = new Torre(
            color, "lenta", "homérica", "directa"
        );

        piezas[1] = new Caballo(
            color, "ligero", "", ""
        );

        piezas[2] = new Alfil(
            color, "lenta", "oblicuo", "sesgo"
        );

        piezas[3] = new Reina(
            color, "lenta", "armada", "encarnizada"
        );

        piezas[4] = new Rey(
            color, "lenta", "tenue", "postrero"
        );

        piezas[5] = new Alfil(
            color, "lenta", "oblicuo", "sesgo"
        );

        piezas[6] = new Caballo(
            color, "ligero", "", ""
        );

        piezas[7] = new Torre(
            color, "lenta", "homérica", "directa"
        );

        for (int i = 8; i < 16; i++) {
            piezas[i] = new Peon(
                color, "lenta", "agresor", "ladino"
            );
        }

        return piezas;
    }

    private static void imprimirPiezas(Pieza[] piezas) {

        for (Pieza pieza : piezas) {

            System.out.println(
                "Tipo: "
                + pieza.getClass().getSimpleName()
            );

            System.out.println(
                "Color: " + pieza.getColor()
            );

            System.out.println(
                "Velocidad: " + pieza.getVelocidad()
            );

            System.out.println(
                "Comportamiento: "
                + pieza.getComportamiento()
            );

            System.out.println(
                "Movimiento: "
                + pieza.getMovimiento()
            );

            System.out.println("--------------------");
        }
    }
}
