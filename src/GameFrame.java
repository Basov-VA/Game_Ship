import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private final GamePanel gamePanel;

    public GameFrame(int size) throws HeadlessException {
        setBounds(100, 100, size, size);
        this.gamePanel = new GamePanel();
    }

    public void startLoop() throws HeadlessException {
        gamePanel.startEvent();
        add(gamePanel);
        setVisible(true);
    }
}
