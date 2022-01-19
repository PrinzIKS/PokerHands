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
        String hand1 = "2H 3D 4S 5C 7D";
        String hand2 = "2C 3H AD 5D 4H";

        poker.setHand1(hand1);
        poker.setHand2(hand2);

        Hand winner = poker.compareHands();

        assertEquals(hand2, winner.getOriginalCards());
    }

}
