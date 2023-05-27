package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class FloydWarshall {
    private int[][] distancias;
    private String[][] caminos;
    private String[] vertices;

    public FloydWarshall(int[][] distancias, String[] vertices) {
        this.distancias = distancias;
        this.vertices = vertices;
        this.caminos = new String[vertices.length][vertices.length];
        calcularCaminos();
    }

    private void calcularCaminos() {
        for (int k = 0; k < vertices.length; k++) {
            for (int i = 0; i < vertices.length; i++) {
                for (int j = 0; j < vertices.length; j++) {
                    if (distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                        caminos[i][j] = vertices[k];
                    }
                }
            }
        }
    }

    public int[][] getDistancias() {
        return distancias;
    }

    public String[] getVertices() {
        return vertices;
    }

    public String[][] getCaminos() {
        return caminos;
    }

    public int getIndiceDeCiudad(String nombreCiudad) {
        return Arrays.asList(vertices).indexOf(nombreCiudad);
    }
}
