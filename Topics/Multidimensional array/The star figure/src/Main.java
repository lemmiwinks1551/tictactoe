import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String [][] twoDimArray = new String[length][length];
        int d = 0;
        int b = length - 1;

        for (int i = 0; i < length; i++) {
            for (int k = 0; k < length; k++) {
                twoDimArray[i][k] = ".";
            }
        } // fill array with "."

        for (int i = (length - 1) / 2; i == (length - 1) / 2; i++) {
            for (int k = 0; k < length; k++) {
                twoDimArray[i][k] = "*";
            }
        } // fill middle row of an array with "*"

        for (int i = 0 / 2; i < length; i++) {
            for (int k = (length - 1) / 2; k == (length - 1) / 2; k++) {
                twoDimArray[i][k] = "*";
            }
        } // fill middle column of an array with "*"

        for (int i = 0; i < length; i++) {
            for (int k = 0; k < length; k++) {
                twoDimArray[i][k + d] = "*";
                d++;
                break;
            }
        } // fill first diagonal (from left to right)

        for (int i = 0; i < length; i++) {
            for (int k = 0; k < length; k++) {
                twoDimArray[i][b - k] = "*";
                b--;
                break;
            }
        } // fill second diagonal (from right to left)

        for (int i = 0; i < length; i++) {
            for (int k = 0; k < length; k++) {
                System.out.print(twoDimArray[i][k] + " ");
            }
            System.out.println();
        } // print array
    }
}
