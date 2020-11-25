package Model;

public class Promociones {

    private String nombrePromocion;
    private int precio;

    public Promociones(String s, int i) {
        this.nombrePromocion = s;
        this.precio = i;
    }


    public String getNombrePromocion() {
        return nombrePromocion;
    }

    public int getPrecio() {
        return precio;
    }

}
