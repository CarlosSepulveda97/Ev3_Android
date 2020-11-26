package Model;

public class Cliente {

    private String id;
    private String nombre;
    private String promo;
    private String destino;

    public Cliente(String id, String nombre, String promo, String destino) {
        this.id = id;
        this.nombre = nombre;
        this.promo = promo;
        this.destino = destino;
    }

    public Cliente() {
    }

    @Override
    public String toString(){
        return this.nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
