package Controller;

import Model.Ciudad;
import Model.Ruta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static UI.main.ciudades;

public class ReadFile {

    public static void leerArchivo(String filename) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("C:\\Users\\danie\\Desktop\\logistica\\Logistica.txt"));
        int indice = 0;  // indice para las ciudades

        while (fileScanner.hasNextLine()) {
            String[] linea = fileScanner.nextLine().split(" ");

            String nombreCiudad1 = linea[0];
            String nombreCiudad2 = linea[1];

            int tiempoNormal = Integer.parseInt(linea[2]);
            int tiempoLluvia = Integer.parseInt(linea[3]);
            int tiempoNieve = Integer.parseInt(linea[4]);
            int tiempoTormenta = Integer.parseInt(linea[5]);

            // Si las ciudades aún no existen en el mapa, se crean y se añaden.
            if(!ciudades.containsKey(nombreCiudad1)) {
                Ciudad ciudad1 = new Ciudad(nombreCiudad1);
                ciudad1.setIndice(indice++);  // asignar el indice a la ciudad
                ciudades.put(nombreCiudad1, ciudad1);
            }
            if(!ciudades.containsKey(nombreCiudad2)) {
                Ciudad ciudad2 = new Ciudad(nombreCiudad2);
                ciudad2.setIndice(indice++);  // asignar el indice a la ciudad
                ciudades.put(nombreCiudad2, ciudad2);
            }

            // Se añade la ruta a las ciudades.
            Ciudad ciudad1 = ciudades.get(nombreCiudad1);
            Ciudad ciudad2 = ciudades.get(nombreCiudad2);

            ciudad1.addRuta(new Ruta(ciudad2, tiempoNormal, tiempoLluvia, tiempoNieve, tiempoTormenta));
            ciudad2.addRuta(new Ruta(ciudad1, tiempoNormal, tiempoLluvia, tiempoNieve, tiempoTormenta));
        }

        fileScanner.close();
    }
}
