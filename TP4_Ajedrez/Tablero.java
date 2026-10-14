public class Tablero {

    public static final int TAMANIO = 8;
    public static final int PIEZAS_POR_COLOR = 2 * TAMANIO;

    private Casillero[][] casilleros;

    // Constructor vacío: crea los 64 casilleros
    public Tablero() {
        this.casilleros = new Casillero[TAMANIO][TAMANIO];
        inicializarCasilleros();
    }

    // Constructor completo
    public Tablero(Casillero[][] casilleros) {
        this.casilleros = casilleros;
    }

    // Getter
    public Casillero[][] getCasilleros() {
        return casilleros;
    }

    // Setter
    public void setCasilleros(Casillero[][] casilleros) {
        this.casilleros = casilleros;
    }

    // fila y columna van de 0 a 7 (fila 0 = fila 1 del tablero, columna 0 = A)
    public Casillero getCasillero(int fila, int columna) {
        return casilleros[fila][columna];
    }

    // Crea las piezas y las ubica en la posición inicial de una partida.
    // Las blancas ocupan las filas 1 y 2, las negras las filas 8 y 7.
    public void colocarPiezasIniciales() {
        colocarPiezas(Color.BLANCO, 0, 1);
        colocarPiezas(Color.NEGRO, 7, 6);
    }

    // Muestra el tablero visto desde las blancas: la fila 8 arriba y la 1 abajo
    public void mostrarTablero() {

        for (int fila = TAMANIO - 1; fila >= 0; fila--) {
            System.out.print((fila + 1) + " ");
            for (int columna = 0; columna < TAMANIO; columna++) {
                System.out.print(casilleros[fila][columna].getContenido() + " ");
            }
            System.out.println();
        }

        // Letras de las columnas, centradas debajo de cada casillero
        System.out.print("  ");
        for (int columna = 0; columna < TAMANIO; columna++) {
            System.out.print("   " + (char) ('A' + columna) + "    ");
        }
        System.out.println();
    }

    // Devuelve las piezas de un color que están en el tablero
    public Pieza[] getPiezas(Color color) {

        Pieza[] piezas = new Pieza[PIEZAS_POR_COLOR];
        int cantidad = 0;

        for (int fila = 0; fila < TAMANIO; fila++) {
            for (int columna = 0; columna < TAMANIO; columna++) {

                Casillero casillero = casilleros[fila][columna];

                if (casillero.estaOcupado()
                        && casillero.getPieza().getColor() == color) {
                    piezas[cantidad] = casillero.getPieza();
                    cantidad++;
                }
            }
        }

        return piezas;
    }

    // Pone la fila de atrás (de A a H) y la fila de peones de un color
    private void colocarPiezas(Color color, int filaPrincipal, int filaPeones) {

        Pieza[] principales = {
            new Torre(color), new Caballo(color), new Alfil(color),
            new Reina(color), new Rey(color),
            new Alfil(color), new Caballo(color), new Torre(color)
        };

        for (int columna = 0; columna < TAMANIO; columna++) {
            casilleros[filaPrincipal][columna].setPieza(principales[columna]);
            casilleros[filaPeones][columna].setPieza(new Peon(color));
        }
    }

    private void inicializarCasilleros() {

        for (int fila = 0; fila < TAMANIO; fila++) {
            for (int columna = 0; columna < TAMANIO; columna++) {

                String coordenada =
                    String.valueOf((char) ('A' + columna)) + (fila + 1);

                Color color;

                // A1 es negro y los colores se van alternando
                if ((fila + columna) % 2 == 0) {
                    color = Color.NEGRO;
                } else {
                    color = Color.BLANCO;
                }

                this.casilleros[fila][columna] =
                    new Casillero(color, coordenada);
            }
        }
    }
}
