package tictactoe;

import java.util.Locale;
import java.util.Scanner;



public class Main {

    public static String xSign = "X";
    public static String oSign = "O";
    public static String prompt = "Enter the coordinates: ";
    public static String warningWrongSymbols = "You should enter numbers!";
    public static String warningNumbers = "Coordinates should be from 1 to 3!";
    public static String warningOccupiedCell = "This cell is occupied! Choose another one!";
    public static String startState = "         ";
    public static String resultWinner = " wins";
    public static String resultDraw = "Draw";
    public static String resultImpossible = "Impossible";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String state = startState;
        int move = 1;

        while (true) {
            OutputField(state);
            state = CheckUserInput(scanner, state, move);
            CheckFieldStatus(scanner, state);
            move++;
        }
    }
    public static String CheckUserInput (Scanner scanner, String state, int move) {

        int i = 0, j = 0, k = 0;
        String line, sign;

        while (true) {
            System.out.print(prompt);

            // Check input type
            line = scanner.nextLine();

            try {
                String [] pieces = line.split(" ");
                i = Integer.parseInt(pieces[0]);
                j = Integer.parseInt(pieces[1]);

            } catch (NumberFormatException e) {
                System.out.println(warningWrongSymbols);
                continue;
            }

            // Check value of coordinates
            if (i > 3 || j > 3 || i < 1 || j < 1) {
                System.out.println(warningNumbers);
                continue;
            }

            // Check cell occupation
            if (i == 1) {
                k = j;
            } else if (i == 2) {
                k = 3 + j;
            } else if (i == 3) {
                k = 6 + j;
            }

            if (state.charAt(k - 1) != ' ') {
                System.out.println(warningOccupiedCell);
                continue;
            } else {
                sign = move % 2 == 0 ? oSign : xSign;
                state = state.substring(0, k - 1) + sign + state.substring(k);
            } break;
        }

        return state;
    }
    public static void OutputField (String state) {
        System.out.println("---------");
        System.out.println(String.format("| %s %s %s |", state.charAt(0), state.charAt(1), state.charAt(2)));
        System.out.println(String.format("| %s %s %s |", state.charAt(3), state.charAt(4), state.charAt(5)));
        System.out.println(String.format("| %s %s %s |", state.charAt(6), state.charAt(7), state.charAt(8)));
        System.out.println("---------");
    }
    public static void CheckFieldStatus (Scanner scanner, String state) {

        Character winner = '?';
        byte length = 3;
        boolean finished = false;
        boolean impossible = false;
        boolean draw = false;
        boolean emptyCell = false;
        byte xCounter = 0;
        byte oCounter = 0;
        Character[][] rows = {{state.charAt(0), state.charAt(1), state.charAt(2)}, {state.charAt(3), state.charAt(4), state.charAt(5)}, {state.charAt(6), state.charAt(7), state.charAt(8)}};
        Character[][] columns = {{state.charAt(0), state.charAt(3), state.charAt(6)}, {state.charAt(1), state.charAt(4), state.charAt(7)}, {state.charAt(2), state.charAt(5), state.charAt(8)}};
        Character[][] diagonals = {{state.charAt(0), state.charAt(4), state.charAt(8)}, {state.charAt(2), state.charAt(4), state.charAt(6)}};

        // Count X and 0 signs, find empty cells in a row
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if( rows[i][j].equals(xSign)) {
                    xCounter++;
                } else if (rows[i][j].equals(oSign)) {
                    oCounter++;
                } else if (rows[i][j] == ' ') {
                    emptyCell = true;
                }
            }
        }

        // Count the difference between X and 0
        if (Math.abs(xCounter - oCounter) > 1) {
            impossible = true;
        }

        // Try to get winner

        // Check winner in rows
        if (!impossible) {
            for (int i = 0; i < length; i++) {
                if (rows[i][0] == ' ' && rows[i][1] == ' ' && rows[i][2] == ' ') {
                } else if (rows[i][0].equals(rows[i][1]) && rows[i][0].equals(rows[i][2]) && finished) {
                    impossible = true;
                } else if (rows[i][0].equals(rows[i][1]) && rows[i][0].equals(rows[i][2]) && !finished) {
                    winner = rows[i][0];
                    finished = true;
                }
            }

            // Check winner in columns
            for (int i = 0; i < length; i++) {
                if (columns[i][0] == ' ' && columns[i][1] == ' ' && columns[i][2] == ' ') {
                } else if (columns[i][0].equals(columns[i][1]) && columns[i][0].equals(columns[i][2]) && finished) {
                    impossible = true;
                } else if (columns[i][0].equals(columns[i][1]) && columns[i][0].equals(columns[i][2]) && !finished) {
                    winner = columns[i][0];
                    finished = true;
                }
            }

            // Check winner in a diagonals
            for (int i = 0; i < length - 1; i++) {
                if (diagonals[i][0] == ' ' && diagonals[i][1] == ' ' && diagonals[i][2] == ' ') {
                } else if (diagonals[i][0].equals(diagonals[i][1]) && diagonals[i][0].equals(diagonals[i][2]) && finished) {
                    impossible = true;
                } else if (diagonals[i][0].equals(diagonals[i][1]) && diagonals[i][0].equals(diagonals[i][2]) && !finished) {
                    winner = diagonals[i][0];
                    finished = true;
                }
            }
        }

        finished = !impossible && winner == '?' && !emptyCell;  // check for 'Game over'
        draw = finished && winner == '?';                       // check for 'Draw'

        PrintResults(state, winner, draw, impossible, emptyCell);
    }
    public static void PrintResults (String state, Character winner, boolean draw, boolean impossible, boolean emptyCell){

        if (winner != '?' && !impossible) {
            OutputField(state);
            System.out.println(winner + resultWinner);
            System.exit(0);
        } else if (draw) {
            System.out.println(resultDraw);
        } else if (impossible) {
            System.out.println(resultImpossible);
        }
    }
}
