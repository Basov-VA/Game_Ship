import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Weapon {
    Integer maxBulletsCount_;
    BufferedImage image;
    final Set<Bullet> bullets;
    Ship selfShip;

    public Weapon(Ship selfShip, Integer maxBulletsCount) {
        this.selfShip = selfShip;
        this.maxBulletsCount_ = maxBulletsCount;
        bullets = new CopyOnWriteArraySet<>();
        try {
            image = ImageIO.read(new File("src/assets/bullet.png"));
        }
        catch (IOException e) {
            System.out.println("Bullet asset load err");
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics g) {
        for (Bullet bullet : this.bullets) {
            bullet.draw(g);
        }
    }

    public void move(Unit unit) {
        System.out.println(bullets.size());
        for (Bullet bullet : this.bullets) {
            bullet.move();
            checkCollision(bullet, unit);
        }
    }

    public void attack(int x, int y, double angle) {
        this.bullets.add(new Bullet(x, y, 30, angle, this.image, 10));
    }

    public void checkCollision(Bullet bullet, Unit unit) {
        if (bullet.x < 0 || bullet.x > 1000 || bullet.y < 0 || bullet.y > 1000) {
            this.bullets.remove(bullet);
            return;
        }
        Rectangle bulletRect = new Rectangle(
                bullet.x + bullet.image.getHeight() / 2,
                bullet.y  + bullet.image.getWidth() / 2,
                bullet.image.getWidth() / 2,
                bullet.image.getHeight() / 2
        );
        Rectangle unitRect = new Rectangle(
                unit.x + unit.image.getHeight() / 2,
                unit.y  + unit.image.getWidth() / 2,
                unit.image.getWidth() / 2,
                unit.image.getHeight() / 2
        );
        if (!bulletRect.intersects(unitRect)) return;
        unit.getDamage(bullet.damage);
        this.bullets.remove(bullet);
    }
}
