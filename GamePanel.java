import Entities.Entity;

import java.awt.event.ActionEvent;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.StrokeBorder;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;

public class GamePanel extends JPanel{

    class RightAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            moveBoardRight();
        }
    }

    class LeftAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            moveBoardLeft();
        }
    }

    final Color BACKGROUND_COLOR = new Color(0x000099);
    final int MAX_RANGE_COLOR = 0xffffff;
    // private List<Entity> entities;
    private JPanel panel1, panel2, panel3, brickPanel;
    private JLabel board, box, bricks[], ball;
    Action rightAction, leftAction;
    
    public GamePanel(int width, int height) {
        this.setLayout(new BorderLayout());
        this.setBackground(BACKGROUND_COLOR);
        this.setBounds(0,0,width,height);
        // this.setOpaque(true);
    }

    // public void addEntity(Entity e){
    //     entities.add(e);
    // }

    public void setPanels() {
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        panel1.setLayout(null);
        panel1.setPreferredSize(new Dimension(200,200));
        panel1.setBackground(Color.orange);
        panel1.setOpaque(true);

        panel2.setLayout(null);
        panel2.setBackground(BACKGROUND_COLOR);
        panel2.setOpaque(true);

        panel3.setLayout(null);
        panel3.setPreferredSize(new Dimension(200,200));
        panel3.setBackground(Color.orange);
        panel3.setOpaque(true);

        this.add(panel2, BorderLayout.CENTER);
        this.add(panel1, BorderLayout.WEST);
        this.add(panel3, BorderLayout.EAST);
    }

    public void drawBoard() {
        board = new JLabel();
        System.out.println(panel2.getWidth());
        board.setBounds(0, this.getHeight()-125,100,40);
        board.setBackground(new Color(0xff4455));
        board.setOpaque(true);
        panel2.add(board);
    }

    public void assignKeyBindings() {
        rightAction = new RightAction();
        board.getInputMap().put(KeyStroke.getKeyStroke('d'), "to the right");
        board.getActionMap().put("to the right", rightAction);

        leftAction = new LeftAction();
        board.getInputMap().put(KeyStroke.getKeyStroke('q'), "to the left");
        board.getActionMap().put("to the left", leftAction);
    }

    public void drawBox() {
        box = new JLabel();
        box.setBounds(100, 100, 900, 700);
        box.setBackground(BACKGROUND_COLOR);
        box.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        box.setOpaque(true);
        panel2.add(box);
    }

    public void drawBricks() {
        brickPanel = new JPanel();
        brickPanel.setLayout(new FlowLayout(0,10,10));
        brickPanel.setBounds(100,100,890,400);
        brickPanel.setBackground(BACKGROUND_COLOR);

        bricks = new JLabel[10];
        for(int i=0; i<10; ++i) {
            JLabel brick = new JLabel();
            Random rand = new Random();
            brick.setBackground(new Color(rand.nextInt(MAX_RANGE_COLOR)));
            brick.setOpaque(true);
            brick.setPreferredSize(new Dimension(100,40));
            bricks[i]=brick;
            brick.setOpaque(true);
            brickPanel.add(brick);
        }
        panel2.add(brickPanel);
    }

    public void drawBall() {
        ball = new JLabel();
        // reshape the size of an Image with BufferedImage  /!\ does not work
		// BufferedImage shrek = null;
		// try {
		// 	shrek = ImageIO.read(new File("Images/shrek.png"));
		// } catch (Exception e) {
		// 	e.getStackTrace();
		// }
		// shrek.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		//ball.setIcon(new ImageIcon("Images/shrek.png"));
        // ball.setPreferredSize(new Dimension(50,50));
        // ball.setLocation(500,475);
        ball.setBounds(475,600,50,50);
        ball.setBackground(Color.white);
        ball.setOpaque(true);
        panel2.add(ball);
    }

    public static GamePanel setUp() {
        GamePanel gamePanel = new GamePanel(1500,830);
        gamePanel.setPanels();
        // gamePanel.drawBox();
        gamePanel.drawBoard();
        gamePanel.drawBricks();
        gamePanel.drawBall();
        gamePanel.assignKeyBindings();
        return gamePanel;
    }

    public void run(double dt) {

    }

    private void moveBoardRight() {
        if(board.getX()<=990) {
            board.setLocation(board.getX()+10, board.getY());
        }
        else {
            board.setLocation(board.getX(), board.getY());
        }
    }

    private void moveBoardLeft() {
        if(board.getX()>=0) {
            board.setLocation(board.getX()-10, board.getY());
        }
        else {
            board.setLocation(board.getX(), board.getY());
        }        
    }
/*
    private void drawAll() {
        Graphics2D g;
        for (Entity e : entities) {
            g = e.draw(this);
            paint(g);
        }
    }
*/
}
