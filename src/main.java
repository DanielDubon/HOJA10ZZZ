public class main {


    public static void main(String[] args) {



    }

    public static void calcularRutas(){

        int[][] matriz_distancias = {{0,4,8,10000,10000},{4,0,1,2,10000},{8,10000,0,4,2},{10000,2,4,0,7},{10000,10000,2,7,0}};

        String[][] matriz_recorridos = {{"A","B","C","D","E"},{"A","B","C","D","E"},{"A","B","C","D","E"},{"A","B","C","D","E"},{"A","B","C","D","E"}};

        FloydWarshall algoritmoFW = new FloydWarshall(matriz_distancias,matriz_recorridos,5);

        algoritmoFW.CalcularRutas();


    }
}
