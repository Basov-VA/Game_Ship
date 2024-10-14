import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    public Ship orc;
    public Ship orc1;
    public Timer timer;


    public GamePanel() {
        setFocusable(true);
        addKeyListener(this);
        this.timer = new Timer(50, this);
        timer.start();


        try {
            Image image1 = ImageIO.read(new File("src/ship100.png"));
            orc = new Ship(50,50,20,0,image1,null,1);
            orc1 = new Ship(50,50,20,0,image1,null,1);
        }
        catch (IOException e) {
            System.out.println("Залупа а не игра");
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        orc1.draw(g);
        orc.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Движение вперед (по текущему углу)
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            orc.direction.up = true;
            orc.direction.down = false;
        }

        // Движение назад (по текущему углу)
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            orc.direction.up = false;
            orc.direction.down = true;
        }

        // Поворот вправо
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            orc.direction.right = true;
        }

        // Поворот влево
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            orc.direction.left = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_W) {
            orc1.direction.up = true;
            orc1.direction.down = false;
        }

        // Движение назад (по текущему углу)
        if (e.getKeyCode() == KeyEvent.VK_S) {
            orc1.direction.up = false;
            orc1.direction.down = true;
        }

        // Поворот вправо
        if (e.getKeyCode() == KeyEvent.VK_D) {
            orc1.direction.right = true;
        }

        // Поворот влево
        if (e.getKeyCode() == KeyEvent.VK_A) {
            orc1.direction.left = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Остановка движения при отпускании клавиш
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
            orc.direction.up = false;
            orc.direction.down = false;
        }

        // Остановка поворота при отпускании клавиш
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT) {
            orc.direction.right = false;
            orc.direction.left = false;
        }


        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D) {
            orc1.direction.right = false;
            orc1.direction.left = false;
        }
        // Остановка движения при отпускании клавиш
        if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_W) {
            orc1.direction.up = false;
            orc1.direction.down = false;
        }
        System.out.println(e.getKeyCode());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        orc.move();
        orc1.move();
        repaint();
    }
}
