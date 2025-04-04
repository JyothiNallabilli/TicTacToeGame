package model;

public class Board {
    private static final int SIZE = 3;
    private char[][] grid;

    public Board() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public void displayBoard() {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean placeMark(int row, int col, char symbol) {
        if (grid[row][col] == '-') {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean hasWinner() {
        // Check rows & columns
        for (int i = 0; i < SIZE; i++) {
            if ((grid[i][0] != '-' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) ||
                (grid[0][i] != '-' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i])) {
                return true;
            }
        }
        // Check diagonals
        if ((grid[0][0] != '-' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) ||
            (grid[0][2] != '-' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0])) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
