import java.util.ArrayList;

public class Game {
    private Deck deck;
    private Player dealer;
    private int noOfPlayers;
    private ArrayList<Player> players;

    public Game(Deck deck, int noOfPlayers) {
        this.deck = deck;
        this.players = new ArrayList<>();
        this.noOfPlayers = noOfPlayers;
    }

    public void dealCard(Player player) {
        Card dealtCard = deck.getCard();
        player.addCardToHand(dealtCard);
    }

    public void startGame() {
        for (int i = 0; i < noOfPlayers; i++) {
            Player player = new HumanPlayer("Player " + String.valueOf(i + 1));
            this.players.add(player);
        }
        this.dealer = new DealerPlayer("Dealer");
        this.players.add(this.dealer);
        for (Player player : this.players) {
            dealCard(player);
            dealCard(player);
        }
    }

    public void runTurns() {
        for (Player player : this.players) {
            runTurn(player);
        }
        printGameResult();
    }

    public void runTurn(Player player) {
        printGameState(player);
        if (BlackJackScorer.getIsPlayerAbleToHit(player) && player.getIsHitting()) {
            dealCard(player);
            runTurn(player);
        }
    }

    public void printGameState(Player player) {
        System.out.println("--- " + player.getName() + " ---");
        ArrayList<Card> hand = player.getHand();
        System.out.println(hand);
        System.out.println(BlackJackScorer.getScore(hand));
        System.out.println(BlackJackScorer.getScoreType(hand));
        System.out.println();
    }

    public void printGameResult(){
        this.players = BlackJackScorer.getPlayersByHandValue(this.players);
        for (Player player : this.players) {
            if (player == this.dealer) continue;
            System.out.print(player.getName() + " ");
            System.out.print(BlackJackScorer.getGameOutcome(player.getHand(), dealer.getHand()));
            System.out.println( " - " + BlackJackScorer.getScore(player.getHand()));
        }

        System.out.println("\n" + this.players);
    }

}
