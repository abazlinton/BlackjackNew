import java.util.ArrayList;
import java.util.HashMap;

public class BlackJackCardRank {

    private static HashMap<Rank, Integer> valueLookup = new HashMap<>();

    static {
        for (Rank rank: Rank.values()){
            valueLookup.put(rank, rank.getValue());
        }
        valueLookup.put(Rank.JACK, 10);
        valueLookup.put(Rank.QUEEN, 10);
        valueLookup.put(Rank.KING, 10);
        valueLookup.put(Rank.ACE, 11);
    }

    public static int getValue(Rank rank){
        return valueLookup.get(rank);
    }

}
