public class DealerPlayer extends Player {

    public DealerPlayer(String name) {
        super(name);
    }

    @Override
    boolean getIsHitting() {
        int score = BlackJackScorer.getScore(this.getHand());
        if (score >= 16) {
            System.out.println(this.getName() + " is sticking - " + score);
            return false;
        }
        System.out.println(this.getName() + " is twisting");
        return true;
    }
}
