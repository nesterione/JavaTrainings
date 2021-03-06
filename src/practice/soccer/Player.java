package practice.soccer;

import java.awt.*;

public class Player {

    private Point position;
    private int radius;
    private Color color;
    private float speed;

    private int hitRadius;
    private boolean isHit;


    public Player(int x, int y, int radius, Color color, float speed) {
        this(new Point(x,y),radius,color, speed);
    }

    public Player(Point position, int radius, Color color, float speed) {
        this.position = position;
        this.radius = radius;
        this.color = color;
        this.speed = speed;
        hitRadius = 2*radius;
    }

    public void move(int stepByX, int stepByY) {
        position.setX( position.getX() + stepByX );
        position.setY( position.getY() + stepByY );
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getSpeed() {
        return speed;
    }

    public int getHitRadius() {
        return hitRadius;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }
}
