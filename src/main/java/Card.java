public class Card implements Comparable<Card> {

    private final CardValue value;
    private final CardSuit suit;

    Card(String card) {
        switch (card.charAt(1)) {
            case 'C':
                this.suit = CardSuit.CLUBS;
                break;
            case 'H':
                this.suit = CardSuit.HEARTS;
                break;
            case 'D':
                this.suit = CardSuit.DIAMONDS;
                break;
            case 'S':
                this.suit = CardSuit.SPADES;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + card.charAt(1));
        }
        switch (card.charAt(0)) {
            case 'A':
                this.value = CardValue.ACE;
                break;
            case 'K':
                this.value = CardValue.KING;
                break;
            case 'Q':
                this.value = CardValue.QUEEN;
                break;
            case 'J':
                this.value = CardValue.JACK;
                break;
            case 'T':
                this.value = CardValue.TEN;
                break;
            case '9':
                this.value = CardValue.NINE;
                break;
            case '8':
                this.value = CardValue.EIGHT;
                break;
            case '7':
                this.value = CardValue.SEVEN;
                break;
            case '6':
                this.value = CardValue.SIX;
                break;
            case '5':
                this.value = CardValue.FIVE;
                break;
            case '4':
                this.value = CardValue.FOUR;
                break;
            case '3':
                this.value = CardValue.THREE;
                break;
            case '2':
                this.value = CardValue.TWO;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + card.charAt(0));
        }
    }

    @Override
    public int compareTo(Card card) {
        return value.toInteger() - card.value.toInteger();
    }

    public boolean isSameSuit(Card card) {
        return this.suit == card.suit;
    }

}
