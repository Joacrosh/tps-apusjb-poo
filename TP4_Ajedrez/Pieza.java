public abstract class Pieza {  // superclase

    //atributtos

    private Color color;
    private String velocidad;
    private String comportamiento;
    private String movimiento;

    // constructores

    public Pieza(){

    }

    public Pieza(Color color, String velocidad, String comportamiento, String movimiento){

        this.color = color;
        this.velocidad = velocidad;
        this.comportamiento = comportamiento;
        this.movimiento = movimiento;


    }

    // getters y setters

    public Color getColor (){
        return color;
    }

    public void setColor(Color color){

        this.color = color;
    }

    public String getVelocidad (){
        return velocidad;
    }

    public void setVelocidad(String velocidad){
        this.velocidad = velocidad;
    }

    public String getComportamiento (){
        return comportamiento;
    }

    public void setComportamiento(String comportamiento){
        this.comportamiento = comportamiento;
    }

    public String getMovimiento (){
        return movimiento;
    }

    public void setMovimiento(String movimiento){
        this.movimiento = movimiento;
    }

    // métodos

    public String getTipo(){
        return getClass().getSimpleName();
    }

    // Texto corto para el tablero: tres letras del tipo y la inicial del color.
    // Por ejemplo "Tor B" (torre blanca) o "Rey N" (rey negro).
    public String getAbreviatura(){
        return getTipo().substring(0, 3) + " " + color.getInicial();
    }

    // Arma un texto con todos los datos de la pieza
    public String getDescripcion(){
        return "Tipo: " + getTipo()
            + "\nColor: " + color.getNombre()
            + "\nVelocidad: " + mostrarValor(velocidad)
            + "\nComportamiento: " + mostrarValor(comportamiento)
            + "\nMovimiento: " + mostrarValor(movimiento);
    }

    // Si el poema no menciona el atributo, se muestra un guion
    private String mostrarValor(String valor){
        if (valor == null || valor.isEmpty()) {
            return "-";
        }
        return valor;
    }
}
