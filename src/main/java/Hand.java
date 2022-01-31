import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {

    private final List<Card> cards = new ArrayList<>();
    private final Rank rank;

    public Hand(String hand) {
        for (String value : hand.split(" ")) {
            cards.add(new Card(value));
        }
        Collections.sort(cards);
        Collections.reverse(cards);
        this.rank = this.calculateRank();
    }

    @Override
    public int compareTo(Hand hand) {
        if (this.rank.toInteger() > hand.rank.toInteger())
            return 1;
        if (this.rank.toInteger() < hand.rank.toInteger())
            return -1;
        return compareCardValues(cards, hand.cards);
    }

    private boolean isFullHouse() {
        return cards.get(0).getValue() == cards.get(2).getValue() && cards.get(3).getValue() == cards.get(4).getValue()
                || cards.get(0).getValue() == cards.get(1).getValue() && cards.get(2).getValue() == cards.get(4).getValue();
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
            isStraight = isStraight && cards.get(i).getValue().toInteger() == cards.get(i + 1).getValue().toInteger() + 1;
        }
        return isStraight;
    }

    private boolean isFourOfAKind() {
        return cards.get(0).getValue() == cards.get(3).getValue() || cards.get(1).getValue() == cards.get(4).getValue();
    }

    private int compareCardValues(List<Card> hand1, List<Card> hand2) {
        for (int i = 0; i < hand1.size(); i++) {
            int compareValue = hand1.get(i).compareTo(hand2.get(i));
            if (compareValue != 0)
                return compareValue;
        }
        return 0;
    }

    private Rank calculateRank() {
        boolean isStraight = this.isStraight();
        boolean isFlush = this.isFlush();
        if (isStraight && isFlush && cards.get(0).getValue() == CardValue.ACE) return Rank.ROYAL_FLUSH;
        if (isStraight && isFlush) return Rank.STRAIGHT_FLUSH;
        if (this.isFourOfAKind()) {
            this.sortFourOfAKind();
            return Rank.FOUR_OF_A_KIND;
        }
        if (this.isFullHouse()) {
            this.sortFullHouse();
            return Rank.FULL_HOUSE;
        }
        if (isFlush) return Rank.FLUSH;
        if (isStraight) return Rank.STRAIGHT;
        return Rank.HIGH_CARD;
    }

    private void sortFullHouse() {
        if (cards.get(0).getValue() != cards.get(2).getValue()) {
            Collections.reverse(cards);
        }
    }

    private void sortFourOfAKind() {
        if (cards.get(0).getValue() != cards.get(1).getValue()) {
            Collections.reverse(cards);
        }
    }

}
