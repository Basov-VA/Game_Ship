import java.awt.*;

public abstract class Unit {
    public int x;
    public int y;
    public int speed;
    public double angle;
    public Image image;
    public Direction direction;


    public Unit(int x, int y, int speed, double angle, Image image) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.angle = angle;
        this.image = image;
        this.direction = new Direction();
    }

    public void processKeyPressed(KeyBoardEvent.Directions direction, boolean isPressed) {
        switch (direction) {
            case UP -> {
                this.direction.up = isPressed;
                this.direction.down = false;
            }
            case DOWN -> {
                this.direction.down = isPressed;
                this.direction.up = false;
            }
            case RIGHT -> {
                this.direction.right = isPressed;
                this.direction.left = false;
            }
            case LEFT -> {
                this.direction.left = isPressed;
                this.direction.right = false;
            }
        }
    }

    public void draw(Graphics g) { };

    public void move() { };
}
