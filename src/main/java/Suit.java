public enum Suit {


    HEARTS("H"),
    DIAMONDS("D"),
    CLUBS("C"),
    SPADES("S");


    private String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
}