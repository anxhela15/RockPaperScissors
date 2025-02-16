import org.junit.jupiter.api.Test;
import org.rps.core.Hand;
import org.rps.core.HandFactory;
import org.rps.players.BotPlayer;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BotPlayerTest {

    @Test
    public void testRandomHandSelection() {
        BotPlayer botPlayer = new BotPlayer();
        HandFactory handFactory = HandFactory.getInstance();
        Map<String, Hand> handMap = Map.of(
                "r", handFactory.getRockHand(),
                "p", handFactory.getPaperHand(),
                "s", handFactory.getScissorsHand()
        );

        for (int i = 0; i < 100; i++) { // Test multiple iterations for randomness
            Hand hand = botPlayer.getHand(handMap);
            assertNotNull(hand);
            assertTrue(handMap.containsValue(hand));
        }
    }
}
