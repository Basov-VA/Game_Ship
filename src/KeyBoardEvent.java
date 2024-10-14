import java.awt.event.KeyEvent;
import java.util.Map;

public class KeyBoardEvent {
    public enum KeyBoards {
        WASD,
        ARROWS
    }

    public enum Directions {
        NONE,
        UP,
        DOWN,
        RIGHT,
        LEFT,
    }

    private static final Map<Integer, Directions> WASD_KEYS = Map.of(
            KeyEvent.VK_UP, Directions.UP,
            KeyEvent.VK_DOWN, Directions.DOWN,
            KeyEvent.VK_RIGHT, Directions.RIGHT,
            KeyEvent.VK_LEFT, Directions.LEFT
    );

    private static final Map<Integer, Directions> ARROWS_KEYS = Map.of(
            KeyEvent.VK_W, Directions.UP,
            KeyEvent.VK_S, Directions.DOWN,
            KeyEvent.VK_D, Directions.RIGHT,
            KeyEvent.VK_A, Directions.LEFT
    );

    private static final Map<KeyBoards, Map<Integer, Directions>> getKeyboard = Map.of(
            KeyBoards.WASD, WASD_KEYS,
            KeyBoards.ARROWS, ARROWS_KEYS
    );

    public static Directions processKey(Integer eventCode, KeyBoards keyBoardType) {
        Map<Integer, Directions> keyBoard = getKeyboard.get(keyBoardType);
        if (!keyBoard.containsKey(eventCode)) {
            return Directions.NONE;
        }
        return keyBoard.get(eventCode);
    }
}
