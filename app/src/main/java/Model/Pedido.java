package Model;

public class Pedido {

    //private static int idPedidos;

    private Promociones promociones;
    private int valorEnvio;
    private String destino;

    public Pedido(Promociones promocion, String destino) {
        this.promociones = promocion;
        this.valorEnvio = 0;
        this.destino = destino;
    }


    public int getValorEnvio() {
        return valorEnvio;
    }

    public void setValorEnvio(int valorEnvio) {
        this.valorEnvio = valorEnvio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
