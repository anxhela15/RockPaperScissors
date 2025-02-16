import org.junit.jupiter.api.Test;
import org.rps.core.Outcome;

import static org.junit.jupiter.api.Assertions.*;

public class OutcomeTest {

    @Test
    public void testGetMessage() {
        assertEquals("You win this round!", Outcome.WIN.getMessage());
        assertEquals("You lose this round!", Outcome.LOSE.getMessage());
        assertEquals("It's a draw!", Outcome.DRAW.getMessage());
    }
}
