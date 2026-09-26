
public class Principito {

    //  ATRIBUTOS
    private Flor florPrincipito;              //  la flor propia del Principito

    // CONSTRUCTORES

    // Constructor vacío
    public Principito() {
    }

    //  Constructor con todos los valores como parámetro
    public Principito( Flor flor) {
        this.florPrincipito = flor;
    }

    //  GETTERS Y SETTERS  
    

    public Flor getFlor() {
        return florPrincipito;
    }

    public void setFlor(Flor flor) {
        this.florPrincipito = flor;
    }

    // Método punto 3
    public void imprimirFlorPrincipito() {
        System.out.println("\n ATRIBUTOS DE LA FLOR DEL PRINCIPITO ");
        
            System.out.println("Actitud: " + this.florPrincipito.getActitud());
        System.out.println("Apariencia: " + this.florPrincipito.getApariencia());
        System.out.println("Estado: " + this.florPrincipito.getEstado());
        System.out.println("Cantidad de Orugas: " + this.florPrincipito.getCantidadOrugas());
    }


}
