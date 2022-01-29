// You can experiment here, it won’t be checked
import java.util.Scanner;

public class Task {

  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[][] array = FormArray(scanner);
    int[][] array2 = new int[array.length][array[0].length];
    int i = scanner.nextInt();
    int j = scanner.nextInt();

    for (int rows = 0; rows < array2.length; rows++) {
      for (int columns = 0; columns < array2[0].length; columns++) {
        if (columns == i) {
          array2[rows][columns] = array[rows][j];
        } else if (columns == j) {
          array2[rows][columns] = array[rows][i];
        } else {
          array2[rows][columns] = array[rows][columns];
        }
      }
    }

    PrintResults(array2);
  }

  public static int[][] FormArray (Scanner scanner) {
    int rows = scanner.nextInt();
    int columns = scanner.nextInt();
    int[][] array = new int[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        array[i][j] = scanner.nextInt();
      }
    }
    return array;
  }

  public static void PrintResults (int[][] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[0].length; j++) {
        System.out.print(array[i][j] + " ");
      }
      System.out.println();
    }
  }
}
