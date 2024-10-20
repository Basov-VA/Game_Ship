import java.awt.image.BufferedImage;

public class Bullet extends Unit {
    public int damage;

    public Bullet(int x, int y, int speed, double angle, BufferedImage image, int damage) {
        super(x, y, speed, angle, damage, image);
        this.direction.up = true;
        this.damage = damage;
    }
}
