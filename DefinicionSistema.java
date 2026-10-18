package Ecuaciones_lineales;

// Define los datos del sistema de ecuaciones lineales.
public class DefinicionSistema {

    // Devuelve la matriz de coeficientes del sistema.
    public static double[][] obtenerMatriz() {
        return new double[][] {
                {5.0, 1.0, 1.0},
                {1.0, 4.0, 1.0},
                {1.0, 2.0, 5.0}
        };
    }

    // Devuelve el vector de términos independientes.
    public static double[] obtenerVector() {
        return new double[] {7.0, 6.0, 8.0};
    }
}