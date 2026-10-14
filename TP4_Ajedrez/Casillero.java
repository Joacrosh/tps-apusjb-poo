public class Casillero {

    // atributos
    private Color color;
    private String coordenadas;
    private Pieza pieza; // null si el casillero está vacío

    //constructores

    public Casillero(){

    }

    public Casillero(Color color, String coordenadas){
        this.color = color;
        this.coordenadas = coordenadas;

    }

    // getters y setters

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){

        this.color = color;
    }

    public String getCoordenadas(){

        return coordenadas;
    }

    public void setCoordenadas(String coordenadas){

        this.coordenadas = coordenadas;
    }

    public Pieza getPieza(){
        return pieza;
    }

    public void setPieza(Pieza pieza){
        this.pieza = pieza;
    }

    // métodos

    public boolean estaOcupado(){
        return pieza != null;
    }

    // Lo que se ve del casillero en el tablero: la pieza si está ocupado,
    // o su propio color si está vacío. Siempre mide 7 caracteres.
    public String getContenido(){
        if (estaOcupado()) {
            return "[" + pieza.getAbreviatura() + "]";
        }
        return "[  " + color.getInicial() + "  ]";
    }
}
