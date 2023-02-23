import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BlackJackScorerTest {


    @Test
    public void can_detect_blackjack() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.TEN));
        assertEquals(BlackJackScorer.ScoreType.BLACKJACK, BlackJackScorer.getScoreType(hand));
        assertEquals(21, BlackJackScorer.getScore(hand));
    }

    @Test
    public void can_detect_non_blackjack_21() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.TEN));
        hand.add(new Card(Suit.CLUBS, Rank.TEN));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        assertEquals(BlackJackScorer.ScoreType.NOT_BLACKJACK_21, BlackJackScorer.getScoreType(hand));
        assertEquals(21, BlackJackScorer.getScore(hand));
    }

    @Test
    public void can_detect_with_aces_under_21() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.TEN));
        hand.add(new Card(Suit.CLUBS, Rank.NINE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        assertEquals(BlackJackScorer.ScoreType.UNDER_21, BlackJackScorer.getScoreType(hand));
        assertEquals(20, BlackJackScorer.getScore(hand));
    }

    @Test
    public void can_detect_some_ace_1_some_11_21() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.SEVEN));
        assertEquals(BlackJackScorer.ScoreType.NOT_BLACKJACK_21, BlackJackScorer.getScoreType(hand));
        assertEquals(21, BlackJackScorer.getScore(hand));
    }

    @Test
    public void can_detect_some_ace_1_some_11_under_21() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.SIX));
        assertEquals(BlackJackScorer.ScoreType.UNDER_21, BlackJackScorer.getScoreType(hand));
        assertEquals(20, BlackJackScorer.getScore(hand));
    }

    @Test
    public void can_detect_four_aces_as_scoring_1_21() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.TEN));
        hand.add(new Card(Suit.CLUBS, Rank.SEVEN));
        assertEquals(BlackJackScorer.ScoreType.NOT_BLACKJACK_21, BlackJackScorer.getScoreType(hand));
        assertEquals(21, BlackJackScorer.getScore(hand));
    }

    @Test
    public void can_detect_four_aces_as_scoring_1_total_under_21() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.TEN));
        hand.add(new Card(Suit.CLUBS, Rank.FIVE));
        assertEquals(BlackJackScorer.ScoreType.UNDER_21, BlackJackScorer.getScoreType(hand));
        assertEquals(19, BlackJackScorer.getScore(hand));
    }

    @Test
    public void can_detect_four_aces_all_1_bust() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.TEN));
        hand.add(new Card(Suit.CLUBS, Rank.TEN));
        assertEquals(BlackJackScorer.ScoreType.BUST, BlackJackScorer.getScoreType(hand));
        assertEquals(24, BlackJackScorer.getScore(hand));
    }

}