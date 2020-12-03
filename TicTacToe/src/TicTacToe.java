import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static TicTacToe myObj = new TicTacToe();
    public static int userChoice = 0;
    public static char[][] grid2 = myObj.gridBuilder();
    public static char[] gridOfPos = {'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n'};
    char user1 = 'x';
    char user2 = 'O';
    char user = user2;
    int counter = 0;
    public static boolean gameEnd = false;

    public char[][] gridBuilder() {
        char[][] grid = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };
        return grid;
    }

    public void gridReader() {
        for (char[] line : grid2) {
            for (char c : line) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void userInput() {
        System.out.println("Welcome to TicTacToe, Please Choose a position (1-9)");
        System.out.println("The numbers associated with the grid positions are shown below: ");
        System.out.println("1|2|3");
        System.out.println("-+-+-");
        System.out.println("4|5|6");
        System.out.println("-+-+-");
        System.out.println("7|8|9");
        while ((counter < 9 && !gameEnd)) {
            if (user == user2){
                System.out.println("X's turn");
            }
            else if (user == user1) {
                System.out.println("O's turn");
            }
            counter += 1;
            Scanner scannerObj = new Scanner(System.in);
            System.out.print("Please choose a square (1-9): ");
            userChoice = scannerObj.nextInt();
            while((userChoice<1) || (userChoice>9)) {
                System.out.print("Please input a valid position between 1-9 that isn't already taken: ");
                userChoice = scannerObj.nextInt();
            }
                while (gridOfPos[userChoice - 1] != 'n') {
                    System.out.print("Please input a valid position between 1-9 that isn't already taken: ");
                    userChoice = scannerObj.nextInt();

            }
            gridEditor();
            gridReader();
            winnerCheck();
        }
    }

    public void gridEditor() {
        if (user == user1) {
            user = user2;
        } else if (user == user2) {
            user = user1;
        }
        switch (userChoice) {
            case 1:
                grid2[0][0] = user;
                gridOfPos[0] = user;
                break;
            case 2:
                grid2[0][2] = user;
                gridOfPos[1] = user;
                break;
            case 3:
                grid2[0][4] = user;
                gridOfPos[2] = user;
                break;
            case 4:
                grid2[2][0] = user;
                gridOfPos[3] = user;
                break;
            case 5:
                grid2[2][2] = user;
                gridOfPos[4] = user;
                break;
            case 6:
                grid2[2][4] = user;
                gridOfPos[5] = user;
                break;
            case 7:
                grid2[4][0] = user;
                gridOfPos[6] = user;
                break;
            case 8:
                grid2[4][2] = user;
                gridOfPos[7] = user;
                break;
            case 9:
                grid2[4][4] = user;
                gridOfPos[8] = user;
                break;
            default:
                break;
        }
    }

    public void winnerCheck() {
        int[][] checkWon = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9},
                {1, 5, 9},
                {3, 5, 7}
        };
        for (int[] combination : checkWon) {
            int pos1 = combination[0] - 1;
            int pos2 = combination[1] - 1;
            int pos3 = combination[2] - 1;
            if (!gameEnd){
            if (counter == 9) {
                System.out.println("The game is a tie");
                gameEnd = true;
            } else {
                if ((gridOfPos[pos1] == 'x') && (gridOfPos[pos2] == 'x') && (gridOfPos[pos3] == 'x')) {
                    System.out.println("X wins");
                    gameEnd = true;
                    break;
                } else if ((gridOfPos[pos1] == 'O') && (gridOfPos[pos2] == 'O') && (gridOfPos[pos3] == 'O')) {
                    System.out.println("O wins");
                    gameEnd = true;
                    break;
                }
            }
        }
        }
    }



    public static void main(String[] args) {
        TicTacToe.myObj.gridBuilder();
        TicTacToe.myObj.userInput();
    }
}
