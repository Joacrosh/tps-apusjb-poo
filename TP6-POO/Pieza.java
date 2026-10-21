import java.util.Map;

public abstract class Pieza {  // superclase

    // Mapeo entre el nombre de la subclase y el idTipoPieza en la BD.
    // Los valores coinciden con la tabla 'tipopieza'.
    private static final Map<String, Integer> TIPO_A_ID = Map.of(
        "Reina", 1, "Rey", 2, "Torre", 3,
        "Alfil", 4, "Caballo", 5, "Peon", 6
    );

    // atributos

    private int idPieza;           // PK en la BD; 0 mientras no se haya guardado/leido
    private Color color;
    private String velocidad;
    private String comportamiento;
    private String movimiento;

    // constructores

    public Pieza() {
    }

    public Pieza(Color color, String velocidad, String comportamiento, String movimiento) {
        this.color = color;
        this.velocidad = velocidad;
        this.comportamiento = comportamiento;
        this.movimiento = movimiento;
    }

    // getters y setters

    public int getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(int idPieza) {
        this.idPieza = idPieza;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    // métodos

    // Devuelve el nombre de la subclase: "Torre", "Rey", etc.
    public String getTipo() {
        return getClass().getSimpleName();
    }

    // Devuelve el idTipoPieza que usa la BD para este tipo de pieza
    public int getIdTipoPieza() {
        return TIPO_A_ID.get(getTipo());
    }

    // Arma la descripcion tal como la guarda la BD: "Torre Blanca", "Peon Negro"
    public String getDescripcionBD() {
        String nombre = color.getNombre();
        String nombreCapitalizado = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
        return getTipo() + " " + nombreCapitalizado;
    }

    // Texto corto para el tablero: tres letras del tipo y la inicial del color.
    // Por ejemplo "Tor B" (torre blanca) o "Rey N" (rey negro).
    public String getAbreviatura() {
        return getTipo().substring(0, 3) + " " + color.getInicial();
    }

    // Arma un texto con todos los datos de la pieza
    public String getDescripcion() {
        return "Tipo: " + getTipo()
            + "\nColor: " + color.getNombre()
            + "\nVelocidad: " + mostrarValor(velocidad)
            + "\nComportamiento: " + mostrarValor(comportamiento)
            + "\nMovimiento: " + mostrarValor(movimiento);
    }

    // Si el poema no menciona el atributo, se muestra un guion
    private String mostrarValor(String valor) {
        if (valor == null || valor.isEmpty()) {
            return "-";
        }
        return valor;
    }
}