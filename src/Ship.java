import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Ship extends Unit {
    private final Weapon weapon;
    public boolean isDead;
    // TODO: add keyboard type var & remove from GamePanel

    public Ship(int x, int y, int speed, double angle, BufferedImage image, int health) {
        super(x, y, speed, angle, health, image);
        this.weapon = new Weapon(this, 5);
        this.isDead = false;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        this.weapon.draw(g);
    }

    public void move(Ship other) {
        if (isDead) return;
        super.move();
        this.weapon.move(other);
    }

    @Override
    public void getDamage(int damage) {
        super.getDamage(damage);
        if (this.hp <= 0) this.kill();
    }

    public void processKeyPressed(KeyBoardEvent.Action direction, boolean isPressed) {
        switch (direction) {
            case UP -> this.direction.up = isPressed;
            case DOWN -> this.direction.down = isPressed;
            case RIGHT -> this.direction.right = isPressed;
            case LEFT -> this.direction.left = isPressed;
            case ATTACK -> { if (isPressed) this.attack(); }
        }
    }

    public void attack() {
        this.weapon.attack(
                this.x + this.image.getWidth() / 2,
                this.y + this.image.getHeight() / 2,
                this.angle
        );
    }

    void kill() {
        if (isDead) return;
        isDead = true;
        try {
            image = ImageIO.read(new File("src/assets/explosion.png"));
        }
        catch (IOException e) {
            System.out.println("Explosion asset load err");
            throw new RuntimeException(e);
        }
    }
}
