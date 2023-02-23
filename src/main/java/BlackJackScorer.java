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

    public static boolean getIsPlayerAbleToHit(Player player) {
        return (BlackJackScorer.getScoreType(player.getHand()) == BlackJackScorer.ScoreType.UNDER_21);
    }

    public static GameState getGameOutcome(ArrayList<Card> playerHand, ArrayList<Card> dealerHand){
        ScoreType playerScoreType = getScoreType(playerHand);
        ScoreType dealerScoreType = getScoreType(dealerHand);
        int playerScore = getScore(playerHand);
        int dealerScore = getScore(dealerHand);
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
