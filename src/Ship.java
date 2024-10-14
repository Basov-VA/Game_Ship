import java.awt.*;

public class Ship extends Unit implements HealthPoint {
    public Weapon weapon;
    public int health = 1;

    public Ship(int x, int y, int speed, double angle, Image image, Weapon weapon, int health) {
        super(x, y, speed, angle, image);
        this.weapon = weapon;
        this.health = health;
    }

    @Override
    public void move() {
        int dx = (int)(Math.sin(angle) * speed);
        int dy = (int)(-Math.cos(angle) * speed);
        if(this.direction.up)
        {
            this.x += dx;
            this.y += dy;
        }
        if(this.direction.down)
        {
            this.x -= dx;
            this.y -= dy;
        }
        if(this.direction.left)
        {
            this.angle -= 0.1;
        }
        if(this.direction.right)
        {
            this.angle += 0.1;
        }

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(angle, x + image.getWidth(null)/2,
                y + image.getHeight(null)/2);
        g2d.drawImage(image, x, y, null);
        g2d.rotate(-angle, x + image.getWidth(null)/2,
                y + image.getHeight(null)/2);
    }

    @Override
    public int getHealthPoint() {
        return this.health;
    }

    @Override
    public void setHealthPoint(int healthPoint) {
        this.health = healthPoint;
    }

    @Override
    public boolean isAlive() {
        return this.health != 0;
    }
}
