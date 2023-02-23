public class NeverStickPlayer extends Player {

    public NeverStickPlayer(String name) {
        super(name);
    }

    @Override
    boolean getIsHitting() {
        return true;
    }


}
