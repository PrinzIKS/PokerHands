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
        int score1 = hand1.getHighestCard();
        int score2 = hand2.getHighestCard();
        return score1 > score2 ? hand1 : hand2;
    }

}
