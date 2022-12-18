package Entities;

import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Brick extends Entity {

    public Brick(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private int solidity;
    private int width, height;

    @Override
    public void draw(JPanel panel) {
    }
}
