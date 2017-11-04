package org.knuba.task25;

public class Task25 {
    private static final int rowsA = 200;
    private static final int colsA = 100;
    private static final int rowsB = colsA;
    private static final int colsB = rowsA;

    private static final int ELEMENT_A = 3;
    private static final int ELEMENT_B = 3;
    
    private static int[][] a;
    private static int[][] b;
    private static int[][] c;

    public static void main(String[] args) throws Exception {
        a = mA();
        b = mB();
        c = new int[a.length][b[0].length];

        One m1 = new One();
        Two m2 = new Two();
        Three m3 = new Three();
        Four m4 = new Four();
        m1.start();
        m2.start();
        m3.start();
        m4.start();
        m1.join();
        m2.join();
        m3.join();
        m4.join();

        printM(c);
    }


    public static int[][] mA() {
        int[][] matrix = new int[rowsA][colsA];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrix[i][j] = ELEMENT_A;
            }
        }
        return matrix;
    }

    public static int[][] mB() {
        int[][] matrix = new int[rowsB][colsB];
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrix[i][j] = ELEMENT_B;
            }
        }
        return matrix;
    }

    public static void printM(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        String str = "|\t";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                str += matrix[i][j] + "\t";
            }

            System.out.println(str + "|");
            str = "|\t";
        }
    }

    public static class One extends Thread {

        @Override
        public void run() {
            int n = b[0].length;
            int k = (a.length) / 4;

            for (int i = 0; i <= k; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < b.length; l++) {
                        c[i][j] = c[i][j] + a[i][l] * b[l][j];

                    }

                }

            }
        }
    }

    public static class Two extends Thread {

        @Override
        public void run() {
            int n = b[0].length;
            int k = (a.length) / 2 + 1;
            int s = ((a.length) / 4) + 1;

            for (int i = s; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < b.length; l++) {
                        c[i][j] = c[i][j] + a[i][l] * b[l][j];

                    }

                }

            }
        }
    }

    public static class Three extends Thread {

        @Override
        public void run() {
            int n = b[0].length;
            int k = ((3 * (a.length)) / 4) + 1;
            int s = (a.length) / 2 + 1;

            for (int i = s; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < b.length; l++) {
                        c[i][j] = c[i][j] + a[i][l] * b[l][j];

                    }

                }

            }
        }
    }

    public static class Four extends Thread {

        @Override
        public void run() {
            int m = a.length;
            int n = b[0].length;
            int k = ((3 * (a.length)) / 4) + 1;


            for (int i = k; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < b.length; l++) {
                        c[i][j] = c[i][j] + a[i][l] * b[l][j];

                    }

                }

            }
        }
    }


}