import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public boolean getIsHitting() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("(S)tick or (H)it me?");
        String choice = keyboard.nextLine().toLowerCase();
        if (choice.equals("h")) return true;
        return false;
    }
}
