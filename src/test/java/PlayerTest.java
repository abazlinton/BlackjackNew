import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player;
    Card card;
    Card card2;

    @Before
    public void setup(){
        player = new HumanPlayer("Ally");
        card = new Card(Suit.DIAMONDS, Rank.ACE);
        card2 = new Card(Suit.SPADES, Rank.FOUR);
    }

    @Test
    public void playerHasName(){
        assertEquals("Ally", player.getName());
    }

    @Test
    public void playerCanTakeCard(){
        player.addCardToHand(card);
        assertEquals(1, player.getHand().size());
    }


}
