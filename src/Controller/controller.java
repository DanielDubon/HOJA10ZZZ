package Controller;

import Model.Ciudad;
import Model.Ruta;

import java.util.Arrays;
import java.util.List;

import static UI.main.algoritmoFW;
import static UI.main.ciudades;

public class controller {

    public static void rutaMasCorta(String nombreCiudad1, String nombreCiudad2) {
        // Encuentra los índices de las ciudades.
        int indiceCiudad1 = algoritmoFW.getIndiceDeCiudad(nombreCiudad1);
        int indiceCiudad2 = algoritmoFW.getIndiceDeCiudad(nombreCiudad2);

        // Comprueba si las ciudades existen.
        if (indiceCiudad1 == -1 || indiceCiudad2 == -1) {
            System.out.println("Una o ambas ciudades no existen.");
            return;
        }

        // Obtiene la distancia y la ruta.
        int distancia = algoritmoFW.getDistancias()[indiceCiudad1][indiceCiudad2];

        // Muestra los resultados.
        System.out.println("La distancia más corta es: " + distancia);
        System.out.println("La ruta más corta es: " + nombreCiudad1 + " -> " + nombreCiudad2);
    }


    public static void actualizarTrafico(String nombreCiudad1, String nombreCiudad2, int tiempoNormal, int tiempoLluvia, int tiempoNieve, int tiempoTormenta) {
        // Verificar si ambas ciudades existen en el mapa
        if (!ciudades.containsKey(nombreCiudad1) || !ciudades.containsKey(nombreCiudad2)) {
            System.out.println("Una o ambas ciudades no existen.");
            return;
        }

        // Obtener las ciudades
        Ciudad ciudad1 = ciudades.get(nombreCiudad1);
        Ciudad ciudad2 = ciudades.get(nombreCiudad2);

        // Buscar la ruta correspondiente entre las dos ciudades
        Ruta ruta = ciudad1.getRuta(ciudad2);

        // Verificar si la ruta existe
        if (ruta == null) {
            System.out.println("No existe una ruta directa entre las ciudades.");
            return;
        }

        // Actualizar los tiempos de la ruta
        ruta.setTiempoNormal(tiempoNormal);
        ruta.setTiempoLluvia(tiempoLluvia);
        ruta.setTiempoNieve(tiempoNieve);
        ruta.setTiempoTormenta(tiempoTormenta);

        System.out.println("Se ha actualizado el tráfico entre " + nombreCiudad1 + " y " + nombreCiudad2 + ".");
    }


    public static String encontrarCiudadCentral() {
        int[][] distancias = algoritmoFW.getDistancias();
        int numCiudades = distancias.length;
        int[] sumasDistancias = new int[numCiudades];

        // Calcula la suma de distancias para cada ciudad
        for (int i = 0; i < numCiudades; i++) {
            int sumaDistancias = 0;
            for (int j = 0; j < numCiudades; j++) {
                sumaDistancias += distancias[i][j];
            }
            sumasDistancias[i] = sumaDistancias;
        }

        // Encuentra la ciudad con la suma mínima de distancias
        int indiceCiudadCentral = 0;
        int minSumaDistancias = sumasDistancias[0];
        for (int i = 1; i < numCiudades; i++) {
            if (sumasDistancias[i] < minSumaDistancias) {
                minSumaDistancias = sumasDistancias[i];
                indiceCiudadCentral = i;
            }
        }

        // Obtiene el nombre de la ciudad central
        String ciudadCentral = algoritmoFW.getVertices()[indiceCiudadCentral];

        return ciudadCentral;
    }


}




