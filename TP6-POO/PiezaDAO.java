import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase de acceso a datos para la tabla 'pieza'.
 * Contiene los metodos para insertar y listar piezas en la BD.
 */
public class PiezaDAO {

    
    // Punto 3 del TP: método de inserción
   

    /**
     * Borra todas las piezas de la tabla 'pieza'.
     * Se llama antes de insertar, asi al ejecutar el programa otra vez
     * no se duplican las piezas (la BD no permite dos piezas en la misma
     * posicion).
     *
     * @param conexion  la conexion abierta a la BD
     */
    public void borrarPiezas(Connection conexion) throws SQLException {

        try (Statement st = conexion.createStatement()) {
            st.executeUpdate("DELETE FROM pieza");
        }
    }

    /**
     * Inserta una pieza en la tabla 'pieza' usando PreparedStatement.
     *
     * @param conexion  la conexion abierta a la BD
     * @param pieza     la pieza a insertar (con color y atributos de Borges)
     * @param posicion  la coordenada del casillero donde está (ej: "A1")
     */
    public void insertarPieza(Connection conexion, Pieza pieza, String posicion)
            throws SQLException {

        String sql = "INSERT INTO pieza "
                + "(Descripcion, idColor, idTipoPieza, Posicion, "
                + " Movimiento, Comportamiento, Velocidad, Fecha_Creacion) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, CURDATE())";  // fecha de hoy

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, pieza.getDescripcionBD());   // "Torre Blanca"
            ps.setInt(2, pieza.getColor().getIdColor());  // 1 o 2
            ps.setInt(3, pieza.getIdTipoPieza());         // 1..6
            ps.setString(4, posicion);                    // "A1"
            ps.setString(5, pieza.getMovimiento());       // del poema
            ps.setString(6, pieza.getComportamiento());   // del poema
            ps.setString(7, pieza.getVelocidad());        // del poema

            ps.executeUpdate();
        }
    }

    // Punto 4 del TP: método de listado
    
    /**
     * Lee todas las piezas de la tabla 'pieza' (con JOIN a color y tipopieza)
     * y las muestra por consola.
     *
     * @param conexion  la conexion abierta a la BD
     */
    public void listarPiezas(Connection conexion) throws SQLException {

        String sql = "SELECT p.idPieza, p.Descripcion, "
                + "       c.Descripcion AS Color, "
                + "       t.Descripciondepieza AS Tipo, "
                + "       p.Posicion, p.Movimiento, "
                + "       p.Comportamiento, p.Velocidad, p.Fecha_Creacion "
                + "FROM pieza p "
                + "JOIN color c      ON p.idColor     = c.idColor "
                + "JOIN tipopieza t  ON p.idTipoPieza = t.idTipoPieza "
                + "ORDER BY p.idPieza";

        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("=== Piezas en la base de datos ===");
            System.out.println();

            while (rs.next()) {
                int id              = rs.getInt("idPieza");
                String descripcion  = rs.getString("Descripcion");
                String color        = rs.getString("Color");
                String tipo         = rs.getString("Tipo");
                String posicion     = rs.getString("Posicion");
                String movimiento   = rs.getString("Movimiento");
                String comportamiento = rs.getString("Comportamiento");
                String velocidad    = rs.getString("Velocidad");
                String fecha        = rs.getString("Fecha_Creacion");

                System.out.println("Pieza #" + id + ": " + descripcion);
                System.out.println("  Color: " + color
                        + " | Tipo: " + tipo
                        + " | Posicion: " + posicion);
                System.out.println("  Movimiento: " + movimiento
                        + " | Comportamiento: " + comportamiento
                        + " | Velocidad: " + velocidad);
                System.out.println("  Fecha de creacion: " + fecha);
                System.out.println();
            }
        }
    }
}