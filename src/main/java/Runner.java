public class Runner {


    // may need to run in Terminal - /target/classes
    // java Runner <no_of_players>
    public static void main(String[] args) {
        int noOfPlayers = Integer.valueOf(args[0]);
        Deck deck = new Deck();
        Game game = new Game(deck, noOfPlayers);
        game.startGame();
        game.runTurns();
    }
}
