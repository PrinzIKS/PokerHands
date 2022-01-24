import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerGameTest {

    private PokerGame poker;

    @BeforeEach
    public void setup() {
        poker = new PokerGame();
    }

    @Test
    public void highCardWins() {
        String hand1 = "2H 3D 4S 5C 7D";
        String hand2 = "2C 3H 8D 5D 4H";

        poker.setHand1(hand1);
        poker.setHand2(hand2);

        Hand winner = poker.compareHands();

        assertEquals(hand2, winner.getOriginalCards());
    }

    @Test
    public void highCardAceWins() {
        String hand1 = "2H 3D 7S 5C 4D";
        String hand2 = "2C 3H 6D AD 4H";

        poker.setHand1(hand1);
        poker.setHand2(hand2);

        Hand winner = poker.compareHands();

        assertEquals(hand2, winner.getOriginalCards());
    }

    @Test
    public void highCardAceSevenWins() {
        String hand1 = "2H 3D AS 4C 7D";
        String hand2 = "2C 3H AD 6D 5H";

        poker.setHand1(hand1);
        poker.setHand2(hand2);

        Hand winner = poker.compareHands();

        assertEquals(hand1, winner.getOriginalCards());
    }

}
