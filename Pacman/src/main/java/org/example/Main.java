package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {




            int[][] board = {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                    {1, 2, 1, 1, 2, 2, 1, 1, 2, 1},
                    {1, 3, 2, 2, 2, 2, 2, 2, 2, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };

            printBoard(board);
            movePacmanRight(board);
            System.out.println("After moving Pac-Man to the right:");
            printBoard(board);
        }

    


    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                switch (board[i][j]) {
                    case 0:
                        System.out.print("  "); // Empty space
                        break;
                    case 1:
                        System.out.print("W "); // Wall
                        break;
                    case 2:
                        System.out.print(". "); // Dot
                        break;
                    case 3:
                        System.out.print("P "); // Pac-Man
                        break;
                }
            }
            System.out.println();
        }
    }
    public static void movePacmanRight(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 3) { // Find Pac-Man
                    if (j + 1 < board[i].length && board[i][j + 1] != 1) { // Check if right is not a wall
                        board[i][j] = 0; // Remove Pac-Man from current position
                        board[i][j + 1] = 3; // Place Pac-Man in new position
                    }
                    return; // Exit the method after moving
                }
            }
        }
    }

}