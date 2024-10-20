import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Unit {
    public int x;
    public int y;
    public int speed;
    public double angle;
    public int hp;
    public BufferedImage image;
    public Direction direction;

    public Unit(int x, int y, int speed, double angle, int hp, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.angle = angle;
        this.image = image;
        this.hp = hp;
        this.direction = new Direction();

    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        double xRot = x + (double) image.getWidth(null) / 2;
        double yRot = y + (double) image.getHeight(null) / 2;

        g2d.rotate(angle, xRot, yRot);
        g2d.drawImage(image, x, y, null);
        g2d.rotate(-angle, xRot, yRot);
    }

    public void move() {
        int dx = (int)(Math.sin(angle) * speed);
        int dy = (int)(-Math.cos(angle) * speed);

        int forwardRatio = (this.direction.up ? 1 : 0) + (this.direction.down ? -1 : 0);
        int angleRatio = ((this.direction.right ? 1 : 0) + (this.direction.left ? -1 : 0)) * (forwardRatio == -1 ? -1 : 1);

        this.x += dx * forwardRatio;
        this.y += dy * forwardRatio;
        this.angle += 0.1 * angleRatio;
    }

    public void getDamage(int damage) {
        this.hp -= damage;
    }
}
