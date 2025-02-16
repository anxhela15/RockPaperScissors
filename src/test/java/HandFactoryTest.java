import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.rps.core.Hand;
import org.rps.core.HandFactory;
import org.rps.core.Outcome;


public class HandFactoryTest {

    @Test
    public void testSingletonInstance() {
        HandFactory instance1 = HandFactory.getInstance();
        HandFactory instance2 = HandFactory.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    public void testRockHandRules() {
        HandFactory factory = HandFactory.getInstance();
        Hand rock = factory.getRockHand();

        assertEquals(Outcome.WIN, rock.getOutcome(factory.getScissorsHand()));
        assertEquals(Outcome.LOSE, rock.getOutcome(factory.getPaperHand()));
        assertEquals(Outcome.DRAW, rock.getOutcome(factory.getRockHand()));
    }

    @Test
    public void testPaperHandRules() {
        HandFactory factory = HandFactory.getInstance();
        Hand paper = factory.getPaperHand();

        assertEquals(Outcome.WIN, paper.getOutcome(factory.getRockHand()));
        assertEquals(Outcome.LOSE, paper.getOutcome(factory.getScissorsHand()));
        assertEquals(Outcome.DRAW, paper.getOutcome(factory.getPaperHand()));
    }

    @Test
    public void testScissorsHandRules() {
        HandFactory factory = HandFactory.getInstance();
        Hand scissors = factory.getScissorsHand();

        assertEquals(Outcome.WIN, scissors.getOutcome(factory.getPaperHand()));
        assertEquals(Outcome.LOSE, scissors.getOutcome(factory.getRockHand()));
        assertEquals(Outcome.DRAW, scissors.getOutcome(factory.getScissorsHand()));
    }
}
