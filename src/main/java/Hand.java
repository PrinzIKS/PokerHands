import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {

    private final String originalCards;
    private final List<Card> cards = new ArrayList<>();

    public Hand(String hand) {
        this.originalCards = hand;
        for (String value : this.originalCards.split(" ")) {
            cards.add(new Card(value));
        }
        Collections.sort(cards);
        Collections.reverse(cards);
    }

    public String getOriginalCards() {
        return this.originalCards;
    }

    @Override
    public int compareTo(Hand hand) {
        return compareCardValues(cards, hand.cards);
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
