package Ecuaciones_lineales.JACOBI;

public class MetodoJacobi {

    // Resuelve el sistema mediante el metodo iterativo de Jacobi.
    public static double[] jacobi(double[][] A, double[] b,
                                  double[] xInicial, double tol, int maxIter) {
        int n = xInicial.length;
        double[] x = xInicial.clone();

        for (int iter = 0; iter < maxIter; iter++) {
            double[] xNuevo = new double[n];

            // Calcula cada componente usando los valores anteriores.
            for (int i = 0; i < n; i++) {
                double suma = b[i];

                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma -= A[i][j] * x[j];
                    }
                }

                // Comprueba que no exista una división entre cero.
                if (A[i][i] == 0.0) {
                    throw new IllegalArgumentException(
                            "La diagonal de la matriz no puede contener ceros.");
                }

                // Calcula el nuevo valor de la variable.
                xNuevo[i] = suma / A[i][i];
            }

            // Comprueba si se alcanzó la tolerancia establecida.
            if (calcularError(x, xNuevo) < tol) {
                return xNuevo;
            }

            // Actualiza el vector para la siguiente iteración.
            x = xNuevo;
        }

        return x;
    }

    // Calcula el mayor cambio absoluto entre dos vectores.
    public static double calcularError(double[] anterior, double[] actual) {
        double error = 0.0;

        for (int i = 0; i < anterior.length; i++) {
            double diferencia = Math.abs(actual[i] - anterior[i]);

            if (diferencia > error) {
                error = diferencia;
            }
        }

        return error;
    }
}