package Exercici_06;

public class MultiplicacioMatrius {

    // Multiplicació seqüencial (opcional, per comparar resultats)
    public static double[][] multiplicarSeq(double[][] A, double[][] B) {
        int n = A.length;
        int m = A[0].length;
        int p = B[0].length;

        if (B.length != m) {
            throw new IllegalArgumentException("Dimensions incompatibles: A és " + n + "x" + m +
                    " i B és " + B.length + "x" + p);
        }

        double[][] C = new double[n][p];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                double suma = 0;
                for (int k = 0; k < m; k++) {
                    suma += A[i][k] * B[k][j];
                }
                C[i][j] = suma;
            }
        }
        return C;
    }

    // Multiplicació en paral·lel
    public static double[][] multiplicarParallel(double[][] A, double[][] B, int numFils) throws InterruptedException {
        int n = A.length;
        int m = A[0].length;
        int p = B[0].length;

        if (B.length != m) {
            throw new IllegalArgumentException("Dimensions incompatibles: A és " + n + "x" + m +
                    " i B és " + B.length + "x" + p);
        }

        double[][] C = new double[n][p];

        // Creem els fils
        Thread[] fils = new Thread[numFils];

        int filesPerFil = (int) Math.ceil(n / (double) numFils);
        for (int i = 0; i < numFils; i++) {
            int filaInicial = i * filesPerFil;
            int filaFinal = Math.min(filaInicial + filesPerFil, n); // exclusiu

            if (filaInicial >= n) break; // pot passar si hi ha més fils que files

            Worker worker = new Worker(A, B, C, filaInicial, filaFinal);
            fils[i] = new Thread(worker, "Worker-" + i);
            fils[i].start();
        }

        // Esperem que tots els fils acabin
        for (Thread t : fils) {
            if (t != null) t.join();
        }

        return C;
    }

    // Classe interna que calcula un rang de files de la matriu C
    private static class Worker implements Runnable {
        private final double[][] A;
        private final double[][] B;
        private final double[][] C;
        private final int filaInicial;
        private final int filaFinal;

        public Worker(double[][] A, double[][] B, double[][] C, int filaInicial, int filaFinal) {
            this.A = A;
            this.B = B;
            this.C = C;
            this.filaInicial = filaInicial;
            this.filaFinal = filaFinal;
        }

        @Override
        public void run() {
            int m = A[0].length;
            int p = B[0].length;

            for (int i = filaInicial; i < filaFinal; i++) {
                for (int j = 0; j < p; j++) {
                    double suma = 0;
                    for (int k = 0; k < m; k++) {
                        suma += A[i][k] * B[k][j];
                    }
                    C[i][j] = suma; // Cada fil només escriu a les seves files
                }
            }
        }
    }

    // Petit main de prova
    public static void main(String[] args) throws InterruptedException {
        // Exemple petit per veure que funciona
        double[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        }; // 2x3

        double[][] B = {
                {7, 8},
                {9, 10},
                {11, 12}
        }; // 3x2

        int numFils = 2;

        double[][] Cseq = multiplicarSeq(A, B);
        double[][] Cpar = multiplicarParallel(A, B, numFils);

        System.out.println("Resultat seqüencial:");
        imprimirMatriu(Cseq);

        System.out.println("Resultat en paral·lel:");
        imprimirMatriu(Cpar);
    }

    private static void imprimirMatriu(double[][] M) {
        for (double[] fila : M) {
            for (double v : fila) {
                System.out.printf("%8.2f", v);
            }
            System.out.println();
        }
    }
}
