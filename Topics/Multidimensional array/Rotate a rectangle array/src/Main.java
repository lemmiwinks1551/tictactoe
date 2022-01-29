import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();    // 3
        int columns = scanner.nextInt(); // 4
        int rows2 = columns; // 4
        int columns2 = rows; // 3
        int[][] twoDimArray = new int[rows][columns];  // 3 4
        int[][] twoDimArray2 = new int[rows2][columns2]; // 4 3

        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < columns; k++) {
                twoDimArray[i][k] = scanner.nextInt();
            }
        } // fill array

        for (int i = 0; i < rows2; i++) {
            for (int k = 0; k < columns2; k++) {
                twoDimArray2[i][k] = twoDimArray[rows - 1 - k][i];
            }
        }

        for (int i = 0; i < rows2; i++) {
            for (int k = 0; k < columns2; k++) {
                System.out.print(twoDimArray2[i][k] + " ");
            }
            System.out.println();
        } // print array
    }
}
