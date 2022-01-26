public class PokerGame {

    private Hand hand1;
    private Hand hand2;

    public PokerGame(Hand hand1, Hand hand2) {
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public Hand compareHands() {
        int compareValue = hand1.compareTo(hand2);
        if (compareValue > 0) {
            return hand1;
        } else if (compareValue < 0) {
            return hand2;
        }
        return null;
    }

}
