import java.awt.*;


public class Ship extends Unit {
    private Weapon weapon;
    private int health = 100;
    // TODO: add keyboard type var & remove from GamePanel

    public Ship(int x, int y, int speed, double angle, Image image, Weapon weapon, int health) {
        super(x, y, speed, angle, image);
        this.weapon = weapon;
        this.health = health;
    }

    @Override
    public void move() {
        int dx = (int)(Math.sin(angle) * speed);
        int dy = (int)(-Math.cos(angle) * speed);

        int forwardRatio = (this.direction.up ? 1 : 0) + (this.direction.down ? -1 : 0);
        int angleRatio = ((this.direction.right ? 1 : 0) + (this.direction.left ? -1 : 0)) * (forwardRatio == -1 ? -1 : 1);

        this.x += dx * forwardRatio;
        this.y += dy * forwardRatio;
        this.angle += 0.1 * angleRatio;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        double xRot = x + (double) image.getWidth(null) / 2;
        double yRot = y + (double) image.getHeight(null) / 2;

        g2d.rotate(angle, xRot, yRot);
        g2d.drawImage(image, x, y, null);
        g2d.rotate(-angle, xRot, yRot);
    }
}
