
public class Flor {

    //  ATRIBUTOS 
    private String actitud;      
    private String apariencia;   
    private String estado;      
    private int cantidadOrugas; 

    //  CONSTRUCTORES 

    // 1c: Constructor vacío -> permite instanciar sin pasar valores
    public Flor() {
    }
    //Este no hace nada explícito, pero permite escribir new Flor(). El objeto se crea con los valores por defecto de Java (null para Strings, 0 para int)
    //Sirve para cuando querés crear el objeto primero y cargarle los datos después con los setters.

    // 1d: Constructor que recibe TODOS los valores y los asigna a cada atributo
    public Flor(String actitud, String apariencia, String estado, int cantidadOrugas) {
        this.actitud = actitud;
        this.apariencia = apariencia;
        this.estado = estado;
        this.cantidadOrugas = cantidadOrugas;
    }

    //  GETTERS Y SETTERS (1b) 

    //Getter: devuelve el valor del atributo (lectura):
    //primer se pone public y luego se indica el tipo de dato
    public String getActitud() {
        return actitud;
    }

    //Setter: modifica el valor del atributo (escritura):

    // El set no retorna nada pero si asigna 
    public void setActitud(String actitud) { 
        this.actitud = actitud;
    }

    public String getApariencia() {
        return apariencia;
    }

    public void setApariencia(String apariencia) {
        this.apariencia = apariencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadOrugas() {
        return cantidadOrugas;
    }

    public void setCantidadOrugas(int cantidadOrugas) {
        this.cantidadOrugas = cantidadOrugas;
    }

    
    public void imprimirTextoDinamico() {
        // Armo el texto concatenando (+) las variables.
        String texto = "El principito tenía una flor que amaba mucho. Cuidaba de ella todos los " +
                       "días, la regaba y le quitaba las " + this.cantidadOrugas + " orugas. La flor, aunque un poco " +
                       this.actitud + ", era muy " + this.apariencia + 
                       " y agradecía al principito por su dedicación. Un día, el " +
                       "principito decidió explorar otros planetas y, aunque no quería dejar " +
                       this.estado + " a su flor, sabía que debía continuar su viaje para " +
                       "aprender más sobre el universo.";
        
        System.out.println(texto);
    }
}
