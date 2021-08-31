import me.and.the.boys.game.Game;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.setUpGame();
        game.printPlayers();
        game.startNightPhase();
        game.printLog();
        game.startNightPhase();
    }

}
