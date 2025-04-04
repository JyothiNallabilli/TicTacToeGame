package service;

import model.Board;
import model.Player;
import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1, player2;
    private Player currentPlayer;
    private Scanner scanner;

    public Game(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (!board.isFull() && !board.hasWinner()) {
            board.displayBoard();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + "): Enter row and column (0-2)");

            int row = -1, col = -1;

            if (scanner.hasNextInt()) {
                row = scanner.nextInt();
                col = scanner.nextInt();

                if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                    System.out.println("Invalid input! Row and column should be between 0-2.");
                    scanner.nextLine(); // Clear buffer
                    continue;
                }

                if (!board.placeMark(row, col, currentPlayer.getSymbol())) {
                    System.out.println("Cell already occupied! Try again.");
                    continue;
                }
            } else {
                System.out.println("Invalid input! Please enter numbers only.");
                scanner.next(); // Consume invalid input
                continue;
            }

            if (board.hasWinner()) {
                board.displayBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                return;
            }

            switchPlayer();
        }

        board.displayBoard();
        System.out.println("Game over! It's a draw.");
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
