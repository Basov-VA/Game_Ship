import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;


public class GamePanel extends JPanel implements KeyListener, ActionListener {
    public Timer timer;
    public Vector<Ship> ships;

    public GamePanel() {
        setFocusable(true);
        addKeyListener(this);
        this.timer = new Timer(25, this);
        this.ships = new Vector<>();
    }

    public void startEvent() {
        timer.start();

        Image shipSprite;
        try {
            shipSprite = ImageIO.read(new File("src/assets/ship100.png"));
        }
        catch (IOException e) {
            System.out.println("Залупа а не игра");
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 2; ++i) {
            ships.add(
                    new Ship(50, 50, 20, 0, shipSprite, null, 1)
            );
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ship ship : ships) {
            ship.draw(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    private void keyEventProcess(Integer keyCode, boolean isPressed) {
        for (int i = 0; i < 2; ++i) {
            ships.get(i).processKeyPressed(
                    KeyBoardEvent.processKey(
                            keyCode,
                            KeyBoardEvent.KeyBoards.values()[i]
                    ),
                    isPressed
            );
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyEventProcess(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyEventProcess(e.getKeyCode(), false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Ship ship : ships) {
            ship.move();
        }
        repaint();
    }
}
