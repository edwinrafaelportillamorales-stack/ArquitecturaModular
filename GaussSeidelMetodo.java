package Ecuaciones_lineales.Gauss_Seidel;

// Importa el cálculo del error implementado en Jacobi.
import static Ecuaciones_lineales.JACOBI.MetodoJacobi.calcularError;

public class GaussSeidelMetodo {

    public static double[] gaussSeidel(double[][] A, double[] b,
                                       double[] xInicial, double tol, int maxIter) {
        int n = xInicial.length;
        double[] x = xInicial.clone();

        // Un solo vector que evoluciona al instante.
        for (int iter = 0; iter < maxIter; iter++) {
            double[] xAnt = x.clone();

            // Respaldamos el estado anterior para calcular el error.
            for (int i = 0; i < n; i++) {
                double suma = b[i];

                // Calcula la suma de los términos restantes.
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        // Usa los valores más recientes disponibles.
                        suma -= A[i][j] * x[j];
                    }
                }

                // Comprueba que no exista una división entre cero.
                if (A[i][i] == 0.0) {
                    throw new IllegalArgumentException(
                            "La diagonal de la matriz no puede contener ceros.");
                }

                // Actualiza inmediatamente el valor de la variable.
                x[i] = suma / A[i][i];
            }

            // Termina cuando el error es menor que la tolerancia.
            if (calcularError(xAnt, x) < tol) {
                return x;
            }
        }

        return x;
    }
}