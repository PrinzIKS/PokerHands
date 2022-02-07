import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PokerGameTest {

    @Test
    public void royalFlushDraw() {
        Hand winningHand = new Hand("AD KD QD JD TD");
        Hand losingHand = new Hand("AS KS QS JS TS");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertNull(winner);
    }

    @Test
    public void royalFlushWinsVsStraightFlush() {
        Hand winningHand = new Hand("AD KD QD JD TD");
        Hand losingHand = new Hand("8H 4H 5H 7H 6H");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void straightFlushDraw() {
        Hand winningHand = new Hand("3D 4D 7D 5D 6D");
        Hand losingHand = new Hand("3H 4H 7H 5H 6H");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertNull(winner);
    }

    @Test
    public void straightFlushWinsVsFourOfAKind() {
        Hand winningHand = new Hand("8H 4H 5H 7H 6H");
        Hand losingHand = new Hand("4D 4H 4C 4S TD");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void fourOfAKindWinsVsLowerFourOfAKind() {
        Hand winningHand = new Hand("5D 5H 5C 5S 6H");
        Hand losingHand = new Hand("4D 4H 4C 4S TD");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void fourOfAKindWinsVsFullHouse() {
        Hand winningHand = new Hand("5D 5H 5C 5S 6H");
        Hand losingHand = new Hand("4S 4H 8S 8D 4C");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void fullHouseWinsVsFullHouse() {
        Hand winningHand = new Hand("5D 5H 5C 6S 6H");
        Hand losingHand = new Hand("4S 4H 8S 8D 4C");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void fullHouseWinsVsFlush() {
        Hand winningHand = new Hand("5D 5H 5C 6S 6H");
        Hand losingHand = new Hand("7H 4H 8H 2H TH");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void flushWinsVsStraight() {
        Hand winningHand = new Hand("2H 3H 8H 5H 4H");
        Hand losingHand = new Hand("2H 3D 4S 5C 6D");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void flushDraw() {
        Hand winningHand = new Hand("2H 3H 8H 5H 4H");
        Hand losingHand = new Hand("2D 3D 8D 5D 4D");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertNull(winner);
    }

    @Test
    public void flushWinsByHighestCard() {
        Hand winningHand = new Hand("2H 3H AH 5H 4H");
        Hand losingHand = new Hand("2D 3D 8D 5D 4D");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void straightWinsVsThreeOfAKind() {
        Hand winningHand = new Hand("2H 3H 6S 5H 4H");
        Hand losingHand = new Hand("2D 2S 2D 5D 4D");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void straightWinsByHighCard() {
        Hand winningHand = new Hand("3D 4S 7D 5D 6D");
        Hand losingHand = new Hand("2H 3H 6S 5H 4H");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void straightDraw() {
        Hand winningHand = new Hand("3D 4S 7D 5D 6D");
        Hand losingHand = new Hand("3H 4H 5S 7H 6H");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertNull(winner);
    }

    @Test
    public void threeOfAKindWinsVsTwoPairs() {
        Hand winningHand = new Hand("2H 3H 3D 3S 4H");
        Hand losingHand = new Hand("2D 4S KD KH 4D");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void threeOfAKindVsThreeOfAKind() {
        Hand winningHand = new Hand("2H 3H 3D 3S 4H");
        Hand losingHand = new Hand("2S 2D 2C 5H 4D");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void twoPairsWinsVsPair() {
        Hand winningHand = new Hand("2C 2H 4D 4S 8H");
        Hand losingHand = new Hand("2S 2D 9C 6H 4C");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void twoPairsDraw() {
        Hand winningHand = new Hand("2C 2H 4D 4S 8H");
        Hand losingHand = new Hand("2S 2D 4C 4H 8C");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertNull(winner);
    }

    @Test
    public void twoPairsHighCardWins() {
        Hand winningHand = new Hand("4C 4H 9D 9S 7H");
        Hand losingHand = new Hand("4S 4D 9C 9H 2C");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void twoPairsWinsVsTwoPairsByHigherFirstPair() {
        Hand winningHand = new Hand("4C 4H 9D 9S TH");
        Hand losingHand = new Hand("4S 4D 8C 8H AC");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void twoPairsHighCardFirstWinsVsTwoPairsHighCardFirstByHigherFirstPair() {
        Hand winningHand = new Hand("4C 4H 9D 9S TH");
        Hand losingHand = new Hand("4S 4D 8C 8H AC");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void twoPairsHighCardFirstWinsVsTwoPairsHighCardMiddleByHigherFirstPair() {
        Hand winningHand = new Hand("4C 4H 9D 9S TH");
        Hand losingHand = new Hand("4S 4D 8C 8H 6C");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void twoPairsHighCardFirstWinsVsTwoPairsHighCardLastByHigherFirstPair() {
        Hand winningHand = new Hand("4C 4H 9D 9S TH");
        Hand losingHand = new Hand("4S 4D 8C 8H 2C");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void twoPairsHighCardMiddleWinsVsTwoPairsHighCardFirstByHigherFirstPair() {
        Hand winningHand = new Hand("4C 4H 9D 9S 6H");
        Hand losingHand = new Hand("4S 4D 8C 8H TC");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void twoPairsHighCardMiddleWinsVsTwoPairsHighCardMiddleByHigherFirstPair() {
        Hand winningHand = new Hand("4C 4H 9D 9S 6H");
        Hand losingHand = new Hand("4S 4D 8C 8H 6C");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void twoPairsHighCardMiddleWinsVsTwoPairsHighCardLastByHigherFirstPair() {
        Hand winningHand = new Hand("4C 4H 9D 9S 6H");
        Hand losingHand = new Hand("4S 4D 8C 8H 2C");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void twoPairsHighCardLastWinsVsTwoPairsHighCardFirstByHigherFirstPair() {
        Hand winningHand = new Hand("4C 4H 9D 9S 2H");
        Hand losingHand = new Hand("4S 4D 8C 8H TC");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void twoPairsHighCardLastWinsVsTwoPairsHighCardMiddleByHigherFirstPair() {
        Hand winningHand = new Hand("4C 4H 9D 9S 2H");
        Hand losingHand = new Hand("4S 4D 8C 8H 6C");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void twoPairsHighCardLastWinsVsTwoPairsHighCardLastByHigherFirstPair() {
        Hand winningHand = new Hand("4C 4H 9D 9S 2H");
        Hand losingHand = new Hand("4S 4D 8C 8H 2C");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void twoPairsWinsVsTwoPairsByHigherSecondPair() {
        Hand winningHand = new Hand("5C 5H 9D 9S TH");
        Hand losingHand = new Hand("4S 4D 9C 9H AC");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void pairWinsVsHighCard() {
        Hand winningHand = new Hand("5C 5H 7D 9S TH");
        Hand losingHand = new Hand("4S 3D 9C 2H AC");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void pairDraw() {
        Hand winningHand = new Hand("5C 5H 7D 9S TH");
        Hand losingHand = new Hand("5S 5D 7C 9D TD");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertNull(winner);
    }

    @Test
    public void pairWinsVsPairByHighCard() {
        Hand winningHand = new Hand("7C 7H 8D 9S TH");
        Hand losingHand = new Hand("7S 7D 9C 2H 6C");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void pairWinsVsPairByHigherPairAce() {
        Hand winningHand = new Hand("AC AH 8D 9S TH");
        Hand losingHand = new Hand("7S 7D 9C 2H 6C");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void pairWinsVsPairByHigherPair() {
        Hand winningHand = new Hand("7C 7H 4D 3S TH");
        Hand losingHand = new Hand("6S 6D 4C 9H KC");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    // todo add more test

    @Test
    public void highCardWins() {
        Hand winningHand = new Hand("2C 3H 8D 5D 4H");
        Hand losingHand = new Hand("2H 3D 4S 5C 7D");

        PokerGame poker = new PokerGame(winningHand, losingHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void highCardAceWins() {
        Hand winningHand = new Hand("2C 3H 6D AD 4H");
        Hand losingHand = new Hand("2H 3D 7S 5C 4D");

        PokerGame poker = new PokerGame(winningHand, losingHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void highCardAceSevenWins() {
        Hand winningHand = new Hand("2H 3D AS 4C 7D");
        Hand losingHand = new Hand("2C 3H AD 6D 5H");

        PokerGame poker = new PokerGame(winningHand, losingHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void highCardDraw() {
        Hand winningHand = new Hand("2H 3D AS 6C 7D");
        Hand losingHand = new Hand("2C 3H AD 6D 7H");

        PokerGame poker = new PokerGame(winningHand, losingHand);
        Hand winner = poker.compareHands();

        assertNull(winner);
    }

    // TODO Straight A-5

}
