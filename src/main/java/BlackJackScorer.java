import java.util.ArrayList;
import java.util.Collections;

public class BlackJackScorer {

    public enum ScoreType {
        BLACKJACK,
        NOT_BLACKJACK_21,
        UNDER_21,
        BUST;

        @Override
        public String toString(){
            String humanReadable = this.name().toLowerCase();
            humanReadable = humanReadable.substring(0,1).toUpperCase() + humanReadable.substring(1);
            humanReadable = humanReadable.replace("_", " ");
            return humanReadable;
        }
    }

    public static ScoreType getScoreType(ArrayList<Card> hand){
        int score = getScore(hand);
        if (score == 21 && hand.size() == 2){
            return ScoreType.BLACKJACK;
        } else if (score == 21){
            return ScoreType.NOT_BLACKJACK_21;
        } else if (score > 21){
            return ScoreType.BUST;
        } else {
            return ScoreType.UNDER_21;
        }
    }

    public static int getScore(ArrayList<Card> hand){
        int score = 0;
        for (Card card : hand){
            Rank rank = card.getRank();
            score += BlackJackCardRank.getValue(rank);
        }
        int noOfAcesToAccountFor = getNoAcesInHand(hand);
        while (score > 21 && noOfAcesToAccountFor > 0){
            score -= 10;
            noOfAcesToAccountFor--;
        }
        return score;
    }

    private static int getNoAcesInHand(ArrayList<Card> hand){
        int aceCount = 0;
        for (Card card : hand){
            Rank rank = card.getRank();
            if (rank == Rank.ACE){
                aceCount++;
            }
        }
        return aceCount;
    }

    public static ArrayList<Player> getPlayersByHandValue(ArrayList<Player> players){
        ArrayList<Player> copyOfPlayers = new ArrayList<>(players);
        Collections.sort(copyOfPlayers, (p1, p2) -> {
            BlackJackScorer.ScoreType p1ScoreType = BlackJackScorer.getScoreType(p1.getHand());
            BlackJackScorer.ScoreType p2ScoreType = BlackJackScorer.getScoreType(p2.getHand());
            int sortOrder = p1ScoreType.compareTo(p2ScoreType);
            if (sortOrder != 0) {
                return sortOrder;
            }
            int p1Score = BlackJackScorer.getScore(p1.getHand());
            int p2Score = BlackJackScorer.getScore(p2.getHand());
            return p2Score - p1Score;
        });
        return copyOfPlayers;

    }

    public static boolean getIsPlayerAbleToHit(Player player) {
        return (BlackJackScorer.getScoreType(player.getHand()) == BlackJackScorer.ScoreType.UNDER_21);
    }

    public static GameState getGameOutcome(ArrayList<Card> playerHand, ArrayList<Card> dealerHand){
        BlackJackScorer.ScoreType playerScoreType = BlackJackScorer.getScoreType(playerHand);
        BlackJackScorer.ScoreType dealerScoreType = BlackJackScorer.getScoreType(dealerHand);
        Integer playerScore = BlackJackScorer.getScore(playerHand);
        Integer dealerScore = BlackJackScorer.getScore(dealerHand);
        if (playerScoreType == ScoreType.BUST) {
            return GameState.LOSE;
        } else if (dealerScore == playerScore && dealerScoreType == playerScoreType) {
            return GameState.DRAW;
        } else if (playerScore > dealerScore || dealerScoreType == ScoreType.BUST) {
            return GameState.WIN;
        } else {
            return GameState.LOSE;
        }
    }


}
