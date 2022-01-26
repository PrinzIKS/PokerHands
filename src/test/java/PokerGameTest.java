import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PokerGameTest {

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

    @Test
    public void flushWins() {
        Hand winningHand = new Hand("2H 3H 8H 5H 4H");
        Hand losingHand = new Hand("2H 3D 4S 5C 9D");

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
    public void straightWins() {
        Hand winningHand = new Hand("2H 3H 6S 5H 4H");
        Hand losingHand = new Hand("2D 4S 8D 5D 4D");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void straightWinsByHighCard() {
        Hand winningHand  = new Hand("3D 4S 7D 5D 6D");
        Hand losingHand = new Hand("2H 3H 6S 5H 4H");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

    @Test
    public void straightDraw() {
        Hand winningHand  = new Hand("3D 4S 7D 5D 6D");
        Hand losingHand = new Hand("3H 4H 5S 7H 6H");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertNull(winner);
    }

    @Test
    public void flushWinsVsStraight() {
        Hand winningHand  = new Hand("3D 4D 7D 5D 6D");
        Hand losingHand = new Hand("8H 4H 5S 7H 6H");

        PokerGame poker = new PokerGame(losingHand, winningHand);
        Hand winner = poker.compareHands();

        assertEquals(winningHand, winner);
    }

}
