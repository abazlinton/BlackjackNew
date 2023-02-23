public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString(){
        return this.rank.getName() + this.suit.getSuit();
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue() {
        return this.rank.getValue();
    }

}
