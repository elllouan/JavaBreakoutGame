import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel
{
    public MyPanel()
    {
        System.out.println("Panel created.");
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // super refers to a JPanel method
        g.setColor(Color.RED);
        g.drawRect(50,100,50,75);
    }
}
