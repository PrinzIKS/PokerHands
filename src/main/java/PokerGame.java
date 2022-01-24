public class PokerGame {

    private Hand hand1;
    private Hand hand2;

    public void setHand1(String hand) {
        this.hand1 = new Hand(hand);
    }

    public void setHand2(String hand) {
        this.hand2 = new Hand(hand);
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
