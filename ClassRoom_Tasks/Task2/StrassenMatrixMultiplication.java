import java.util.*;

public class StrassenMatrixMultiplication {

    // Conventional multiplication: O(N^3)
    static long[][] conventionalMultiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    // Strassen multiplication with a cutoff to avoid recursion overhead
    static long[][] strassen(long[][] A, long[][] B) {
        int n = A.length;

        // For small matrices, conventional multiplication is usually faster.
        if (n <= 2) {
            return conventionalMultiply(A, B);
        }

        int half = n / 2;

        // Divide A and B into four submatrices.
        long[][] A11 = new long[half][half];
        long[][] A12 = new long[half][half];
        long[][] A21 = new long[half][half];
        long[][] A22 = new long[half][half];

        long[][] B11 = new long[half][half];
        long[][] B12 = new long[half][half];
        long[][] B21 = new long[half][half];
        long[][] B22 = new long[half][half];

        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                A11[i][j] = A[i][j];
                A12[i][j] = A[i][j + half];
                A21[i][j] = A[i + half][j];
                A22[i][j] = A[i + half][j + half];

                B11[i][j] = B[i][j];
                B12[i][j] = B[i][j + half];
                B21[i][j] = B[i + half][j];
                B22[i][j] = B[i + half][j + half];
            }
        }

        // Seven recursive multiplications.
        long[][] M1 = strassen(add(A11, A22), add(B11, B22));
        long[][] M2 = strassen(add(A21, A22), B11);
        long[][] M3 = strassen(A11, subtract(B12, B22));
        long[][] M4 = strassen(A22, subtract(B21, B11));
        long[][] M5 = strassen(add(A11, A12), B22);
        long[][] M6 = strassen(subtract(A21, A11), add(B11, B12));
        long[][] M7 = strassen(subtract(A12, A22), add(B21, B22));

        // C11 = M1 + M4 - M5 + M7
        long[][] C11 = add(subtract(add(M1, M4), M5), M7);

        // C12 = M3 + M5
        long[][] C12 = add(M3, M5);

        // C21 = M2 + M4
        long[][] C21 = add(M2, M4);

        // C22 = M1 - M2 + M3 + M6
        long[][] C22 = add(subtract(add(M1, M3), M2), M6);

        // Combine result submatrices.
        long[][] C = new long[n][n];

        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                C[i][j] = C11[i][j];
                C[i][j + half] = C12[i][j];
                C[i + half][j] = C21[i][j];
                C[i + half][j + half] = C22[i][j];
            }
        }

        return C;
    }

    static long[][] add(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    static long[][] subtract(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(row[j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n < 1 || n > 128 || (n & (n - 1)) != 0) {
            System.out.println("Invalid input: N must be a power of 2 between 1 and 128.");
            return;
        }

        long[][] A = new long[n][n];
        long[][] B = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextLong();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = sc.nextLong();
            }
        }

        long[][] result = strassen(A, B);
        printMatrix(result);

        sc.close();
    }
}
