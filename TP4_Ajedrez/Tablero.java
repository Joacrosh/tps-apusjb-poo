public class Tablero {

    private Casillero[][] casillero;

    // Constructor vacío
    public Tablero() {
        this.casillero = new Casillero[8][8];
        inicializarCasilleros();
    }

    // Constructor completo
    public Tablero(Casillero[][] casillero) {
        this.casillero = casillero;
    }

    // Getter
    public Casillero[][] getCasillero() {
        return casillero;
    }

    // Setter
    public void setCasillero(Casillero[][] casillero) {
        this.casillero = casillero;
    }

    private void inicializarCasilleros() {

        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {

                String coordenada =
                    String.valueOf((char) ('A' + columna)) + (fila + 1);

                String color;

                if ((fila + columna) % 2 == 0) {
                    color = "negro";
                } else {
                    color = "blanco";
                }

                this.casillero[fila][columna] =
                    new Casillero(color, coordenada);
            }
        }
    }
}