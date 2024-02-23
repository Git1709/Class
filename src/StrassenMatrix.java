
public class StrassenMatrix {

    public int[][] mul(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            int[][] A11 = part(A, 0, 0);
            int[][] A12 = part(A, 0, n / 2);
            int[][] A21 = part(A, n / 2, 0);
            int[][] A22 = part(A, n / 2, n / 2);

            int[][] B11 = part(B, 0, 0);
            int[][] B12 = part(B, 0, n / 2);
            int[][] B21 = part(B, n / 2, 0);
            int[][] B22 = part(B, n / 2, n / 2);

            int[][] M1 = mul(add(A11, A22), add(B11, B22));
            int[][] M2 = mul(add(A21, A22), B11);
            int[][] M3 = mul(A11, sub(B12, B22));
            int[][] M4 = mul(A22, sub(B21, B11));
            int[][] M5 = mul(add(A11, A12), B22);
            int[][] M6 = mul(sub(A21, A11), add(B11, B12));
            int[][] M7 = mul(sub(A12, A22), add(B21, B22));

            int[][] C11 = add(sub(add(M1, M4), M5), M7);
            int[][] C12 = add(M3, M5);
            int[][] C21 = add(M2, M4);
            int[][] C22 = add(sub(add(M1, M3), M2), M6);

            join(C11, C, 0, 0);
            join(C12, C, 0, n / 2);
            join(C21, C, n / 2, 0);
            join(C22, C, n / 2, n / 2);
        }
        return C;
    }

    private int[][] part(int[][] A, int sr, int sc) {
        int n = A.length / 2;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                res[i][j] = A[i + sr][j + sc];
        return res;
    }

    private int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                res[i][j] = A[i][j] + B[i][j];
        return res;
    }

    private int[][] sub(int[][] A, int[][] B) {
        int n = A.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                res[i][j] = A[i][j] - B[i][j];
        return res;
    }

    private void join(int[][] p, int[][] C, int sr, int sc) {
        int n = p.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i + sr][j + sc] = p[i][j];
    }

    public static void main(String[] args) {
        StrassenMatrix s = new StrassenMatrix();

        int[][] A = { { 1, 2 }, { 3, 4 } };
        int[][] B = { { 5, 6 }, { 7, 8 } };

        System.out.println("Matrix A:");
        printMatrix(A);
        System.out.println("Matrix B:");
        printMatrix(B);

        int[][] C = s.mul(A, B);

        System.out.println("Resultant Matrix C:");
        printMatrix(C);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}