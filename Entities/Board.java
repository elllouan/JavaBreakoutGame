package Entities;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Board extends Entity {

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private int width, height;
    private Graphics2D board;

    public Dimension getDimension() {
        return new Dimension(width,height);
    }

    

    @Override
    public void draw(JPanel panel) {
        // board.drawRect(x, y, width, height);; 
    }

}
