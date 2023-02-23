import java.util.ArrayList;

public abstract class Player {
    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {

        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        this.hand.add(card);
    }

    @Override
    public String toString(){
        return this.name + this.hand;
    }

    // false = Twist
    // true = Stick
    abstract boolean getIsHitting();

}
