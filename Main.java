package Ecuaciones_lineales;

import java.util.Arrays;
import Ecuaciones_lineales.JACOBI.MetodoJacobi;
import Ecuaciones_lineales.Gauss_Seidel.GaussSeidelMetodo;

public class Main {

    public static void main(String[] args) {

        // Inicializa la matriz y el vector de términos independientes.
        double[][] A = DefinicionSistema.obtenerMatriz();
        double[] b = DefinicionSistema.obtenerVector();

        // Define el vector inicial, la tolerancia y el máximo de iteraciones.
        double[] xInicial = {0.0, 0.0, 0.0};
        double tolerancia = 0.0001;
        int maxIteraciones = 100;

        // Ejecuta el método de Jacobi.
        double[] resultadoJacobi = MetodoJacobi.jacobi(
                A, b, xInicial, tolerancia, maxIteraciones);

        // Ejecuta el método de Gauss-Seidel.
        double[] resultadoGaussSeidel = GaussSeidelMetodo.gaussSeidel(
                A, b, xInicial, tolerancia, maxIteraciones);

        // Muestra los resultados obtenidos.
        System.out.println("Metodo de Jacobi:");
        System.out.println(Arrays.toString(resultadoJacobi));

        System.out.println("\nMetodo de Gauss-Seidel:");
        System.out.println(Arrays.toString(resultadoGaussSeidel));
    }
}