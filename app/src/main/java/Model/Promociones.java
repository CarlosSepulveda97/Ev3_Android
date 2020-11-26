package Model;

public enum Promociones {

    PROMO("Pizzas promo", 5990),MASTER("Master pizza", 12990),MAX("Pizza max", 18500);

    private String nombre;
    private int costo;


    private Promociones(String s, int i) {
        this.costo=i;
        this.nombre=s;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCosto() {
        return costo;
    }

}
