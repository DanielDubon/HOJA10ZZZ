package UI;

import Controller.ReadFile;
import Model.Ciudad;
import Model.FloydWarshall;
import Model.Ruta;

import java.io.FileNotFoundException;
import java.util.*;

import static Controller.ReadFile.leerArchivo;
import static Controller.controller.*;

public class main {
    private static boolean menu = true;
    public static Scanner scanner = new Scanner(System.in);
    public static Map<String, Ciudad> ciudades = new HashMap<>();
    public static FloydWarshall algoritmoFW;

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Nombre de archivo:");

        leerArchivo(scanner.nextLine());
        int[][] distancias = obtenerMatrizDistancias();

        // Obtener los nombres de las ciudades en un array
        String[] nombresCiudades = ciudades.values().stream()
                .map(Ciudad::getNombre)
                .toArray(String[]::new);

        // Inicializar el algoritmo de Floyd-Warshall
        algoritmoFW = new FloydWarshall(distancias, nombresCiudades);
        menu();



    }


    public static void menu(){
        System.out.println("Bienvenido al waze Floyd");

        while (menu){
            System.out.println("¿Que desea realizar?");
            System.out.println("1) Calcular distancia entre ciudades");
            System.out.println("2) Actualizar trafico encontrado entre ciudades");
            System.out.println("3) Cual es la ciudad central" );
            System.out.println("4) Finalizar");
            String opcion = scanner.nextLine();
            switch (opcion){

                case "1":
                    System.out.println("Ciudad 1");
                    String cd1 = scanner.nextLine();
                    System.out.println("Ciudad 2");
                    String cd2 = scanner.nextLine();


                    rutaMasCorta(cd1, cd2);

                    break;

                case "2":
                    System.out.println("Ciudad 1:");
                    String ciudad1 = scanner.nextLine();
                    System.out.println("Ciudad 2:");
                    String ciudad2 = scanner.nextLine();
                    System.out.println("Nuevo tiempo normal:");
                    int tiempoNormal = scanner.nextInt();
                    System.out.println("Nuevo tiempo con lluvia:");
                    int tiempoLluvia = scanner.nextInt();
                    System.out.println("Nuevo tiempo con nieve:");
                    int tiempoNieve = scanner.nextInt();
                    System.out.println("Nuevo tiempo con tormenta:");
                    int tiempoTormenta = scanner.nextInt();
                    scanner.nextLine();
                    actualizarTrafico(ciudad1, ciudad2, tiempoNormal, tiempoLluvia, tiempoNieve, tiempoTormenta);
                    break;

                case "3":

                    String ciudadCentral = encontrarCiudadCentral();
                    System.out.println("La ciudad central del grafo es: " + ciudadCentral);

                    break;

                case "4":

                    break;

            }


        }





    }

    public static int[][] obtenerMatrizDistancias() {
        int numCiudades = ciudades.size();
        int[][] distancias = new int[numCiudades][numCiudades];

        // Inicializar la matriz con un valor alto (infinito)
        for (int i = 0; i < numCiudades; i++) {
            Arrays.fill(distancias[i], Integer.MAX_VALUE);
        }

        // El costo de viajar de una ciudad a sí misma es 0
        for (int i = 0; i < numCiudades; i++) {
            distancias[i][i] = 0;
        }

        // Llenar la matriz con las distancias reales
        List<Ciudad> listaCiudades = new ArrayList<>(ciudades.values());
        for (int i = 0; i < numCiudades; i++) {
            Ciudad ciudadActual = listaCiudades.get(i);
            for (Ruta ruta : ciudadActual.getRutas()) {
                Ciudad ciudadDestino = ruta.getDestino();
                int indiceDestino = listaCiudades.indexOf(ciudadDestino);
                distancias[i][indiceDestino] = ruta.getTiempoNormal();
            }
        }

        return distancias;
    }



}
