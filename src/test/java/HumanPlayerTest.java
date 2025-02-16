import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rps.core.Hand;
import org.rps.players.HumanPlayer;
import org.rps.utils.IOProvider;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HumanPlayerTest {

    private IOProvider ioProvider;
    private HumanPlayer humanPlayer;

    @BeforeEach
    public void setup() {
        ioProvider = mock(IOProvider.class);
        humanPlayer = new HumanPlayer(ioProvider);
    }

    @Test
    public void testValidInput() {
        when(ioProvider.getString()).thenReturn("r");
        Map<String, Hand> handMap = Map.of("r", mock(Hand.class));

        Hand hand = humanPlayer.getHand(handMap);

        assertNotNull(hand);
        verify(ioProvider).print("Choose your move (r): ");
    }

    @Test
    public void testInvalidInput() {
        when(ioProvider.getString()).thenReturn("x", "r"); // Invalid, then valid
        Map<String, Hand> handMap = Map.of("r", mock(Hand.class));

        Hand hand = humanPlayer.getHand(handMap);

        assertNotNull(hand);
        verify(ioProvider, times(2)).print(anyString());
    }
}
