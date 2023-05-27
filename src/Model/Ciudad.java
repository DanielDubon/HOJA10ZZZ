package Model;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    private String nombre;
    private int indice;
    private List<Ruta> rutas;


    public int getIndice() { return indice; }
    public void setIndice(int indice) {
        this.indice = indice;
    }
    public Ciudad(String nombre) {
        this.nombre = nombre;
        this.rutas = new ArrayList<>();
    }

    public void addRuta(Ruta ruta) {
        rutas.add(ruta);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Ruta> getRutas() {
        return rutas;
    }

    public Ruta getRuta(Ciudad ciudadDestino) {
        for (Ruta ruta : rutas) {
            if (ruta.getDestino().equals(ciudadDestino)) {
                return ruta;
            }
        }
        return null; // Devuelve null si no se encuentra la ruta
    }


}