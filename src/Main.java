import model.Player;
import service.Game;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Alice", 'X');
        Player player2 = new Player("Bob", 'O');

        Game game = new Game(player1, player2);
        game.start();
    }
}
