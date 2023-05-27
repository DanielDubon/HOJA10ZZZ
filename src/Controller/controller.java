package Controller;

import java.util.Arrays;
import java.util.List;

import static UI.main.algoritmoFW;

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




}
