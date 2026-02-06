import java.util.*;
class FlipMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] A = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        char ch = sc.next().charAt(0);
        if (ch == 'H') {
            for (int i = 0; i < r / 2; i++) {
                int[] temp = A[i];
                A[i] = A[r - 1 - i];
                A[r - 1 - i] = temp;
            }
        }
        else if (ch == 'V') {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c / 2; j++) {
                    int temp = A[i][j];
                    A[i][j] = A[i][c - 1 - j];
                    A[i][c - 1 - j] = temp;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
