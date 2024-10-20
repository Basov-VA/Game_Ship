import java.awt.event.KeyEvent;
import java.util.Map;

public class KeyBoardEvent {
    public enum KeyBoards {
        WASD,
        ARROWS
    }

    public enum Action {
        NONE,
        UP,
        DOWN,
        RIGHT,
        LEFT,
        ATTACK
    }

    private static final Map<Integer, Action> WASD_KEYS = Map.of(
            KeyEvent.VK_UP, Action.UP,
            KeyEvent.VK_DOWN, Action.DOWN,
            KeyEvent.VK_RIGHT, Action.RIGHT,
            KeyEvent.VK_LEFT, Action.LEFT,
            KeyEvent.VK_SLASH, Action.ATTACK
    );

    private static final Map<Integer, Action> ARROWS_KEYS = Map.of(
            KeyEvent.VK_W, Action.UP,
            KeyEvent.VK_S, Action.DOWN,
            KeyEvent.VK_D, Action.RIGHT,
            KeyEvent.VK_A, Action.LEFT,
            KeyEvent.VK_SPACE, Action.ATTACK
    );

    private static final Map<KeyBoards, Map<Integer, Action>> getKeyboard = Map.of(
            KeyBoards.WASD, WASD_KEYS,
            KeyBoards.ARROWS, ARROWS_KEYS
    );

    public static Action processKey(Integer eventCode, KeyBoards keyBoardType) {
        Map<Integer, Action> keyBoard = getKeyboard.get(keyBoardType);
        if (!keyBoard.containsKey(eventCode)) {
            return Action.NONE;
        }
        return keyBoard.get(eventCode);
    }
}
