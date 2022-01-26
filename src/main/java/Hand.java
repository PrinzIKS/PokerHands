import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {

    private final List<Card> cards = new ArrayList<>();
    private final boolean isFlush;
    private final boolean isStraight;

    public Hand(String hand) {
        for (String value : hand.split(" ")) {
            cards.add(new Card(value));
        }
        Collections.sort(cards);
        Collections.reverse(cards);
        this.isFlush = this.isFlush();
        this.isStraight = this.isStraight();
    }

    @Override
    public int compareTo(Hand hand) {
        if (this.isFlush && !hand.isFlush) {
            return 1;
        }
        if (!this.isFlush && hand.isFlush) {
            return -1;
        }
        if (this.isStraight && !hand.isStraight) {
            return 1;
        }
        if (!this.isStraight && hand.isStraight) {
            return -1;
        }
        return compareCardValues(cards, hand.cards);
    }

    private boolean isFlush() {
        boolean isFlush = true;
        for (int i = 0; i < cards.size() - 1; i++) {
            isFlush = isFlush && cards.get(i).isSameSuit(cards.get(i + 1));
        }
        return isFlush;
    }

    private boolean isStraight() {
        boolean isStraight = true;
        for (int i = 0; i < cards.size() - 1; i++) {
            isStraight = isStraight && cards.get(i).compareTo(cards.get(i+1)) == 1;
        }
        return isStraight;
    }

    private int compareCardValues(List<Card> hand1, List<Card> hand2) {
        for (int i = 0; i < hand1.size(); i++) {
            int compareValue = hand1.get(i).compareTo(hand2.get(i));
            if (compareValue != 0)
                return compareValue;
        }
        return 0;
    }

}
