import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Se encarga de una sola cosa: abrir (y cerrar) la conexion con MySQL.
 * Las demas clases piden la conexion con getConexion().
 */
public class AccesoDatos implements AutoCloseable {

    private static final String MAQUINA = "localhost";
    private static final String USUARIO = "joaco";
    private static final String CLAVE = "kali";
    private static final int PUERTO = 3306;
    private static final String BASE_DATOS = "ajedrez";

    private final Connection conexion;

    public AccesoDatos() throws ClassNotFoundException, SQLException {
        registrarDriver();
        this.conexion = abrirConexion();
        System.out.println("Conectado a " + BASE_DATOS);
    }

    private void registrarDriver() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    private Connection abrirConexion() throws SQLException {
        String url = "jdbc:mysql://" + MAQUINA + ":" + PUERTO + "/" + BASE_DATOS
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        return DriverManager.getConnection(url, USUARIO, CLAVE);
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrar() throws SQLException {
        conexion.close();
    }

    @Override
    public void close() throws SQLException {
        cerrar();
    }
}