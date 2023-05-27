package Model;



public class Ruta {
    private Ciudad destino;
    private int tiempoNormal;
    private int tiempoLluvia;
    private int tiempoNieve;
    private int tiempoTormenta;

    public Ruta(Ciudad destino, int tiempoNormal, int tiempoLluvia, int tiempoNieve, int tiempoTormenta) {
        this.destino = destino;
        this.tiempoNormal = tiempoNormal;
        this.tiempoLluvia = tiempoLluvia;
        this.tiempoNieve = tiempoNieve;
        this.tiempoTormenta = tiempoTormenta;
    }

    public Ciudad getDestino() {
        return destino;
    }


    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public int getTiempoNormal() {
        return tiempoNormal;
    }

    public void setTiempoNormal(int tiempoNormal) {
        this.tiempoNormal = tiempoNormal;
    }

    public int getTiempoLluvia() {
        return tiempoLluvia;
    }

    public void setTiempoLluvia(int tiempoLluvia) {
        this.tiempoLluvia = tiempoLluvia;
    }

    public int getTiempoNieve() {
        return tiempoNieve;
    }

    public void setTiempoNieve(int tiempoNieve) {
        this.tiempoNieve = tiempoNieve;
    }

    public int getTiempoTormenta() {
        return tiempoTormenta;
    }

    public void setTiempoTormenta(int tiempoTormenta) {
        this.tiempoTormenta = tiempoTormenta;
    }
}