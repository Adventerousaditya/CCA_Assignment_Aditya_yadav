import java.util.*;

class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int k = sc.nextInt();
        int[][] A = new int[r][k];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < k; j++)
                A[i][j] = sc.nextInt();

        int k2 = sc.nextInt();
        int c = sc.nextInt();
        int[][] B = new int[k2][c];
        for (int i = 0; i < k2; i++)
            for (int j = 0; j < c; j++)
                B[i][j] = sc.nextInt();

        int[][] C = new int[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                for (int t = 0; t < k; t++)
                    C[i][j] += A[i][t] * B[t][j];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                System.out.print(C[i][j] + " ");
            System.out.println();
        }
    }
}
