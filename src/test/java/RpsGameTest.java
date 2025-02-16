import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.rps.game.RpsGame;
import org.rps.players.BotPlayer;
import org.rps.players.HumanPlayer;
import org.rps.utils.IOProvider;

import static org.mockito.Mockito.*;

public class RpsGameTest {

    private IOProvider ioProvider;
    private HumanPlayer humanPlayer;
    private BotPlayer botPlayer;

    @BeforeEach
    public void setup() {
        ioProvider = mock(IOProvider.class);
        humanPlayer = mock(HumanPlayer.class);
        botPlayer = mock(BotPlayer.class);
    }

    @Test
    public void testGameInitialization() {
        RpsGame game = new RpsGame(humanPlayer, botPlayer, ioProvider);
        game.play();
        verify(ioProvider, atLeastOnce()).printWithNewLine(anyString());
    }
}
