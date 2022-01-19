public class Hand {

    private final String originalCards;


    public Hand(String hand) {
        this.originalCards = hand;
    }

    public String getOriginalCards() {
        return this.originalCards;
    }

    public int getHighestCard() {
        int highest = 0;
        String[] cards = this.originalCards.split(" ");
        for (int i = 0; i < cards.length; i++) {
            String card = cards[i];
            char c = card.charAt(0);
            if ('T' == c) {
                cards[i] = card.replace("T", "10");
            } else if ('J' == c) {
                cards[i] = card.replace("J", "11");
            } else if ('Q' == c) {
                cards[i] = card.replace("Q", "12");
            } else if ('K' == c) {
                cards[i] = card.replace("K", "13");
            } else if ('A' == c) {
                cards[i] = card.replace("A", "14");
            }
        }

        for (String c : cards) {
            int i = Integer.parseInt(c.substring(0, c.length()-1));
            if ( i > highest)  {
                highest = i;
            }
        }
        return highest;
    }

}
