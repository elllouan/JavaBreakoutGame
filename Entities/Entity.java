package Entities;

import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color;

public abstract class Entity implements Drawable{

    public Entity(){

    }
    
    public double getX()        { return x; }
    public double getY()        { return y; }
    public double getVx()       { return vx; }
    public double getVy()       { return vy; }
    public double getAx()       { return ax; }
    public double getAy()       { return ay; }
    public Color getColor()     { return color; }

    protected int x, y;
    protected double vx, vy, ax, ay;
    private Color color; 

    // abstract public void drawEntity(JPanel panel);

    public static void create(double radius){}
}
