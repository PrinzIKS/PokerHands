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

    private boolean isThreeOfAKind() {
        return cards.get(0).getValue() == cards.get(2).getValue()
                || cards.get(1).getValue() == cards.get(3).getValue()
                || cards.get(2).getValue() == cards.get(4).getValue();
    }

    private int countPairs() {
        int pairs = 0;
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getValue() == cards.get(i + 1).getValue()) {
                pairs++;
                i++;
            }
        }
        return pairs;
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
        Rank rank = Rank.HIGH_CARD;
        if (isStraight && isFlush && cards.get(0).getValue() == CardValue.ACE) {
            rank = Rank.ROYAL_FLUSH;
        } else if (isStraight && isFlush) {
            rank = Rank.STRAIGHT_FLUSH;
        } else if (this.isFourOfAKind()) {
            this.swapThirdCardWithFirst();
            rank = Rank.FOUR_OF_A_KIND;
        } else if (this.isFullHouse()) {
            this.swapThirdCardWithFirst();
            rank = Rank.FULL_HOUSE;
        } else if (isFlush) {
            rank = Rank.FLUSH;
        } else if (isStraight) {
            rank = Rank.STRAIGHT;
        } else if (this.isThreeOfAKind()) {
            this.swapThirdCardWithFirst();
            rank = Rank.THREE_OF_A_KIND;
        } else if (this.countPairs() == 2) {
            this.movePairsToFront();
            rank = Rank.TWO_PAIRS;
        } else if (this.countPairs() == 1) {
            this.movePairsToFront();
            rank = Rank.PAIR;
        }
        return rank;
    }

    //todo method name
    private void swapThirdCardWithFirst() {
        if (cards.get(0).getValue() != cards.get(2).getValue()) {
            Collections.swap(cards, 0, 2);
        }
    }

    private void movePairsToFront() {
        int endIndex = 0;
        for (int i = cards.size() - 1; i > endIndex; i--) {
            if (cards.get(i).getValue() == cards.get(i - 1).getValue()) {
                cards.add(0, cards.get(i));
                cards.remove(i + 1);
                cards.add(0, cards.get(i));
                cards.remove(i + 1);
                endIndex = endIndex + 2;
                i = cards.size();
            }
        }
    }

}
