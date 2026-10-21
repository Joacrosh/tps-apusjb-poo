import java.sql.Connection;
import java.sql.SQLException;

/**
 * TP6 - Persistencia de Ajedrez en BD
 *
 * 1. Crea el tablero con las 32 piezas en posicion inicial.
 * 2. Recorre el tablero e inserta cada pieza en la BD (INSERT con PreparedStatement).
 * 3. Lee todas las piezas de la BD y las muestra por consola (SELECT con Statement).
 */
public class App {

    public static void main(String[] args) {

        // --- Paso 1: armar el tablero ---
        Tablero tablero = new Tablero();
        tablero.colocarPiezasIniciales();

        System.out.println("Tablero armado:");
        tablero.mostrarTablero();
        System.out.println();

        // --- Paso 2 y 3: conectar a la BD, insertar y listar ---
        try (AccesoDatos acceso = new AccesoDatos()) {

            Connection conexion = acceso.getConexion();
            PiezaDAO dao = new PiezaDAO();

            // Insertar las 32 piezas recorriendo el tablero
            int insertadas = 0;
            for (int fila = 0; fila < Tablero.TAMANIO; fila++) {
                for (int col = 0; col < Tablero.TAMANIO; col++) {

                    Casillero casillero = tablero.getCasillero(fila, col);

                    if (casillero.estaOcupado()) {
                        Pieza pieza = casillero.getPieza();
                        String posicion = casillero.getCoordenadas();

                        dao.insertarPieza(conexion, pieza, posicion);
                        insertadas++;
                    }
                }
            }

            System.out.println("Se insertaron " + insertadas + " piezas en la BD.");
            System.out.println();

            // Listar todo lo que hay en la tabla pieza
            dao.listarPiezas(conexion);

        } catch (ClassNotFoundException e) {
            System.out.println("No se encontro el driver de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
    }
}