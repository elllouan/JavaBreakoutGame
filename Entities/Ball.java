package Entities;

import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Ball extends Entity {

    public Ball(double radius) {
        this.radius = radius;
    }

    private double radius;
    private Graphics2D ball;

    public double getRadius()   { return radius; }

    public static Ball create() {
        return null;
    }

    @Override
    public void draw(JPanel panel) {
        ball.drawLine(0, 0, 100, 100);
    }
}
